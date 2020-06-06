/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamza.projects.buffer.replacement.datacreator;

import java.util.ArrayList;

/**
 *
 * @author Hamza
 */
public class Buffer {
    
    
    private ArrayList<Case> buff ;
    
    
     public void showStatus(){
        
        if(buff.isEmpty()) {System.out.println("buffer is empty");}
        else  for(int i=0;i<buff.size();i++){
            System.out.print("("+buff.get(i).getFrame()+","+buff.get(i).getFlag()+")");
        }
    }
    
    public void showStatus_FIFO(){
        
         if(buff.isEmpty()) {System.out.println("buffer is empty");}
        else  { String out ="";
            
            for(int i=0;i<buff.size();i++){
          System.out.print("( Frame number "+buff.get(i).getFrame()+") ");
        }
            
    }}
    
    public boolean empty(){
        
        return buff.isEmpty();
    }
    public void insert_case(Case a,int place){
        
        this.buff.set(place, a);
    }
    
    public Case elementAt(int i){
        
        return this.buff.get(i);
    }
    public void update_case(Case a, int position){
        
        this.buff.set(position, a);
    }
    public boolean exist(String a){
        int k =0;
        boolean exist = false;
        while ((k<this.buff.size())&&(exist==false)) {
            if(a.equals(this.buff.get(k).getFrame())){
                
            // re insert the same element with incremented flag
             //   this.insert_case(new Case(a.getFrame(),1),k);
               // point = (point+1) % this.size;
               // last = k ;
                exist = true;
                break ;
            }
            else k++;
            }
       return exist; 
    }
    
     public int existAt(String a){
        int k =0;
        int pos = -1;
        boolean exist = false;
        while ((k<this.buff.size())&&(exist==false)) {
            if(a.equals(this.buff.get(k).getFrame())){
                
            // re insert the same element with incremented flag
             //   this.insert_case(new Case(a.getFrame(),1),k);
               // point = (point+1) % this.size;
               // last = k ;
                exist = true;
                pos = k;
                break ;
            }
            else k++;
            }
       return pos; 
    }
    public Buffer(int size){
        
        this.buff= new ArrayList<Case>();
        for (int i=0;i<size;i++){
            buff.add(new Case());
        }
        
    }
    
}
