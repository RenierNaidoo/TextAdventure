/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textadventure;

/**
 *
 * @author Maxine Van Der Merwe
 */
public class Player extends Character{
    
    public Player(String name, int classType){
        super(name);
        switch (classType) {
            case 1: //Warrior
                health = 100;
                STR = 4;
                DEX = 2;
                INT = 1;
                armour = 100;
                attack = 100;
                break;
            case 2: //Rogue
                health = 100;
                STR = 2;
                DEX = 5;
                INT = 2;
                armour = 70;
                attack = 80;
                break;
            case 3: //Wizard
                health = 100;
                STR = 1;
                DEX = 2;
                INT = 6;
                armour = 50;
                attack = 50;
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public String Stats(){
        String stats = "";
        stats += "Health = " + health + "   Armour = " + armour + "   Attack = " + attack +
                "\nStrength = " + STR + "   Dexterity = " + DEX + "   Intelligence = " + INT;
        System.out.println(stats);
        return stats;
    }
}
