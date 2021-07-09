public class Player {
    public String name;
    public int health;
    public String weapon;

    public Player(String name, int health, String weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        this.health = this.health - damage;
        if(this.health<=0){
            System.out.println("Player Knocked Out");


        }
    }

    public int healthRemaining(){
        return this.health;
    }
}
