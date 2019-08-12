package com.oppa.payboxsoft.api;

import com.oppa.payboxsoft.rest.validators.AmountConstraint;
import com.oppa.payboxsoft.rest.validators.MobileNumberConstraint;

import javax.validation.constraints.NotNull;

public class MobileParameters {

    @MobileNumberConstraint
    private String mobileNumber;

    @AmountConstraint
    private Integer amount;

    @NotNull
    private Service service;

    public MobileParameters() {
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public Service getService() {
        return service;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
