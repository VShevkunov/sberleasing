package project.pagewidgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$x;

public class FilterPage {

    SelenideElement loader = $x("//div[@class='el-loading-spinner']");
    SelenideElement findBtn = $x("//a[contains(@class, 'find-button')]");

    public void setCheckbox(String checkboxType) {
        SelenideElement checkbox = $x("//label[contains(@for, 'arrFilter') and contains(.,'" + checkboxType + "')]");
        checkbox.click();
        waitLoader();
    }

    @Step("Заполнение фильтра {filterType} значениямиями {values}")
    public FilterPage setMainFilter (String filterType, String... values) {
        SelenideElement cityFilter =
                $x("//input[@type='text' and parent::div/preceding-sibling::div[contains(text(), '" + filterType + "')]]");

        cityFilter.click();
        for (String value : values) {
            setCheckbox(value);
            //cityFilter.setValue(value);
        }

        return this;
    }

    @Step("Авто со скидкой? - {choice}")
    public FilterPage setDiscountFilter (Boolean choice) {
        if (choice) setCheckbox("Только авто со скидкой");

        return this;
    }

    @Step("Заполнение привода")
    public FilterPage setDriveUnit (String driveUnit) {
        setCheckbox(driveUnit);

        return this;
    }

    @Step("Выбор трансмиссии")
    public FilterPage setTransmission (String transmission) {
        setCheckbox(transmission);

        return this;
    }

    @Step("Выбор кузова")
    public FilterPage setBodyType (String bodyType) {
        setCheckbox(bodyType);

        return this;
    }

    @Step("Выбор топлива")
    public FilterPage setFuelType (String fuelType) {
        setCheckbox(fuelType);

        return this;
    }

    @Step("Выбор цвета")
    public FilterPage setColour (String colour) {
        SelenideElement colourFilter = $x("//div[contains(text(), 'Цвет')]/following-sibling::*/i");
        colourFilter.click();
        setCheckbox(colour);

        return this;
    }

    @Step("Манипуляция со слайдером")
    public FilterPage setSlider(String filterName) {
        SelenideElement slider = $x("//div[(@role='slider') and parent::*/preceding-sibling::div[contains(.,'" + filterName + "')]]");
        if (slider.isEnabled()) {
            Selenide.actions().moveToElement(slider , (int)(slider.getSize().width / 2 * 0.6), 0 ).click().build().perform(); //тут возможна логика перечёта цены в % перемещения слайдера
            waitLoader();
        }

        return this;
    }


    public void waitLoader() {
        loader.should(appear, Duration.ofSeconds(5));
        loader.should(disappear, Duration.ofSeconds(5));
    }

    @Step("Получение результата")
    public ResultsPage goToResultsPage() {
        findBtn.click();

        return new ResultsPage();
    }
}
