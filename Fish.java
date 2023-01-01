import java.util.HashMap;
import java.lang.Math;
// import java.util.ArrayList;

public class Fish {
    private String name;
    private double health;
    private double scaledHealth;
    private double attack;
    private double scaledAttack;
    private double speed;
    private double scaledSpeed;
    private String type;
    private int level;

    private HashMap<String,Fish> fishes = new HashMap<String,Fish>();

    public String[] fishArray = {"Hatchling","Jellyfish","Turtle(Shell)","Squibi","Octopus",
    "Blue Carp","Red Carp","Rainbow Carp","Jellyfish(Scary)",
    "Turtle(No Shell)","Squeed","Blue Ring",
    "Hammerhead","Shark","Orca","Whale",
    "Hammerhead(Angry)","Shark(Angry)","Orca(Scary)","Whale(Scary)"};

    public Fish(String name, int health, double attack, double speed){
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
    }

    private void fishes_init(){
        fishes.put(
            "Hatchling",
            new Fish("Hatchling",30,1,3)
        );

        fishes.put(
            "Blue Carp",
            new Fish("Blue Carp",60,3,4)
        );

        fishes.put(
            "Red Carp",
            new Fish("Red Carp", 50,5,4)
        );

        fishes.put(
            "Rainbow Carp",
            new Fish("Rainbow Carp",55,4,4)
        );

        fishes.put(
            "Jellyfish",
            new Fish("Jellyfish",35,3,3)
            );

        fishes.put(
            "Jellyfish(Scary)",
            new Fish("Jellyfish(Scary)",50,5,4)
            );

        fishes.put(
            "Turtle(Shell)",
            new Fish("Turtle(Shell)",75,2,2)
            );

        fishes.put(
            "Turtle(No Shell)",
            new Fish("Turtle(No Shell)",50,5,7)
            );

        fishes.put(
            "Squibi",
            new Fish("Squibi",25,2,5)
            );

        fishes.put(
            "Squeed",
            new Fish("Squeed",45,4,8)
            );

        fishes.put(
            "Octopus",
            new Fish("Octopus",30,3,3)
            );

        fishes.put(
            "Blue Ring",
            new Fish("Blue Ring",45,5,5)
            );

        fishes.put(
            "Hammerhead",
            new Fish("Hammerhead",50,5,4)
            );

        fishes.put(
            "Hammerhead(Angry)",
            new Fish("Hammerhead(Angry)",75,8,5)
            );

        fishes.put(
            "Shark",
            new Fish("Shark",50,5,4)
            );

        fishes.put(
            "Shark(Angry)",
            new Fish("Shark(Angry)",75,6,7)
            );

        fishes.put(
            "Orca",
            new Fish("Orca",50,6,3)
            );

        fishes.put(
            "Orca(Scary)",
            new Fish("Orca(Scary)",80,7,5)
            );

        fishes.put(
            "Whale",
            new Fish("Whale",60,4,4)
            );

        fishes.put(
            "Whale(Scary)",
            new Fish("Whale(Scary)",100,6,4)
            );

    }


    

    public Fish(int level){
        this.fishes_init();
        int base;
        int cap;
        if (level<=20){
            base = 0;
            cap = 5;
        }else if(level<=40){
            base = 5;
            cap = 4;
        }else if(level <=60){
            base = 9;
            cap = 3;
        }else if(level <= 80){
            base = 12;
            cap = 4;
        }else{
            base = 16;
            cap = 4;
        }
        Fish temp = fishes.get(fishArray[(int)(Math.random()*cap) + base]);

        this.name = temp.name;
        this.health = temp.health;
        this.attack = temp.attack;
        this.speed = temp.speed;
        this.type = temp.name;

        this.level = level;
        
        this.levelScale();
    }

    public String getName(){
        return name;
    }
    
    public double getHealth(){
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

    public String getType(){
        return type;
    }

    public double getScaledHealth(){
        return scaledHealth;
    }

    public double getScaledAttack(){
        return scaledAttack;
    }
    
    public double getScaledSpeed(){
        return scaledSpeed;
    }

    public void setName(String name){
        this.name = name;
    }

    public void takeDamage(double damage){
        this.scaledHealth -= damage;
    }

    public void heal(double heal){
        this.scaledHealth += heal;
    }

    public void attackChange(int multiplier){
        this.scaledAttack *= 1+ (multiplier/100);
    }

    public void speedChange(int multiplier){
        this.scaledSpeed *= 1 + (multiplier/100);
    }

    public void levelUp(int level){
        if (this.level!=100){
            if((this.level+level)<=100){
                this.level += level;
            } else if ((this.level + level)>100){
                this.level = 100;
            }
        }
        
    }

    public void levelScale(){
        this.scaledHealth = Math.floor((health + (level*health/5))*10)/10;
        this.scaledAttack = Math.floor((attack + (level*attack/8))*10)/10;
        this.scaledSpeed = Math.floor((speed + (level*speed/10))*10)/10;
    }
}
