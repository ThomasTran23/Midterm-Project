import java.util.ArrayList;
import java.util.Collections;

public class NPC {

    NPCFace face;
    public Fish playerFish;
    public ArrayList<String> inventory = new ArrayList<String>();

    private String[] allItems = {"Pellet","Big Pellet","Bait","Smelly Bait","Fear Pheromone","Nightmare Pheromone"};

    


    public NPC(){
        face = new NPCFace();

        playerFish = new Fish("Hatchling", 30,1,3,0);

        inventory.add("Pellet");

        face.setImage("fisherman");
        face.setBackground("");

        face.popMessage("The Deep is calling.", "The Boatman");

        mainMenu();
    }

    public void mainMenu(){

        String[] menu = {
        "Cast Line",
        "View Fish",
        "View Items"
        };

        // face.setImage("fisherman");
        // face.setBackground("");

        // face.togglePanel(false);

        playerFish.levelScale();

        String s = face.popOption("What would you like to do?","The Boatman",menu,menu[0],null);
        if (s == null){
            mainMenu();
        }else if (s.equals(menu[0])){
            Battle(playerFish.getLevel());
        }else if (s.equals(menu[1])){
            viewStats();
        }else if(s.equals(menu[2])){
            viewInventory();
        }
        mainMenu();  
    }

    public Fish getFish(){
        return playerFish;
    }

    public void changeFish(Fish fish){
        playerFish = fish;
    }

    public void viewStats(){
        final String[] options = {"Change Name","Exit","View Moves"};
            int n = face.popConfirm(

                "\nLevel: " + playerFish.getLevel() +
                "\nHealth: " + playerFish.getScaledHealth() + " (" + playerFish.getHealth() + " + " + (playerFish.getScaledHealth() - playerFish.getHealth()) + ")" +
                "\nAttack: " + playerFish.getScaledAttack() + " (" + playerFish.getAttack() + " + " + (playerFish.getScaledAttack() - playerFish.getAttack()) + ")" +
                "\nSpeed: " + playerFish.getScaledSpeed() + " (" + playerFish.getSpeed() + " + " + (playerFish.getScaledSpeed() - playerFish.getSpeed()) + ")"
                
                ,playerFish.getName(),
                options,
                playerFish.getType()
                
            );
            if (n == 0){
                playerFish.setName(face.popText("What would you like to name you fish?", "Change Name", playerFish.getName(), "Cannot input null or empty string")); 
            }else if (n == 2){
                String message = "";
                for (Move m: playerFish.getMoveList()){
                    message += m.getName() + ": " + m.getDescription() + "\n";
                }
                face.popMessage(message, playerFish.getName() + "'s Moves");
            }
    }

    public void viewInventory(){
        String temp = "";
            if (inventory.size()>0){
                for (String item : inventory){
                temp += item + "\n";
                }
            }
            
            face.popMessage(temp, "Your Items");
    }

    //******************************************THIS IS THE GREAT BORDER OF BUGS***************************************** */

    private Fish enemyFish;
    boolean turn = true;
    boolean active;
    boolean win;
    boolean skip = false;
    boolean eskip = false;


    private void Battle(int level){
        this.enemyFish = new Fish(level);

        face.setBackground("battle_");
        face.setImage(enemyFish.getType());

        active = true;
        System.out.println(enemyFish.getName());

        if (playerFish.getScaledSpeed()<enemyFish.getScaledSpeed()){
            turn = false;
        }
        active = true;
        while (active){
            if (turn&&!skip){
                playerMenu();
                turn = !turn;
            }else if (skip){
                skip = !skip;
            }else if (!eskip){
                face.popMessage(processMove(enemyFish.getMoveList()[(int)(Math.random()*4)], playerFish,enemyFish),"Enemy");
                // System.out.println("enemy turn");
                turn = !turn;
            }else if (eskip){
                eskip = !eskip;
            }

            if (playerFish.getScaledHealth()<=0){
                active = false;
                win = false;
            }
            if (enemyFish.getScaledHealth()<=0){
                active = false;
                win = true;
            }

        }
        if (win){
            String[] options = {"Use " + enemyFish.getName() + " as your new fish","Obtain Items","Feed " + playerFish.getName()};

            face.popMessage("Congratulations! You successfully fished up a " + enemyFish.getName() + ".", "Victory!");
            int n = face.popConfirm("What would you like to do?", "Victory!", options, enemyFish.getName());
            if (n==0){
                changeFish(enemyFish);
            }else if(n ==1){
                int rand = (int)(Math.random()*100);
                String item;
                int num = enemyFish.getLevel()>playerFish.getLevel()?2 + enemyFish.getLevel():3;
                if (rand<=24){
                    item = allItems[0];
                }else if (rand<=47){
                    item = allItems[2];
                }else if (rand<=70){
                    item = allItems[4];
                }else if (rand<=80){
                    item = allItems[1];
                }else if (rand<=90){
                    item = allItems[3];
                }else{
                    item = allItems[5];
                }

                for (int i = 0;i<num;i++){
                    inventory.add(item);
                }                

                face.popMessage(num + num>0?item +"s":item + "recieved", "Item obtained!");
                
            }else if(n == 2){
                playerFish.levelUp(enemyFish.getLevel()>playerFish.getLevel()?2 + enemyFish.getLevel():3);
            }
        }

        turn = true;
        active = false;
        win = false;
        skip = false;
        eskip = false;

        
    }




    private void attackMenu(){
        String[] options = {null,null,null,null};
        for (int i = 0; i<options.length;i++){
            options[i] = playerFish.getMoveList()[i].getName();
        }
        String s = face.popOption("",
        playerFish.getName(),
        options,
        null,
        playerFish.getType());

        if (s == null){
            playerMenu();
        }

        for(Move m: playerFish.getMoveList()){
            if (m.getName().equals(s)){
                face.popMessage(processMove(m, enemyFish,playerFish), s);
                break;
            }
        }
    }

    private void playerMenu(){
        String[] options = {"Items","Attack","Check Stats"};

        int n = face.popConfirm("What would you like to do?", "Battle", options, playerFish.getType());

        if(n == 0){
            itemMenu();
        }else if (n == 1){
            attackMenu();
        }else{
            this.viewStats();
            playerMenu();
        }
    }

    private String processMove(Move move,Fish target,Fish user){
        // if (move.getDamage()>0){
        //     damageMove(move,target);
        // }else if (move.getMultiplier()>0){
        //     statMove(move, target);
        // }else{
        //     statusEffect(move, target);
        // }
        if (move.getTarget()){
            target = user;
        }
        String message = "";
        if((int)(Math.random()*move.getAccuracy())>target.getScaledSpeed()/3||move.getAccuracy()>=200){
            if (move.getDamage()>0){
                target.takeDamage(move.getDamage() * (1 + (user.getScaledAttack()/100)) );

            message += move.getName() + " hit! " + target.getName() + " took " +move.getDamage() + " damage. They're now at " + target.getScaledHealth() + " health.";
            }
            
            if(move.getMultiplier()>0){
                String changed;
                double temp;
                double after;
                if (move.getStat() == 0){
                    changed = "attack";
                    temp = target.getScaledAttack();
                    target.attackChange(move.getMultiplier());
                    after = target.getScaledAttack();
                }else{
                    changed = "speed";
                    temp = target.getScaledSpeed();
                    target.speedChange(move.getMultiplier());
                    after = target.getScaledSpeed();
                }
                message += message.length()>0?"\n":move.getName() + " hit! " ;
                message += target.getName() + "'s " + changed + " went from " + temp + " to " + after + ".";
            }

            if (move.getStatus()){
                // statusEffect(move, target);
                System.out.println("status run");
            }


        }else{
            message = move.getName() + " missed!";
        }

        return message;

    }

    private void itemMenu(){
        String[] temp = {"Pellet","Big Pellet","Bait","Smelly Bait","Fear Pheromone","Nightmare Pheromone"};
        for (int i = 0; i<temp.length;i++){
            temp[i] = allItems[i] + "x" + Collections.frequency(inventory, allItems[i]);
        }
        String result = face.popOption("Pick an item", "Item Menu", temp, temp[0], null);

        if (result == null){
            playerMenu();
        }

        String s = result.substring(0,result.indexOf("x"));

        if (Collections.frequency(inventory, s)>0){

            if (s.equals(allItems[0])){
                playerFish.heal(20.0);
                face.popMessage(playerFish.getName() +"'s health increased by 20!", s);

            }else if (s.equals(allItems[1])){
                playerFish.heal(100.0);
                face.popMessage(playerFish.getName() +"'s health increased by 100!", s);

            }else if (s.equals(allItems[2])){
                playerFish.attackChange(10);
                face.popMessage(playerFish.getName() +"'s attack increased by 10 percent!", s);

            }else if (s.equals(allItems[3])){
                playerFish.attackChange(50);
                face.popMessage(playerFish.getName() +"'s attack increased by 50 percent!", s);

            }else if (s.equals(allItems[4])){
                playerFish.speedChange(5);
                face.popMessage(playerFish.getName() +"'s speed increased by 5 percent!", s);

            }else if (s.equals(allItems[5])){
                playerFish.speedChange(25);
                face.popMessage(playerFish.getName() +"'s speed increased by 25 percent!", s);

            }
        }
        inventory.remove(s);
    }

    // private String damageMove(Move move,Fish target){
    //     if((int)(Math.random()*move.getAccuracy())>target.getScaledSpeed()||move.getAccuracy()>200){
    //         target.takeDamage(move.getDamage());
    //         if (move.getStatus()){
    //             statusEffect(move, target);
    //         }
    //         return move.getName() + " hit! " + target.getName() + " took " +move.getDamage() + " damage. They're now at " + target.getHealth() + " health.";
    //     }else{
    //         return move.getName() + " missed!";
    //     }
        
        
    // }

    // private String statMove(Move move,Fish target){
    //     if((int)(Math.random()*move.getAccuracy())>target.getScaledSpeed()||move.getAccuracy()>200){
    //         String changed;
    //         double temp;
    //         double after;
    //         if (move.getStat() == 0){
    //             changed = "attack";
    //             temp = target.getScaledAttack();
    //             target.attackChange(move.getMultiplier());
    //             after = target.getScaledAttack();
    //         }else{
    //             changed = "speed";
    //             temp = target.getScaledSpeed();
    //             target.speedChange(move.getMultiplier());
    //             after = target.getScaledAttack();
    //         }
    //         if (move.getStatus()){
    //             statusEffect(move, target);
    //         }
    //         return move.getName() + " hit! " + target.getName() + "'s " + changed + " went from " + temp + " to " + after + ".";
    //     }else{
    //         return move.getName() + " missed!";
    //     }
    // }

    // private String statusEffect(Move move,Fish target){
        
    // }

}
