package com.herokuapp.restful_booker.bookinginfo;

import com.herokuapp.restful_booker.model.BookingPojo;
import com.herokuapp.restful_booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostCreateBooking extends TestBase {
    @Test
    public void createBooking(){
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("jim");
        bookingPojo.setLastname("Brown");
        bookingPojo.setDepositpaid(true);
        bookingPojo.setTotalprice(111);
        HashMap<String,String> dates= new HashMap<>();
        dates.put("checkin","2018-01-01");
        dates.put("checkout","2019-01-01");
        bookingPojo.setBookingdates(dates);
        bookingPojo.setAdditionalneeds("Breakfast");
        Response response =given()
                .header("Content-Type","application/json")
                .body(bookingPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}