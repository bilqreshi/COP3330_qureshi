public class BodyMassIndex {

    public double height, weight;

    public BodyMassIndex(double height, double weight) {
        if (height > 0) {
            this.height = height;
        }
        if (weight > 0) {
            this.weight = weight;
        }
    }

    public static double BmiScore(double height, double weight) {
        double bmi = 703 * (weight / (height * height));
        return bmi;
    }

    public static String BmiCategory(double bmi) {
        String result = "";
        if (bmi < 18.5) {
            result = "Underweight";
        }
        if (bmi >= 18.5 || bmi <= 24.9) {
            result = "Normal weight";
        }
        if (bmi >= 25 || bmi <= 29.9) {
            result = "Overweight";
        }
        if (bmi >= 30) {
            result = "Obesity";
        }
        return result;
    }
}
