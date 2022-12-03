package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student) {
        studentRepository.addStudentToDB(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacherToDB(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        studentRepository.addStudentTeacherPairToDB(student, teacher);
    }

    public Student getStudentByName(String name) {
        return studentRepository.getStudentFromDBByName(name);
    }

    public Teacher getTeacherByName(String name) {
        return studentRepository.getTeacherFromDBByName(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return studentRepository.getStudentListFromDBByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudentsDataFromDB();
    }


    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherDataFromDB(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachersDataFromDB();
    }
}
