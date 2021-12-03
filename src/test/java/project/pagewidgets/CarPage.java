package project.pagewidgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$x;

public class CarPage {

    SelenideElement head = $x("//h1[@class='h2']");

    @Step("Вадидация результата")
    public CarPage validateMark() {
        for(String string : ResultsPage.listOfMarks){
            System.out.println(string);
        }

        System.out.println();

        System.out.println(head.getText());
        Assertions.assertTrue(ResultsPage.listOfMarks.contains(head.getText()));
        return this;
    }


}
