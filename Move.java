public class Move {
    private double damage;
    private int accuracy;
    private String name;
    private int multiplier;
    private int stat;
    private boolean status = false;
    private int stunChance;
    private String description;
    private boolean target;

    public Move(String name, double damage, int accuracy, int multiplier, int stat, boolean status, int stunChance, String description,boolean target){
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
        this.multiplier = multiplier;
        this.stat = stat;
        this.status = status;
        this.stunChance = stunChance;
        this.description = description;
        this.target = target;
    }

    public String getName(){
        return name;
    }

    public double getDamage(){
        if (damage>100){
            if((int)(Math.random()*5)==0){
                if (name == "Kaboom"){
                    return (damage/100)*5;
                }else{
                    return (damage/100)*2;
                }
            }
        }
        return damage;
    }

    public int getAccuracy(){
        return accuracy;
    }

    public int getMultiplier(){
        return multiplier;
    }

    public boolean getStatus(){
        return status;
    }

    public int getstunChance(){
        return stunChance;
    }

    public int getStat(){
        return stat;
    }

    public String getDescription(){
        return description;
    }

    public boolean getTarget(){
        return target;
    }

}
