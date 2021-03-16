package specs;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static template.ReportTemplate.filters;

public class RequestSpec {

    public static RequestSpecification request() {
        return given()
                .baseUri("http://demowebshop.tricentis.com")
                .filter(filters().customTemplates())
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("product_attribute_28_7_10=25&product_attribute_28_1_11=29&addtocart_28.EnteredQuantity=1")
                .log().uri();
    }

}
