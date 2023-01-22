/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yan
 */
public class PointsOnLine implements Runnable,IPointOnLine{
    
    DataBaseTools db= new DataBaseTools("points","pointid");
 int muxn;
private boolean doStop = false;


static int i=0,k=0,j=0;
private static int x1,y1,z1;
private static int x2,y2,z2;

private static int [][]pointOnLine;

PointsOnLine(){
    i=0;
    k=0;
    j=0;
   this.muxn = db.muxRows()-1;
   this.pointOnLine=new int[muxn][4];
}
 @Override
    public void doStop(){this.doStop = true;}
     @Override
    public boolean keepRunning(){return this.doStop == false;}
     @Override
    public  void setStartPointCoordinat(int x, int y, int z){
   System.out.println( this.x1=x);
   System.out.println(  this.y1=y);
    System.out.println( this.z1=z);
    }
     @Override
    public  void setEndPointCoordinat(int x, int y, int z){
    System.out.println( this.x2=x);
   System.out.println(  this.y2=y);
    System.out.println( this.z2=z);
    }
    
  
    public int[][] getPointOnLineC(){
      return pointOnLine;
    }
     public String [] getCoordinatI(int num){
      
      String[] out= new String [4];
      for(int i=0;i<4;i++)
          out[i]=""+pointOnLine[num][i];
      
    
      return out;
      
    }
     public int getRows(){
      return k;
     }


    @Override
    public void run() {
       System.out.println("muxR"+muxn);
      
      
        while(keepRunning()) {
           
            // keep doing what this thread should do.
             try {
                System.out.println("Running Line");
                double xM,yM,zM;
                double id,tx,ty,tz;
                
                id=db.getCellDoubleData(i, 1); 
                tx=(xM=db.getCellIntData(i, 2)-x1)/(x2-x1);
                ty=(yM=db.getCellIntData(i, 3)-y1)/(y2-y1);
                tz=(zM=db.getCellIntData(i, 4)-z1)/(z2-z1);
                  i++;
                
                System.out.println("TX="+tx+"  CoordinatXM="+xM+" ["+i+"]");
                System.out.println("TY="+ty+"  CoordinatYM="+yM+" ["+i+"]");
                System.out.println("TZ="+tz+"  CoordinatZM="+yM+" ["+i+"]");
               
                
                
               
                  if(tx==tz&&tx==ty){
                    System.out.println("ln search");
                    
                    j=0;
                    
                    System.out.println(pointOnLine[k][j++]=(int) id);
                    System.out.println(pointOnLine[k][j++]=(int) xM);
                    System.out.println(pointOnLine[k][j++]=(int) yM);
                    System.out.println(pointOnLine[k][j]=(int) zM);
                    
                    k++;
                  
                  }
                  
              
               if(i>=muxn){doStop();
               System.out.println("stoped");
               }
              // Thread.sleep(3L * 1000L);
             }catch (Exception e) {
            
            }
             
        }
    }
}
