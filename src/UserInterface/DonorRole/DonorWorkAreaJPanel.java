/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DonorRole;

import Business.Enterprise.Enterprise;
import Business.Organization.DonorOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import Business.Donor.Donor;
import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.BloodBankOrganization;
import Business.Organization.ClothesNGOOrganization;
import Business.Organization.FoodNGOOrganization;
import Business.Organization.OrganBankOrganization;
import Business.Organization.Organization;
import Business.WorkQueue.AcceptDonationWorkRequest;
import java.awt.Image;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author deepankkhurana
 */

public class DonorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DonorWorkAreaJPanel
     */
    private final JPanel userProcessContainer;
    private final DonorOrganization organization;
    private final Enterprise enterprise;
    private final UserAccount userAccount;
    private final EcoSystem system;
    
    public DonorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, DonorOrganization organization, Enterprise enterprise, EcoSystem system, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.system = system;
        
        //valueLabel.setText(enterprise.getName());
        try{
            loadNetworksComboBox();
            loadDonationTypeComboBox();

            donationTypeComboBox.setSelectedIndex(-1);
            networkComboBox.setSelectedIndex(-1);

            donationTypeComboBox.setEnabled(false);
            btnYes.setEnabled(false);
            btnNo.setEnabled(false);
            btnSubmit.setEnabled(false);
            lblBloodType.setVisible(false);
            bloodTypeComboBox.setVisible(false);
            lblOrganType.setVisible(false);
            organTypeComboBox.setVisible(false);

            nameTxtBox.setEnabled(false);
            addressTxtArea.setEnabled(false);
            emailIdTxtBox.setEnabled(false);
            contactTxtBox.setEnabled(false);

            String imageFilePath = "./Donate.jpg";
            ImageIcon icon=new ImageIcon(imageFilePath);
            Image image = icon.getImage().getScaledInstance(1450, 900, Image.SCALE_SMOOTH);
            backgroundLbl.setIcon(new ImageIcon(image));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
        }
    }
    
    public void loadNetworksComboBox(){
        try{
            networkComboBox.removeAllItems();
            for (Network network : system.getNetworkList()) {
                networkComboBox.addItem(network);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
        }
    }
    
    public  void loadDonationTypeComboBox(){
        try{
            donationTypeComboBox.removeAllItems();
            String net = String.valueOf(networkComboBox.getSelectedItem());
            for(Network n : system.getNetworkList()){
                if(n.getName().equals(net)){
                    for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                        for(Organization o: e.getOrganizationDirectory().getOrganizationList()){
                            if((o instanceof FoodNGOOrganization)||(o instanceof ClothesNGOOrganization)||
                                    (o instanceof BloodBankOrganization)||(o instanceof OrganBankOrganization)){
                                donationTypeComboBox.addItem(o);
                            }
                        }
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
        donationTypeComboBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        nameTxtBox = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        emailIdTxtBox = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        contactTxtBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTxtArea = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        lblAddMore = new javax.swing.JLabel();
        btnYes = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblBloodType = new javax.swing.JLabel();
        lblOrganType = new javax.swing.JLabel();
        organTypeComboBox = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        networkComboBox = new javax.swing.JComboBox();
        bloodTypeComboBox = new javax.swing.JComboBox();
        backgroundLbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 140, 190));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Donation To*");

        donationTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        donationTypeComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                donationTypeComboBoxMouseClicked(evt);
            }
        });
        donationTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donationTypeComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name*");

        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email Id*");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Full Address*");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("10 digit Contact No.*");

        addressTxtArea.setColumns(20);
        addressTxtArea.setRows(5);
        jScrollPane1.setViewportView(addressTxtArea);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblAddMore.setForeground(new java.awt.Color(255, 255, 255));
        lblAddMore.setText("Do you want to add more?");

        btnYes.setText("Yes");
        btnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYesActionPerformed(evt);
            }
        });

        btnNo.setText("No");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel5.setText("Welcome!");

        jLabel6.setText("Please enter the details below for making a donation. Fields with * are compulsory");

        lblBloodType.setText("Blood Type*");

        lblOrganType.setText("Organ type*");

        organTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organTypeComboBox.setMaximumSize(new java.awt.Dimension(96, 27));

        jLabel8.setText("Choose your network*");

        networkComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkComboBoxActionPerformed(evt);
            }
        });

        bloodTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(nameTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(lblEmail)
                        .addGap(103, 103, 103)
                        .addComponent(emailIdTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3)
                        .addGap(423, 423, 423)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(696, 696, 696)
                        .addComponent(organTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(lblOrganType))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(donationTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(707, 707, 707)
                        .addComponent(contactTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(lblBloodType))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(bloodTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addComponent(btnAdd)
                        .addGap(32, 32, 32)
                        .addComponent(lblAddMore, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backgroundLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 1450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nameTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(459, 459, 459)
                        .addComponent(lblBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(organTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(lblAddMore, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(620, 620, 620)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(bloodTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backgroundLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(donationTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(contactTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(networkComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(367, 367, 367)
                                .addComponent(lblOrganType, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(emailIdTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(62, 62, 62)
                        .addComponent(btnAdd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(413, 413, 413)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //temp variable declaration
        String name = nameTxtBox.getText();
        String email = emailIdTxtBox.getText();
        String contact = contactTxtBox.getText();
        String address = addressTxtArea.getText();
        try{
        Organization donateAt = (Organization)donationTypeComboBox.getSelectedItem();
        String network = String.valueOf(networkComboBox.getSelectedItem());
        String donation = "";
        
        //checking if any field is left blank
        if(networkComboBox.getSelectedIndex() < 0 || donationTypeComboBox.getSelectedIndex() < 0 || name.isEmpty() || email.isEmpty() || contact.isEmpty() || address.isEmpty()){
            JOptionPane.showMessageDialog(null,"All the fields are compulsory");
            return;
        }
        
        //assigning proper value to donation depending on value selected from donationtype dropdown
        if(donateAt instanceof BloodBankOrganization) donation = "Blood";
        else if(donateAt instanceof OrganBankOrganization) donation = "Organ";
        else if(donateAt instanceof FoodNGOOrganization) donation = "Food";
        else if(donateAt instanceof ClothesNGOOrganization) donation = "Clothes";
        
        if(name.matches("^[a-zA-Z]+$") && email.matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
                && contact.matches("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$")){
            switch (donation) {
                case "Blood":
                    if(bloodTypeComboBox.getSelectedIndex()<0){
                        JOptionPane.showMessageDialog(null, "Please select blood type");
                    }
                    else {
                        String bloodType = String.valueOf(bloodTypeComboBox.getSelectedItem());
                        for(Network n : system.getNetworkList()){
                            if (network.equals(n.getName())){
                                for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                                    for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                                        if(o instanceof BloodBankOrganization){
                                            Donor donor = organization.getDonorDir().createDonor(name, email, contact, address, donation, bloodType, " ",network);
                                            btnYes.setEnabled(true);
                                            btnNo.setEnabled(true);
                                            btnAdd.setEnabled(false);
                                            donationTypeComboBox.setSelectedIndex(-1);
                                            AcceptDonationWorkRequest request = new AcceptDonationWorkRequest();
                                            request.setDonor(donor);
                                            o.getWorkQueue().getDonationWorkRequestList().add(request);
                                            JOptionPane.showMessageDialog(null,"Added successfully");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }   break;
                case "Organ":
                    if(organTypeComboBox.getSelectedIndex()<0){
                        JOptionPane.showMessageDialog(null, "Please select organ type");
                    }
                    else {
                        String organType = String.valueOf(organTypeComboBox.getSelectedItem());
                        for(Network n : system.getNetworkList()){
                            if (networkComboBox.getSelectedItem().equals(n)){
                                for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                                    for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
                                        if(o instanceof OrganBankOrganization){
                                            Donor donor = organization.getDonorDir().createDonor(name, email, contact, address, donation, " ", organType, network);
                                            btnYes.setEnabled(true);
                                            btnNo.setEnabled(true);
                                            btnAdd.setEnabled(false);
                                            donationTypeComboBox.setSelectedIndex(-1);
                                            AcceptDonationWorkRequest request = new AcceptDonationWorkRequest();
                                            request.setDonor(donor);
                                            o.getWorkQueue().getDonationWorkRequestList().add(request);
                                            JOptionPane.showMessageDialog(null,"Added successfully");
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }   break;
                default:
                    btnYes.setEnabled(true);
                    btnNo.setEnabled(true);
                    btnAdd.setEnabled(false);
                    lblBloodType.setVisible(false);
                    bloodTypeComboBox.setVisible(false);
                    lblOrganType.setVisible(false);
                    organTypeComboBox.setVisible(false);
                    for(Network n : system.getNetworkList()){
                        if (networkComboBox.getSelectedItem().equals(n)){
                            for(Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()){
                                for(Organization o: e.getOrganizationDirectory().getOrganizationList()){
                                    if((o instanceof FoodNGOOrganization) && (donationTypeComboBox.getSelectedItem() instanceof FoodNGOOrganization)){
                                        Donor donor = organization.getDonorDir().createDonor(name, email, contact, address, donation, " ", " ",network);
                                        AcceptDonationWorkRequest request = new AcceptDonationWorkRequest();
                                        request.setDonor(donor);
                                        o.getWorkQueue().getDonationWorkRequestList().add(request);
                                        JOptionPane.showMessageDialog(null,"Added successfully");
                                        donationTypeComboBox.setSelectedIndex(-1);
                                        break;
                                    }
                                    else if((o instanceof ClothesNGOOrganization) && (donationTypeComboBox.getSelectedItem() instanceof ClothesNGOOrganization)){
                                        Donor donor = organization.getDonorDir().createDonor(name, email, contact, address, donation, " ", " ",network);
                                        AcceptDonationWorkRequest request = new AcceptDonationWorkRequest();
                                        request.setDonor(donor);
                                        o.getWorkQueue().getDonationWorkRequestList().add(request);
                                        JOptionPane.showMessageDialog(null,"Added successfully");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                }
            }
        else {
            JOptionPane.showMessageDialog(null,"Please ensure that the entered details are valid. E.g. Name should be alphabets only and contact number should be digits only.");
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYesActionPerformed
        btnAdd.setEnabled(true);
        donationTypeComboBox.setSelectedIndex(-1);
    }//GEN-LAST:event_btnYesActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        btnSubmit.setEnabled(true);
        btnYes.setEnabled(true);
    }//GEN-LAST:event_btnNoActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
    }//GEN-LAST:event_btnBackActionPerformed

    private void donationTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donationTypeComboBoxActionPerformed
        try{
        Organization donateAt = (Organization)donationTypeComboBox.getSelectedItem();
        String donation = "";
        if(donateAt instanceof BloodBankOrganization) donation = "Blood";
        else if(donateAt instanceof OrganBankOrganization) donation = "Organ";
        else if(donateAt instanceof FoodNGOOrganization) donation = "Food";
        else if(donateAt instanceof ClothesNGOOrganization) donation = "Clothes";
        
        switch (donation) {
            case "Blood":
                lblBloodType.setVisible(true);
                bloodTypeComboBox.setVisible(true);
                bloodTypeComboBox.removeAllItems();  // to load type of blood combo box
                bloodTypeComboBox.addItem("O+");
                bloodTypeComboBox.addItem("B+");
                bloodTypeComboBox.addItem("AB+");
                bloodTypeComboBox.addItem("A+");
                bloodTypeComboBox.addItem("O-");
                bloodTypeComboBox.addItem("B-");
                bloodTypeComboBox.addItem("AB-");
                bloodTypeComboBox.addItem("A-");
                bloodTypeComboBox.setSelectedIndex(-1);
                lblOrganType.setVisible(false);
                organTypeComboBox.setVisible(false);
                break;
            case "Organ":
                lblOrganType.setVisible(true);
                organTypeComboBox.setVisible(true);
                organTypeComboBox.removeAllItems();  // to load type of organ combo box
                organTypeComboBox.addItem("Kidney");
                organTypeComboBox.addItem("Eye");
                bloodTypeComboBox.setSelectedIndex(-1);
                lblBloodType.setVisible(false);
                bloodTypeComboBox.setVisible(false);
                break;
            default:
                lblBloodType.setVisible(false);
                bloodTypeComboBox.setVisible(false);
                lblOrganType.setVisible(false);
                organTypeComboBox.setVisible(false);
                break;
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
        }
    }//GEN-LAST:event_donationTypeComboBoxActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        sendEmail();
        JOptionPane.showMessageDialog(null,"Donation request submitted successfully");
                            
    }//GEN-LAST:event_btnSubmitActionPerformed

    private class SMTPAuthenticator extends javax.mail.Authenticator
    {
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication("aeddemogss@gmail.com", "aed_gss123");
        }
    }
    private void sendEmail()
    {
        try
        {
        Properties props = new Properties();
        
        props.put("mail.smtp.user", "aeddemogss@gmail.com");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);

        session.setDebug(true);

        // create a message
        MimeMessage msg = new MimeMessage(session);
            msg.setText("Thankyou for your donation request.Your request will be shortly processed");
            msg.setSubject("Email from Americare");
            msg.setFrom(new InternetAddress("aeddemogss@gmail.com"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailIdTxtBox.getText()));
            Transport.send(msg);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error in Sending Email---"+e.getMessage());
        }
    }
    
    private void donationTypeComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_donationTypeComboBoxMouseClicked
        
    }//GEN-LAST:event_donationTypeComboBoxMouseClicked

    private void networkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkComboBoxActionPerformed
        try{
        donationTypeComboBox.setEnabled(true);
        loadDonationTypeComboBox();
        donationTypeComboBox.setSelectedIndex(-1);
        nameTxtBox.setEnabled(true);
        addressTxtArea.setEnabled(true);
        emailIdTxtBox.setEnabled(true);
        contactTxtBox.setEnabled(true);
        lblBloodType.setVisible(false);
        bloodTypeComboBox.setVisible(false);
        lblOrganType.setVisible(false);
        organTypeComboBox.setVisible(false);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Something went wrong..");
        }
    }//GEN-LAST:event_networkComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTxtArea;
    private javax.swing.JLabel backgroundLbl;
    private javax.swing.JComboBox bloodTypeComboBox;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnYes;
    private javax.swing.JTextField contactTxtBox;
    private javax.swing.JComboBox donationTypeComboBox;
    private javax.swing.JTextField emailIdTxtBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddMore;
    private javax.swing.JLabel lblBloodType;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblOrganType;
    private javax.swing.JTextField nameTxtBox;
    private javax.swing.JComboBox networkComboBox;
    private javax.swing.JComboBox organTypeComboBox;
    // End of variables declaration//GEN-END:variables
}
