package workingWithAbstraction.CardsWithPower;

public class Card {
    CardSuit cardSuit;
    CardRank cardRank;

    public Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public int getCardPower() {
        return cardRank.getPower() + cardSuit.getPower();
    }
}
