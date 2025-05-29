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
                .loginDoesNotExists()
                .myListDoesNotExists();
    }

    @CsvFileSource(resources = "/servicesAvailableList.csv")
    @ParameterizedTest(name = "Проверка доступных опций в выпадающем списке Сервисы")
    void checkAvailableServiceTest(String hotTours, String lowPriceCalendar, String howToFind, String giftCert, String offers, String superCashback) {
        header.servicesHover()
                .checkServices(hotTours)
                .checkServices(lowPriceCalendar)
                .checkServices(howToFind)
                .checkServices(giftCert)
                .checkServices(offers)
                .checkServices(superCashback);
    }

    @CsvFileSource(resources = "/helpAvailableList.csv")
    @ParameterizedTest(name = "Проверка доступных опций в выпадающем списке Помощь")
    void checkAvailableHelpTest(String aboutCompany, String openCountries, String faq, String review, String press, String offers, String contacts) {
        header.helpHover()
                .checkHelp(aboutCompany)
                .checkHelp(openCountries)
                .checkHelp(faq)
                .checkHelp(review)
                .checkHelp(press)
                .checkHelp(offers)
                .checkHelp(contacts);
    }

    @DisplayName("Проверка открытия модального окна при нажатии Напишите нам")
    @Test
    void contactUsTest() {
        header.contactUsClick()
                .contactUsModelWindowExists();
    }
}
