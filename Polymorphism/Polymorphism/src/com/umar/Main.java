package com.umar;

class Movie{
    private String name;

    public Movie(String name){
        this.name = name;
    }

    public String plot(){
        return "No Plot Here";
    }
    public String getName(){
        return this.name;
    }
}

class Jaws extends Movie{
    public Jaws(){
        super("Jaws");
    }

    public String plot(){
        return "A shark eats a lot of people";
    }
}

class IndependenceDay extends Movie{

    public IndependenceDay() {
        super("Independence Day");
    }

    public String plot(){
        return "Oh Noooooooo";
    }
}

class MazeRunner extends Movie{
    public MazeRunner(){
        super("Maze Runner");
    }

    public String plot(){
        return "Kids try and escape a maze";
    }
}

class StarWars extends Movie{
    public StarWars() {
        super("Star wars");
    }
    public String plot(){
        return "Imperiallssss aaahhh";
    }
}

class Forgetable extends Movie{
    public Forgetable(){
        super("Forgetable");
    }
}
public class Main {

    public static void main(String[] args) {
        //Polymorphism
        //actions to act differently based
        // on actual action is being performed on

        for(int i=1;i<11;i++){
            Movie currentMovie = randomMovie();
            System.out.println("Movie #"+i+" : "+currentMovie.getName()+"/n"+"Plot : "+currentMovie.plot()+"/n");
        }


    }


    public static Movie randomMovie(){

        //return a number between 1 and 5
        int randomNumber = (int)(Math.random()*5)+1;
        System.out.println("The Random Number Generated Was"+randomNumber);
        switch(randomNumber){
            case 1:
               return new Jaws();
               case 2:
                   return new IndependenceDay();
                    case 3:
                        return new MazeRunner();
                        case 4:
                            return new StarWars();
            case 5:
                return new Forgetable();


        }
        return null;
    }
}
