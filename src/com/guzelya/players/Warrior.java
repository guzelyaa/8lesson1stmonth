package com.guzelya.players;

import com.guzelya.players.Hero;
import com.guzelya.players.SuperAbility;

public class Warrior extends Hero {

    public Warrior(int health, int damage,  String heroName) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, heroName);
    }

    @Override
    public void useSuperAbility(Hero[] heroes, Boss boss) {

    }
}
