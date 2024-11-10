package GradeStatistics;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grade grade = new Grade();
        while (true) {
            System.out.println("Enter point totals, -1 stops: ");
            int point = Integer.valueOf(scanner.nextLine());
            if (point == -1){
                break;
            }
            if (point < -1 || point > 100){
                continue;
            }
            grade.add(point);
        }
        System.out.println("Point average (all): " + grade.avg(grade.total(),grade.allCount()));
        System.out.println("Point average (passing): " + grade.avg(grade.passingTotal(),grade.passingCount()));
        System.out.println("Pass percentage: " + grade.passPercentage(grade.allCount(), grade.passingCount()));
        grade.printDistribution(grade.gradeDistribution());
    }

}

