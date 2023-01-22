/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author yan
 */
public class FarCoordinat implements Runnable,IMaxMinCoordinat{

DataBaseTools db= new DataBaseTools("points","pointid");
 int muxn;
private boolean doStop = false;


static int i=0,k=0,j=0;
private int x,y,z;
private int searchDistance;

private int maxX=0,maxY=0,maxZ=0;
private static int [][]maxC;

FarCoordinat(){
    i=0;
    k=0;
    j=0;
   this.muxn = db.muxRows()-1;
   this.maxC=new int[muxn][4];
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
  
    public int[][] getMaxCoordinat(){
      return maxC;
    }
     public String [] getMaxCoordinatI(int num){
      
      String[] out= new String [4];
      for(int i=0;i<4;i++)
          out[i]=""+maxC[num][i];
      
      return out;
      
    }
     
      public int [] getMaxPoint(){
      
      int [] out={maxX,maxY,maxZ};

      return out;
  }
     
     public int getRowsMaxC(){
      return k;
     }


    @Override
    public void run() {
       
      
      
        while(keepRunning()) {
           
            // keep doing what this thread should do.
             try {
                System.out.println("Running Max");
                int id,tx,ty,tz;
                int temp=(int) Math.abs(Math.sqrt(
                        Math.pow(tx=(int) (db.getCellDoubleData(i, 2)-x), 2)
                                +Math.pow(ty=(int) (db.getCellDoubleData(i, 3)-y), 2)
                                    +Math.pow(tz=(int) (db.getCellDoubleData(i, 4)-z), 2)
                   ));
               
                id=(int) db.getCellDoubleData(i++, 1);
                
               System.out.println("D"+searchDistance);
                  if(temp>=(searchDistance/2)&&temp<=searchDistance){
                  j=0;
                   
                    System.out.println(temp+"i["+i+"] /////////");
                    System.out.println( maxC[k][j++]=id);
                    System.out.println(maxC[k][j++]=tx);
                    System.out.println( maxC[k][j++]=ty);
                    System.out.println( maxC[k][j]=tz);
                    
                     if(Math.abs(tx)>=maxX && Math.abs(ty)>=maxY && Math.abs(tz)>=maxZ)
                    {
                    maxX=tx;
                    maxY=ty;
                    maxZ=tz;
                    
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
