

/*
* Version 6.0
* Author:Kumar Aditya Pratap
* Custom Robot Safety Exception
*/

import java.util.*;

import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        displayHeader();

        double armPrecision = readArmPrecision(scanner);
        int workerDensity = readWorkerDensity(scanner);
        String machineryState = readMachineryState(scanner);

        RobotHazardAuditor auditor = new RobotHazardAuditor();

        try {
            double riskScore = auditor.calculateHazardRisk(
                    armPrecision,
                    workerDensity,
                    machineryState
            );
            System.out.println("Robot Hazard Risk Score: " + riskScore);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    private static void displayHeader() {
        System.out.println("Factory Robot Hazard Analyzer");
    }

    private static double readArmPrecision(Scanner scanner) {
        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        return scanner.nextDouble();
    }

    private static int readWorkerDensity(Scanner scanner) {
        System.out.print("Enter Worker Density (1 - 20): ");
        return scanner.nextInt();
    }

    private static String readMachineryState(Scanner scanner) {
        scanner.nextLine(); // consume newline
        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        return scanner.nextLine();
    }
}