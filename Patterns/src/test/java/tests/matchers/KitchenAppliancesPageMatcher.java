package tests.matchers;

import org.junit.jupiter.api.Assertions;
import pages.KitchenAppliancesPage;

public class KitchenAppliancesPageMatcher {
    KitchenAppliancesPage page;

    public KitchenAppliancesPageMatcher(KitchenAppliancesPage page) {
        this.page = page;
    }

    public void pageTitleEquals(String expected) {
        String actual = page.textTitle().getText();
        Assertions.assertEquals(expected, actual, "Текст 'Техника для кухни' не отображается");
    }

    public void pageLinkCustomKitchenVisibility(Boolean expected) {
        Boolean actual = page.linkCustomKitchen().visibility();
        Assertions.assertEquals(expected, actual, "Ссылка 'Собрать свою кухню' не отображается");
    }

    public void pageSubCategoryMoreThan(int expected) {
        int actual = page.linksSubCategory().size();
        Assertions.assertTrue(actual > expected, "Количество категорий > " + expected);
    }
}
