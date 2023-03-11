package Polymorphism.shapes;

public abstract class Shape {
   private Double	perimeter;
    private   Double	area;


    public Double getPerimeter() {
        return this.perimeter;
    }

    public Double getArea() {
        return this.area;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(Double area) {
        this.area = area;
    }
    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();

    }

