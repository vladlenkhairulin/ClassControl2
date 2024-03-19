import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.View;

import Controller.ControllerClass;
import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.FileModelClass;
import Model.ModelClass;
import Model.Domain.Student;
import Model.ModelClassHash;
import View.ViewClass;
import View.ViewClassEng;
/*
* Название проекта: Модель класса студентов
* Описание: проект реализует хранилище данныъх о студентах в разных структурах данных.
* Дата создания: 18.03.2024
* Автор: Хайрулин Владлен
* Версия: 1.0
* */
public class App {
    public static void main(String[] args) throws Exception {


        Student student1 = new Student("Ivan", 21);
        Student student2 = new Student("Anna", 25);
        Student student3 = new Student("Vasya", 22);
        Student student4 = new Student("Nastya", 27);
        Student student5 = new Student("Vasilisa", 26);
        Student student6 = new Student("Karina", 25);
        Student student7 = new Student("Andrey", 22);
        Student student8 = new Student("Masha", 27);
        Student student9 = new Student("Irina", 28);
        Student student10 = new Student("Nikolay", 30);

        List<Student> studList = new ArrayList<>();
        studList.add(student1);
        studList.add(student2);
        studList.add(student3);
        studList.add(student4);
        studList.add(student5);
        studList.add(student6);
        studList.add(student7);
        studList.add(student8);
        studList.add(student9);
        studList.add(student10);

        FileModelClass fmodel = new FileModelClass("StudentDB.csv");
        //fmodel.saveAllStudentToFile(studList);
        Map<Integer, Student> studentsMap = new HashMap<>();

        // Добавляем студентов в Map, используя их id в качестве ключа
        for (Student student : studList) {
            studentsMap.put(student.getId(), student);
        }


        iGetModel model = new ModelClassHash(studentsMap);
        iGetView view = new ViewClassEng();

        ControllerClass controller = new ControllerClass(model, view);


        ModelClassHash modelHash = new ModelClassHash(studentsMap);
        System.out.println(modelHash);

        controller.run();


    }
}