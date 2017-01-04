package ru.wallet.data.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Set;

/**
 * @author nivanov
 *         on 04.01.17.
 */
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    private String title;

    @NotNull
    private BigDecimal balance;
    @NotNull
    private Currency currency;
    @NotNull
    private Type type;

    @NotNull
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "wallet_id")
    private Set<MoneyMoving> moneyMovingSet;

    @NotNull
    @ManyToOne
    private SystemUser user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<MoneyMoving> getMoneyMovingSet() {
        return moneyMovingSet;
    }

    public void setMoneyMovingSet(Set<MoneyMoving> moneyMovingSet) {
        this.moneyMovingSet = moneyMovingSet;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }

    public enum Type{
        CASH, CARD, ONLINE
    }
}
