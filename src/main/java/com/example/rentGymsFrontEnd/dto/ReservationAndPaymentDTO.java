package com.example.rentGymsFrontEnd.dto;

import java.time.LocalDate;

public class ReservationAndPaymentDTO {

    private String hour;
    private String date;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReservationAndPaymentDTO{" +
                "hour='" + hour + '\'' +
                ", date=" + date +
                '}';
    }
}
