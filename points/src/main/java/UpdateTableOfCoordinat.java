
import static com.sun.org.apache.xalan.internal.lib.ExsltMath.random;
import static java.lang.Math.random;
import java.util.Random;
import static jdk.nashorn.internal.objects.NativeMath.random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author yan
 */
public class UpdateTableOfCoordinat implements Runnable{

DataBaseTools db= new DataBaseTools("points","pointid");
Random random  = new Random();
int muxn;
int maxC,minC;
private boolean doStop = false;


static int i=0,k=0;


UpdateTableOfCoordinat(){
}
    
    public synchronized void doStop() { this.doStop = true; }
   
    public synchronized boolean keepRunning() {return this.doStop == false;}

    public synchronized void setMuxNumRows(int nmR){
    this.muxn=nmR;
    }
    
     public synchronized void setRandomBorders(int max, int min){
         this.maxC=max;
         this.minC=min;
     }

    @Override
    public void run() {
       
        while(keepRunning()) {
           
            // keep doing what this thread should do.
             try {
                System.out.println("Running");
                int diff;
                 diff = maxC - minC;

                double x;
                 x = random.nextInt(diff + 1);
                double y;
                 y = random.nextInt(diff + 1);
                double z;
                 z = random.nextInt(diff+1);
                
                x += minC;
                y += minC;
                z += minC;
            
                db.addData(x, y, z);
                i++;
               if(i>muxn)
                 doStop();
              // Thread.sleep(3L * 1000L);
             }catch (Exception e) {
                System.out.println("Error:          "+e);
            }
             
        }
    }

   

    
}
