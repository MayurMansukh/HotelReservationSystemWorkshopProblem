package com.HotelReservationSystem;

import static com.HotelReservationSystem.HotelReservationManager.hotels;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class HotelReservationManagerTest {

    HotelReservationManager hotelReservation;

    @BeforeEach
    public void setup(){
        hotelReservation=new HotelReservationManager();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

    }

    Hotel lakewood =new Hotel("Lakewood",100,3);
    Hotel bridgewood =new Hotel("Bridgewood",200,4);
    Hotel ridgewood =new Hotel("Ridgewood",300,5);

    @Test
    public void testAddHotel(){ //create addHotelTest method to test

        Assertions.assertTrue(hotels.contains(lakewood));
        Assertions.assertTrue(hotels.contains(bridgewood));
        Assertions.assertTrue(hotels.contains(ridgewood));

        System.out.println("Welcome To Hotel Reservayion System");
        hotels.forEach(System.out::println);
    }//test
}//class