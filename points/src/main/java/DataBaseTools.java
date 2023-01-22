/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yan
 */

public class DataBaseTools implements IDataBase {
private static final String NAME_USER="";
private static final String PASSWORLD_USER="";
private static  String NAME_DATA_BASE="";
private static  String NAME_TABLE="";


private static Connection conn;
private static Statement stmt;
private static ResultSet rs;
private static ResultSetMetaData md;

private int muxNumColum=0;
private int muxNumRows=0;

DataBaseTools(String NameDB,String NameTable){
    NAME_DATA_BASE=NameDB;
    NAME_TABLE=NameTable;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");  
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+NAME_DATA_BASE,NAME_USER,PASSWORLD_USER);
               stmt = conn.createStatement();  
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            md = (ResultSetMetaData) rs.getMetaData();
             
            ////////////////
           muxNumCells();
           muxNumRows();
          //////////////////
           
        }catch(Exception ex){
            System.out.println(ex);
        } 
}
public ResultSet getRs(){
return this.rs;}
private void muxNumCells() {
    try{
        int i=1;
            while(md.getColumnLabel(i)!=null){
              muxNumColum++;
              i++;  
          
          }
            
    }
    catch(Exception ex){
            System.out.println(ex);
        } 
    System.out.println(muxNumColum);
}
private void muxNumRows(){
    try{
            rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
                muxNumRows++;
            }
    }catch(Exception ex){
            System.out.println(ex);
        } 
    System.out.println(muxNumRows+"+++++++++++++");
}

public int muxRows(){
    return muxNumRows;
}

@Override
    public  String [] [] outputTable(int numRw,int numCls){
        String table [][]=new String[numRw][numCls];
           try{
            int i=0;
            while(rs.next()){


                    if(numRw>i){
                        for(int j=1;j<=numCls;j++){
                          
                        table[i][j-1]=""+rs.getString(j);
                        }
                    }
               i++;
            }
           }catch(Exception ex){
            System.out.println(ex);} 

        return table;
    }
   

@Override
    public int maxNumRows (String searchingParameter){
        int i=0;
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
           
                for(int j=1;j<=muxNumColum;j++){
                    
                    if( rs.getString(j).equals(searchingParameter)){
                         ++i;
                        
                    }
                }
           
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        } 
        
        return i;
    }
@Override
    public int maxNumRows (long searchingParameter){
       
        return maxNumRows(""+searchingParameter);
    }
@Override
    public int maxNumRows (boolean searchingParameter){
        return maxNumRows(""+searchingParameter);
    }
@Override
    public int maxNumRows (int searchingParameter){
        return maxNumRows(""+searchingParameter);
    }

    
    
@Override
    public int numRow(String searchingParameter){
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
           
                for(int j=1;j<=muxNumColum;j++){
                    
                    if( rs.getString(j).equals(searchingParameter)){
                        return rs.getRow();   
                    }
                }
           
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        } 
        return -1;
    }
@Override
    public int numRow (long searchingParameter){
        return numRow(""+searchingParameter);
    }
@Override
    public int numRow (boolean searchingParameter){
        return numRow(""+searchingParameter);
    }
@Override
    public int numRow (int searchingParameter){
        return numRow(""+searchingParameter);
    }
    
    
    @Override
     public int []numRows(String searchingParameter){
         
         int i=0;
         int outRs[] = new int[maxNumRows(searchingParameter)];
          try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
           
                for(int j=1;j<=muxNumColum;j++){
                    
                    if( rs.getString(j).equals(searchingParameter)){
                        outRs[i]= rs.getRow();   
                        i++;
                    }
                }
           
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        } 
    return outRs;
}
     @Override
    public int []numRows (int searchingParameter){
    return numRows(""+searchingParameter);
}
    @Override
    public int []numRows (long searchingParameter){
    return numRows(""+searchingParameter);
}
    @Override
    public int []numRows (boolean searchingParameter){
    return numRows(""+searchingParameter);
}
    
    
@Override
    public  String[] getCellsData(int numRow){
        
          int i=0;
          String outData[]=new String[muxNumColum];
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
                if(i++==numRow)
                    for(int j=1;j<=muxNumColum;j++)
                        outData[j-1]=rs.getString(j);
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
        return outData;
    }
 @Override  
    public  String getCellStringData(int numRow, int numCell){
        int i=0;
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
                if(i++==numRow)
                     return rs.getString(numCell);
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }
    
    @Override
    public double getCellDoubleData(int numRow, String nameCell){
          int i=0;
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
                if(i++==numRow)
                     return rs.getDouble(nameCell);
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    @Override
     public boolean getCellBooleanData(int numRow, String nameCell){
          int i=0;
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
                if(i++==numRow)
                     return rs.getBoolean(nameCell);
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
    return false;
}
    @Override
    public int getCellIntData(int numRow, String nameCell){
         int i=0;
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
                if(i++==numRow)
                     return rs.getInt(nameCell);
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    return 0;
}
    
    
     @Override
    public String getCellStringData(int numRow, String nameCell) {
       int i=0;
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
                if(i++==numRow)
                     return rs.getString(nameCell);
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public double getCellDoubleData(int numRow, int numCell) {
       int i=0;
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
                if(i++==numRow)
                     return rs.getDouble(numCell);
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    @Override
    public boolean getCellBooleanData(int numRow, int numCell) {
        int i=0;
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
                if(i++==numRow)
                     return rs.getBoolean(numCell);
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
        return false;
    }

    @Override
    public int getCellIntData(int numRow, int numCell) {
        int i=0;
        try{
             rs = stmt.executeQuery("SELECT * FROM "+NAME_TABLE);
            while(rs.next()){
                if(i++==numRow)
                     return rs.getInt(numCell);
            }
        
        }catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    
    
@Override
    public void addData(double x, double y, double z){ 
    try { 
        stmt.executeUpdate("INSERT INTO `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`"
                + " (`idpoint`, `PointX`, `PointY`, `PointZ`) "
                + "VALUES ('"+(++muxNumRows)+"', '"
                +x+"', '"
                +y+"', '"
                +z+"');");
   
    } catch (SQLException ex) {
        Logger.getLogger(DataBaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
    
@Override
    public void deleteRow(int numRow){
    try {
        stmt.executeUpdate("DELETE FROM `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"` WHERE Id ="+numRow);
    } catch (SQLException ex) {
        Logger.getLogger(DataBaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
@Override
    public void deleteCell(int numRow,int numCell){
       
    
    }
@Override
    public void deleteCell(int numRow,String nameCell){
     
        try{
            stmt.executeUpdate("UPDATE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+""
                    + "` SET `"+nameCell+"` = null "
                    + "WHERE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`.`id` ="+numRow);
                
        
        }catch(Exception ex){
            System.out.println(ex);
        }}

////  змінити 
    
@Override
    public void updateRow(int id, double x,double y, double z){
       try{
            stmt.executeUpdate("UPDATE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`"
                    +" SET `PointX` = '"+x
                    +"' ,`PointY` = '"+y
                    +"' ,`PointZ` = '"+z
                    +"' WHERE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`.`id` ="+id);
                
        
        }catch(Exception ex){
            System.out.println(ex);
        }
    
    
    }
    
    
@Override
    public void updateCell(int id,String cell,String data){
    try {
        stmt.executeUpdate("UPDATE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`"
                +" SET `"+cell+"` = '"+data+"' WHERE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`.`id` ="+id);
    } catch (SQLException ex) {
        Logger.getLogger(DataBaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

@Override
    public void updateCell(int id,String cell,long data){
    try {
        stmt.executeUpdate("UPDATE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`"
                +" SET `"+cell+"` = "+data+"WHERE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`.`id` ="+id);
    } catch (SQLException ex) {
        Logger.getLogger(DataBaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }}
@Override
    public void updateCell(int id,String cell,int data){
    try {
        stmt.executeUpdate("UPDATE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`"
                +" SET `"+cell+"` = "+data+"WHERE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`.`id` ="+id);
    } catch (SQLException ex) {
        Logger.getLogger(DataBaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }}
@Override
    public void updateCell(int id,String cell,boolean data){
    try {
        stmt.executeUpdate("UPDATE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`"
                +" SET `"+cell+"` = "+data+"WHERE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`.`id` ="+id);
    } catch (SQLException ex) {
        Logger.getLogger(DataBaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }}
@Override
    public void updateCell(int id,String cell,double data){
    try {
        stmt.executeUpdate("UPDATE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`"
                +" SET `"+cell+"` = "+data+"WHERE `"+NAME_DATA_BASE+"`.`"+NAME_TABLE+"`.`id` ="+id);
    } catch (SQLException ex) {
        Logger.getLogger(DataBaseTools.class.getName()).log(Level.SEVERE, null, ex);
    }}

   
}

