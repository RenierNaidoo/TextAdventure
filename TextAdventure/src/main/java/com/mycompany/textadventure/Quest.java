/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textadventure;

import java.util.ArrayList;

public class Quest {

    private int ID;
    private String title;
    private String description;
    private ArrayList<QuestStep> qSteps;
    private QuestStep current;
    private int flag;
    private String flagInfo;

    public Quest(int id, String t, String d) {
        ID = id;
        title = t;
        description = d;
        qSteps = new ArrayList<>();
        current = null;
    }

    //Adds steps to a quest, meant to be used in quest formulation
    public void AddStep(String step) {
        QuestStep toAdd = new QuestStep(step);
        qSteps.add(toAdd);
        if (current == null) {
            current = toAdd;
        }
    }

    //Finds the next step based on input; else returns flagged output
    public String NextStep(String in) {
        String output;
        if (qSteps.indexOf(current) == (qSteps.size() - 1)) {
            output = "End of Quest";
        } else {
            int nextID = current.getNext(in);
            if (nextID == -1) {
                output = "Incorrect";
            } else {
                for (int i = 0; i < qSteps.size(); i++) {
                    if (qSteps.get(i).getID() == nextID) {
                        current = qSteps.get(i);
                    }
                }
                output = current.getDescription();
                flagInfo = current.getFlagInfo();
                flag = current.getFlag();
            }
        }
        return output;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }
    
    public String getFlagInfo(){
        return flagInfo;
    }

    public String getDescription() {
        return description;
    }
    
    public int getFlag() {
        return flag;
    }
    
    public void setFlag(int f){
        flag = f;
    }
}
