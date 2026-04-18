package Project.bean;

public abstract class Character {
    private String name;
    private int maxhp=100;
    private int hp=100;
    private int attack=10;
    private int defense=10;

    public Character(String name, int hp, int attack, int defense) {
        this.name = name;
        this.maxhp += hp;
        this.attack += attack;
        this.defense += defense;
        this.hp = this.maxhp;
    }
    public void show()
    {
        System.out.println("=== 角色信息 ===");
        System.out.println("  名称：" + this.name);
        System.out.println("  生命值：" + this.hp + "/" + this.maxhp);
        System.out.println("  攻击力：" + this.attack);
        System.out.println("  防御力：" + this.defense);
        System.out.println("  状态：" + (this.alive() ? "存活" : "死亡"));
        System.out.println("-------------------");

    }


    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxhp() {
        return maxhp;
    }

    public void setMaxhp(int maxhp) {
        this.maxhp = maxhp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public boolean alive(){
       return hp > 0;
    }

     public void takeDamage(int damage){
        this.hp -= damage;
    }

}
