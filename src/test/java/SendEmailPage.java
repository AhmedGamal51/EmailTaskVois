import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SendEmailPage extends BaseTest {
    private GmailPage gmailPage;
    private String email;
    private String password;

    @BeforeClass
    public void setUpTest() {
        setup();
        gmailPage = new GmailPage(driver);


        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/app.properties"));
            email = prop.getProperty("email");
            password = prop.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void sendEmailTest() throws InterruptedException {
        gmailPage.login(email, password);
        gmailPage.composeAndSendEmail("islam.hassan@vodafone.com", "Modified Excel Sheet",
                "Please find the attached modified Excel sheet.", "C:\\Users\\Dell\\Desktop\\Vois_Task_Two\\src\\main\\resources\\TaskData");
    }

    @AfterClass
    public void tearDownTest() {
        tearDown();
    }
}

