package Cardgame;
import java.util.*;

public class Room {

    public  void main(String[] args) {

       ram();



    }

     ArrayList<Card> cards=new ArrayList<>();

    {
        String card[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String colors[] = {"♥","♠","♣","♦"};
        int count = 0;
        for (String cards : card) {
            for (String color : colors) {
                this.cards.add(new Card(cards,color,count));
            }
            count++;
        }
        Collections.addAll(cards,new Card("King","black",count++),new Card("King","red",count));
    }
    //洗牌,存牌

    List<Card> player1=new ArrayList<>();
    List<Card> player2=new ArrayList<>();
    List<Card> player3=new ArrayList<>();
    List<Card> rest=new ArrayList<>();
    Map<String,List<Card>> map=new HashMap<>();



    public void ram()
    {
        //洗牌+发牌
        Collections.shuffle(this.cards);
        for (int i = 0; i < cards.size()-3; i++) {
            if(i%3==0)
            {
                player1.add(cards.get(i));
            }
            else if(i%3==1)
            {
                player2.add(cards.get(i));
            }
            else
            {
                player3.add(cards.get(i));
            }
        }
        for (int i = cards.size()-3; i < cards.size(); i++)
        {
            rest.add(cards.get(i));
        }
        player3.sort((s,t)->s.sort-t.sort);
        player2.sort((s,t)->s.sort-t.sort);
        player1.sort((s,t)->s.sort-t.sort);

        map.put("韩信",player1);
        map.put("张飞",player2);
        map.put("关羽",player3);

    }

    public void show(Map.Entry<String, List<Card>> player)
    {
       player.getValue().forEach(System.out::println);
    }

    public void start()
    {
        System.out.println("欢迎来到牌桌");
        while ( true)
        {

        }

    }









}
