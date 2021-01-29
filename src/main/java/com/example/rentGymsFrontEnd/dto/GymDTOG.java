package com.example.rentGymsFrontEnd.dto;

public class GymDTOG {
    private String gym_id;
    private String gym_name;
    private String gym_description;
    private String gym_location;
    private String gym_price;
    private String gym_type;

    public String getGym_id() {
        return gym_id;
    }

    public void setGym_id(String gym_id) {
        this.gym_id = gym_id;
    }

    public String getGym_name() {
        return gym_name;
    }

    public void setGym_name(String gym_name) {
        this.gym_name = gym_name;
    }

    public String getGym_description() {
        return gym_description;
    }

    public void setGym_description(String gym_description) {
        this.gym_description = gym_description;
    }

    public String getGym_location() {
        return gym_location;
    }

    public void setGym_location(String gym_location) {
        this.gym_location = gym_location;
    }

    public String getGym_price() {
        return gym_price;
    }

    public void setGym_price(String gym_price) {
        this.gym_price = gym_price;
    }

    public String getGym_type() {
        return gym_type;
    }

    public void setGym_type(String gym_type) {
        this.gym_type = gym_type;
    }

    @Override
    public String toString() {
        return "GymDTOG{" +
                "gym_id='" + gym_id + '\'' +
                ", gym_name='" + gym_name + '\'' +
                ", gym_description='" + gym_description + '\'' +
                ", gym_location='" + gym_location + '\'' +
                ", gym_price='" + gym_price + '\'' +
                ", gym_type='" + gym_type + '\'' +
                '}';
    }
}
