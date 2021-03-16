package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import models.AddWishListResponse;
import org.junit.jupiter.api.*;
import specs.RequestSpec;
import specs.ResponseSpec;
import java.util.Collections;
import static helpers.AuthApi.cookies;
import static helpers.AuthApi.mapToString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WishListTests extends TestBase {
    String cookieText = mapToString(cookies());

    @BeforeAll
    public static void setUp() {
        RestAssured.filters(Collections.singletonList(new AllureRestAssured()));
    }

    @Test
    @Order(1)
    @DisplayName("Добавление товара в WishList.")
    public void addToWishListTest() {

        AddWishListResponse response = RequestSpec.request()
                .cookie(cookieText)
                .when()
                .post("/addproducttocart/details/28/2")
                .then()
                .statusCode(200)
                .extract().as(AddWishListResponse.class);

        assertEquals(response.getUpdatetopwishlistsectionhtml(), "(1)");
    }

    @Test
    @Order(2)
    @DisplayName("Удаление товара из WishList.")
    public void removeFromWishListTest() {
        String prodVal = getNumberProduct(); //Получение номера продукта из WishList для передачи в запросе на его удаление
        String bodyText = "removefromcart=" + prodVal + "&itemquantity" + prodVal + "=1&updatecart=Update+wishlist";

        ResponseSpec.request()
                .cookie(cookieText)
                .body(bodyText)
                .when()
                .post("/wishlist")
                .then()
                .statusCode(200);
    }
}
