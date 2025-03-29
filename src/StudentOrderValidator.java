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
            System.out.println("Finish");
            AnswerCityRegister cityAnswer = checkCityRegister(so);// передаем её на проверки
            if (!cityAnswer.success) {
                continue; // (возврат в начало цикла, если проверка не пройдена)
            }

            AnswerWedding wedAnswer = checkWedding(so);
            AnswerChildren chilAnswer = checkChildren(so);
            AnswerStudent studAnswer = checkStudent(so);

            sendMail(so);
        }
        System.out.println("Finish 2");
    }


    static StudentOrder readStudentOrder() {
        StudentOrder so = new StudentOrder(); // создаем новую студ.заявку и возвращаем ее
        return null;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        System.out.println("CityRegister is running");
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }

    static AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Marrige запущен");
        return new AnswerWedding();
    }

    static AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Childern Check is running");
        return new AnswerChildren();
    }

    static AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Студенты проверяются");
        return new AnswerStudent();
    }

    static void sendMail(StudentOrder so) {

    }
}
