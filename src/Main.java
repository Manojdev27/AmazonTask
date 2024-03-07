import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static WebDriver driver; // global static variable - global variable present outside the method and scope is within the class

    public static void main(String[] args) throws InterruptedException {

        String currentWorkingDirectory = System.getProperty("user.dir");
        System.out.println(currentWorkingDirectory);
        // current project location in java
        System.setProperty("webdriver.chrome.driver", currentWorkingDirectory + "/chromedriver.exe");
        driver = new ChromeDriver();

        String hamburgerMenu =  "nav-hamburger-menu";

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
//      driver.findElement(By.id(hamburgerMenu)).click();
        click("id","nav-hamburger-menu");
        Thread.sleep(6000);
        By mobilesAndComputers = By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a");
         click(mobilesAndComputers);
//        driver.findElement(mobilesAndComputers).click();
        Thread.sleep(10000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[8]/li[17]/a"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",element);
//        click(element);
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[5]/ul/li[6]/span/a/span")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]/span[1]")).click();
        Thread.sleep(6000);
        WebElement elements = driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_2\"]"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();",elements);
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div")).click();
        Thread.sleep(6000);
        driver.close();

    }

    static void click(By by) throws InterruptedException {
        Thread.sleep(6000);
        driver.findElement(by).click();
    }

    static void click(WebElement element) throws InterruptedException {
        Thread.sleep(6000);
        element.click();
    }
    static void click(String locatorType, String locatorValue) throws InterruptedException {
        Thread.sleep(3000);
        if (locatorType.equalsIgnoreCase("xpath")){
            driver.findElement(By.xpath(locatorValue)).click();
        }
        else if(locatorType.equalsIgnoreCase("id")){
            driver.findElement(By.id(locatorValue)).click();
        }
        else if(locatorType.equalsIgnoreCase("linkText")){
            driver.findElement(By.linkText(locatorValue)).click();
        }
    }
}