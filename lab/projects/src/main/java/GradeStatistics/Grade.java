package GradeStatistics;

import java.util.ArrayList;

public class Grade {
    private final ArrayList<Integer> grades;

    public Grade(){
        grades = new ArrayList<>();
    }

    public void add(int point){
        this.grades.add(point);
    }

    public int total(){
        int total = 0;
        for (Integer grade: grades){
            total += grade;
        }
        return total;
    }

    public int allCount(){
        return grades.size();
    }

    public double avg(int total, int count){
        double avg = 0;
        if (count != 0){
            avg = 1.0 * total / count;
        }

        return avg;
    }

    public int passingTotal(){
        int total = 0;
        for (Integer grade: grades){
            if (grade >= 50){
                total += grade;
            }
        }
        return total;
    }

    public int passingCount(){
        int count = 0;
        for (Integer grade: grades){
            if (grade >= 50){
                count++;
            }
        }
        return count;
    }

    public double passPercentage(int allCount, int passingCount){
        double percentage = 0;
        percentage = 100.0 * passingCount / allCount;
        return percentage;
    }

    public int[] gradeDistribution(){
        int[] gradeNumbers = new int[6];
        for (Integer grade: grades){
            if (grade < 50){
                gradeNumbers[0]++;
            } else if (grade >= 50 && grade < 60){
                gradeNumbers[1]++;
            } else if (grade >= 60 && grade < 70){
                gradeNumbers[2]++;
            } else if (grade >= 70 && grade < 80){
                gradeNumbers[3]++;
            }else if (grade >= 80 && grade < 90){
                gradeNumbers[4]++;
            }else if (grade >= 90 && grade < 100){
                gradeNumbers[5]++;
            }
        }
        return gradeNumbers;
    }

    public void starPrinter(int count){
        for (int i = 0; i < count; i++){
            System.out.print("*");
        }
    }

    public void printDistribution(int[] array){
        for (int i = 5; i > -1; i--){
            System.out.print(i + ":");
            starPrinter(array[i]);
            System.out.println("");
        }
    }
}

