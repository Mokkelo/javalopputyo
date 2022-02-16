package com.repeoy.webservice;

public class Exam {
    private String subject;
    private String grade;

    public Exam(String subject, String grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }
}
