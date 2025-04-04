package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildernValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {

        while (true) {
            StudentOrder so = readStudentOrder(); // читаем студ.заявку и
            System.out.println("Start");

            if (so == null) { // если заявка есть,
                break; // (выход из цикла, если заявки нет)
            }
            System.out.println("Проверяем регистрацию в городской системе");
            AnswerCityRegister cityAnswer = checkCityRegister(so);// передаем её на проверки
            if (!cityAnswer.success) {
                //continue; // (возврат в начало цикла, если проверка не пройдена)
                break;
            }

            System.out.println("Проверяем статус семейного положения");
            AnswerWedding weddingAnswer = checkWedding(so);
            if (!weddingAnswer.success) {
                break;
            }
            AnswerChildren childAnswer = checkChildren(so);
            if (!childAnswer.success){
                break;
            }
            AnswerStudent studAnswer = checkStudent(so);
            if (!studAnswer.success){
                break;
            }

            sendMail(so);
        }
    }


    static StudentOrder readStudentOrder() {
        StudentOrder so = new StudentOrder(); // создаем новую студ.заявку и возвращаем ее
        return so;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hosnName = "Host1";
        crv1.login = "Login1";
        crv1.password = "Password1";
        CityRegisterValidator crv2 = new CityRegisterValidator();
        crv2.hosnName = "Host2";
        crv2.login = "Login2";
        crv2.password = "Password2";
        AnswerCityRegister acr1 = crv1.checkCityRegister(so);
        AnswerCityRegister acr2 = crv2.checkCityRegister(so);
        return acr1;
    }

    static AnswerWedding checkWedding(StudentOrder so) {
        WeddingValidator cw = new WeddingValidator();
        cw.hostName = "Host1";
        cw.login = "Login1";
        cw.password = "Password1";
        AnswerWedding aw = cw.checkWedding(so);
        return aw;
    }

    static AnswerChildren checkChildren(StudentOrder so) {
        ChildernValidator cc = new ChildernValidator();
        cc.hosnName = "Host";
        cc.login = "Login";
        cc.password = "Password";
        AnswerChildren cv = cc.checkChildren(so);
        return cv;
    }

    static AnswerStudent checkStudent(StudentOrder so) {
        StudentValidator sv = new StudentValidator();
        sv.hostName = "Host1";
        sv.login = "Login1";
        sv.password = "Password1";
        AnswerStudent as = sv.checkStudent(so);
        return as;
    }

    static void sendMail(StudentOrder so) {
        new MailSender().sendMail(so);
    }
}
