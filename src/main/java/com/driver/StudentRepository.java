package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    Map<String, Student> studentMap = new HashMap<>();
    Map<String, Teacher> teacherMap = new HashMap<>();
    HashMap<String, List<String>> teacherStudentMap = new HashMap<>();

    public void addStudentToDB(Student student) {
        studentMap.put(student.getName(), student);
    }

    public void addTeacherToDB(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPairToDB(String student, String teacher) {
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            if (!teacherStudentMap.containsKey(teacher))
                teacherStudentMap.put(teacher, new ArrayList<>());
            teacherStudentMap.get(teacher).add(student);
        }
    }

    public Student getStudentFromDBByName(String name) {
        return studentMap.get(name);
    }

    public Teacher getTeacherFromDBByName(String name) {
        return teacherMap.get(name);
    }

    public List<String> getStudentListFromDBByTeacherName(String teacher) {
        return teacherStudentMap.get(teacher);
    }

    public List<String> getAllStudentsDataFromDB() {
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacherDataFromDB(String teacher) {
        if(teacherStudentMap.containsKey(teacher)){
            Set<String> studentSet = new HashSet<>(teacherStudentMap.get(teacher));
            for(String student: studentSet){
                studentMap.remove(student);
            }
            teacherStudentMap.remove(teacher);
        }
        teacherMap.remove(teacher);

    }

    public void deleteAllTeachersDataFromDB() {
        Set<String> studentSet = new HashSet<>();
        for(String teacher: teacherStudentMap.keySet())
            studentSet.addAll(teacherStudentMap.get(teacher));
        for(String student: studentSet){
            studentMap.remove(student);
        }
        teacherMap.clear();
        teacherStudentMap.clear();
    }
}
