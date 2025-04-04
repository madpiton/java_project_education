package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerStudent;
import edu.javacourse.studentorder.domain.StudentOrder;

public class StudentValidator {

    public String hostName;
    public String login;
    public String password;

    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Студенты проверяются" + hostName + ", " +
                login + ", " + password);
        AnswerStudent stud = new AnswerStudent();
        stud.success = false;
        return stud;
    }
}
