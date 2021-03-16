package tests;

import com.codeborne.selenide.Configuration;
import helpers.CookieManager;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.util.Collections;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AuthApi.cookies;

public class TestBase {

    @BeforeAll
    public static void setUp() {
        RestAssured.filters(Collections.singletonList(new AllureRestAssured()));
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud:4444/wd/hub/";

    }

    @Step("Получение кода продукта, который находится в WishList")
    public String getNumberProduct() {
        addListener("allure", new AllureSelenide());
        open("http://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png");
        CookieManager.addCookiesToSite(cookies());
        open("http://demowebshop.tricentis.com/wishlist");
        return $(byName("removefromcart")).getValue();
    }

}
