import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main1{


    public static void main(String[] args) throws Exception {

        Myntra myntra = new Myntra();

        myntra.maximixe();


        myntra.Search("Sports Shoes for Men");

        myntra.selectBrand();


        myntra.discount();
        myntra.selectShoe();

        myntra.setWindow();
        myntra.setSize();

        myntra.addToBag();
        myntra.goToBag();

        myntra.setWindow();
//        myntra.applyCoupon();  // Not Working

        myntra.closingBrowser();


    }
}
