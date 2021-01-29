package com.example.rentGymsFrontEnd.dto;

import java.time.LocalDate;

public class ReservationDTO {
    private String hour;
    private LocalDate date;
    private Long gym_id;
    private Long payment_id;
    private Float value;
    private Long user_id;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getGym_id() {
        return gym_id;
    }

    public void setGym_id(Long gym_id) {
        this.gym_id = gym_id;
    }

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
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
        return "ReserveAndPayDTO{" +
                "hour='" + hour + '\'' +
                ", date=" + date +
                ", gym_id=" + gym_id +
                ", payment_id=" + payment_id +
                ", value=" + value +
                ", user_id=" + user_id +
                '}';
    }
}
