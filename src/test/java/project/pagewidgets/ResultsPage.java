package project.pagewidgets;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$x;

public class ResultsPage {

    public static ArrayList<String> listOfMarks = new ArrayList();

    By carMark = By.xpath(".//div[@class='font-weight-bold']");
    By carModel = By.xpath(".//div[@class='fs-14 text-muted mb-2']");

    ElementsCollection cars = $$x("//div[@class='configuration-card']");

    public int getRandomInt(int min, int max) {
        return (int)Math.floor(Math.random() * (max - min)) + min;
    }


    @Step("Переход на страницу машины")
    public CarPage goToCarPage() {

        for (SelenideElement element : cars){
            listOfMarks.add(element.$(carMark).getText() + "\n" + element.$(carModel).getText());
        }

        int random = getRandomInt(0, cars.size());
        cars.get(random).$(carMark).click();

        return new CarPage();
    }


}
