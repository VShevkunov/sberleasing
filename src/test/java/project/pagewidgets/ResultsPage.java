package project.pagewidgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$x;

public class ResultsPage {

    public static String goalMark = "";

    By carMark = By.xpath(".//div[@class='font-weight-bold']");
    By carModel = By.xpath(".//div[@class='fs-14 text-muted mb-2']");

    ElementsCollection cars = $$x("//div[@class='configuration-card']");

    public int getRandomInt(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min)) + min;
    }


    @Step("Переход на страницу машины")
    public CarPage goToCarPage() {
        int random = getRandomInt(0, cars.size());
        SelenideElement goalCar = cars.get(random);
        goalMark = goalCar.$(carMark).getText() + "\n" + goalCar.$(carModel).getText();
        goalCar.$(carMark).click();

        return new CarPage();
    }


}
