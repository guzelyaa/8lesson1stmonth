package com.guzelya.players;

import com.guzelya.players.Hero;
import com.guzelya.players.SuperAbility;

public class Berserk extends Hero {

    public Berserk(int health, int damage,  String heroName) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, heroName);
    }

    @Override
    public void useSuperAbility(Hero[] heroes, Boss boss) {

    }
}
