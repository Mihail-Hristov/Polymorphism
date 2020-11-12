package shapes;

public class Rectangle extends Shape {
    private Double height;

    private Double width;
    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getWidth() {
        return this.width;
    }

    @Override
    protected Double calculatePerimeter() {
        super.setPerimeter((getHeight() * 2) + (getWidth() * 2));
        return super.getPerimeter();
    }

    @Override
    protected Double calculateArea() {
        super.setArea(getHeight() * getWidth());
        return super.getArea();
    }
}
