public class Move {
    private double damage;
    private int accuracy;
    private String name;
    private int multiplier;
    private int stat;
    private boolean status = false;
    private int statusType;

    public Move(String name, double damage, int accuracy){
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public Move(String name, int multiplier, int accuracy, int stat){
        this.name = name;
        this.multiplier = multiplier;
        this.accuracy = accuracy;
        this.stat = stat;
    }

    public Move(String name, boolean status, int statusType, int accuracy){
        this.name = name;
        this.status = status;
        this.statusType = statusType;
        this.accuracy = accuracy;
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

}
