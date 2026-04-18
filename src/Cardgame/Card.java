package Cardgame;
public class Card {
    private String size;
    private String color;
     int sort;
    public Card(String size,String color,int sort)
    {
        this.size=size;
        this.color=color;
        this.sort=sort;
    }
    public Card(){
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
