package UI.PageObject;

import UI.Abstract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ItemPageWB extends Abstract {

    public ItemPageWB (WebDriver driver) {
        this.driver = (EventFiringWebDriver) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class = 'price-block__wallet-price']")
    public WebElement priceItemPage;
    public By priceItemPageWait = By.xpath("//span[@class = 'price-block__wallet-price']");

    @FindBy(xpath = "//h1[@class = 'product-page__title']")
    public WebElement productNameItemPage;
    public By productNameItemPageWait = By.xpath("//h1[@class = 'product-page__title']");

    @FindBy(xpath = "//button[@class = 'breadcrumbs__back']")
    public WebElement buttonBackItemPage;
    public By buttonBackItemPageWait = By.xpath("//button[@class = 'breadcrumbs__back']");

}
