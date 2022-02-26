package com.repeoy.webservice;

public class Course {
    private String courseName;
    private String teacher;
    private int grade;
    private int kurssiID;



    public Course(String courseName, String teacher, int grade, int kurssiID) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.grade = grade;
        this.kurssiID = kurssiID;
    }


    public String getCourseName() {
        return courseName;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getGrade() {
        return grade;
    }

    public int getKurssiID() { return kurssiID; }

}

