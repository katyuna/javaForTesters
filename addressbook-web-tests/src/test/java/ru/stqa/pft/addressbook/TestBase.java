package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    FirefoxDriver wd;

    public static boolean isAlertPresents(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    //@BeforeMethod
    @BeforeTest
    public void setUp() {
        init();
    }

    private void init() {
        System.setProperty("webdriver.gecko.driver", "C:\\KATYUNA\\Education\\Java\\JavaForTesters\\Projects\\javaForTesters\\geckodriver.exe");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //login
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    protected void returnToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    protected void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    protected void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    protected void initGroupCreation() {

        wd.findElement(By.name("new")).click();
    }

    protected void gotoGroupPage() {

        wd.findElement(By.linkText("groups")).click();
    }

    //@AfterMethod
    @AfterTest
    public void tearDown() {
        stop();
    }

    private void stop() {
        wd.quit();
    }

    protected void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    protected void deleteSelectedGroups() {
        wd.findElement(By.name("delete")).click();
   }
}
