public class Main {

    public static void main(String[] args) {

        Player p1 = new Player("Umar",30,"Ice-Axe");

        p1.name="Tariq";
        p1.health=20;
        p1.weapon="fire-0axe";
        int damage = 11;
        p1.loseHealth(damage);
        System.out.println("remaining health" + p1.healthRemaining());
        p1.loseHealth(damage);
        System.out.println("remaining health" + p1.healthRemaining());


        //now enhanced player
        EnhancedPlayer ep1 = new EnhancedPlayer("muhammad umar tariq",101,"M4A1");
        System.out.println("Initial health is"+ep1.getHealth());

    }
}
