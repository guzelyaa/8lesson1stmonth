package com.guzelya.players;

import com.guzelya.players.Hero;
import com.guzelya.players.SuperAbility;

public class Berserk extends Hero {

    public Berserk(int health, int damage,  String heroName) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, heroName);
    }

    @Override
    public void useSuperAbility(Hero[] heroes, Boss boss) {
            if(heroes[4].getHealth() > 0 && boss.getHealth() > 0){
                boss.setHealth(boss.getHealth() - heroes[4].getDamage() - (boss.getDamage()/5));
            }
            if (boss.getHealth() < heroes[4].getDamage()){
                boss.setHealth(0);
            }
    }
    }
