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
    public void userFromGoogle() {

        new GooglePage()
                .toSearch("СберЛизинг")
                .clickSberLeasingSite();

    }




}
