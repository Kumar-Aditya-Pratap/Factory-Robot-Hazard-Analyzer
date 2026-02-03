import java.util.*;
/*
* Version 2.0
* Author:Kumar Aditya Pratap
* Accept robot hazard inputs
*/

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {
        System.out.println("Factory Robot Hazard Analyzer");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Arm precision:");
        double armPrecision = sc.nextDouble();

        System.out.println("Enter Worker Density:");
        int workerDensity = sc.nextInt();

        System.out.println("Enter Machinery State:");
        String machineryState = sc.next();

        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        sc.close();
    }
}