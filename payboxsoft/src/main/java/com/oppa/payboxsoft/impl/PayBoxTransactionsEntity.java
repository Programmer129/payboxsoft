package com.oppa.payboxsoft.impl;

import com.oppa.payboxsoft.api.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "paybox_products", indexes = {
        @Index(columnList = "commission", name = "commission_index"),
        @Index(columnList = "transferred", name = "transferred_index")
})
class PayBoxTransactionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * could be null, if for example charity was persisted
     */
    @Column(name = "account_number")
    private String accountNumber;

    /**
     * could be null, if for example mobile product was persisted
     */
    @Column(name = "personal_number")
    private String personalNumber;

    @Column(name = "service", nullable = false)
    @Enumerated(EnumType.STRING)
    private Service service;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "commission")
    private Integer commission;

    @Column(name = "total")
    private Integer total;

    @Column(name = "transferred")
    private boolean transferred;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isTransferred() {
        return transferred;
    }

    public void setTransferred(boolean transferred) {
        this.transferred = transferred;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayBoxTransactionsEntity entity = (PayBoxTransactionsEntity) o;
        return id == entity.id &&
                transferred == entity.transferred &&
                Objects.equals(accountNumber, entity.accountNumber) &&
                Objects.equals(personalNumber, entity.personalNumber) &&
                service == entity.service &&
                Objects.equals(mobileNumber, entity.mobileNumber) &&
                Objects.equals(amount, entity.amount) &&
                Objects.equals(commission, entity.commission) &&
                Objects.equals(total, entity.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, personalNumber, service, mobileNumber, amount, commission, total, transferred);
    }

    @Override
    public String toString() {
        return "PayBoxTransactionsEntity{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", service=" + service +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", amount=" + amount +
                ", commission=" + commission +
                ", total=" + total +
                ", transferred=" + transferred +
                '}';
    }
}
