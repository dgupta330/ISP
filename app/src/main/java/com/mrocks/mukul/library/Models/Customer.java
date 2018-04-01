package com.mrocks.mukul.library.Models;

/**
 * Created by Er.Deepak_kumar on 01-04-2018.
 */

public class Customer {
    String id;
    String name;
    String mobile;
    String area;
    String company;
    String planid;
    String plandetail;

    public Customer()
    {

    }
    public Customer(String id, String name, String mobile, String area, String company, String planid, String plandetail) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.area = area;
        this.company = company;
        this.planid = planid;
        this.plandetail = plandetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
}
