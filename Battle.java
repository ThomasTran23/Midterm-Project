import java.util.ArrayList;

public class Battle{
    private Fish yourFish;
    private Fish enemyFish;
    NPC player;
    NPCFace face;
    boolean turn = true;
    boolean active;
    boolean win;
    
    public Battle(int level,NPC npc){
        this.player = npc;
        this.face = npc.face;
        this.yourFish = player.getFish();
        this.enemyFish = new Fish(level);
        active = true;
        System.out.println(enemyFish.getName());

        

        double pSpeed = yourFish.getScaledSpeed();
        double pHealth = yourFish.getScaledHealth();     
        double pAttack = yourFish.getScaledAttack();   
        
        double eSpeed = enemyFish.getScaledSpeed();
        double eHealth = enemyFish.getScaledHealth();
        double eAttack = enemyFish.getScaledAttack();

        if (pSpeed<eSpeed){
            turn = false;
        }
        active = true;
        while (active){
            if (turn){
                
            }
        }


        
    }

    private void status_Effect(){
        
    }

    private String attackMenu(){
        String[] options = {null,null,null,null};
        for (int i = 0; i<options.length;i++){
            options[i] = yourFish.getName();
        }
        String s = face.popOption("",
        yourFish.getName(),
        options,
        null,
        yourFish.getType());

        return s;
    }

    private void playerMenu(){
        String[] options = {"Attack","Items","Check Stats"};

        int n = face.popConfirm("What would you like to do?", "Battle", options, yourFish.getName());

        System.out.println(n);
        
        playerMenu();

    }
}
