package com.herokuapp.restful_booker.bookinginfo;

import com.herokuapp.restful_booker.model.BookingPojo;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchTestUpdateRecord {
    @Test
    public void updateRecord() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Jame");
        bookingPojo.setLastname("Brown");
        Response response = given()
                .header("Authorization","Bearer 4f1f803f9e68094")
                .header("Cookie","token=4f1f803f9e68094")
                .header("Content-Type","application/json")
                .body(bookingPojo)
                .when()
                .patch("/booking/3037");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}