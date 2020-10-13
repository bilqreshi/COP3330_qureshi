public class Sphere extends Shape3D{
    private double radius;
    String name = "sphere";
    double area;
    double volume;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        area = 4 * Math.PI * radius * radius;
        return area;
    }

    public double getVolume() {
        volume = (4 * Math.PI * radius * radius * radius)/3;
        return volume;
    }
}
