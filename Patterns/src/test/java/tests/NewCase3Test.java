package tests;

import helpers.JavaScriptHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.NotebookProductPage;
import pages.NotebooksPage;
import pages.StartPage;
import tests.matchers.NotebookProductPageMatcher;

public class NewCase3Test extends BaseTest {

    private Logger logger = LogManager.getLogger(NewCase3Test.class);
    public String notebooksPageFirstProductName = "";

    public NotebookProductPage getNotebookProductPage(String company, String ramValue, String sortType,String testNumber) {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        startPage.buttonApplyCity().click();
        startPage.takeScreenshot("afterClickOnApplyCity" + testNumber);
        //нестабильно работает тест на этом шаге
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startPage.linkPcNotebooksEtc().focusOnLink();
        startPage.takeScreenshot("afterMoveToLinkPcNotebooksEtc" + testNumber);
        startPage.linkNotebooks().focusOnLink();
        startPage.takeScreenshot("afterMoveToLinkNotebooks" + testNumber);
        startPage.linkPcNotebooksEtc().focusOnLink();
        startPage.linkNotebooks().focusOnLink();
        startPage.linkNotebooks().click();
        NotebooksPage notebooksPage = new NotebooksPage(driver);
        notebooksPage.takeScreenshot("afterOpenNotebooksPage" + testNumber);
        notebooksPage.blockHeader().hide();
        notebooksPage.takeScreenshot("afterHideBlock" + testNumber);
        JavaScriptHelper.scrollBy(0, 1000);
        notebooksPage.checkBoxCompany(company).setChecked(true);
        JavaScriptHelper.scrollBy(0, 600);
        notebooksPage.accordeonRAM().show();
        notebooksPage.checkBoxRam(ramValue).setChecked(true);
        JavaScriptHelper.scrollBy(0,600);
        notebooksPage.buttonApplyFilter().click();
        notebooksPage.takeScreenshot("afterApplyFilters" + testNumber);
        notebooksPage.accordeonSort().show();
        notebooksPage.radiobuttonSort(sortType).setSelected(true);
        notebooksPage.takeScreenshot("afterSetSort" + testNumber);
        JavaScriptHelper.scrollBy(0,600);
        notebooksPageFirstProductName = notebooksPage.textFirstProductName().getText();
        notebooksPage.linkFirstProduct().openInNewWindow();
        NotebookProductPage notebookProductPage = new NotebookProductPage(driver);
        notebookProductPage.takeScreenshot("afterOpenNotebookProductPage" + testNumber);
        return new NotebookProductPage(driver);
    }


    public NotebookProductPage actionsInNotebookProductPage(NotebookProductPage notebookProductPage) {
        JavaScriptHelper.scrollBy(0,600);
        notebookProductPage.btnDropDownCharacteristics().click();
        JavaScriptHelper.scrollBy(0,1000);
        return notebookProductPage;
    }

    @Test
    public void Test1() {
        //Arrange
        String company = "ASUS";
        String ramValue = "32";
        String sortType = "сначала дорогие";
        //Act
        NotebookProductPage notebookProductPage = getNotebookProductPage(company, ramValue, sortType,"Test1");
        //Assert
        NotebookProductPageMatcher notebookProductPageMatcher = new NotebookProductPageMatcher(notebookProductPage);
        notebookProductPageMatcher.pageNotebookNameEquals(notebooksPageFirstProductName);
    }

    @Test
    public void Test2() {
        //Arrange
        String company = "ASUS";
        String ramValue = "32";
        String sortType = "сначала дорогие";
        String expectedManufacture = "ASUS";
        //Act
        NotebookProductPage notebookProductPage = getNotebookProductPage(company, ramValue, sortType,"Test2");
        //Assert
        NotebookProductPageMatcher notebookProductPageMatcher = new NotebookProductPageMatcher(notebookProductPage);
        notebookProductPageMatcher.pageManufactureContains(expectedManufacture);
    }

    @Test
    public void Test3() {
        //Arrange
        String company = "ASUS";
        String ramValue = "32";
        String sortType = "сначала дорогие";
        String expectedRamValue = "32";
        //Act
        NotebookProductPage notebookProductPage = getNotebookProductPage(company, ramValue, sortType,"Test3");
        //Assert
        NotebookProductPageMatcher notebookProductPageMatcher = new NotebookProductPageMatcher(actionsInNotebookProductPage(notebookProductPage));
        notebookProductPageMatcher.pageNotebookRamValueEquals(expectedRamValue);
    }

}
