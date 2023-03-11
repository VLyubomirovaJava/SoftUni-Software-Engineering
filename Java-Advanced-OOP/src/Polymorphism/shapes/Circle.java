package Polymorphism.shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculateArea();
        this.calculatePerimeter();
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public  final Double getRadius() {
        return radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2*this.radius*Math.PI);
    }

    @Override
    protected void calculateArea() {
setArea(Math.PI*(this.radius*this.radius));
    }
}
