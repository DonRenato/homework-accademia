package com.nyd.VehicleSystem.Entity.Sale;


import com.nyd.VehicleSystem.Entity.Vehicle.Vehicle;

public class Sale {
    private int id;
    private double value;
    private int costumer;
    private int seller;
    private String vehicle;




    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getCostumer() {
        return costumer;
    }

    public void setCostumer(int costumer) {
        this.costumer = costumer;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public double saleVehicle(String vehicle, double value){ ;
        var carType = vehicle;
        if(vehicle == "Regular"){
            return  (this.value * 1.15);
        }else{
            return this.value;
        }
    }


    public double cashPayment(String vehicle, double value){
        var cash = saleVehicle(vehicle, value);
        var total = cash * 0.9;
        return total;

    }

    public double parceledOutPayment(String vehicle, double value, int parceledOut){
        var total = saleVehicle(vehicle, value);
        var parcel = total / parceledOut;
        return (parcel *= 1.0189);
    }


}
