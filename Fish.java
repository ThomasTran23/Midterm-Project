import java.util.ArrayList;
import java.util.HashMap;

import java.lang.Math;

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
    private boolean evolved;
    private int threshold;

    private HashMap<String,Fish> fishes = new HashMap<String,Fish>();

    private HashMap<String,Move[]> allMoves = new HashMap<String,Move[]>();

    private Move[] moveList;

    public String[] fishArray = {"Hatchling","Jellyfish","Turtle(Shell)","Squibi","Octopus",
    "Hatchling(Hatched_Blue)","Hatchling(Hatched_Red)","Hatchling(Hatched_Rainbow)","Jellyfish(Scary)",
    "Turtle(No Shell)","Squibi(Adult)","Octopus(Blue-Ring)",
    "Hammerhead","Shark","Orca","Whale",
    "Hammerhead(Angry)","Shark(Angry)","Orca(Scary)","Whale(Scary)"};

    public Fish(String name, int health, double attack, double speed,boolean evolved){
        moves_init();
        this.name = name;
        this.type = this.name;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
        this.evolved = evolved;
        if(!this.evolved){
            this.threshold = level + (int)(Math.random()*20) + 10;
        }
        this.moveList = allMoves.get(this.type);
        // for (Move m : getMoveList()){
        //     System.out.println(m.getName());
        // }
    }

    public Fish(String name, int health, double attack, double speed,int level){
        moves_init();
        this.name = name;
        this.type = name;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
        this.evolved = false;
        this.level = level;

        this.threshold = level + (int)(Math.random()*20) + 10;

        this.levelScale();

        this.moveList = allMoves.get(this.type);
        

        // for (Move m : getMoveList()){
        //     System.out.println(m.getName());
        // }
    }

    private void fishes_init(){
        fishes.put(
            "Hatchling",
            new Fish("Hatchling",30,1,3,false)
        );

        fishes.put(
            "Hatchling(Hatched_Blue)",
            new Fish("Hatchling(Hatched_Blue)",60,3,4,true)
        );

        fishes.put(
            "Hatchling(Hatched_Red)",
            new Fish("Hatchling(Hatched_Red)", 50,5,4,true)
        );

        fishes.put(
            "Hatchling(Hatched_Rainbow)",
            new Fish("Hatchling(Hatched_Rainbow)",55,4,4,true)
        );

        fishes.put(
            "Jellyfish",
            new Fish("Jellyfish",35,3,3,false)
            );

        fishes.put(
            "Jellyfish(Scary)",
            new Fish("Jellyfish(Scary)",50,5,4,true)
            );

        fishes.put(
            "Turtle(Shell)",
            new Fish("Turtle(Shell)",75,2,2,false)
            );

        fishes.put(
            "Turtle(No Shell)",
            new Fish("Turtle(No Shell)",50,5,7,true)
            );

        fishes.put(
            "Squibi",
            new Fish("Squibi",25,2,5,false)
            );

        fishes.put(
            "Squibi(Adult)",
            new Fish("Squibi(Adult)",45,4,8,true)
            );

        fishes.put(
            "Octopus",
            new Fish("Octopus",30,3,3,false)
            );

        fishes.put(
            "Octopus(Blue-Ring)",
            new Fish("Octopus(Blue-Ring)",45,5,5,true)
            );

        fishes.put(
            "Hammerhead",
            new Fish("Hammerhead",50,5,4,false)
            );

        fishes.put(
            "Hammerhead(Angry)",
            new Fish("Hammerhead(Angry)",75,8,5,true)
            );

        fishes.put(
            "Shark",
            new Fish("Shark",50,5,4,false)
            );

        fishes.put(
            "Shark(Angry)",
            new Fish("Shark(Angry)",75,6,7,true)
            );

        fishes.put(
            "Orca",
            new Fish("Orca",50,6,3,false)
            );

        fishes.put(
            "Orca(Scary)",
            new Fish("Orca(Scary)",80,7,5,true)
            );

        fishes.put(
            "Whale",
            new Fish("Whale",60,4,4,false)
            );

        fishes.put(
            "Whale(Scary)",
            new Fish("Whale(Scary)",100,6,4,true)
            );

    }

    public void moves_init(){
        
        Move[] hatchMoves = {new Move("Nibble", 10.0, 70, 0, 0, false, 1, "Hatchling nibbles the target dealing a small ammount of damage", false),
        new Move("Flop", 0, 200, -5, 0, false, 1, "Hatchling flops around, looking harmless. The target feels less motivated to do damage. ", false),
        new Move("Splash", 15.0, 40, 0, 0, false, 1, "The hatchling tries to splash the target with its tail, doing a bit of damage and looking cute as a button", false),
        new Move("Squirt", 2.0, 201, 0, 0, false, 1, "The hatchling shoots water in its mouth at the target with extreme precision, dealing minimal damage.", false)};

    allMoves.put("Hatchling", hatchMoves);

   
       Move[] jellyMoves =  {new Move("Sting", 10.0, 60, 0, 0, true, 30, "Jelly stings the target causing a small ammount of damage, but the target may be to stunned to attack", false),
        new Move("Whip", 5.0, 200, 0, 0, false, 0, "Jelly swings its tentacles at the target with extreme precision, dealing a bit of damage.", false),
        new Move("Regenerate", -15.0, 201, 0, 0, false, 1, "Jelly regrows it's broken tentacles, healing a small ammount of HP", true),
        new Move("Splash", 15.0, 40, 0, 0, false, 1, "Jelly tries to splash the target with its tentacles, doing a bit of damage and looking cute as a button", false)};
     
        allMoves.put("Jellyfish", jellyMoves); 
        
     Move[] jellysMoves =  {new Move("Sting", 10.0, 60, 0, 0, true, 30, "Scary Jelly stings the target causing a small ammount of damage, but the target may be to stunned to attack", false),
        new Move("Whip", 5.0, 200, 0, 0, false, 0, "Scary Jelly swings its tentacles at the target with extreme precision, dealing a bit of damage.", false),
        new Move("Regneration", -15.0, 201, 0, 0, false, 1, "Scary Jelly regrows it's broken tentacles, healing a small ammount of HP", true),
        new Move("poison", 50.0, 20, 0, 0, false, 1, "Scary Jelly clumsly attempts to stick all of its tentacles on the target, dealing lots of damage", false)};
     
     allMoves.put("Jellyfish(Scary)", jellysMoves); 

              Move[] shellMoves =  {new Move("Eat Grass", -15.0, 201, 0, 0, false, 0, "The shelled turtle eats some seagrass and heals some HP", true),
        new Move("Bonk", 15.0, 35, 0, 0, false, 0, "The shelled turtle tries to ram itself into the target, dealing high damage when it hits.", false),
        new Move("Spin", 0.0, 201, 5, 1, false, 1, "The shelled turtle spins in a circle, feeling quicker than before", true),
        new Move("Punch", 10.0, 60, 0, 0, false, 1, "The shelled turtle punches the target with high precision, dealing some damage", false)};
     
     allMoves.put("Turtle(Shell)", shellMoves); 

         Move[] nshellMoves =  {new Move("Eat Grass", -15.0, 201, 0, 0, false, 0, "The turtle eats some seagrass and heals some HP", true),
        new Move("Bonk", 20.0, 35, 0, 0, false, 0, "The turtle tries to ram itself into the target, dealing high damage when it hits.", false),
        new Move("Chomp", 15.0, 70, 0, 0, false, 1, "The turtle bites down on the target, dealing some damage", false),
        new Move("Hide", 15.0, 60, -15, 0, false, 1, "The turtle hides in it's shell, the target does less damage now", false)};
     
     allMoves.put("Turtle(NoShell)", nshellMoves); 

          Move[] squibiMoves =  {new Move("Slap", 10.0, 70, 0, 0, true, 30, "The small squid slaps the target with its tentacles, dealing medium damage", false),
        new Move("Squirt", 5.0, 201, 0, 0, false, 0, "The small squid shoots water in its mouth at the target with extreme precision, dealing minimal damage.", false),
        new Move("Camouflage", 0, 70, 10, 1, false, 1, "The small squid camouflages itself, making it harder to hit", true),
        new Move("Whip", 5.0, 200, 0, 0, false, 1, "The small squid whips the target with its tentacles, dealing small damge with high precision", false)};
     
     allMoves.put("Squibi", squibiMoves); 

     Move[] gsquibiMoves =  {new Move ("Splash", 15.0, 40, 0, 0, false, 1, "The large squid tries to splash the target with its tentacles, doing a bit of damage and looking cute as a button", false),
     new Move("Grab", 5.0, 60, 0, 0, true, 50, "The large squid wraps it's arms around the target, dealing a small ammount of damage and incapacatating them", false),
     new Move("Camouflage", 0, 70, 10, 1, false, 1, "The large squid camouflages itself, making it harder to hit", true),
     new Move("Chomp", 15.0, 70, 0, 0, false, 1, "The large squid bites down on the target with it's beak, dealing some damage", false)};
  
  allMoves.put("Squibi(Adult)", gsquibiMoves); 

  Move[] octopusMoves =  {new Move ("Whip", 5.0, 200, 0, 0, false, 1, "The octopus whips the target with its tentacles, dealing small damge with high precision", false),
  new Move("Grab", 5.0, 60, 0, 0, true, 50, "The octopus wraps it's arms around the target, dealing a small ammount of damage and incapacatating them", false),
  new Move("Camouflage", 0, 70, 10, 1, false, 1, "The octopus camouflages itself, making it harder to hit", true),
  new Move("Chomp", 15.0, 70, 0, 0, false, 1, "The octopus bites down on the target with it's beak, dealing some damage", false)};

allMoves.put("Octopus", octopusMoves); 

Move[] boctopusMoves =  {new Move ("Sting", 10.0, 60, 0, 0, true, 30, "The blue-ring octopus stings the target causing a small ammount of damage, but the target may be to stunned to attack", false),
new Move("Grab", 5.0, 60, 0, 0, true, 50, "The blue-ring octopus wraps it's arms around the target, dealing a small ammount of damage and incapacatating them", false),
new Move("poison", 50.0, 20, 0, 0, false, 1, "The blue-ring octopus clumsly attempts to stick all of its tentacles on the target, dealing lots of damage", false),
new Move("Bite", (Math.random()*2)*20.0, 50, 0, 0, false, 1, "The blue-ring octopus chomps hard down on the target with it's beak, dealing good damage and sometimes lots", false)};

allMoves.put("Octopus(Blue-Ring)", boctopusMoves); 

Move[] hammerheadMoves =  {new Move ("Hammer", 80.0, 40, 0, 0, true, 30, "The hammerhead whallops the target with it's large hammer, it isn't very precise but does high damage and the target may be too stunned to attack", false),
new Move("Punch", 10.0, 60, 0, 0, false, 1, "The hammerhead punches the target with high precision, dealing some damage", false),
new Move("Splash", 15.0, 40, 0, 0, false, 1, "The hammerhead tries to splash the target with its tentacles, doing a bit of damage and looking cute as a button", false),
new Move("Chomp", 15.0, 70, 0, 0, false, 1, "The hammerhead bites down on the target with it's beak, dealing some damage", false)};

allMoves.put("Hammerhead", hammerheadMoves); 

Move[] shammerheadMoves =  {new Move ("Hammer", 80.0, 40, 0, 0, true, 30, "The angry hammerhead whallops the target with it's large hammer, it isn't very precise but does high damage and the target may be too stunned to attack", false),
new Move("Grab", 5.0, 60, 0, 0, true, 50, "The angry hammerhead grabs the target in it's jaws, dealing a small ammount of damage and incapacatating them", false),
new Move("Wave", 75.0, 40, 0, 0, false, 1, "The angry hammerhead causes a large wave towards the target, it might miss but it does high damage", false),
new Move("Bite", (Math.random()*2)*20.0, 50, 0, 0, false, 1, "The angry hammerhead chomps hard down on the target, dealing good damage and sometimes lots", false)};

allMoves.put("Hammerhead(Angry)", shammerheadMoves); 

Move[] sharkMoves =  {new Move ("Punch", 10.0, 60, 0, 0, false, 1, "The shark punches the target with high precision, dealing some damage", false),
new Move("Grab", 5.0, 60, 0, 0, true, 50, "The shark grabs the target in it's jaws, dealing a small ammount of damage and incapacatating them", false),
new Move("Wave", 75.0, 40, 0, 0, false, 1, "The shark causes a large wave towards the target, it might miss but it does high damage", false),
new Move("Bite", (Math.random()*2)*20.0, 50, 0, 0, false, 1, "The shark chomps hard down on the target, dealing good damage and sometimes lots", false)};

allMoves.put("Shark", sharkMoves); 

Move[] asharkMoves =  {new Move ("Body Slam", 90.0, 70, 0, 0, true, 20, "The shark launches onto the target with high precision, dealing insane damage with a chance to stun the target", false),
new Move("Grab", 5.0, 60, 0, 0, true, 50, "The angry shark grabs the target in it's jaws, dealing a small ammount of damage and incapacatating them", false),
new Move("Wave", 75.0, 40, 0, 0, false, 1, "The angry shark causes a large wave towards the target, it might miss but it does high damage", false),
new Move("Bite", (Math.random()*2)*20.0, 50, 0, 0, false, 1, "The angry shark chomps hard down on the target, dealing good damage and sometimes lots", false)};

allMoves.put("Shark(Angry)", asharkMoves); 

Move[] orcaMoves =  {new Move ("Body Slam", 90.0, 70, 0, 0, true, 20, "The orca launches onto the target with high precision, dealing insane damage with a chance to stun the target", false),
new Move("Spout", 70.0, 201, 0, 0, false, 50, "The orca shoots the target with an extremely precise shot of water from it's blowhole dealing high damage", false),
new Move("Wave", 75.0, 40, 0, 0, false, 1, "The orca causes a large wave towards the target, it might miss but it does high damage", false),
new Move("Bite", (Math.random()*2)*20.0, 50, 0, 0, false, 1, "The orca chomps hard down on the target, dealing good damage and sometimes lots", false)};

allMoves.put("Orca", orcaMoves); 

Move[] aorcaMoves =  {new Move ("Body Slam", 90.0, 70, 0, 0, true, 20, "The angry orca launches onto the target with high precision, dealing insane damage with a chance to stun the target", false),
new Move("Spout", 70.0, 201, 0, 0, false, 50, "The angry orca shoots the target with an extremely precise shot of water from it's blowhole dealing high damage", false),
new Move("Tsunami", 75.0, 40, 0, 0, false, 1, "The angry orca causes a 200ft tsunami wiping out everything in it's path, it might miss but it does absurd damage", false),
new Move("Devour", (Math.random()*2)*65.0, 50, 0, 0, false, 1, "The angry orca takes out chunks of the target with it's teeth, dealing high damage with a chance to do absurd damage", false)};

allMoves.put("Orca(Scary)", aorcaMoves); 

Move[] whaleMoves =  {new Move ("Body Slam", 90.0, 70, 0, 0, true, 20, "The whale launches onto the target with high precision, dealing insane damage with a chance to stun the target", false),
new Move("Spout", 70.0, 201, 0, 0, false, 50, "The whale shoots the target with an extremely precise shot of water from it's blowhole dealing high damage", false),
new Move("Tsunami", 75.0, 40, 0, 0, false, 1, "The whale causes a 200ft tsunami wiping out everything in it's path, it might miss but it does absurd damage", false),
new Move("Grab", 5.0, 60, 0, 0, true, 50, "The whale grabs the target in it's massive mouth, dealing a small ammount of damage and incapacatating them", false)};

allMoves.put("Whale", whaleMoves); 

Move[] swhaleMoves =  {new Move ("Kaboom", (Math.random()*5)*65.0, 40, 0, 0, true, 20, "The scary whale launches onto the target, it's extreme weight causing anywhere from medium to indiscribably high damage", false),
new Move("Spout", 70.0, 201, 0, 0, false, 50, "The scary whale shoots the target with an extremely precise shot of water from it's blowhole dealing high damage", false),
new Move("Tsunami", 75.0, 40, 0, 0, false, 1, "The scary whale causes a 200ft tsunami wiping out everything in it's path, it might miss but it does absurd damage", false),
new Move("Grab", 5.0, 60, 0, 0, true, 50, "The scary whale grabs the target in it's massive mouth, dealing a small ammount of damage and incapacatating them", false)};

allMoves.put("Whale(Scary)", swhaleMoves); 



    }


    

    public Fish(int level){
        this.fishes_init();
        this.moves_init();
        int base = 0;
        int cap;
        if (level<=20){
            cap = 5;
        }else if(level<=40){
            cap = 9;
        }else if(level <=60){
            cap = 12;
        }else if(level <= 80){
            cap = 16;
        }else{
            cap = fishArray.length;
        }
        Fish temp = fishes.get(fishArray[(int)(Math.random()*cap) + base]);

        this.name = temp.name;
        this.health = temp.health;
        this.attack = temp.attack;
        this.speed = temp.speed;
        this.type = temp.name;

        this.level = level-5>=0?level+(int)(Math.random()*10)-5:level+(int)(Math.random()*5)-level;

        this.moveList = allMoves.get(this.type);
        
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

    public Move[] getMoveList(){
        return moveList;
    }

    public void setName(String name){
        this.name = name;
    }

    public void takeDamage(double damage){
        this.scaledHealth -= damage;
    }

    public void heal(double heal){
        if (scaledHealth+heal>=Math.floor((health + (level*health/5))*10)/10){
            scaledHealth = Math.floor((health + (level*health/5))*10)/10;
        }else{
            this.scaledHealth += heal;
        }
        
        
    }

    public void attackChange(int multiplier){
        this.scaledAttack += multiplier;
    }

    public void speedChange(int multiplier){
        this.scaledSpeed = this.scaledAttack * 1+ (multiplier/5);
    }

    public boolean levelUp(int level){
        if (this.level!=100){
            if((this.level+level)<=100){
                this.level += level;
            } else if ((this.level + level)>100){
                this.level = 100;
            }
        }
        return level>=threshold&&!evolved;
    }

    public void levelScale(){
        this.scaledHealth = Math.floor((health + (level*health/5))*10)/10;
        this.scaledAttack = Math.floor((attack + (level*attack/8))*10)/10;
        this.scaledSpeed = Math.floor((speed + (level*speed/10))*10)/10;
    }

    public Fish evolve(){
        ArrayList<Fish> evolutions = new ArrayList<Fish>();
        for (String s: fishArray){
            if (s.length()>= this.type.length()){
                if (this.type.equals(s.substring(0,type.length()))){
                                evolutions.add(fishes.get(s));
                }
            }
        }
        return evolutions.get((int)(Math.random()*evolutions.size()));

    }
}
