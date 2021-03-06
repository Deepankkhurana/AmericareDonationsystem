/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.BloodBankRole;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DoctorWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deepankkhurana
 */
public class TrackRequestStatusJPanel extends javax.swing.JPanel {

    /**
     * Creates new form TrackRequestStatusJPanel
     */
    private final JPanel userProcessContainer;
    private final Enterprise enterprise;
    private UserAccount userAccount;
    ArrayList<DoctorWorkRequest> doctorWorkRequestList;
    public TrackRequestStatusJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, ArrayList<DoctorWorkRequest> doctorWorkRequestList) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.doctorWorkRequestList = doctorWorkRequestList;
        
        try{
            populateTrackStatusJTable();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
        }
    }
    
    public void populateTrackStatusJTable(){
        try{
            DefaultTableModel model = (DefaultTableModel) trackStatusJTable.getModel();
            model.setRowCount(0);
            for(DoctorWorkRequest request : doctorWorkRequestList){
                if(request.getDonationType().equals("Blood")){
                   Object[] row = new Object[5];
                   row[0] = request;
                   row[1] = request.getDescription();
                   row[2] = request.getRequestedBy();
                   row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                   row[4] = request.getStatus();
                   model.addRow(row); 
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trackStatusJTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        backgroundLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 140, 190));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Track status of previously sent requests below :");

        trackStatusJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Received At", "Blood Group", "Request Sent By", "Request Received By", "Status"
            }
        ));
        jScrollPane1.setViewportView(trackStatusJTable);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 1450, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnBack)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(578, 578, 578)
                .addComponent(btnBack))
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(backgroundLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try{
            userProcessContainer.remove(this);
            Component[] componentArray = userProcessContainer.getComponents();
            Component component = componentArray[componentArray.length - 1];
            BloodBankRoleWorkArea jp = (BloodBankRoleWorkArea)component;
            jp.populateRequestTable();
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
        }
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLbl;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable trackStatusJTable;
    // End of variables declaration//GEN-END:variables
}
