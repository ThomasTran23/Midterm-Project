public class Move {
    private double damage;
    private int accuracy;
    private String name;
    private int multiplier;
    private int stat;
    private boolean status = false;
    private int statusType;
    private String description;

    public Move(String name, double damage, int accuracy, int multiplier, int stat, boolean status, int statusType, String description){
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
        this.multiplier = multiplier;
        this.stat = stat;
        this.status = status;
        this.statusType = statusType;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public double getDamage(){
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

    public int getStatusType(){
        return statusType;
    }

    public int getStat(){
        return stat;
    }

    public String getDescription(){
        return description;
    }

}
