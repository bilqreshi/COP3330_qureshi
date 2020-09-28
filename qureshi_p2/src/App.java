import java.util.Scanner;
import java.util.ArrayList;

public class App {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private boolean moreInput() {
        String input = "e";

        while (!(input.equals("Y")) || !(input.equals("N"))) {
            System.out.println("More input?\n'Y' for yes\n'N' for no");
            input = scanner.next();
            if (input.equals("Y")) {
                return true;
            }
            if (input.equals("N")) {
                return false;
            }
        }
    }

    private double getUserHeight() {
        System.out.print("Enter height: ");
        double height = scanner.nextDouble();
        return height;
    }

    private double getUserWeight() {
        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();
        return weight;
    }

    private void displayBmiInfo() {
    }

    private void displayBmiStatistics() {
    }
}
