package com.example.rentGymsFrontEnd.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankAccountDTO {

    private Long id;
    private String bank_number;
    private String security_number;
    private Float amount;
    private Long user_id;

    public BankAccountDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getBank_number() {
        return bank_number;
    }

    public void setBank_number(String bank_number) {
        this.bank_number = bank_number;
    }

    public String getSecurity_number() {
        return security_number;
    }

    public void setSecurity_number(String security_number) {
        this.security_number = security_number;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "BankAccountDTO{" +
                "id=" + id +
                ", bank_number='" + bank_number + '\'' +
                ", security_number='" + security_number + '\'' +
                ", amount=" + amount +
                ", user=" + user_id +
                '}';
    }
}
