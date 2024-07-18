import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C://users/downloads/chromedriver");

        // Initialize a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();


        
        //Run this test 5 times to ensure 100% pass rate
        for(int count=1; count<=5; count++){

            // Navigate to a home page
            WebUI.openBrowser('')
            WebUI.navigateToUrl('http://example.com')

            //Go to Contact page
            WebElement contactPage = driver.findElement(By.xpath('//*[@id="nav-contact"]/a'));
            contactPage.click();

            //populate mandatory fields
            driver.findElement(By.xpath('//*[@id="forename"]')).sendKeys("Jake James");
            driver.findElement(By.xpath('//*[@id="email"]')).sendKeys("manzonjake15@gmail.com");
            driver.findElement(By.xpath('//textarea[@id="message"]')).sendKeys("This is a text");

             // Submit
            driver.findElement(By.xpath('//*[contains(@class, "btn") and text()="Submit"] ')).click();

            //wait for submisssion to finish
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Validate successful submission message
            List<WebElement> verify = driver.findElement(By.xpath('//*[contains(@class,"alert-success")]'));
            if(verify.size() > 0){  //if success
                //success
                 System.out.println("Passed "+count +" out of 5")

                //click Back button
                 driver.findElement(By.xpath('//*[contains(@class,"btn") and contains(@ng-click,"goBack()")]').click());

                //wait
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            }else{ 
                //error found, terminate
                System.out.println("TestCase 2 failed.")
            }

        }


    }
}