package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class googleTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "97.0";
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

    @Test
    public void FindSelenide() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(Condition.text("selenide.org"));
    }
}
