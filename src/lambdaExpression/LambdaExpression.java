package lambdaExpression;

import lambdaExpression.FunctionalInterface.Student;

public class LambdaExpression {
    public static void main(String[] args) {
        Student EngineeringStudent = new Student() {
            @Override
            public String getBio(String name) {
                return name + " is Engineering Student";
            }
        };

        String studentName = EngineeringStudent.getBio("Muez");
        System.out.println(studentName);


        /* now i would like to implement with lambda expression */
        Student lawStudent = (String name) -> {
            return name + " is law student";
        };

        String lawStudenthere = lawStudent.getBio("Ibrahim");
        System.out.println(lawStudenthere);

    }
}
