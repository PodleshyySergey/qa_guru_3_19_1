package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.CookieManager;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.AuthApi.cookies;

public class TestBase {

    @Step("Получение кода продукта, который находится в WishList")
    public String getNumberProduct() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("http://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/logo.png");
        CookieManager.addCookiesToSite(cookies());
        open("http://demowebshop.tricentis.com/wishlist");
        return $(byName("removefromcart")).getValue();
    }

}
