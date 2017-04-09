/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group;

/**
 *
 * @author 749849
 */
public class Invoice {
     public String BookingId;
    public String BasePrice;
    public String AgencyCommision;
    public String Destination;
    public String TravelerCount;
    public String Sum;

    public String getBookingId() {
        return BookingId;
    }

    public void setBookingId(String BookingId) {
        this.BookingId = BookingId;
    }

    public String getBasePrice() {
        return BasePrice;
    }

    public void setBasePrice(String BasePrice) {
        this.BasePrice = BasePrice;
    }

    public String getAgencyCommision() {
        return AgencyCommision;
    }

    public void setAgencyCommision(String AgencyCommision) {
        this.AgencyCommision = AgencyCommision;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getTravelerCount() {
        return TravelerCount;
    }

    public void setTravelerCount(String TravelerCount) {
        this.TravelerCount = TravelerCount;
    }

    public String getSum() {
        return Sum;
    }

    public void setSum(String Sum) {
        this.Sum = Sum;
    }

    @Override
    public String toString() {
        return "Invoice{" + "BookingId=" + BookingId + ", BasePrice=" + BasePrice + ", AgencyCommision=" + AgencyCommision + ", Destination=" + Destination + ", TravelerCount=" + TravelerCount + '}';
    }
    
    
    



}
