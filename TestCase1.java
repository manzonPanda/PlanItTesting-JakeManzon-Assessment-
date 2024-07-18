import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C://users/downloads/chromedriver");

        // Initialize a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();


        try {

            // Navigate to a home page
            WebUI.openBrowser('')
            WebUI.navigateToUrl('http://example.com')

            //Go to Contact page
            WebElement contactPage = driver.findElement(By.xpath('//*[@id="nav-contact"]/a'));
            contactPage.click();

            //Submit
            driver.findElement(By.xpath('//*[contains(@class, "btn") and text()="Submit"] ')).click();

            //verify error messages
            List<WebElement> verify1 = driver.findElement(By.xpath('//div[contains(@class, "alert") and contains(@ui-if, "!")]'));
            if(verify1.size() > 0){ 
                //error message found
            }else{ 
             //no error message in form
            }

            //populate mandatory fields
            driver.findElement(By.xpath('//*[@id="forename"]')).sendKeys("Jake James");
            driver.findElement(By.xpath('//*[@id="email"]')).sendKeys("manzonjake15@gmail.com");
            driver.findElement(By.xpath('//textarea[@id="message"]')).sendKeys("This is a text");
        
        	//Validate errors are gone
            List<WebElement> verify2 = driver.findElement(By.xpath('//div[contains(@class, "alert") and contains(@ui-if, "!")]'));
            if(verify2.size() > 0){ 
                //no error message in form
            }else{ 
             //error message found
            }

        } catch (Exception e) {
     
        } finally {
            driver.quit();
        }
    }
}