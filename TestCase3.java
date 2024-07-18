import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase3 {

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C://users/downloads/chromedriver");

        // Initialize a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();


        try {

            // Navigate to a home page
            WebUI.openBrowser('')
            WebUI.navigateToUrl('http://example.com')

            //Go to ShoppingPage
            WebElement shoppingButton = driver.findElement(By.xpath('//a[@href="#/shop" and contains(@class,"btn")]'));
            shoppingButton.click();

            //Buy 2 Stuffed Frog
            for(int count=1; count<=2; count++){
                driver.findElement(By.xpath('//h4[text()="Stuffed Frog"]//../p/a')).click();
            }
            //5 Fluffy Bunny
            for(int count=1; count<=5; count++){
                driver.findElement(By.xpath('//h4[text()="Fluffy Bunny"]//../p/a')).click();
            }
            //3 Valentine Bear
            for(int count=1; count<=3; count++){
                driver.findElement(By.xpath('//h4[text()="Valentine Bear"]//../p/a')).click();
            }

            //Go to Cart page
            WebElement shoppingButton = driver.findElement(By.xpath('//a[@href="#/cart"]')).click();
            //wait  
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

            //Verify the subtotal for each product is correct
            WebElement stuffedFrog = driver.findElement(By.xpath("(//td[@class='ng-binding'])[1]"));
            List<WebElement> tr = driver.findElement(By.xpath('//tr[contains(@class,"cart-item")]'));
            double subtotalResult = 0.0
            for(int i=1; i<=tr.size();i++){
                double tempPrice = driver.findElement(By.xpath('//tr[contains(@class,"cart-item")]/td[2]')).getText();
                double quantity =  driver.findElement(By.xpath('//tr[contains(@class,"cart-item")]/td[3]/input')).getText();
                double subtotal = driver.findElement(By.xpath('//tr[contains(@class,"cart-item")]/td[4]')).getText();
                if(tempPrice*quantity==subtotal){
                    System.out.println("Passed: Subtotal correct.")
                }else{
                    System.out.println("Failed: Subtotal failed.") 
                }
                subtotalResult += subtotal;
            }

            //Verify that total = sum(sub totals)
            double total = driver.findElement(By.xpath('//*[contains(@class,"total")]')).getText();
            if(total==subtotalResult){
                System.out.println("Passed: Total value is the same as Subtotal value.")
            }else{
                System.out.println("Failed: Total value is not the same as Subtotal value.")
            }

        } catch (Exception e) {
     
        } finally {
            driver.quit();
        }
    }
}