/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agro;



import static agro.Nacimiento.txtMadre;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static agro.Nacimiento.txtid;


/**
 *
 * @author Dahiana Sanchez G
 */
public class BuscarIA extends javax.swing.JFrame {
Conexion conn = new Conexion ();
    javax.swing.table.DefaultTableModel  m;

    public BuscarIA() {
        initComponents();
         m = (javax.swing.table.DefaultTableModel) Lista.getModel();
         cargaTabla();
       
    }

   
   
          private void cargaTabla(){
           m.setRowCount(0);
        String sql = "SELECT id, Fecha, animalid  FROM ia";
        String columna = "id";
            
        try {
             if (!txtfiltro.getText().trim().isEmpty()){
                    if(cbobuscar.getSelectedIndex() == 1) columna = "id";
                    sql = sql + " where " + columna + " like '%"+ txtfiltro.getText().trim() +"%' " ;
                }
            conn.sentencia = conn.conexion.createStatement();
            conn.resultado = conn.sentencia.executeQuery(sql);
            while(conn.resultado.next()){
                m.addRow(new Object[] {conn.resultado.getInt("id"),
                    conn.resultado.getString("Fecha"), conn.resultado.getString("animalid")});
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarIA.class.getName()).log(Level.SEVERE, null, ex);
        }
 }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JTable();
        txtfiltro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbobuscar = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.gray)); // NOI18N

        Lista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        Lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "IA", "MADRE", "FECHA"
            }
        ));
        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ListaMousePressed(evt);
            }
        });
        Lista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Lista);

        jLabel6.setText("Buscar");

        cbobuscar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RP", "HBP" }));
        cbobuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbobuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbobuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 150, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbobuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListaKeyPressed
     BuscarSementales();
     dispose();
    }//GEN-LAST:event_ListaKeyPressed

    private void cbobuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbobuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbobuscarActionPerformed

    private void ListaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMousePressed
      
    }//GEN-LAST:event_ListaMousePressed
    
    private void AceptarSemental() {
//        txtid = Lista.getValueAt(Lista.getSelectedRow(), 0).toString();
        
//        String sql = "select  *from maestro where id = " +  Lista.getValueAt(Lista.getSelectedRow(), 0).toString();
//            System.out.println(sql);
//            conn.traeDatos(sql);
//        try {
//            if(conn.resultado.next()){
//                Tabla1.getValuAt.(conn.resultado.getString("id"));
//                txtHBP.setText(conn.resultado.getString("Nombre"));
//            }} catch (SQLException ex) {
//            Logger.getLogger(Sementales.class.getName()).log(Level.SEVERE, null, ex);
//        
//    
//    }
//    
    }

    private void BuscarSementales() {
        String sql = "select * from ia where id = " + Lista.getValueAt(Lista.getSelectedRow(), 0).toString();
            System.out.println(sql);
            conn.traeDatos(sql);
        try {
            if(conn.resultado.next()){
                txtid.setText(conn.resultado.getString("Fecha"));
                txtMadre.setText(conn.resultado.getString("animalid"));
              
              
                
            }} catch (SQLException ex) {
            Logger.getLogger(BuscarIA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscarIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarIA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Lista;
    private javax.swing.JComboBox cbobuscar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtfiltro;
    // End of variables declaration//GEN-END:variables
}
