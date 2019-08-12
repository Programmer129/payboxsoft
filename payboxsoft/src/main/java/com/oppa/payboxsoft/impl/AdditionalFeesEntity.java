package com.oppa.payboxsoft.impl;

import com.oppa.payboxsoft.api.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "additional_fees")
public class AdditionalFeesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "service", nullable = false)
    @Enumerated(EnumType.STRING)
    private Service service;

    /**
     * Commission in percents
     */
    @Column(name = "commission")
    private BigDecimal commission;

    @Column(name = "min_commission_price")
    private Integer minCommissionPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Integer getMinCommissionPrice() {
        return minCommissionPrice;
    }

    public void setMinCommissionPrice(Integer minCommissionPrice) {
        this.minCommissionPrice = minCommissionPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalFeesEntity that = (AdditionalFeesEntity) o;
        return id == that.id &&
                Objects.equals(commission, that.commission) &&
                Objects.equals(minCommissionPrice, that.minCommissionPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, commission, minCommissionPrice);
    }
}
