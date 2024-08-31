import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GmailPage {
    private WebDriver driver;


    public GmailPage(WebDriver driver) {
        this.driver = driver;
    }


    private By emailField = By.id("identifierId");
    private By emailNextButton = By.id("identifierNext");
    private By passwordField = By.name("password");
    private By passwordNextButton = By.id("passwordNext");
    private By composeButton = By.cssSelector(".T-I.T-I-KE.L3");
    private By toField = By.name("to");
    private By subjectField = By.name("subjectbox");
    private By bodyField = By.cssSelector("div[aria-label='Message Body']");
    private By attachButton = By.cssSelector("input[type='file']");
    private By sendButton = By.xpath("//div[text()='Send']");


    public void login(String email, String password) throws InterruptedException {
        driver.get("https://mail.google.com/");
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(emailNextButton).click();
        Thread.sleep(3000);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(passwordNextButton).click();
        Thread.sleep(5000);
    }

    public void composeAndSendEmail(String recipient, String subject, String body, String filePath) throws InterruptedException {
        driver.findElement(composeButton).click();
        Thread.sleep(2000);
        driver.findElement(toField).sendKeys(recipient);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(bodyField).sendKeys(body);
        driver.findElement(attachButton).sendKeys(filePath);
        driver.findElement(sendButton).click();
        Thread.sleep(5000);
    }
}


