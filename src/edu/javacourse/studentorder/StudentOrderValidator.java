package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildernValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildernValidator childernVal;
    private StudentValidator studenVal;
    private MailSender mailSender;

    public StudentOrderValidator(){
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childernVal = new ChildernValidator();
        studenVal = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll() {

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


    public StudentOrder readStudentOrder() {
        StudentOrder so = new StudentOrder(); // создаем новую студ.заявку и возвращаем ее
        return so;
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childernVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studenVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }
}
