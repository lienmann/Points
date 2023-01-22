/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
/**
 *
 * @author yan
 */
public class Main {
  
    
     public static void main(String args[]) {
          
         //java -classpath c:\Java\mysql-connector-java-8.0.30.jar;c:\Java Program
       
            PointsForm p= new PointsForm();
            p.setVisible(true);

    }
     
   
     
    public void updateTableMYSQL(){
         UpdateTableOfCoordinat up= new UpdateTableOfCoordinat();
         up.setMuxNumRows(6);
         
         
        
        Thread theard1=new Thread(up);
        theard1.start();
        
        try{
         up.setRandomBorders(10, -10);
        }
        catch(Exception e){
        System.out.println("Error:    "+e);
        }
     }
     
}
