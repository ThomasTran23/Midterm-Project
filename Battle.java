// import java.util.ArrayList;

// public class Battle{
//     private Fish yourFish;
//     private Fish enemyFish;
//     NPC player;
//     NPCFace face;
//     boolean turn = true;
//     boolean active;
//     boolean win;
//     boolean skip = false;
//     boolean eskip = false;
    
//     public Battle(int level,NPC npc){
//         this.player = npc;
//         this.face = npc.face;
//         this.yourFish = player.getFish();
//         this.enemyFish = new Fish(level);

//         face.setBackground("battle_");

//         active = true;
//         System.out.println(enemyFish.getName());

//         if (yourFish.getScaledSpeed()<enemyFish.getScaledSpeed()){
//             turn = false;
//         }
//         active = true;
//         while (active){
//             if (turn&&!skip){
//                 playerMenu();
//             }else if (skip){
//                 skip = !skip;
//             }else if (!eskip){
//                 processMove(enemyFish.getMoveList()[(int)(Math.random()*4)], yourFish);
//             }else if (eskip){
//                 eskip = !eskip;
//             }

//             if (yourFish.getScaledHealth()<=0){
//                 active = false;
//                 win = false;
//             }
//             if (enemyFish.getScaledHealth()<=0){
//                 active = false;
//                 win = true;
//             }

//         }
//         if (win){

//         }

        
//     }

    

//     private void attackMenu(){
//         String[] options = {null,null,null,null};
//         for (int i = 0; i<options.length;i++){
//             options[i] = yourFish.getMoveList()[i].getName();
//         }
//         String s = face.popOption("",
//         yourFish.getName(),
//         options,
//         null,
//         yourFish.getType());

//         for(Move m: yourFish.getMoveList()){
//             if (m.getName() == s){
//                 processMove(m, enemyFish);
//                 break;
//             }
//         }
//     }

//     private void playerMenu(){
//         String[] options = {"Items","Attack","Check Stats"};

//         int n = face.popConfirm("What would you like to do?", "Battle", options, yourFish.getType());

//         if(n == 0){
//             player.viewInventory();
//         }else if (n == 1){
//             attackMenu();
//         }else{
//             player.viewStats();
//         }
//     }

//     private String processMove(Move move,Fish target){
//         // if (move.getDamage()>0){
//         //     damageMove(move,target);
//         // }else if (move.getMultiplier()>0){
//         //     statMove(move, target);
//         // }else{
//         //     statusEffect(move, target);
//         // }
//         String message = "";
//         if((int)(Math.random()*move.getAccuracy())>target.getScaledSpeed()||move.getAccuracy()>200){
//             if (move.getDamage()>0){
//                 target.takeDamage(move.getDamage());

//             message += move.getName() + " hit! " + target.getName() + " took " +move.getDamage() + " damage. They're now at " + target.getHealth() + " health.";
//             }
            
//             if(move.getMultiplier()>0){
//                 String changed;
//                 double temp;
//                 double after;
//                 if (move.getStat() == 0){
//                     changed = "attack";
//                     temp = target.getScaledAttack();
//                     target.attackChange(move.getMultiplier());
//                     after = target.getScaledAttack();
//                 }else{
//                     changed = "speed";
//                     temp = target.getScaledSpeed();
//                     target.speedChange(move.getMultiplier());
//                     after = target.getScaledAttack();
//                 }
//                 message += message.length()>0?"\n":move.getName() + " hit! " ;
//                 message += target.getName() + "'s " + changed + " went from " + temp + " to " + after + ".";
//             }

//             if (move.getStatus()){
//                 statusEffect(move, target);
//             }


//         }else{
//             message = move.getName() + " missed!";
//         }

//         return message;

//     }

//     // private String damageMove(Move move,Fish target){
//     //     if((int)(Math.random()*move.getAccuracy())>target.getScaledSpeed()||move.getAccuracy()>200){
//     //         target.takeDamage(move.getDamage());
//     //         if (move.getStatus()){
//     //             statusEffect(move, target);
//     //         }
//     //         return move.getName() + " hit! " + target.getName() + " took " +move.getDamage() + " damage. They're now at " + target.getHealth() + " health.";
//     //     }else{
//     //         return move.getName() + " missed!";
//     //     }
        
        
//     // }

//     // private String statMove(Move move,Fish target){
//     //     if((int)(Math.random()*move.getAccuracy())>target.getScaledSpeed()||move.getAccuracy()>200){
//     //         String changed;
//     //         double temp;
//     //         double after;
//     //         if (move.getStat() == 0){
//     //             changed = "attack";
//     //             temp = target.getScaledAttack();
//     //             target.attackChange(move.getMultiplier());
//     //             after = target.getScaledAttack();
//     //         }else{
//     //             changed = "speed";
//     //             temp = target.getScaledSpeed();
//     //             target.speedChange(move.getMultiplier());
//     //             after = target.getScaledAttack();
//     //         }
//     //         if (move.getStatus()){
//     //             statusEffect(move, target);
//     //         }
//     //         return move.getName() + " hit! " + target.getName() + "'s " + changed + " went from " + temp + " to " + after + ".";
//     //     }else{
//     //         return move.getName() + " missed!";
//     //     }
//     // }

//     private String statusEffect(Move move,Fish target){
        
//     }


// }
