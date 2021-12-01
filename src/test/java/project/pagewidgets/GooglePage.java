package project.pagewidgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class GooglePage extends BasePage {

    SelenideElement searchField = $x("//input[@title='Поиск']");
    SelenideElement sberLeasingSiteLink = $x("//h3[contains(text(), 'СберЛизинг — официальный сайт')]");


    public GooglePage() {
        Selenide.open("https://www.google.com/");
        logger.info("Открыта страница google.com");
    }

    @Step("Пользователь ищет {text}")
    public GooglePage toSearch (String text) {
        searchField.clear();
        searchField.setValue(text).sendKeys(Keys.ENTER);
        logger.info("Произведен поиск по словам \"{}\"", text);

        return this;
    }

    @Step("Пользователь переходит на сайт СберЛизинг")
    public MainPage clickSberLeasingSite() {
        sberLeasingSiteLink.click();

        return new MainPage();
    }



}
