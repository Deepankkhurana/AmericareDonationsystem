/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author deepankkhurana
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.FoodNGO.getValue())){
            organization = new FoodNGOOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.ClothesNGO.getValue())){
            organization = new ClothesNGOOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Donor.getValue())){
            organization = new DonorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.BloodBank.getValue())){
            organization = new BloodBankOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.OrganBank.getValue())){
            organization = new OrganBankOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.WarehouseCollection.getValue())){
            organization = new WarehouseCollectionOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.WarehouseDistribution.getValue())){
            organization = new WarehouseDistributionOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
