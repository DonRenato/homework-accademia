package com.nyd.VehicleSystem.Entity.Employee;

public class Manager extends Employee implements Authorization  {

    private String password = "123456";

    public String  getPassword() {
        return password;
    }

    @Override
    public int authorization(String password){
        if(password.equals(this.password)){
            return 0;
        }
        else{
            return 1;
        }
    }

    @Override
    public String getType() {
        return "Manager";
    }
}
