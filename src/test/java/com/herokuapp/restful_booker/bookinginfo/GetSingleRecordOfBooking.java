package com.herokuapp.restful_booker.bookinginfo;

import com.herokuapp.restful_booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetSingleRecordOfBooking extends TestBase {
    @Test
    public void readSingleBookingRecord(){
        Response response =  given()
                .when()
                .get("/booking/1252");
        response.then().statusCode(200);
    }
}