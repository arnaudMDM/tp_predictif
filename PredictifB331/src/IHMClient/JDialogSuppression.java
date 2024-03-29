/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Suppresion.java
 *
 * Created on 6 mars 2012, 17:22:49
 */

package IHMClient;

import Modele.Client;
import Service.Service;

/**
 *
 * @author Administrateur
 */
public class JDialogSuppression extends javax.swing.JDialog {
private Service service;
private Client client;
    /** Creates new form Suppresion */
    public JDialogSuppression(java.awt.Frame parent, boolean modal,Service service,Client client) {
        super(parent, modal);
        initComponents();
        this.service = service;
        this.client = client;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSuppresion = new javax.swing.JLabel();
        jButtonConfirmer = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelSuppresion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSuppresion.setText("Voulez-vous vraiment supprimer le client ");

        jButtonConfirmer.setText("Confirmer");
        jButtonConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmerActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");
        jButtonAnnuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAnnulerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSuppresion, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jButtonConfirmer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jButtonAnnuler)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelSuppresion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnnuler)
                    .addComponent(jButtonConfirmer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmerActionPerformed
        // TODO add your handling code here:
        service.deleteClient(client);
        dispose();
}//GEN-LAST:event_jButtonConfirmerActionPerformed

    private void jButtonAnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAnnulerMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonAnnulerMouseClicked

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JDialogSuppression dialog = new JDialogSuppression(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonConfirmer;
    private javax.swing.JLabel jLabelSuppresion;
    // End of variables declaration//GEN-END:variables

}
