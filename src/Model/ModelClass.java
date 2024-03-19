package Model;

import java.util.Iterator;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

public class ModelClass implements iGetModel {

    private List<Student> students;

    public ModelClass(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudents()
    {
        return students;
    }

    /**
     * @param studentId айди студента
     * Описание: находит объект класса Student, в котором айди совпадает с введённым айди,
     *                  удаляет этого студента.
     */
    @Override
    public void deleteStudent(int studentId) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == studentId) {
                iterator.remove();
            }
        }
    }
}