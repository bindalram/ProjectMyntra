import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Myntra {

    public WebDriver driver = null;
    public Myntra(){
        System.setProperty("webdriver.chrome.driver", "/Users/ram.bindal/IdeaProjects/Selenium1/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.myntra.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }

    public void maximixe(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

    }


    public void Search(String product){

        driver.findElement(By.className("desktop-searchBar")).sendKeys(product);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

        WebElement search = driver.findElement(By.className("desktop-submit"));
        search.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

    }



    public void selectBrand() throws InterruptedException{

        // Not Working ?
//        List<WebElement> ele = driver.findElements(By.className("brand-list"));
//        int c = 0;
//        for(WebElement brandName : ele){
//
//            String brand = brandName.getText();
//            System.out.println(brand);
//
//            brandName.click();
//        }


        WebElement ele1  = driver.findElement(By.xpath("//*[@id='mountRoot']/div/div[1]/main/div[3]/div[1]/section/div/div[2]/ul/li[2]/label"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        ele1.click();
        Thread.sleep(2000);
    }


    public void discount(){
        WebElement discount = driver.findElement(By.xpath("//ul[@class='discount-list']/li[1]"));
        discount.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }

    public void selectShoe(){
        WebElement shoe = driver.findElement(By.xpath("//*[@id='desktopSearchResults']/div[2]/section/ul/li[1]/a/div[1]/div/div/div/picture/img"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        shoe.click();
    }

    public void setWindow(){

        Set<String> handle = driver.getWindowHandles();
        Iterator<String> it = handle.iterator();
        it.next();
        String childWindowId = it.next();
        driver.switchTo().window(childWindowId);
        System.out.println(driver.getTitle());
    }


    public void setSize(){
        WebElement shoe_size = driver.findElement(By.xpath("//*[@id='sizeButtonsContainer']/div[2]/div[5]/div[1]/button/p"));
        String size = shoe_size.getText();
        shoe_size.click();
        System.out.println(size);
//        Assert.assertEquals(size,"10");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
    }


    public void addToBag() throws InterruptedException{
        WebElement addToBag = driver.findElement(By.xpath("//*[text()='ADD TO BAG']"));
        addToBag.click();
        Thread.sleep(2000);
    }

    public void goToBag(){
        WebElement Bag = driver.findElement(By.xpath("//*[text()='Bag']"));
        Bag.click();
    }

    public void applyCoupon(){
        WebElement ApplyCoupon = driver.findElement(By.xpath("//span[contains(text(),'Apply Coupon')]"));
        ApplyCoupon.click();
    }

    public void takeScreenShot() throws IOException {

        TakesScreenshot takesShot = (TakesScreenshot)driver;
        File src = takesShot.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src,new File("/Users/ram.bindal/Desktop/ScreenShot/sc1.jpeg"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));


    }

    public void closingBrowser() throws Exception{

        takeScreenShot();
        driver.quit();
    }

}
