package Controller.Interfaces;

import java.util.List;

import Model.Domain.Student;

public interface iGetModel {
    public List<Student> getAllStudents();

    /**
     * @param studentId айди студента
     * Описание: метод для удаления студента из модели с любым типом хранилища
     */
    void deleteStudent(int studentId);
}
