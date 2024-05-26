package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Cookies extends Abstract{
    public Cookies(WebDriver driver) {
        this.driver = (EventFiringWebDriver) driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@class = 'cookies__btn btn-minor-md']")
    public WebElement cookies;
    public By cookiesWait = By.xpath("//button[@class = 'cookies__btn btn-minor-md']");

    public void cookiesAgree() {
    clickOnElement(cookiesWait);
    }
}
