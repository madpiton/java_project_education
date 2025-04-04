package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerChildren;
import edu.javacourse.studentorder.domain.StudentOrder;

public class ChildernValidator {

    public String hosnName;
    public String login;
    public String password;

    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running:" + hosnName + " ," +
                login + " ," + password);
        AnswerChildren child = new AnswerChildren();
        return child;
    }
}
