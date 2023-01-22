/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author yan
 */
public class NearCoordinat implements Runnable,IMaxMinCoordinat{

DataBaseTools db= new DataBaseTools("points","pointid");
 int muxn;
private boolean doStop = false;


static int i=0,k=0,j=0;
private int x,y,z;
private int searchDistance;
private int minX=1000,minY=1000,minZ=1000;
private static int [][]minC;

NearCoordinat(){
    i=0;
    k=0;
    j=0;
   this.muxn = db.muxRows()-1;
   NearCoordinat.minC=new int[muxn][4];
}
@Override
    public synchronized void doStop() { this.doStop = true; }
@Override
    public synchronized boolean keepRunning() {return this.doStop == false;}
@Override
  public synchronized void setPointCoordinat(int x, int y, int z){
  this.x=x;
  this.y=y;
  this.z=z;
  }
@Override
  public synchronized void searchDistance(int array){
  this.searchDistance=array;
  }
  
  public int[][] getMinCoordinat(){
      return minC;
  }
  public String [] getMinCoordinatI(int num){
      
      String[] out= new String [4];
      for(int i=0;i<4;i++)
          out[i]=""+minC[num][i];
      
      return out;
      
  }
  public double [] getMinPoint(){
      
      double [] out={minX,minY,minZ};

      return out;
  }
  public int getRowsMinC(){
      return k;
  }


    @Override
    public void run() {
       
      
      
        while(keepRunning()) {
           
            // keep doing what this thread should do.
             try {
                System.out.println("Running Min");
                int id,tx,ty,tz;
  
                int temp=(int) Math.abs(Math.sqrt(
                        Math.pow(tx=(int) (db.getCellDoubleData(i, 2)-x), 2)
                                +Math.pow(ty=(int) (db.getCellDoubleData(i, 3)-y), 2)
                                    +Math.pow(tz=(int) (db.getCellDoubleData(i, 4)-z), 2)
                   ));
               
                id=(int) db.getCellDoubleData(i++, 1);
                
               System.out.println("D"+searchDistance);
                  if(temp<=(searchDistance/2)){
                  j=0;
                   
                    System.out.println(temp+"i["+i+"] /////////");
                    System.out.println( minC[k][j++]=id);
                    System.out.println(minC[k][j++]=tx);
                    System.out.println( minC[k][j++]=ty);
                    System.out.println( minC[k][j]=tz);
                    
                    if(Math.abs(tx)<=minX&&Math.abs(ty)<=minY&&Math.abs(tz)<=minZ)
                    {
                    minX=tx;
                    minY=ty;
                    minZ=tz;
                    
                    }
                  k++;
                  
                  }
                  
              
               if(i>=muxn)doStop();
              // Thread.sleep(3L * 1000L);
             }catch (Exception e) {
            
            }
             
        }
    }

   

    
}
