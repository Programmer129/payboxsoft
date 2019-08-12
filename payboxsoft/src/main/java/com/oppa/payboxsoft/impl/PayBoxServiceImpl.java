package com.oppa.payboxsoft.impl;

import com.oppa.payboxsoft.api.FinancialParameters;
import com.oppa.payboxsoft.api.MobileParameters;
import com.oppa.payboxsoft.api.PayBoxService;
import com.oppa.payboxsoft.api.Price;
import com.oppa.payboxsoft.api.UtilitiesAndCharityParameters;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
class PayBoxServiceImpl implements PayBoxService {

    private final PayBoxProductsTransactionsRepository repository;
    private final AdditionalFeesRepository additionalFeesRepository;
    private final PayBoxMapper payBoxMapper;

    PayBoxServiceImpl(PayBoxProductsTransactionsRepository repository,
                      AdditionalFeesRepository additionalFeesRepository,
                      PayBoxMapper payBoxMapper) {
        this.repository = repository;
        this.additionalFeesRepository = additionalFeesRepository;
        this.payBoxMapper = payBoxMapper;
    }

    @Override
    public Price calculatePrePrice(int amount, com.oppa.payboxsoft.api.Service service) {
        AdditionalFeesEntity entity = additionalFeesRepository
                .findByService(service)
                .orElseThrow(() -> new IllegalStateException("Commission not found for ".concat(service.name())));

        BigDecimal commissionRate = entity.getCommission().movePointLeft(2);

        int minCommission = entity.getMinCommissionPrice();

        int commission = BigDecimal.valueOf(amount).multiply(commissionRate).intValue();

        commission = Math.max(commission, minCommission);

        return new Price(amount, commission, amount + commission);
    }

    @Override
    public void transferToMobile(MobileParameters request) {
        Price price = calculatePrePrice(request.getAmount(), request.getService());

        repository.save(payBoxMapper.mapToEntity(request, price));
    }

    @Override
    public void transferToCharity(UtilitiesAndCharityParameters request) {
        Price price = calculatePrePrice(request.getMobileParameters().getAmount(), request.getMobileParameters().getService());

        repository.save(payBoxMapper.mapToEntity(request, price));
    }

    @Override
    public void transferToFinancials(FinancialParameters request) {
        int amount = request.getUtilitiesAndCharityParameters().getMobileParameters().getAmount();
        com.oppa.payboxsoft.api.Service service = request.getUtilitiesAndCharityParameters().getMobileParameters().getService();
        Price price = calculatePrePrice(amount, service);

        repository.save(payBoxMapper.mapToEntity(request, price));
    }
}
