package com.HotelReservationSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.HotelReservationSystem.HotelReservationManager.*;


class HotelReservationManagerTest {

    HotelReservationManager hotelReservation;

    @BeforeEach
    public void setup(){
        hotelReservation=new HotelReservationManager();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

    }

    Hotel lakewood =new Hotel("Lakewood",100,120,3);
    Hotel bridgewood =new Hotel("Bridgewood",200,240,4);
    Hotel ridgewood =new Hotel("Ridgewood",300,350,5);

    @Test
    public void testAddHotel(){ //create addHotelTest method to test

        Assertions.assertTrue(hotels.contains(lakewood));
        Assertions.assertTrue(hotels.contains(bridgewood));
        Assertions.assertTrue(hotels.contains(ridgewood));

        System.out.println("Welcome To Hotel Reservayion System");
        hotels.forEach(System.out::println);
   }

    @Test
    void cheapestHotelByRatingsTest() {  // test Cheapest Hotel By Rating
        Hotel  cheapestHotelByRatings = hotelReservation.cheapestHotelByRating();
        Assertions.assertEquals(lakewood, cheapestHotelByRatings);
        System.out.println("Cheapest hotel by rating: " + cheapestHotelByRatings.hotelName);
    }

    @Test
    public void bestRatedHotelTest() { //test find best hotel by rating
        Assertions.assertEquals(ridgewood, bestRatedHotel());
        System.out.println("Best rated Hotel: " + bestRatedHotel().hotelName + "  total Rate:  "  + totalRates(bestRatedHotel()) );
    }

}//class