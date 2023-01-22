/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yan
 */
public interface IDataBase {
    public  String [] [] outputTable(int numRw,int numCls);


    public int maxNumRows (String searchingParameter);
    public int maxNumRows (long searchingParameter);
    public int maxNumRows (boolean searchingParameter);
    public int maxNumRows (int searchingParameter);

    public int numRow(String searchingParameter);
    public int numRow (long searchingParameter);
    public int numRow (boolean searchingParameter);
    public int numRow (int searchingParameter);
    
    public int []numRows(String searchingParameter);
    public int []numRows (int searchingParameter);
    public int []numRows (long searchingParameter);
    public int []numRows (boolean searchingParameter);
    
    
    public  String[] getCellsData(int numRow);
    
    public  String getCellStringData(int numRow, int numCell);
    public  String getCellStringData(int numRow, String nameCell);

    public double getCellDoubleData(int numRow, String nameCell);
     public double getCellDoubleData(int numRow, int numCell);
     
    public boolean getCellBooleanData(int numRow, String nameCell);
    public boolean getCellBooleanData(int numRow, int numCell);
    
    public int getCellIntData(int numRow, String nameCell);
    public int getCellIntData(int numRow, int numCell);

    public void addData(double x,double y, double z);

    public void deleteRow(int numRow);
    public void deleteCell(int numRow,int numCell);
    public void deleteCell(int numRow,String nameCell);

    public void updateRow(int id, double x,double y, double z);
  
     public void updateCell(int id,String cell,String data);
    public void updateCell(int id,String cell,long data);
    public void updateCell(int id,String cell,int data);
    public void updateCell(int id,String cell,boolean data);
    public void updateCell(int id,String cell,double data);


}
