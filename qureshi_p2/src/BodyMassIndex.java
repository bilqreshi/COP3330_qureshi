public class BodyMassIndex {

    private double height, weight;

    public BodyMassIndex(double height, double weight) {
        if (height > 0) {
            this.height = height;
        }
        if (weight > 0) {
            this.weight = weight;
        }
    }

    public double BmiScore(double height, double weight) {
        double bmi = 703 * (weight / (height * height));
        return bmi;
    }

    public String BmiCategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi >= 18.5 || bmi <= 24.9) {
            return "Normal weight";
        }
        if (bmi >= 25 || bmi <= 29.9) {
            return "Overweight";
        }
        if (bmi >= 30) {
            return "Obesity";
        }
    }
}
