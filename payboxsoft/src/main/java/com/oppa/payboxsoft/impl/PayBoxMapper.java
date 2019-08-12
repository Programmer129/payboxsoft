package com.oppa.payboxsoft.impl;

import com.oppa.payboxsoft.api.FinancialParameters;
import com.oppa.payboxsoft.api.MobileParameters;
import com.oppa.payboxsoft.api.Price;
import com.oppa.payboxsoft.api.UtilitiesAndCharityParameters;
import org.springframework.stereotype.Component;

@Component
class PayBoxMapper {

    PayBoxTransactionsEntity mapToEntity(FinancialParameters request, Price price) {
        PayBoxTransactionsEntity entity = mapToEntity(request.getUtilitiesAndCharityParameters(), price);
        entity.setAccountNumber(request.getAccountNumber());

        return entity;
    }

    PayBoxTransactionsEntity mapToEntity(UtilitiesAndCharityParameters request, Price price) {
        PayBoxTransactionsEntity entity = mapToEntity(request.getMobileParameters(), price);
        entity.setPersonalNumber(request.getPersonalNumber());

        return entity;
    }

    PayBoxTransactionsEntity mapToEntity(MobileParameters request, Price price) {
        PayBoxTransactionsEntity entity = new PayBoxTransactionsEntity();

        entity.setAmount(price.getAmount());
        entity.setCommission(price.getCommission());
        entity.setTotal(price.getTotal());
        entity.setMobileNumber(request.getMobileNumber());
        entity.setService(request.getService());

        return entity;
    }
}
