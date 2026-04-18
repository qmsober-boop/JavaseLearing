package Project.bean;

public class MyCharactor extends  Character{
    public MyCharactor(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    public void strongAttack(Character enemy){
        System.out.println("使用了强力一击");
        enemy.takeDamage(this.getAttack()*2);
    }
}
