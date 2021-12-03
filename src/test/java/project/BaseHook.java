package project;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BaseHook {

    @BeforeAll
    public static void setUp() {

        //Создаём объект класса DesiredCapabilities, используется как настройка конфигурации с помощью пары ключ-значение
        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browser = "chrome";
        //Configuration.browserVersion = "90.0";
        Configuration.baseUrl = "https://www.sberleasing.ru/";
        Configuration.browserSize = "1280x720";
        Configuration.browserCapabilities = capabilities;
        Configuration.timeout = 5000; //ms

    }
}
