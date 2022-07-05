package com.guzelya.players;

import com.guzelya.general.RPG_Game;
import com.guzelya.players.Hero;
import com.guzelya.players.SuperAbility;

public class Warrior extends Hero {

    public Warrior(int health, int damage,  String heroName) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, heroName);
    }

    @Override
    public void useSuperAbility(Hero[] heroes, Boss boss) {
        int coefficient = RPG_Game.random.nextInt(5)+2;
        if(heroes[0].getHealth() > 0){
            heroes[0].setDamage(heroes[0].getDamage() * coefficient);
        }
    }
}
