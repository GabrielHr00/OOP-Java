public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int val;

    CardSuits(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
