package lesson.hwskeleton.ui;

import lesson.hwskeleton.bll.InMemoryRepository;
import lesson.hwskeleton.bll.Repository;
import lesson.hwskeleton.model.Record;

/**
 * Created by igor on 22.06.2015.
 */
public class RunPhoneBook {

    public static void main(String[] args) {
        // Точка входа в приложене
        // Создаем репозиторий
        Repository<Record> phoneRecords = new InMemoryRepository();

        //while (не выход) {
          // вывод меню
          //action

          //switch (action) {
          //    case 1:
                Record record =  UIHelper.createNewRecord();
                phoneRecords.add(record);
          //     break;
          //}




        //}
    }
}
