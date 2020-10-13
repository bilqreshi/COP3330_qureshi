public class Pyramid extends Shape3D {
    private double base, width, height;
    String name = "pyramid";
    double area;
    double volume;

    public Pyramid(double base, double width, double height) {
        this.base = base;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        area = (base * width) + (base * Math.sqrt(((width/2)*(width/2))+(height * height))) + (width * Math.sqrt(((base/2)*(base/2))+(height * height)));
        return area;
    }

    public double getVolume() {
        volume = (base * width * height)/3;
        return volume;
    }
}
