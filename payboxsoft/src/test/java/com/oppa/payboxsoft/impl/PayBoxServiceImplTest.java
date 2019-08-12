package com.oppa.payboxsoft.impl;

import com.oppa.payboxsoft.api.FinancialParameters;
import com.oppa.payboxsoft.api.MobileParameters;
import com.oppa.payboxsoft.api.Price;
import com.oppa.payboxsoft.api.Service;
import com.oppa.payboxsoft.api.UtilitiesAndCharityParameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class PayBoxServiceImplTest {

    @InjectMocks
    private PayBoxServiceImpl service;

    @Mock
    private AdditionalFeesRepository repository;

    @Mock
    private PayBoxProductsTransactionsRepository payBoxProductsTransactionsRepository;

    @Mock
    private MobileParameters mobileParameters;

    @Mock
    private PayBoxMapper mapper;

    @Mock
    private UtilitiesAndCharityParameters utilitiesAndCharityParameters;

    @Before
    public void before() {

    }

    @Test
    public void shouldCalculatePrePriceUsingMinimumCommissionPrice() {
        // Expected
        Price price = new Price(500, 50, 550);

        // Given
        AdditionalFeesEntity entity = new AdditionalFeesEntity();
        entity.setCommission(BigDecimal.ONE);
        entity.setMinCommissionPrice(50);

        doReturn(Optional.of(entity)).when(repository).findByService(Service.MOBILE);

        // When
        Price actual = service.calculatePrePrice(500, Service.MOBILE);

        // Then
        assertEquals(price, actual);
    }

    @Test
    public void shouldCalculatePerPrice() {
        // Expected
        Price price = new Price(70000, 700, 70700);

        // Given
        AdditionalFeesEntity entity = new AdditionalFeesEntity();
        entity.setCommission(BigDecimal.ONE);
        entity.setMinCommissionPrice(50);

        doReturn(Optional.of(entity)).when(repository).findByService(Service.MOBILE);

        // When
        Price actual = service.calculatePrePrice(70000, Service.MOBILE);

        // Then
        assertEquals(price, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowException() {
        // Given
        doReturn(Optional.empty()).when(repository).findByService(Service.MOBILE);

        // Then
        service.calculatePrePrice(70000, Service.MOBILE);
    }

    @Test
    public void shouldTransferToMobile() {
        // Given
        MobileParameters mobileParameters = new MobileParameters();
        mobileParameters.setAmount(100);
        mobileParameters.setMobileNumber("555121314");
        mobileParameters.setService(Service.MOBILE);
        AdditionalFeesEntity entity = new AdditionalFeesEntity();
        entity.setCommission(BigDecimal.ONE);
        entity.setMinCommissionPrice(50);

        doReturn(Optional.of(entity)).when(repository).findByService(Service.MOBILE);

        // Then
        service.transferToMobile(mobileParameters);
    }

    @Test
    public void shouldTransferToCharity() {
        // Given
        MobileParameters mobileParameters = new MobileParameters();
        mobileParameters.setAmount(100);
        mobileParameters.setMobileNumber("555121314");
        mobileParameters.setService(Service.CHARITY);
        UtilitiesAndCharityParameters utilitiesAndCharityParameters = new UtilitiesAndCharityParameters();
        utilitiesAndCharityParameters.setPersonalNumber("12345678910");
        utilitiesAndCharityParameters.setMobileParameters(mobileParameters);
        AdditionalFeesEntity entity = new AdditionalFeesEntity();
        entity.setCommission(BigDecimal.ONE);
        entity.setMinCommissionPrice(50);

        doReturn(Optional.of(entity)).when(repository).findByService(Service.CHARITY);

        // Then
        service.transferToCharity(utilitiesAndCharityParameters);
    }

    @Test
    public void shouldTransferToFinancials() {
        // Given
        MobileParameters mobileParameters = new MobileParameters();
        mobileParameters.setAmount(100);
        mobileParameters.setMobileNumber("555121314");
        mobileParameters.setService(Service.FINANCIAL);
        UtilitiesAndCharityParameters utilitiesAndCharityParameters = new UtilitiesAndCharityParameters();
        utilitiesAndCharityParameters.setPersonalNumber("12345678910");
        utilitiesAndCharityParameters.setMobileParameters(mobileParameters);
        FinancialParameters financialParameters = new FinancialParameters();
        financialParameters.setAccountNumber("GE00BG0000000000000000");
        financialParameters.setUtilitiesAndCharityParameters(utilitiesAndCharityParameters);
        AdditionalFeesEntity entity = new AdditionalFeesEntity();
        entity.setCommission(BigDecimal.ONE);
        entity.setMinCommissionPrice(50);

        doReturn(Optional.of(entity)).when(repository).findByService(Service.FINANCIAL);


        // Then
        service.transferToFinancials(financialParameters);
    }

}
