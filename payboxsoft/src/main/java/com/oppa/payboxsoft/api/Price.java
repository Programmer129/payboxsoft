package com.oppa.payboxsoft.api;

import com.oppa.payboxsoft.rest.validators.AmountConstraint;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Price {

    @AmountConstraint
    private Integer amount;

    @NotNull
    private Integer commission;

    @NotNull
    private Integer total;

    public Price() {
    }

    public Price(Integer amount, Integer commission, Integer total) {
        this.amount = amount;
        this.commission = commission;
        this.total = total;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getCommission() {
        return commission;
    }

    public Integer getTotal() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(amount, price.amount) &&
                Objects.equals(commission, price.commission) &&
                Objects.equals(total, price.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, commission, total);
    }
}
