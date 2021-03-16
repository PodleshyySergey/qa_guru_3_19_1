package specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static template.ReportTemplate.filters;

public class ResponseSpec {

    public static RequestSpecification request() {
        return given()
                .baseUri("http://demowebshop.tricentis.com")
                .filter(filters().customTemplates())
                .contentType("application/x-www-form-urlencoded")
                .log().uri();
    }

}
