package ch.fhnw.webec.contactlist;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ContactsPageIT {

    @Value("${local.server.port}")
    int port;

    @Test
    void displayAllContactsTest() {
        WebDriver driver = new HtmlUnitDriver();
        driver.navigate().to("http://localhost:%d/contacts".formatted(port));

        var main = driver.findElements(By.id("contacts"));
        assertEquals(1, main.size());

        var contactList = driver.findElement(By.id("contacts"));
        var contactListEntries = contactList.findElements(By.tagName("li"));
        assertEquals(30, contactListEntries.size());

        var wholeList = driver.findElements(By.cssSelector("#contacts > nav > ul > li"));
        assertEquals(30, wholeList.size());
    }

    @Test
    void initialPageShowsNoContactDetails() {
        //        WebDriver driver = new HtmlUnitDriver();
        //        int port = 8080;
        //        driver.navigate().to("http://localhost:%d/contacts".formatted(port));
        //
        //        var ul = driver.findElementsByTagName("ul");
        //
        //        var page = ContactsPage.create(driver, port);
        //        assertEquals(empty(), page.getContactDetails());
        //        assertTrue(page.getSelectContactMessage().isPresent());
    }
}
