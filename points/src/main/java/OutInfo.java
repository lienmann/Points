
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author yan
 */
public class OutInfo extends javax.swing.JFrame {
 private int dist=0;
 private int  START_X =0,START_Y=0,START_Z=0;
 private int  END_X =0,END_Y=0,END_Z=0;
 private boolean SEARCH=false;
 
 private DefaultTableModel tblModel;
 private String[] columnNames = {"IdPoint",
                        "X coordinat",
                        "Y coordinat",
                        "Z coordinat"};
    
 private NearCoordinat mr;
 private FarCoordinat mx = new FarCoordinat();
 private PointsOnLine pntL= new PointsOnLine();
 private Thread theard;
    
 
    public OutInfo() {
        this.mr = new NearCoordinat();
       
        initComponents();
        createTable();
     
        getContentPane().setBackground(Color.GRAY);
        
    }
    
      public void setSearchD(int schd){
         this.dist=schd;
       }
      public void setStartPos(int x, int y, int z){
          this.START_X=x;
          this.START_Y=y;
          this.START_Z=z;
      }
      public void setEndPos(int x, int y, int z){
          this.END_X=x;
          this.END_Y=y;
          this.END_Z=z;
      }
  
      private void showMinC(){
           try {
            
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
               
            mr.setPointCoordinat(START_X, START_Y, START_Z);
            mr.searchDistance((int) dist); 
     
          
        } catch (Exception e) {
           e.printStackTrace();
            
        }
           int i=0;
           do{
               if(mr.getMinCoordinatI(i)!=null&&mr.getRowsMinC()>i){
               
                    tblModel.addRow(mr.getMinCoordinatI(i));
                     i++;
               
               }
           }while(mr.keepRunning());
         
         double ot[]=  mr.getMinPoint(); 
         String text="";
         
         for(int f=0;f<ot.length;f++)
            text+=ot[f]+"   ";
         
             jLabel2.setText(text);
         
      }
       private void showMaxC(){
           try {
            jLabel1.setVisible(true);
            jLabel2.setVisible(true);
               
            mx.setPointCoordinat(START_X, START_Y, START_Z);
            mx.searchDistance(dist); 
     
        } catch (Exception e) {
           e.printStackTrace();
            
        }
           int i=0;
            do{
              if(mx.getMaxCoordinatI(i)!=null&&mx.getRowsMaxC()>i){
               tblModel.addRow(mx.getMaxCoordinatI(i));
               i++;
              }
           }while(mx.keepRunning());
         
      
          int ot[]=  mx.getMaxPoint(); 
         String text="";
         
         for(int f=0;f<ot.length;f++)
            text+=ot[f]+"   ";
         
             jLabel2.setText(text);
      }
       private void showPointL(){
           try {
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
               
               
            pntL.setStartPointCoordinat(START_X, START_Y, START_Z);
            pntL.setEndPointCoordinat(END_X, END_Y, END_Z);
             
     
        } catch (Exception e) {
           e.printStackTrace();
            
        }
          int i=0;
           do{
              if(pntL.getCoordinatI(i)!=null&&pntL.getRows()>i){
               tblModel.addRow(pntL.getCoordinatI(i));
               i++;
              }
              
             
               
           }while(pntL.keepRunning());
            
          
      
       }
      public void startSearch(String com){
          if(com=="min"){
              this.setTitle("min");
              
            theard= new Thread(mr); 
            theard.start();
            showMinC();
            }
          else if(com=="max"){
              this.setTitle("max");
            theard= new Thread(mx);
            theard.start();
            showMaxC();
          }
          else if(com=="line"){
               this.setTitle("line");
            theard= new Thread(pntL);
            theard.start();
            showPointL();
           }
          
            
      }
      
     private void createTable(){
      tblModel=(DefaultTableModel)jTable1.getModel();

        tblModel.getDataVector().removeAllElements();
        tblModel.fireTableDataChanged();
        
        tblModel.setColumnIdentifiers(columnNames);
     }

     private void out(int muxR){  
       
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("null");

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Шукані координати");

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Координати точок в заданому діапазоні");

        jTable1.setBackground(new java.awt.Color(153, 153, 153));
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setForeground(new java.awt.Color(0, 51, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setSelectionBackground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}