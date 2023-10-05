package service;

import java.math.BigDecimal;
import pojo.MarginAccount;
import repository.TradeAccountRepository;

public class MarginAccountService implements TradeAccountService {

private TradeAccountRepository repository;

    public MarginAccountService(TradeAccountRepository repository){
        this.repository = repository;
    }

    public void createTradeAccount(MarginAccount tradeAccount){
       repository.createTradeAccount(tradeAccount);
    }
   
    public MarginAccount retrieveTradeAccount(String id){
       return (MarginAccount) repository.retrieveTradeAccount(id);
    }

    public void updateTradeAccount(MarginAccount marginAccount){
       repository.updateTradeAccount(marginAccount);
    }

    public void deleteTradeAccount(String id){
        repository.deleteTradeAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        MarginAccount currentAccount = (MarginAccount) repository.retrieveTradeAccount(id).clone();
        repository.updateTradeAccount(new MarginAccount(id, currentAccount.getMargin().add(amount)));
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        MarginAccount currentAccount = (MarginAccount) repository.retrieveTradeAccount(id).clone();
        repository.updateTradeAccount(new MarginAccount(id, currentAccount.getMargin().subtract(amount)));
    }


}