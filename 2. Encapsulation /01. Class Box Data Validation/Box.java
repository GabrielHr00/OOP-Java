public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if(length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea(){
        double surface = (2*length*width) + (2*this.length*this.height) + (2*width*height);
        return surface;
    }

    public double calculateLateralSurfaceArea(){
        double surface = (2*length*height) + (2*this.width*this.height);
        return surface;
    }

    public double calculateVolume(){
        return this.height * this.length * this.width;
    }
}
