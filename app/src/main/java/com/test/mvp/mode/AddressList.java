package com.test.mvp.mode;

/**
 * Created by Administrator on 2017/8/7.
 */

public class AddressList {
    public String  name;
    public String  phone;
    public String  address;

    public AddressList(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
