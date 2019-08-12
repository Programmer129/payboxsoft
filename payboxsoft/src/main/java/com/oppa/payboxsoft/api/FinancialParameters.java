package com.oppa.payboxsoft.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.oppa.payboxsoft.rest.validators.AccountNumberConstraint;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class FinancialParameters {

    @AccountNumberConstraint
    private String accountNumber;

    @Valid
    @NotNull
    @JsonProperty("amountAndPersonalInfo")
    private UtilitiesAndCharityParameters utilitiesAndCharityParameters;

    public FinancialParameters() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public UtilitiesAndCharityParameters getUtilitiesAndCharityParameters() {
        return utilitiesAndCharityParameters;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setUtilitiesAndCharityParameters(UtilitiesAndCharityParameters utilitiesAndCharityParameters) {
        this.utilitiesAndCharityParameters = utilitiesAndCharityParameters;
    }
}
