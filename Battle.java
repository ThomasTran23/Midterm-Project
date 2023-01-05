public class Battle {
    private Fish yourFish;
    private Fish enemyFish;
    NPC player;
    NPCFace face;
    
    public Battle(int level,NPC npc){
        this.player = npc;
        this.face = npc.face;
        this.yourFish = player.getFish();
        this.enemyFish = new Fish(level);

        
    }

    private void status_Effect(){
        
    }
}
