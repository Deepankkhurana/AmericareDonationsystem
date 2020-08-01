/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Donor.Donor;

/**
 *
 * @author deepankkhurana
 */
public class AcceptDonationWorkRequest extends WorkRequest{
    
//    private String result;
//
//    public String getResult() {
//        return result;
//    }
//
//    public void setResult(String result) {
//        this.result = result;
//    }
    private Donor donor;

    
    public AcceptDonationWorkRequest(){
        donor = new Donor();
    }
    
    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    @Override
    public String toString() {
        return donor.getName();
    }

    
}
