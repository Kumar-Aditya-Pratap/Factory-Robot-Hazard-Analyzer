

import java.util.Scanner;

public class RobotHazardAuditor {

    private static final double WORN_RISK = 1.3;
    private static final double FAULTY_RISK = 2.0;
    private static final double CRITICAL_RISK = 3.0;

    public double calculateHazardRisk(double armPrecision,
                                      int workerDensity,
                                      String machineryState)
            throws RobotSafetyException {

        validateArmPrecision(armPrecision);
        validateWorkerDensity(workerDensity);

        double machineRiskFactor = resolveMachineRiskFactor(machineryState);

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineRiskFactor);
    }

    private void validateArmPrecision(double armPrecision)
            throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0"
            );
        }
    }

    private void validateWorkerDensity(int workerDensity)
            throws RobotSafetyException {

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20"
            );
        }
    }

    private double resolveMachineRiskFactor(String machineryState)
            throws RobotSafetyException {

        switch (machineryState) {
            case "Worn":
                return WORN_RISK;
            case "Faulty":
                return FAULTY_RISK;
            case "Critical":
                return CRITICAL_RISK;
            default:
                throw new RobotSafetyException(
                        "Error: Unsupported machinery state"
                );
        }
    }
}