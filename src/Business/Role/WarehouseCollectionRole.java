/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.WarehouseCollectionOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.WarehouseCollectionRole.WarehouseCollectionRoleWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author deepankkhurana
 */
public class WarehouseCollectionRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, Network network) {
        return new WarehouseCollectionRoleWorkArea(userProcessContainer, account, (WarehouseCollectionOrganization)organization, enterprise, business, network);
    }
}