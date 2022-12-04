package tests.matchers;

import org.junit.jupiter.api.Assertions;
import pages.AppliancesPage;

public class AppliancesPageMatcher {
    AppliancesPage page;
    public AppliancesPageMatcher(AppliancesPage page){
        this.page = page;
    }
    public void pageTitleEquals(String expected){
        String actual = page.textTitle().getText();
        Assertions.assertEquals(expected,actual,"Текст 'Бытовая техника' не отображается");
    }
}
