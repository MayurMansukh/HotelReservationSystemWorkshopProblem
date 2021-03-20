package com.HotelReservationSystem;

public class Hotel {
    String hotelName;
    int Rating;
    public static final int REGULAR_CUSTOMER = 0;
    public static final int REWARD_CUSTOMER = 1;

    public int[] weekDayRate = new int[2];
    public int[] weekEndRate = new int[2];


    public Hotel(String hotelName,int rating,int regularWeekDayRate,int regularWeekEndRate ,int rewardWeekDayRate, int rewardWeekEndRate) {
        this.hotelName = hotelName;
        this.Rating = rating;
        weekDayRate[REGULAR_CUSTOMER] = regularWeekDayRate;
        weekEndRate[REGULAR_CUSTOMER] = regularWeekEndRate;
        weekDayRate[REWARD_CUSTOMER] = rewardWeekDayRate;
        weekEndRate[REWARD_CUSTOMER] = rewardWeekEndRate;

    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", Rating=" + Rating +
                '}';
    }
}//class

