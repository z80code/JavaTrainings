package lesson.networks.streams.linalg;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {

        double[] b = {1,2,3,4};

        double[][] A = {
                {1,2,7,1},
                {5,3,3,2},
                {2,1,2,3},
                {7,2,9,4}
        };

        Matrix m = new Matrix(A);

        int N = 3;

        ServerSocket serverSocket = new ServerSocket(9000);
        ObjectOutputStream[] outputs = new ObjectOutputStream[N];

        for (int i = 0; i < N; i++) {
            Socket socket = serverSocket.accept();
            outputs[i] = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("User connected: "+i);
        }

        int activeNode = 0;

        for(int i = 0; i < A[0].length; i++) {
            outputs[activeNode].writeObject(new Pack(Message.Send, new Column(i, m.getColumn(i))  ));
            activeNode++;
            activeNode%=N;
        }

        outputs[activeNode].writeObject(new Pack(Message.Send, new Column(-1, b) ));

        for(ObjectOutputStream o : outputs) {
            o.writeObject( new Pack(Message.End, null) );
        }

        System.out.println("Correct end");

    }
}
