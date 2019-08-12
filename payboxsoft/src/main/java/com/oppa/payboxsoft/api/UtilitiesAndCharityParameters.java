package com.oppa.payboxsoft.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oppa.payboxsoft.rest.validators.PersonalNumberConstraint;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

// TODO decide nested objects or flat JSON :)

public class UtilitiesAndCharityParameters {

    @PersonalNumberConstraint
    private String personalNumber;

    @Valid
    @NotNull
    @JsonProperty("amountAndNumber")
    private MobileParameters mobileParameters;

    public UtilitiesAndCharityParameters() {
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public MobileParameters getMobileParameters() {
        return mobileParameters;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public void setMobileParameters(MobileParameters mobileParameters) {
        this.mobileParameters = mobileParameters;
    }
}
