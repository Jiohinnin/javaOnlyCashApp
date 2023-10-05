package service;

import java.math.BigDecimal;
import pojo.CashAccount;
import repository.TradeAccountRepository;

public class CashAccountService implements TradeAccountService{

    private TradeAccountRepository repository = new TradeAccountRepository();

    public CashAccountService(TradeAccountRepository repository){
        this.repository = repository;
    }

    public void createTradeAccount(CashAccount tradeAccount){
       repository.createTradeAccount(tradeAccount);
    }
   
    public CashAccount retrieveTradeAccount(String id){
       return (CashAccount) repository.retrieveTradeAccount(id);
    }

    public void updateTradeAccount(CashAccount cashAccount){
       repository.updateTradeAccount(cashAccount);
    }

    public void deleteTradeAccount(String id){
        repository.deleteTradeAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        CashAccount currentAccount = (CashAccount) repository.retrieveTradeAccount(id).clone();
        repository.updateTradeAccount(new CashAccount(id, currentAccount.getCashBalance().add(amount)));
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        CashAccount currentAccount = (CashAccount) repository.retrieveTradeAccount(id).clone();
        repository.updateTradeAccount(new CashAccount(id, currentAccount.getCashBalance().subtract(amount)));
    }

    

}
