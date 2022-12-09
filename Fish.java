import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.ArrayList;

public class Fish {
    private String name;
    private int health;
    private double attack;
    private double speed;
    private int level;

    
    
    //  new Fish("Carp", 30, 5, 10)


    public Fish(String name, int health, double attack, double speed){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
    }

    public String getName(){
        return name;
    }
    
    public int getHealth(){
        return health;
    }

    public double getAttack(){
        return attack;
    }

    public double getSpeed(){
        return speed;
    }

    public int getLevel(){
        return level;
    }

    public void setName(String name){
        this.name = name;
    }

    public void takeDamage(int damage){
        this.health -= damage;
    }

    public void attackChange(int multiplier){
        this.attack *= 1+ (multiplier/100);
    }

    public void speedChange(int multiplier){
        this.speed *= 1 + (multiplier/100);
    }

    public void levelUp(int level){
        this.level += level;
    }
}
