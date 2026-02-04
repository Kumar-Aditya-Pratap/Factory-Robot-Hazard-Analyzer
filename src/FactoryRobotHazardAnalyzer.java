

/*
* Version 5.0
* Author:Kumar Aditya Pratap
* Refactor Hazard Method
*/

import java.util.*;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Factory Robot Hazard Analyzer");

        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = scanner.nextDouble();

        System.out.print("Enter Worker Density (1 - 20): ");
        int workerDensity = scanner.nextInt();

        scanner.nextLine(); // consume newline

        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = scanner.nextLine();

        RobotHazardAuditor auditor = new RobotHazardAuditor();

        double risk = auditor.calculateHazardRisk(
                armPrecision,
                workerDensity,
                machineryState
        );

        if (risk != -1) {
            System.out.println("Robot Hazard Risk Score: " + risk);
        }

        scanner.close();
    }
}
