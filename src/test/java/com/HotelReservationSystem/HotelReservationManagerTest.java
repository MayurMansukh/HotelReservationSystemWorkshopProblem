package com.HotelReservationSystem;

import static com.HotelReservationSystem.HotelReservationManager.hotels;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;


class HotelReservationManagerTest {

    HotelReservationManager hotelReservation;

    @BeforeEach
    public void setup(){
        hotelReservation=new HotelReservationManager();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

    }

    Hotel lakewood =new Hotel("Lakewood",100,120);
    Hotel bridgewood =new Hotel("Bridgewood",200,240);
    Hotel ridgewood =new Hotel("Ridgewood",300,350);

    @Test
    public void testAddHotel(){ //create addHotelTest method to test

        Assertions.assertTrue(hotels.contains(lakewood));
        Assertions.assertTrue(hotels.contains(bridgewood));
        Assertions.assertTrue(hotels.contains(ridgewood));

        System.out.println("Welcome To Hotel Reservayion System");
        hotels.forEach(System.out::println);
    }//test

    @Test
    public void cheapestHotelListTest(){ //find chepest Hotel
        LocalDate date1=LocalDate.of(2020,10,10);
        LocalDate date2=LocalDate.of(2020,10,11);

        Hotel cheapesthotel=hotelReservation.chepeatestHotelListWeekEndRate(date1,date2);

        Assertions.assertEquals("Lakewood",cheapesthotel.hotelName);
    }//CHLT


    @Test
    public void weekdayRates(){ //test weekday hotel rate
        Assertions.assertEquals(100,lakewood.weekdayrate);
        Assertions.assertEquals(200,bridgewood.weekdayrate);
        Assertions.assertEquals(300,ridgewood.weekdayrate);
    }//WDR

    @Test
    public void weekEndRates(){ //test weekend hotel rate
        Assertions.assertEquals(120,lakewood.weekendrate);
        Assertions.assertEquals(240,bridgewood.weekendrate);
        Assertions.assertEquals(350,ridgewood.weekendrate);
    }//WER
}//class