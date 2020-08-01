/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.WarehouseDistributionRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Inventory.InventoryDetails;
import Business.Inventory.InventoryDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.WarehouseDistributionOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DistributeDonationWorkRequest;
import Business.WorkQueue.WorkRequest;
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
public class WarehouseDistributionRoleWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form WarehouseDistributionRoleWorkArea
     */
    private final JPanel userProcessContainer;
    private final WarehouseDistributionOrganization organization;
    private final Enterprise enterprise;
    private final UserAccount userAccount;
    private final ArrayList<Organization> orgs;
    private final EcoSystem system;
    private final Network network;
    
    public WarehouseDistributionRoleWorkArea(JPanel userProcessContainer, UserAccount account, WarehouseDistributionOrganization organization, Enterprise enterprise, EcoSystem system, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.orgs = new ArrayList<>();
        this.system = system;
        this.network = network;
        try{
        valueLabel.setText(enterprise.getName());
        networkLbl.setText(network.getName());
        
        for(Network n : system.getNetworkList()){
            if(n.getName().equals(network.getName())){
                for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                    for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                        orgs.add(o);
                    }
                } 
            }
        }
        
        populateDistributionRequestJTable();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
        }
    }
    
    public void populateDistributionRequestJTable(){
        try{
        DefaultTableModel model = (DefaultTableModel)distributionWorkRequestJTable.getModel();
        model.setRowCount(0);
        for(Organization org : orgs){
           if(org instanceof WarehouseDistributionOrganization) {
            for (DistributeDonationWorkRequest request : org.getWorkQueue().getDistributionWorkRequestList()){
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getLocation();
                row[2] = request.getSender() == null ? null : request.getSender().getEmployee().getName();
                row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[4] = request.getStatus();
                model.addRow(row);
                } 
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
        valueLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        networkLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        distributionWorkRequestJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAccept = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        backgroundLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 140, 190));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Donations Received at");

        valueLabel.setForeground(new java.awt.Color(255, 255, 255));
        valueLabel.setText("<EnterpriseName>");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setText("Network");

        networkLbl.setText("<NetworkName>");

        distributionWorkRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Donation Type", "Location", "Requested By", "Accepted By", "Status"
            }
        ));
        jScrollPane1.setViewportView(distributionWorkRequestJTable);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Accept Distribution Request");

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Update Distribution Status");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(valueLabel)
                .addGap(826, 826, 826)
                .addComponent(jLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1296, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnAccept))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(btnUpdate))
            .addGroup(layout.createSequentialGroup()
                .addGap(1222, 1222, 1222)
                .addComponent(networkLbl))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(backgroundLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 1450, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccept))
                .addGap(18, 18, 18)
                .addComponent(btnUpdate))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(networkLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(backgroundLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(623, 623, 623)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        try{
        int selectedRow = distributionWorkRequestJTable.getSelectedRow();
        String acceptedBy = String.valueOf(distributionWorkRequestJTable.getValueAt(selectedRow, 3));
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a distribution request to accept.");
        }
        else {
            if(acceptedBy.equals("null")){
                WorkRequest request = (WorkRequest)distributionWorkRequestJTable.getValueAt(selectedRow, 0);
                request.setReceiver(userAccount);
                request.setStatus("Pending");
                populateDistributionRequestJTable();
            }
            else JOptionPane.showMessageDialog(null, "Already accepted.");
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try{
        int selectedRow = distributionWorkRequestJTable.getSelectedRow();
        if (selectedRow >= 0){
            DistributeDonationWorkRequest request = (DistributeDonationWorkRequest)distributionWorkRequestJTable.getValueAt(selectedRow, 0);
            String status = String.valueOf(distributionWorkRequestJTable.getValueAt(selectedRow, 4));
            String acceptedBy = String.valueOf(distributionWorkRequestJTable.getValueAt(selectedRow, 3));
            if(status.equals("Pending") && acceptedBy.equals(userAccount.getEmployee().getName())){
               WorkRequest workRequest = (WorkRequest)distributionWorkRequestJTable.getValueAt(selectedRow, 0);
               request.setStatus("Distributed");
               workRequest.setStatus("Distributed");
               populateDistributionRequestJTable();
               int id = request.getDonationId();
               InventoryDirectory inventoryList = new InventoryDirectory();
               for(InventoryDetails inventory : inventoryList.getInventory()){
                   if(id==inventory.getDonationId()) inventoryList.getInventory().remove(inventory);
               }
            }
            else JOptionPane.showMessageDialog(null, "Please select a 'Pending' distribution request accepted by you to update.");
        }
        else JOptionPane.showMessageDialog(null, "Please select a collection request to update.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLbl;
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JTable distributionWorkRequestJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel networkLbl;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
