package tests.matchers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.NotebookProductPage;

public class NotebookProductPageMatcher {
    NotebookProductPage page;
    private Logger logger = LogManager.getLogger(NotebookProductPageMatcher.class);

    public NotebookProductPageMatcher(NotebookProductPage page) {
        this.page = page;
    }

    public void pageTitleEquals(String expected) {
        String actualTitle = page.getPageTitle();
        Assertions.assertTrue(actualTitle.contains(expected), "Название ноутбука не соответсвует названию в заголовке страницы");
    }

    public void pageNotebookNameEquals(String expected) {
        String actualNotebookName = page.textTitleNotebookName.getText();
        Assertions.assertTrue(expected.contains(actualNotebookName), "Название ноутбука не соответсвует названию на прошлой странице");
    }

    public void pageManufactureContains(String expected) {
        String actualManufacture = page.textTitleManufacture.getText();
        Assertions.assertTrue(actualManufacture.contains(expected), "Заголовок не содержит 'ASUS'");
    }

    public void pageNotebookRamValueEquals(String expected) {
        String actualRamValue = page.textNotebookRamValue().getText();
        Assertions.assertEquals(expected + "ГБ", actualRamValue.replaceAll("\\s+", ""), "Количество оперативной памяти != " + expected + " Гб");
    }
}
