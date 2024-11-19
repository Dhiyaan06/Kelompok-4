package Execute;

import java.util.Random;
import java.util.Scanner;

import Role.*;
import Weapon.*;

public class PilihChar {

    public PilihChar(){}
    Human player = null;
    Human enemy = null;

    Weapon playerWeapon = null;
    Weapon enemyWeapon = null;

    Scanner sc = new Scanner(System.in);

    public Human pilihKarakter(){
        System.out.println("Pilih Role : (1)Spartan (2)Assasin (3)Archer");
        int pil = sc.nextInt();
        switch(pil){
            case 1: player = new Spartan();
            break;

            case 2: player = new Assassin();           
            break;

            case 3: player = new Archer();
            break;
        
        }


        System.out.println("Pilih Senjata : (1)Sword (2)Katana (3)Bow");
        int pil1 = sc.nextInt();
        switch(pil1){
            case 1: playerWeapon = new Sword();
            break;

            case 2: playerWeapon = new Katana();
            break;

            case 3: playerWeapon = new Bow();
        }
        player.setWeapon(playerWeapon);
        return player;
        
    }

    public Human karakterMusuh(){
        System.out.println("Karakter Musuh (ACAK)");
        Random random = new Random();
        int bot = random.nextInt(3) + 1;
        switch (bot) {
            case 1: enemy = new Spartan();
            break;
            
            case 2: enemy = new Assassin();
            break;

            case 3: enemy = new Archer();
            break;
            
        }
        
        int botwpn = random.nextInt(3) + 1;
        switch (botwpn) {
            case 1: enemyWeapon = new Sword();
            break;
        
            case 2: enemyWeapon = new Katana();
            break;

            case 3: enemyWeapon = new Bow();
            break;
        }
        enemy.setWeapon(enemyWeapon);
        return enemy;
    }
}
