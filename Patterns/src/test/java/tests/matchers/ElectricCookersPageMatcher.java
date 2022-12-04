package tests.matchers;

import org.junit.jupiter.api.Assertions;
import pages.ElectricCookersPage;

public class ElectricCookersPageMatcher {
    ElectricCookersPage page;

    public ElectricCookersPageMatcher(ElectricCookersPage page) {
        this.page = page;
    }

    public void pageItemCountMoreThan(int expectedCount) {
        String actualCount = page.textItemCount().getText().replaceAll("\\D", "");
        Assertions.assertTrue(Integer.parseInt(actualCount) > expectedCount, "Количество товаров > " + expectedCount);
    }
}
