public class Rectangle {
    private Point bottomleft;
    private Point topright;

    public Rectangle(String[] points) {
        this.bottomleft = new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1]));
        this.topright = new Point(Integer.parseInt(points[2]), Integer.parseInt(points[3]));
    }

    public boolean contains(String[] point){
        int x = Integer.parseInt(point[0]);
        int y = Integer.parseInt(point[1]);

        return x >= this.bottomleft.getX() && x <= this.topright.getX() && y >= this.bottomleft.getY() && y <= this.topright.getY();
    }
}
