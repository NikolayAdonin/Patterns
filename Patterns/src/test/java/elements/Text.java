package elements;

import helpers.WaitHelper;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Text extends BaseElement {
    public Text(WebElement webElement) {
        super(webElement);
    }

    public String getText() {
        WaitHelper.visibilityOfElement(webElement);
        return webElement.getText();
    }
}
