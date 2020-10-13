public class Cube extends Shape3D {
    private double length;
    String name = "cube";
    double area;
    double volume;

    public Cube(double length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        area = 6 * length * length;
        return area;
    }

    public double getVolume() {
        volume = length * length * length;
        return volume;
    }
}
