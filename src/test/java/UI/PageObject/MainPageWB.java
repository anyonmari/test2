package UI.PageObject;

import UI.Abstract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MainPageWB extends Abstract {
    public MainPageWB (WebDriver driver) {
        this.driver = (EventFiringWebDriver) driver;
        PageFactory.initElements(driver, this);
    }
    public String wb = "https://www.wildberries.ru/";
    @FindBy(xpath = "(//a[contains(@class, 'product-card__link')])[1]")
    public WebElement firsItemCard;
    public By firsItemCardWait = By.xpath("(//a[contains(@class, 'product-card__link')])[1]");
    @FindBy(xpath = "(//a[contains(@class, 'product-card__link')])[2]")
    public WebElement secondItemCard;
    public By secondItemCardWait = By.xpath( "(//a[contains(@class, 'product-card__link')])[2]");

    @FindBy(xpath = "(//span[@class='product-card__name'])[1]")
    public WebElement productFistCardName;
    public By productCardFirstNameWait = By.xpath("(//span[@class='product-card__name'])[1]");

    @FindBy(xpath = "(//span[@class='product-card__name'])[2]")
    public WebElement productSecondCardName;
    public By productCardSecondNameWait = By.xpath("(//span[@class='product-card__name'])[2]");
    @FindBy(xpath = "(//ins[@class='price__lower-price wallet-price'])[1]")
    public WebElement priceFirst;
    public By priceFirstWait = By.xpath("(//ins[@class='price__lower-price wallet-price'])[1]");
    @FindBy(xpath = "(//ins[@class='price__lower-price wallet-price'])[2]")
    public WebElement priceSecond;
    public By priceSecondWait = By.xpath("(//ins[@class='price__lower-price wallet-price'])[2]");

}
