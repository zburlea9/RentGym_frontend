package com.example.rentGymsFrontEnd.dto;

public class PaymentDTO {

    private Long id;
    private Float value;
    private Long user_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id=" + id +
                ", value=" + value +
                ", user_id=" + user_id +
                '}';
    }
}
