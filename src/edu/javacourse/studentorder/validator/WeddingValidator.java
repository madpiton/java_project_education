package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerWedding;
import edu.javacourse.studentorder.domain.StudentOrder;

public class WeddingValidator {

    public String hostName;
    public String login;
    public String password;

    public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding Registry is running:" + hostName + " ," +
                login + " ," + password);
        AnswerWedding wed = new AnswerWedding();
        wed.success = false;
        return wed;
    }
}
