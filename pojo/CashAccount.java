package pojo;

import java.math.BigDecimal;

public class CashAccount extends TradeAccount{

    private BigDecimal cashBalance;



    public CashAccount(String id, BigDecimal cashBalance) {
        super(id);
        setCashBalance(cashBalance);
    }


    public BigDecimal getCashBalance() {
        return this.cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }
    @Override
    public TradeAccount clone(){
        return new CashAccount(this.getId(), this.getCashBalance());
    }



}
