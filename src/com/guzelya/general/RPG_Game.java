package com.guzelya.general;

import com.guzelya.players.*;

import java.security.PublicKey;
import java.util.Random;

public class RPG_Game {
    private static int roundNumber;

    public static Random random = new Random();


    public static void start(){
        Boss boss = new Boss(700, 50);
        Warrior warrior = new Warrior(270, 15, "Warrior");
        Medic medic = new Medic(220, 5, "Medic", 15);
        Magic magic = new Magic(240, 20, "Magic");
        Berserk berserk = new Berserk(300, 20, "Berserk");
        Medic assistant = new Medic(250, 10, "Assistant", 15);

        Hero[] heroes = {warrior, medic, magic, assistant, berserk};

        printStatistics(heroes, boss);
        while(!isGameFinished(heroes, boss)){
            round(heroes, boss);
        }
    }

    private static void printStatistics(Hero[] heroes, Boss boss) {
        System.out.println("---ROUND " + roundNumber + "---");
        System.out.println("Boss health: " + boss. getHealth() + "[" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]. getHeroName() + " health: " + heroes[i].getHealth()
                    + "[" + heroes[i].getDamage() + "]");
        }
    }


    private static  void  bossHits(Hero[] heroes, Boss boss){
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && boss.getHealth() > 0){
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
            if (heroes[i].getHealth() < boss.getDamage()){
                heroes[i].setHealth(0);
            }
        }
    }

    private static void heroesHits(Hero[] heroes, Boss boss){
        for (int i = 0; i < (heroes.length-1); i++) {
            if(heroes[i].getHealth() > 0 && boss.getHealth() > 0){
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
            if (boss.getHealth() < heroes[i].getDamage()){
                boss.setHealth(0);
            }
        }
    }

    private static void useSuperAbility(Hero[] heroes, Boss boss){
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && boss.getHealth() > 0){
                heroes[i].useSuperAbility(heroes, boss);
            }
        }
    }

    private static boolean isGameFinished(Hero[] heroes, Boss boss){
        if(boss.getHealth() <= 0){
            System.out.println("Heroes won!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth()>0){
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead){
            System.out.println("Boss won!");
        }
        return allHeroesDead;
    }

    private static void round(Hero[] heroes, Boss boss){
        roundNumber++;
        bossHits(heroes, boss);
        heroesHits(heroes, boss);
        useSuperAbility(heroes, boss);
        printStatistics(heroes, boss);
    }


}
