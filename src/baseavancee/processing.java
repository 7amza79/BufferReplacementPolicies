/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseavancee;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Hamza
 */
public class processing {
    
    private int size ; //buffer size
    private Vector input; // input vector 
    
    private Buffer buffer; // buffer 
    private int inputSize; // input size 
    
    private static final Logger LOGGER = Logger.getLogger( processing.class.getName() );
   
    public void setInputSize(){
        
        Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter input size");
    int a = scanner.nextInt();
    this.inputSize = a;
   // scanner.close();
    
    }
    public int getInputSize(){
      return inputSize;  
    }
    public void setInput(Vector input) {
        this.input = input;
    }
    
    public Vector getInput2(){
        return input;
    }

    
    
 public Vector setInput(){
    String res="";
    Vector myVec = new Vector();
    String[] a = null;
    Scanner scanner = new Scanner(System.in);
    
    try{
    System.out.println("Please enter input separated by comma \",\"");
    res=scanner.nextLine();
    scanner.close();
    a = res.split(",");
    
     for (int i=0;i<a.length;i++){
        myVec.add(Integer.parseInt(a[i]));
    }
    
    }catch(Exception e){
        System.out.println("error with input Please try again");
        exit(1);
    }
    /*
    for(int i = 0; i < res.length(); ++i) {
        if (Character.isDigit(res.charAt(i)))
             myVec.add(res.charAt(i));
   
    }
*/
    
    
   
    return myVec;    
    }
    
    public int getBufferSize(){
        int size ;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter buffer size");
    size=(scanner.nextInt());
   // scanner.close();
   
    return size;
    }
    
    public void showStatus_SC(){
        
        this.buffer.showStatus();
        System.out.print("pointer on case "+this.point+" last on case "+this.last);
        System.out.println("");
    }
    
        public void showStatus_FIFO(){
        
        this.buffer.showStatus_FIFO();
        System.out.print(" pointer on case "+this.point);
        System.out.println("");
       // return "pointer on case "+this.point;
    }
        public void showStatus_LRU(){
             this.buffer.showStatus_FIFO();
        }
    
    private int point;
    private int last;
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
    public int process_LRU(){
         int count = 0;
        point =0;
        // set first elements
        for(int i=0;i<this.size;i++){
            
            Case a = new Case(input.elementAt(i).toString(),0);
            this.buffer.insert_case(a, i);
        }
    //     System.out.println("initial insertion over"); this.showStatus_FIFO();
    //      System.out.println("Let's do the rest");
        
          int j = this.size;
         
         for(int i=j;i<this.input.size();i++){
            // if the element exists
           // search the index and put the item in the last case and push back all the other items
    //       System.out.print("Input is "+this.input.get(i).toString()+"");
            boolean exist = false;   
            if (this.buffer.exist(this.input.get(i).toString())){
                
             int last_index = this.buffer.existAt(this.input.get(i).toString());
             Case a = new Case();
             a = this.buffer.elementAt(last_index);
              for(int k=last_index;k<(this.size-1);k++){
                  this.buffer.insert_case(this.buffer.elementAt(k+1), k);
              }
              this.buffer.insert_case(a, this.size-1);
                
     //           this.showStatus_FIFO();
              //  System.out.println("input is "+this.input.get(i).toString()+ "/ frame exists");
             
            }
            else {
                // if the item doesn't exist in the buffer  we push back all the
                // items and we put the input item in the front
                
                for(int k=0;k<(this.size-1);k++){
                this.buffer.insert_case(this.buffer.elementAt(k+1), k);
                
            }
                Case a = new Case(input.elementAt(i).toString(),0);
                this.buffer.insert_case(a, this.size-1);
    //             this.showStatus_FIFO();
                count++;
            }
         
    }
    //     System.out.println("end of processing LRU");
         return count;
    }
    public int process_FIFO(){
        int count = 0;
        point =0;
        // set first elements
        for(int i=0;i<this.size;i++){
            
            Case a = new Case(input.elementAt(i).toString(),0);
            this.buffer.insert_case(a, i);
        }
    //     System.out.println("initial insertion over"); this.showStatus_FIFO();
     //     System.out.println("Let's do the rest");
        // System.out.println("Beginning of the game");
         
         int j = this.size;
         
         for(int i=j;i<this.input.size();i++){
            // if the element exists
           // parse all the buffer to search
           
            boolean exist = false;   
            if (this.buffer.exist(this.input.get(i).toString())){
     //          this.showStatus_FIFO();
              //  System.out.println("input is "+this.input.get(i).toString()+ "/ frame exists");
             
            }
           
            // if the element does not exist
            
            else{
                // System.out.println("input is "+this.input.get(i).toString()+ "/ frame non existant let's process");
               
                 try{
                  this.buffer.insert_case(new Case(this.input.get(i).toString(),0),point);
                  point = (point +1) % this.size;
                  count++;
       //          this.showStatus_FIFO();
                 } catch(Exception e) {
                     
                     System.out.println("Error with inserting new element");
                 }
               
            }
        }
    //   System.out.println("end of processing fifo");
    return count ;}
    
       public int Process_second_chance(){
       
     // PrintWriter writer = new PrintWriter("second_chance.txt", "UTF-8");
           
        point=0;
        last=-1;
        int count = 0;
       // set first elements
        
       for(int i=0;i<this.size;i++){
           
           Case a = new Case(input.elementAt(i).toString(),0);
           this.buffer.insert_case(a, i);
       }
       
   //    System.out.println("initial insertion over"); this.showStatus_SC();
   //    System.out.println("Let's do the rest");
      // writer.println("initial insertion over");
     //  writer.println(this.showStatus());
       
       int j = this.size;
       String s ="";
       // parse all remaining pages 
       for(int i=j;i<this.input.size();i++){
           // if the element exists
          // parse all the buffer to search
          
           boolean exist = false;   
           if (this.buffer.exist(this.input.get(i).toString())){
              
              
                s = "input is "+this.input.get(i).toString()+ "/ frame exists";
        //       System.out.println(s); 
             //  writer.println(s);
              try{
               this.buffer.insert_case(new Case(this.input.get(i).toString(),1),this.buffer.existAt(this.input.get(i).toString()));
              
               //last = this.buffer.existAt(this.input.get(i).toString());
      //         this.showStatus_SC();
            //  writer.println(this.showStatus());
              }catch(Exception e){
                  
                  System.out.println("Problem with replacement here frame exists !");
              }
           }
          
           // if the element does not exist
           
           else{
                s ="input is "+this.input.get(i).toString()+ "/ frame non existant";
               // System.out.println("input is "+this.input.get(i).toString()+ "/ frame non existant");
         //       System.out.println(s);
             //  writer.println(s);
               point = (last +1)%this.size ;
               count++;
               while(this.buffer.elementAt(point).getFlag()!=0){
                   String a = this.buffer.elementAt(point).getFrame();
                   this.buffer.insert_case(new Case(a,0), point);
                   point = (point +1) % this.size;
                    
               }
               
               if(this.buffer.elementAt(point).getFlag()==0){
                //  s = "Free place found here, replacement preparing";
                   //System.out.println("Free place found here, replacement preparing");
                  // System.out.println(s);  //writer.println(s);
                   
                    try{
               this.buffer.insert_case(new Case(this.input.get(i).toString(),0),point);
               last = point;
               point = (point +1) % this.size;
            //   writer.println(this.showStatus());
               
 //              this.showStatus_SC();
              }catch(Exception e){
                  
                  System.out.println("Problem with replacement here free space charged !");
              }
               }
           }
       }
    // System.out.println("end of second chance processing");
   return count; }
    
    
    public processing() {
        
        this.size = this.getBufferSize();
        this.input = this.setInput();
        this.buffer= new Buffer(this.size);
        this.last=-1;
        this.point=0;
    }
    
    public processing(Vector in) {
        // if we want to use another input defined in the main class and not entred by user
        // like using the normal distribution : see the commented code in main class 
        this.size = this.getBufferSize();
        this.input = in;
        this.buffer= new Buffer(this.size);
        this.last=-1;
        this.point=0;
    }
    public processing(Vector in, int size) {
        // if we want to use another input defined in the main class and not entred by user
        // like using the normal distribution : see the commented code in main class 
        this.size = size;
        this.input = in;
        this.buffer= new Buffer(this.size);
        this.last=-1;
        this.point=0;
    }
    
    
}
