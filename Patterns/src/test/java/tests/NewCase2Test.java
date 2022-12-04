package tests;

import org.junit.jupiter.api.Test;
import pages.ElectricCookersPage;
import pages.StartPage;
import tests.matchers.ElectricCookersPageMatcher;

public class NewCase2Test extends BaseTest{

    public ElectricCookersPage getElectricCookersPage(String testNumber){
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
        startPage.linkCookerAndFurnace().focusOnLink();
        startPage.linkElectricCooker().focusOnLink();
        startPage.linkElectricCooker().click();
        ElectricCookersPage electricCookersPage = new ElectricCookersPage(driver);
        electricCookersPage.takeScreenshot("afterOpenElectricCookersPage" + testNumber);
        return electricCookersPage;
    }

    @Test
    public void Test1(){
        //Arrange
        int itemCountExpectedMoreThan = 100;
        //Act
        ElectricCookersPage electricCookersPage = getElectricCookersPage("Test1");
        //Assert
        ElectricCookersPageMatcher electricCookersPageMatcher = new ElectricCookersPageMatcher(electricCookersPage);
        electricCookersPageMatcher.pageItemCountMoreThan(itemCountExpectedMoreThan);
    }
}
