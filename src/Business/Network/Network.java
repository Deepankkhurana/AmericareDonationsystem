/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author deepankkhurana
 */
public class Network {

    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private ArrayList<Network> networkList;

    public Network() {
        enterpriseDirectory = new EnterpriseDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    @Override
    public String toString() {
        return name;
    }
    
        public boolean checkIfNetworkIsUnique(String name){
        for (Network n : networkList){
            if (n.getName().equals(name))
                return false;
        }
        return true;
    }

         public ArrayList<Network> getnetworkList() {
        return networkList;
    }
}
