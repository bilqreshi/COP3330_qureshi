import java.util.Scanner;
import java.util.ArrayList;

public class App {
    static Scanner scanner = new Scanner(System.in);

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

    private static boolean moreInput() {
        char input = 'e';
        boolean result = false;
        while ((input != 'Y') && (input != 'N')) {
            System.out.println("\nMore input?\n'Y' for yes\n'N' for no");
            input = scanner.next().charAt(0);
            if (input == 'Y') {
                result = true;
            }
            if (input == 'N') {
                result = false;
            }
        }
        return result;
    }

    private static double getUserHeight() {
        double height = 0;
        while (height <= 0) {
            System.out.print("Enter height (greater than 0): ");
            height = scanner.nextDouble();
        }
        return height;
    }

    private static double getUserWeight() {
        double weight = 0;
        while (weight <= 0) {
            System.out.print("Enter weight (greater than 0): ");
            weight = scanner.nextDouble();
        }
        return weight;
    }

    private static void displayBmiInfo(BodyMassIndex bmi) {
        System.out.println("Body Mass Index Score: " + BodyMassIndex.BmiScore(bmi));
        System.out.println("Body Mass Index Category: " + BodyMassIndex.BmiCategory(BodyMassIndex.BmiScore(bmi)));
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
        double avg = 0, sum = 0;
        for (int i = 0; i < bmiData.size(); i++) {
            sum += BodyMassIndex.BmiScore(bmiData.get(i));
        }
        avg = sum / bmiData.size();
        System.out.println("Average Body Mass Index Score: " + avg);
    }
}
