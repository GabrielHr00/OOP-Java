public enum Discount {
    VIP(0.2),
    SecondVisit(0.1),
    None(0.0);

    private double perc;

    private Discount(double perc) {
        this.perc = perc;
    }

    public double getPerc() {
        return perc;
    }
}
