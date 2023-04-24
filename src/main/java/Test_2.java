import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Test_2 {
    @Parameters("browser")
    @Test
    public static void test_2() throws InterruptedException {
        String log4jConfPath = "C:\\Users\\123\\IdeaProjects\\main\\src\\main\\resources\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\123\\Desktop\\cd\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.wildberries.ru/");
        Thread.sleep(2000);
        WebElement panel1 = driver.findElement(By.className("nav-element__burger"));
        panel1.click();
        Thread.sleep(2000);

        WebElement panel2 = driver.findElement(By.className("menu-burger__main-list-link--519"));
        panel2.click();
        Thread.sleep(2000);

        WebElement panel3 = driver.findElement(By.className("j-menu-item"));
        panel3.click();
        Thread.sleep(2000);

        String span = driver.getTitle();
        Assert.assertEquals(span, "Купить художественную литературу в интернет магазине WildBerries.ru");
        Thread.sleep(1000);



        WebElement name = driver.findElement(By.xpath("//*[@id='searchInput']"));
        Thread.sleep(2000);
        name.click();
        name.sendKeys("Преступление и наказание");
        Thread.sleep(1000);
        name.sendKeys(Keys.chord(Keys.ENTER));
        Thread.sleep(2000);

        String selectBook = driver.getTitle();
        Assert.assertEquals(selectBook, "Wildberries - модный интернет магазин");
        Thread.sleep(1000);

        WebElement book = driver.findElement(By.xpath("//*[@alt='Преступление и наказание Издательство АСТ']")).findElement(By.xpath("//*[@class='product-card__img-wrap img-plug j-thumbnail-wrap']"));
        book.click();
        Thread.sleep(1000);

        String selectBook1 = driver.getTitle();
        Assert.assertEquals(selectBook1, "Достоевский Ф. Преступление и наказание. Роман (офсет) Издательство Мартин 153010244 купить за 346 ₽ в интернет-магазине Wildberries");
        Thread.sleep(1000);



        WebElement buy1 = driver.findElement(By.xpath("//div[@class ='product-page__aside-container j-price-block']"));
        new Actions(driver).doubleClick(buy1).perform();
        Thread.sleep(2000);

        WebElement basket = driver.findElement(By.xpath("//*[@href='/lk/basket']"));
        basket.click();
        Thread.sleep(2000);

        String selectBookBasket = driver.getTitle();
        Assert.assertEquals(selectBookBasket, "Wildberries - модный интернет магазин");
        Thread.sleep(1000);

        driver.quit();
















    }
}
