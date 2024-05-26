package UI.Tests;

import UI.Abstract;
import UI.Cookies;
import UI.PageObject.CartPageWB;
import UI.PageObject.ItemPageWB;
import UI.PageObject.MainPageWB;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


@Feature("Тесты связанные с провекрой добавления товара в корзину")
public class WBTests extends Abstract {
    MainPageWB mainPageWB;
    ItemPageWB itemPageWB;

    public By cookies = By.xpath("//button[@class = 'cookies__btn btn-minor-md']");

    @Tag("wb")
    @Owner("Марина")
    @DisplayName("Проверка на соответсвие цены товара")
    @Test
    public void cartTet1() {
        mainPageWB = new MainPageWB(driver);
        driver.get(mainPageWB.wb);

        if(isDisplayed(cookies)) {
            clickOnElement(cookies);
        }

        int priceFirstItemMainPage = getPriceWithoutCurrency(mainPageWB.priceFirstWait);
        int priceSecondItemMainPage = getPriceWithoutCurrency(mainPageWB.priceSecondWait);
        clickOnElement(mainPageWB.firsItemCardWait);

        itemPageWB = new ItemPageWB(driver);
        int priceFirstItemPage = getPriceWithoutCurrency(itemPageWB.priceItemPageWait);
        clickOnElement(itemPageWB.buttonBackItemPageWait);

        mainPageWB = new MainPageWB(driver);
        clickOnElement(mainPageWB.secondItemCardWait);


        itemPageWB = new ItemPageWB(driver);
        int priceSecondItemPage = getPriceWithoutCurrency(itemPageWB.priceItemPageWait);

        Assertions.assertEquals(priceFirstItemMainPage, priceFirstItemPage, "Цена товара на главной странице не равна цене товара на карточке товара");
        Assertions.assertEquals(priceSecondItemMainPage, priceSecondItemPage, "Цена товара на главной странице не равна цене товара на карточке товара");

    }
    @Tag("wb2")
    @Owner("Марина")
    @DisplayName("Проверка на соответсвие наимнования товара")
    @Test
    public void cartTet2() {
        mainPageWB = new MainPageWB(driver);
        driver.get(mainPageWB.wb);

        if(isDisplayed(cookies)) {
            clickOnElement(cookies);
        }

        String nameFirstItemMainPge = getTextWebElement(mainPageWB.productCardFirstNameWait).replaceAll("/", "").trim();
        String nameSecondItemMainPge = getTextWebElement(mainPageWB.productCardSecondNameWait).replaceAll("/", "").trim();
        clickOnElement(mainPageWB.firsItemCardWait);

        itemPageWB = new ItemPageWB(driver);
        String nameFirstItemItemPage = getTextWebElement(itemPageWB.productNameItemPageWait);
        clickOnElement(itemPageWB.buttonBackItemPageWait);

        mainPageWB = new MainPageWB(driver);
        clickOnElement(mainPageWB.secondItemCardWait);


        itemPageWB = new ItemPageWB(driver);
        String nameSecondItemItemPage = getTextWebElement(itemPageWB.productNameItemPageWait);

        Assertions.assertEquals(nameFirstItemMainPge, nameFirstItemItemPage, "Наименование товара на главной странице не совпадает с наименованием товара на карточке товара");
        Assertions.assertEquals(nameSecondItemMainPge, nameSecondItemItemPage, "Наименование товара на главной странице не совпадает с наименованием товара на карточке товара");
    }

}
