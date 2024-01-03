public class Card {
    private int value;
    private String color;
    private String symbol;
    public Card(int value, String color, String symbol) {
        this.value = value;
        this.color = color;
        this.symbol = symbol;

    }
    public int getValue(){
        return this.value;
    }
    public String getColor(){
        return this.color;
    }
    public String getSymbol(){
        return this.symbol;
    }

    public String data(){
        return this.value + " " + this.color + " " + this.symbol;
    }
}
