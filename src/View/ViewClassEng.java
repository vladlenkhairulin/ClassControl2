package View;

import Model.Domain.Student;

import java.util.List;

public class ViewClassEng extends ViewClass{

    /**
     * @param students список студентов
     * Описание: выводит список студентов на консоль, но на английском языке
     */
    @Override
    public void printAllStudents(List<Student> students) {
        System.out.println("------------------- List of students ---------------------------");

        for(Student s : students)
        {
            System.out.println(s);
        }

        System.out.println("---------------------------------------------------------------");
    }
}
