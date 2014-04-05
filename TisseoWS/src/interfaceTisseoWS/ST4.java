/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceTisseoWS;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import tisseows.RequestJCDecaux;
import tisseows.Station;

/**
 *
 * @author Hugo
 */
public final class ST4 extends javax.swing.JFrame {

    private List<Station> stations;
    /**
     * Creates new form ST4
     * @throws org.json.simple.parser.ParseException
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     */
    public ST4() throws ParseException, IOException, URISyntaxException {
        initComponents();
        stations = new ArrayList<>();
        init();
    }
    
    public final void init() throws ParseException, IOException, URISyntaxException{
        RequestJCDecaux r = new RequestJCDecaux();
        JSONParser parser = new JSONParser();
        
        r.setPathURIB("/vls/v1/stations");
        
        Object obj = parser.parse(r.request());
        JSONArray array = (JSONArray) obj;
        
        int nbStations = array.size();
        DefaultListModel lm = new DefaultListModel();
        for(int i = 0 ; i < nbStations ; i++){
            stations.add(new Station((JSONObject) array.get(i)));
            lm.addElement(stations.get(i).getName());
        }
        listeStations.setModel(lm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listeStations = new javax.swing.JList();
        lblName = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblBikeStands = new javax.swing.JLabel();
        lblBikes = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setTitle("ST4");

        listeStations.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listeStationsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listeStations);

        lblName.setText("Station ");

        lblStatus.setText("Statut ");

        lblBikeStands.setText("Points d'attache disponibles");

        lblBikes.setText("Vélos disponibles");

        lblAddress.setText("Adresse");

        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblStatus)
                            .addComponent(lblBikeStands)
                            .addComponent(lblBikes)
                            .addComponent(lblAddress))
                        .addContainerGap(109, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addGap(18, 18, 18)
                        .addComponent(lblAddress)
                        .addGap(18, 18, 18)
                        .addComponent(lblStatus)
                        .addGap(18, 18, 18)
                        .addComponent(lblBikeStands)
                        .addGap(18, 18, 18)
                        .addComponent(lblBikes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listeStationsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listeStationsValueChanged
        lblName.setText("Station : " + stations.get(listeStations.getSelectedIndex()).getName());
        lblAddress.setText("Adresse : " + stations.get(listeStations.getSelectedIndex()).getAdresse());
        lblStatus.setText("Statut : " + stations.get(listeStations.getSelectedIndex()).getStatut());
        lblBikeStands.setText("Points d'attache disponibles : " + stations.get(listeStations.getSelectedIndex()).getBikeStands());
        lblBikes.setText("Vélos disponibles : " + stations.get(listeStations.getSelectedIndex()).getBike());
    }//GEN-LAST:event_listeStationsValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ST4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ST4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ST4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ST4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ST4().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(ST4.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ST4.class.getName()).log(Level.SEVERE, null, ex);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(ST4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBikeStands;
    private javax.swing.JLabel lblBikes;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList listeStations;
    // End of variables declaration//GEN-END:variables
}
