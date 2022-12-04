package tests;

import org.junit.jupiter.api.Test;
import pages.AppliancesPage;
import pages.KitchenAppliancesPage;
import pages.StartPage;
import tests.matchers.AppliancesPageMatcher;
import tests.matchers.KitchenAppliancesPageMatcher;

public class NewCase1Test extends BaseTest {

    public AppliancesPage getAppliancesPage(String testNumber) {
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
        startPage.linkRootCategory().focusOnLink();
        startPage.linkRootCategory().click();
        AppliancesPage appliancesPage = new AppliancesPage(driver);
        appliancesPage.takeScreenshot("afterOpenAppliancesPage" + testNumber);
        return appliancesPage;
    }

    public KitchenAppliancesPage getKitchenAppliancesPage(AppliancesPage appliancesPage, String testNumber){
        appliancesPage.linkSubCategory().click();
        KitchenAppliancesPage kitchenAppliancesPage = new KitchenAppliancesPage(driver);
        kitchenAppliancesPage.takeScreenshot("afterOpenKitchenAppliancesPage"+testNumber);
        return kitchenAppliancesPage;
    }

    @Test
    public void Test1() {
        //Arrange
        String titleExpected = "Бытовая техника";
        //Act
        AppliancesPage appliancesPage = getAppliancesPage("Test1");
        //Assert
        AppliancesPageMatcher appliancesPageMatcher = new AppliancesPageMatcher(appliancesPage);
        appliancesPageMatcher.pageTitleEquals(titleExpected);
    }

    @Test
    public void Test2() {
        //Arrange
        String titleExpected = "Техника для кухни";
        //Act
        KitchenAppliancesPage kitchenAppliancesPage = getKitchenAppliancesPage(getAppliancesPage("Test2"),"Test2");
        //Assert
        KitchenAppliancesPageMatcher kitchenAppliancesPageMatcher = new KitchenAppliancesPageMatcher(kitchenAppliancesPage);
        kitchenAppliancesPageMatcher.pageTitleEquals(titleExpected);
    }

    @Test
    public void Test3() {
        //Arrange
        Boolean linkCustomKitchenVisibility = true;
        //Act
        KitchenAppliancesPage kitchenAppliancesPage = getKitchenAppliancesPage(getAppliancesPage("Test3"),"Test3");
        //Assert
        KitchenAppliancesPageMatcher kitchenAppliancesPageMatcher = new KitchenAppliancesPageMatcher(kitchenAppliancesPage);
        kitchenAppliancesPageMatcher.pageLinkCustomKitchenVisibility(linkCustomKitchenVisibility);
    }

    @Test
    public void Test4() {
        //Arrange
        int linksSubCategoryExpectedMoreThan = 5;
        //Act
        KitchenAppliancesPage kitchenAppliancesPage = getKitchenAppliancesPage(getAppliancesPage("Test4"),"Test4");
        //Assert
        KitchenAppliancesPageMatcher kitchenAppliancesPageMatcher = new KitchenAppliancesPageMatcher(kitchenAppliancesPage);
        kitchenAppliancesPageMatcher.pageSubCategoryMoreThan(linksSubCategoryExpectedMoreThan);
    }
}
