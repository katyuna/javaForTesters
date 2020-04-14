package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    //@BeforeTest
    public void setUp() {
        app.init();
    }

    @AfterMethod
    //@AfterTest
    public void tearDown() {
        app.stop();
    }

}
