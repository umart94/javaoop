package com.example.game;

import java.util.ArrayList;
import java.util.List;

//i have copied files from another intellij project and pasted here
// you have to output a jar file from this project and include it in another project

public class Player implements com.example.game.ISaveable {
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0,this.name);
        values.add(1," " + this.hitPoints);
        values.add(2," " + this.strength);
        values.add(3," " + this.weapon);

        return values;
    }

    @Override
    public void read(ArrayList<String> savedValues) {
            if(savedValues != null && savedValues.size()>0){
                this.name = savedValues.get(0);
                this.hitPoints = Integer.parseInt(savedValues.get(1));
                this.strength = Integer.parseInt(savedValues.get(2));
                this.weapon = savedValues.get(3);

            }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}