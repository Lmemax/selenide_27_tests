import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideComponentTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void testExampleJunit5() {

        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(withTagAndText("button","Show 3 more pages")).click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $$(".markdown-heading").findBy(text("JUnit5")).sibling(0).shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                    @Test
                    void test() {
                        Configuration.assertionMode = SOFT;
                        open("page.html");
    
                        $("#first").should(visible).click();
                        $("#second").should(visible).click();
                    }
                }"""));
    }
}