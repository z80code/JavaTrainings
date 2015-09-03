package lesson.anatations.proxy;

import java.lang.reflect.Method;

public class SecureLogic {

    public void onInvoke(SecurityLevel level, Method method, Object[] args) {
        StringBuilder argsStr = new StringBuilder();
        if(args!=null) {
            for (Object arg : args) {
                argsStr.append(arg.toString() + ", ");
            }
            argsStr.setLength(argsStr.length()-1);
        }


        System.out.format("Method %s (%s)\n", method.getName(), argsStr.toString());

        switch (level) {
            case LOW:
                System.out.println("Low security logic");
                break;
            case NORMAL:
                System.out.println("Normal security logic");
                break;
            case HIGH:
                System.out.println("High security logic");
                break;
        }
    }

}
