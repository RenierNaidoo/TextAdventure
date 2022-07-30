/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textadventure;

import java.util.Hashtable;

public class QuestStep {
    private int ID;
    private int flag;
    private String flagInfo;
    private String description;
    private Hashtable<String, Integer> triggers;
    
    //Constructor to handle the creation of individual steps; note the form of steps
    public QuestStep(String step){
        triggers = new Hashtable<>();
        String[] items = step.split("#");
        ID = Integer.parseInt(items[0]);
        flag = Integer.parseInt(items[1]);
        flagInfo = items[2];
        description = items[3];
        int counter = 4;
        while(counter<items.length){
            triggers.put(items[counter], Integer.parseInt(items[counter+1]));
            counter += 2;
        }
    }

    public int getID() {
        return ID;
    }

    public int getFlag() {
        return flag;
    }

    public String getDescription() {
        return description;
    }
    
    public String getFlagInfo(){
        return flagInfo;
    }
    
    //gets the next step, else returns -1 to denote failure
    public int getNext(String t){
        int next;
        if(triggers.containsKey(t)){
            next = triggers.get(t);
        }else if(flag == 9999){// Special ignore flag to proceed to next step regrdless
            next = triggers.get("");
        }else{
           next = -1; 
        }
        return next;
    }
}
