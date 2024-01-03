import java.util.ArrayList;
import java.util.Random;
public class Deck {
    private ArrayList<Card> cards;
    public Deck(){
        this.cards = new ArrayList<>();
        initialize(cards);
    }
    //creates a standard 52 card deck, giving the cards all the attributes
    public void initialize(ArrayList<Card> cards){
        int color = 0;
        for(int i = 0;i < 4; i++){
            for(int b = 1;b < 14; b++){
                switch(color){
                    case 0:
                        Card cb = new Card(b, "black", "clubs");
                        cards.add(cb);
                        break;
                    case 1:
                        Card sb = new Card(b, "black", "spades");
                        cards.add(sb);
                        break;
                    case 2:
                        Card hr = new Card(b, "red", "hearts");
                        cards.add(hr);
                        break;
                    case 3:
                        Card dr = new Card(b, "red", "diamonds");
                        cards.add(dr);
                        break;
                }
            }
            color ++;
        }
    }
    //Shuffles the deck of cards.
    //Made by looping the deck tru a thingy that gets a random card out and adds it to a new deck
    //the deck is replaced by the new deck, which has cards from the original deck in a
    //random order
    public void shuffle(){
        Random random = new Random();
        ArrayList<Card> newDeck = new ArrayList<>();
        while(cards.size() != 0){
            int randomSwap = random.nextInt(cards.size());
            Card temp = cards.get(randomSwap);
            cards.remove(temp);
            newDeck.add(temp);
        }
        cards = newDeck;
    }
    //returns a card and removes it from the deck
    public Card draw(){
        Card temp = cards.get(cards.size() - 1);
        cards.remove(temp);
        return temp;
    }

}
