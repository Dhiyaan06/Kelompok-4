package Execute;

import Role.*;

public class Battlefield{
    public static void main(String[] args) {
    
    PilihChar pilih = new PilihChar();

    Human player = pilih.pilihKarakter();
    Human enemy = pilih.karakterMusuh();

    if(player == null && enemy == null){
        System.out.println("Karakter is not available");
        return;
    }

    Arena arena = new Arena(player, enemy);
    arena.displayStatus();
    arena.menentukanLawan();
    arena.startBattle();
    }
}
