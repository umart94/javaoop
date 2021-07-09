package com.umartariq;

import java.util.ArrayList;


//player is upper bound of T
public class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    private int NumberofPlayedGames = 0;
    private int NumberofWonGames = 0;
    private int NumberofLostGames = 0;
    private int NumberofTiedGames = 0;

    private ArrayList<T> members = new ArrayList<>();
    //T will be replaced by the type we use with the class


    public Team(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean addPlayer(T player){
        if (members.contains(player)){
            System.out.println( ((Player)player).getName() + "is already on the team");
            return false;
        } else {
            members.add(player);
            System.out.println(((Player)player).getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent,int ourScore,int theirScore){
        String message;
        if(ourScore > theirScore){
            NumberofWonGames++;
            message = " beat ";
        } else if(ourScore == theirScore){
            NumberofTiedGames++;
            message = " drew with ";
        } else {
            NumberofLostGames++;
            message = " lost to ";
        }
        NumberofPlayedGames++;
        if(opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null,theirScore,ourScore);
        }
    }

    public int ranking(){
        return (NumberofWonGames * 2) + NumberofTiedGames;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() > team.ranking()){
            return -1;
        }
        else if(this.ranking() < team.ranking())
        {
            return 1;
        }else {
            return 0;
        }
    }
}
