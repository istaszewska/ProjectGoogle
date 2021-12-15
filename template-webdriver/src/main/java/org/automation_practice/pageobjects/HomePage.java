package org.automation_practice.pageobjects;

import org.automation_practice.components.ItemsInCartPopup;
import org.automation_practice.components.TopMenu;
import org.openqa.selenium.WebDriver;
import org.automation_practice.AbstractPage;
import org.automation_practice.components.Header;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Header header() {
        return new Header(driver);
    }

    public TopMenu topMenu(){return new TopMenu(driver);}

    public ShoppingCartSummaryPage shoppingCartSummaryPage(){return new ShoppingCartSummaryPage(driver);}

    public  TShirtsPage tShirtsPage(){return new TShirtsPage(driver);}

    public ItemsInCartPopup itemsInCartPopup(){return new ItemsInCartPopup(driver);}

    public CasualDressesPage casualDressesPage(){return new CasualDressesPage(driver);}

}
