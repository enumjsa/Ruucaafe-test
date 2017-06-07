import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;



public class RuuCaafeTest {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    //TU01
    public void shouldBeInvalidLoginMessage() {
        driver.get("http://ru-cafe.ru/account/login");
        driver.findElement(By.xpath(".//*[@id='ctl00_cphMainPanel_ctl00_ctl00_txtLogin']")).sendKeys("asdasdasd");
        driver.findElement(By.xpath(".//*[@id='ctl00_cphMainPanel_ctl00_ctl00_txtPassword']")).sendKeys("qweqweqwe");
        driver.findElement(By.xpath(".//*[@id='ctl00_cphMainPanel_ctl00_ctl00_butLogin']")).click();
        String err = driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[3]/div/div/div[1]/fieldset/div")).getText();
        Assert.assertEquals("Вход не удался: эл. почта или пароль не верен", err);
    }

    @Test
    //TU02
    public void shouldBeFailedInvalidLoginMessage() {
        driver.get("http://ru-cafe.ru/account/login");
        driver.findElement(By.id("ctl00_cphMainPanel_ctl00_ctl00_txtLogin")).sendKeys("asdasdasd");
        driver.findElement(By.id("ctl00_cphMainPanel_ctl00_ctl00_txtPassword")).sendKeys("qweqweqwe");
        driver.findElement(By.id("ctl00_cphMainPanel_ctl00_ctl00_butLogin")).click();
        String err = driver.findElement(By.xpath("//form[@id='aspnetForm']/div[3]/div/div/div/fieldset/div")).getText();
        Assert.assertEquals("Вход не удался", err);

    }

    @Test
    //TU03
    public void shouldBeInvalidRestoreMessage() {
        driver.get("http://ru-cafe.ru/account/restore");
        driver.findElement(By.xpath(".//*[@id='ctl00_cphMainPanel_txtEmail']")).sendKeys("user");
        driver.findElement(By.xpath(".//*[@id='ctl00_cphMainPanel_butRestore']")).click();
        String err = driver.findElement(By.xpath(".//*[@id='ctl00_cphMainPanel_exprEmail']")).getText();
        Assert.assertEquals("Введено неверное значение", err);
    }


    @AfterTest
    public void tearDown() throws Exception {
        driver.close();
    }


}

