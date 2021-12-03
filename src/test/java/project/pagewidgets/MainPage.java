package project.pagewidgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {

    SelenideElement selectByParameters = $x("//a[contains(text(), 'Подобрать по параметрам')]");
    SelenideElement closeCookie = $x("//button[contains(@class, 'cookie')]");

    public MainPage() {
        logger.info("Переход на главную страницу");


        closeCookie.click();
        logger.info("Закрыто окно про куки");
    }

    @Step("Переход на страницу фильтра")
    public FilterPage goToFilterPage() {
        selectByParameters.click();

        return new FilterPage();
    }














}
