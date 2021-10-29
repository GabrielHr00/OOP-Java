import java.util.Scanner;

public class Card {
    CardRank rank;
    CardSuits suit;

    public Card(CardRank rank, CardSuits suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getSum() {
        return rank.getValue() + suit.getVal();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", rank.name(), suit.name(), getSum());
    }
}

