/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.textadventure;

import java.util.ArrayList;

/*
Class meant to handle the progression of quests, such as performing actions,
retrieving next steps, and storing all existing quests. Facilitates branching.
*/

public class QuestHandler {
    
    private Quest current;
    private ArrayList<Quest> allQuests;
    private int flag;
    private String flagInfo;
    //private boolean flagSet;
   
    public QuestHandler(Quest q){
        current = q;
        flag = 0;
        //flagSet = false;
    }
    
    //Retrieves next step's output or relays error message
    public String NextStep(String in)
    {
        String output = current.NextStep(in);
        
        if(output.equals("Incorrect")){
            output = "That input is not valid. Try again";
        }
        flag = current.getFlag();
        flagInfo = current.getFlagInfo();
        return output;
    }
    
    //Retrieves next quest.
    public void FetchQuest(int ID){
        for(int i = 0; i < allQuests.size(); i++){
            if(allQuests.get(i).getID() == ID)
            {
                current = allQuests.get(i);
            }
        }
    }
    public int getFlag()
    {
        return flag;
    }
    
    public String getFlagInfo(){
        return flagInfo;
    }
}
