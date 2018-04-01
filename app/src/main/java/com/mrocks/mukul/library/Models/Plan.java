package com.mrocks.mukul.library.Models;

/**
 * Created by Er.Deepak_kumar on 01-04-2018.
 */

public class Plan {
    String company;
    String planid;
    String plandetail;
    String customercare;
    String type;
    String imagepath;


    public Plan()
    {}

    public Plan(String company, String planid, String plandetail, String customercare, String type, String imagepath) {
        this.company = company;
        this.planid = planid;
        this.plandetail = plandetail;
        this.customercare = customercare;
        this.type = type;
        this.imagepath = imagepath;
    }

    public Plan(String company, String planid, String plandetail, String customercare, String type) {
        this.company = company;
        this.planid = planid;
        this.plandetail = plandetail;
        this.customercare = customercare;
        this.type = type;
    }

    public String getData() {
        String data;
        data="Hi "+planid+" \ndetails: "+plandetail+"\nContact : "+customercare+"\nRegards\n("+company+")" ;
        return data;
    }


    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPlanid() {
        return planid;
    }

    public void setPlanid(String planid) {
        this.planid = planid;
    }

    public String getPlandetail() {
        return plandetail;
    }

    public void setPlandetail(String plandetail) {
        this.plandetail = plandetail;
    }

    public String getCustomercare() {
        return customercare;
    }

    public void setCustomercare(String customercare) {
        this.customercare = customercare;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
