import java.util.HashMap;

public class Fish {
    private String name;
    private int health;
    private double attack;
    private double speed;
    private String type;
    private int level;
    
    
    //  new Fish("Carp", 30, 5, 10)

    private HashMap<String,Fish> fishes = new HashMap<String,Fish>();

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
            new Fish("Hammerhead"50,5,4)
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

    public String getType(){
        return type;
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
