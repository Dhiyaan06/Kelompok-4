package Execute;

import java.util.Random;
import java.util.Scanner;

import Role.Human;
import Weapon.*;

public class Arena {
    public Human player;
    public Human enemy;
    public Weapon playerWeapon;
    public Weapon enemyWeapon;

    public Arena(Human player, Human enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public void startBattle(){
        while(player.getHp() > 0 && enemy.getHp() > 0){
            if(playerTurn()){
                if(menentukanPemenang()) break;
            }

            if(enemyTurn()){
                if(menentukanPemenang()) break;
                displayStatus();
            }
        }
    }

    public void menentukanLawan(){
        System.out.println(player.getRole() + " (" + player.getNamaWeapon()+") " + " >>>VS<<< " + enemy.getRole() + " (" + enemy.getNamaWeapon() + ")\n");
    }

    public void displayStatus(){
        System.out.println("\n---||STATUS||---");
        System.out.println("Status Pemain");
        System.out.println(player.getRole() + " HP : " + player.getHp());
        System.out.println(player.getNamaWeapon() + " Damage : " + player.getTotalDamage(player) + "\n");
        System.out.println("Status Lawan");
        System.out.println(enemy.getRole() + " HP : " + enemy.getHp());
        System.out.println(enemy.getNamaWeapon() + " Damage : " + enemy.getTotalDamage(enemy));
        System.out.println("----------------\n");
    }

    public boolean playerTurn(){
        System.out.println("Giliran Kamu!! (1)Menyerang (2)Bertahan");

        Scanner sc = new Scanner(System.in);

        int pilihan = sc.nextInt();
        if(pilihan == 1){
            player.attack(enemy);
        }
        else if(pilihan == 2){
            player.defend();
        }
        return true;
        
    }

    public boolean enemyTurn(){
        System.out.println("Giliran Lawan");

        Random random = new Random();
        int action = random.nextInt(2) + 1;
        if (action == 1){
            enemy.attack(player);
        } else {
            enemy.defend();
        }
        return true;
    }


    public boolean menentukanPemenang(){
        if(enemy.getHp() <= 0){
            System.out.println("Selamat Kamu Memenangkan Permainan!!");
            return true;
        } else if (player.getHp() <= 0) {
            System.out.println("Kamu Telah Terbunuh...");
            return true;
        }
        return false;
    }
    
}
    
