package project;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import project.pagewidgets.GooglePage;

@Epic("Тестовое задание СберЛизинг")
@Feature("Тестирование сайта СберЛизинг")

public class SberleasingTest extends BaseHook {

    @Description("Переход из поисковой машины и подбор автомобиля")
    @DisplayName("Тестовое задание")
    @Test
    public void userFromGoogle() throws InterruptedException {

        new GooglePage()
                .toSearch("СберЛизинг")
                .goToSberLeasingSite()
                .goToFilterPage()
                .setMainFilter("Город", "Москва", "Санкт-Петербург")       //можно вынести в Enum
                .setMainFilter("Марка", "BMW", "Audi", "Ford")          //при известном наборе парметров
                .setMainFilter("Модель", "7 серия", "A4", "A6")     //чтобы исключить риск грамматической ошибки test data
                .setDriveUnit("передний")
                .setSlider("Стоимость автомобиля")
                .setSlider("Мощность двигателя")
                .setDiscountFilter(false)
                .setTransmission("автомат")
                .setBodyType("седан")
                .setFuelType("бензин")
                .setColour("черный")
                .goToResultsPage()
                .goToCarPage()
                .validateMark();

    }




}
