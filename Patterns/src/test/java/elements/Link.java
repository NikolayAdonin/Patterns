package elements;

import helpers.*;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Link extends BaseElement {
    public Link(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    public Boolean visibility(){
        return webElement.isDisplayed();
    }

    public void focusOnLink() {
        WaitHelper.visibilityOfElement(webElement);
        WaitHelper.clickabilityOfElement(webElement);
        ActionHelper.moveToElement(webElement);
    }

    private String getURL() {
        return webElement.getAttribute("href");
    }

    public void openInNewWindow() {
        String URL = this.getURL();
        SwitchHelper.switchToNewWindow();
        WindowHelper.maximizeWindow();
        NavigationHelper.navigateTo(URL);
    }

    public String getText() {
        return webElement.getText();
    }
}
