package ru.wallet.data.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author nivanov
 *         on 04.01.17.
 */
@Entity
@Inheritance
public class MoneyMoving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime eventTime;

    @NotNull
    private BigDecimal value;
    private String userComment;

    @NotNull
    @ManyToOne
    private Wallet wallet;

    @NotNull
    @ManyToOne
    private MoneyMovingCategory category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public MoneyMovingCategory getCategory() {
        return category;
    }

    public void setCategory(MoneyMovingCategory category) {
        this.category = category;
    }
}
