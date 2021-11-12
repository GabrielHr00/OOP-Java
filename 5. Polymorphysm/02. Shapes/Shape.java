public abstract class Shape {
    private Double perimeter;
    private Double area;

    public abstract Double calculatePerimeter();
    public abstract Double calculateArea();

    public final Double getPerimeter() {
        return perimeter;
    }

    public final Double getArea() {
        return area;
    }
}
