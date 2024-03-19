package Model;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

import java.util.*;


/**
 * Класс создает хэш-таблицу, хранящую айди студентов в качестве ключей,
 * список имени и возраста студента в качестве значений.
 */
public class ModelClassHash implements iGetModel {
    private Map<Integer, Student> students;

    public ModelClassHash(Map<Integer, Student> students) {
        this.students = students;
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    /**
     * @param studentId айди студента
     * Описание: метод находит ключ с таким же значением айди,
     *                 удаляет студента из последовательности (iterator).
     */
    @Override
    public void deleteStudent(int studentId) {
        Iterator<Student> iterator = students.values().iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == studentId) {
                iterator.remove();
            }
        }
    }
    @Override
    public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (Map.Entry<Integer, Student> entry : students.entrySet()) {
        sb.append(entry.getKey()).append(": ").append(entry.getValue().getName()).append(", ");
                }
    sb.append("]");
    return sb.toString();
            }
        }


