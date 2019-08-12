package com.oppa.payboxsoft.api;

public interface PayBoxService {

    Price calculatePrePrice(int amount, Service service);

    void transferToMobile(MobileParameters request);

    void transferToCharity(UtilitiesAndCharityParameters request);

    void transferToFinancials(FinancialParameters request);
}
