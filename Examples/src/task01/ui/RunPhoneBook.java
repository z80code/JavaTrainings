package task01.ui;

import task01.bll.InMemoryRepository;
import task01.bll.Repository;
import task01.model.Record;

import java.util.Scanner;

/**
 * Created by igor on 22.06.2015.
 */
public class RunPhoneBook {

    public static void main(String[] args) {

        Repository<Record> repository = new InMemoryRepository();

        String action = null;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("");
            System.out.println("enter 'show' to print all records");
            System.out.println("enter 'details' to print record details");
            System.out.println("enter 'delete' to remove record");
            System.out.println("enter 'add' to create new record");
            System.out.println("enter 'update' to update record");
            System.out.println("enter 'exit' to exit");

            System.out.println("");
            action = scanner.nextLine();

            switch (action.trim()) {
                case "sort":
                    // by ...
                    // repository.sort(  );
                case "add":
                    Record record = UIHelper.createNewRecord();
                    repository.add(record);
                    break;
                case "update":
                    int id = StdReader.readInt("Enter id to update", "Enter number!");
                    record = repository.get(id);

                    if(record!=null){

                        Record updatedRecord = UIHelper.updateRecord(record);
                        repository.update(updatedRecord);

                    } else {
                        System.out.format("Record with id='%d' not found\n", id);
                    }

                    break;
                case "delete":
                    id = StdReader.readInt("Enter id to delete", "Enter number!");

                    record = repository.get(id);

                    if (record != null) {
                        repository.remove(record);
                    } else {
                        System.out.format("Record with id='%d' not found\n", id);
                    }

                    break;
                case "show":
                    UIHelper.printRecords(repository.getAll());
                    break;
                case "exit":
                    break;
                case "details":

                    id = StdReader.readInt("Enter id to show details", "Enter number!");
                    record = repository.get(id);

                    if (record != null) {
                        System.out.println(record);
                    } else {
                        System.out.format("Record with id='%d' not found\n", id);
                    }

                    break;

                default:
                    System.out.println("Illegal command");
                    break;
            }
        } while (!"exit".equals(action));


        // Точка входа в приложене
        // Создаем репозиторий
        //Repository<Record> phoneRecords = new InMemoryRepository();

        //while (не выход) {
        // вывод меню
        //action

        //switch (action) {
        //    case 1:
        //      Record record =  UIHelper.createNewRecord();
        //      phoneRecords.add(record);
        //     break;
        //}


        //}
    }
}
