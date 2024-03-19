package Controller;

import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Controller.Interfaces.iGetView;
import Model.ModelClass;
import Model.Domain.Student;
import View.ViewClass;
import Controller.Command;
import View.ViewClassEng;
import Model.ModelClassHash;

public class ControllerClass {

private iGetModel model;
private iGetView view;
private List<Student> buffer = new ArrayList<>();

public ControllerClass(iGetModel model, iGetView view) {
    this.model = model;
    this.view = view;
}
    //private ModelClassHash model;
    //private ViewClassEng view;
    //private List<Student> buffer = new ArrayList<>();
    //public ControllerClass(ModelClassHash model, ViewClassEng view) {
    //    this.model = model;
    //    this.view = view;
    //}
    private boolean testData(List<Student> students)
    {
        if(students.size()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void update()
    {
        //MVC
        //view.printAllStudents(model.getAllStudents());

        //MVP
        buffer = model.getAllStudents();

        if(testData(buffer))
        {
            view.printAllStudents(buffer);
        }
        else{
            System.out.println("Список студентов пуст!");
        }
    }

    public void run() {
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = view.prompt("Введите команду: ");
            com = Command.valueOf(command.toUpperCase());
            switch (com) {
                case EXIT:
                    getNewIteration = false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST:
                    //MVC
                    view.printAllStudents(model.getAllStudents());
                    break;
                  // при выборе команды УДАЛИТЬ программа запрашивает айди студента и удаляет студента с таким айди
                case DELETE:
                    int studentToDelete = Integer.parseInt(view.prompt("Введите номер студента для удаления: "));
                    model.deleteStudent(studentToDelete);
                    System.out.println("Student with ID number " + studentToDelete + " was deleted");

            }
        }
    }
}
