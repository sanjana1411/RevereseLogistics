package com.example.revereselogistics.POJOs;

public class Wholesaler_Details {
    public String Email_id, Name, Password, Ph_no, Region, Address1, City, State, Pincode;
    public Wholesaler_Details(String Email_id, String Name, String Password,
                              String Ph_no, String Region, String address1,
                              String city, String state, String pincode) {
        this.Email_id = Email_id;
        this.Name = Name;
        this.Password = Password;
        this.Ph_no = Ph_no;
        this.Region = Region;
        this.Address1 = address1;
        this.City = city;
        this.State = state;
        this.Pincode = pincode;
    }



}
