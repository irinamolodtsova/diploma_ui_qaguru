package tests;

import components.HeaderComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class HeaderTest extends TestBase {

    HeaderComponent header = new HeaderComponent();

    @DisplayName("Проверка доступных Header Icon на главной странице")
    @Test
    void checkMainPageHeaderIconsTest() {
        header.contactUsIconExists()
                .servicesIconExists()
                .helpIconExists()
                .loginExists()
                .myListDoesNotExists();
    }

    @DisplayName("Проверка открытия модального окна при нажатии Напишите нам")
    @Test
    void contactUsTest() {
        header.contactUsClick()
                .contactUsModelWindowExists();
    }


}
