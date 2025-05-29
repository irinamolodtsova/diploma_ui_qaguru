package tests;

import components.Search;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends TestBase {

    Search search = new Search();

    @DisplayName("Проверка доступных опций по поиску - Туры, Отели, Экскурсии")
    @Test
    void checkMainPageSearchOptions() {
        search.checkToursIcon()
                .checkHotelIcon()
                .checkExcursionIcon();
    }

    @DisplayName("Проверка доступных полей в поиске тура")
    @Test
    void checkMainPageToursFields() {
        search.clickToursIcon()
                .checkDestinationField()
                .checkDepartureCityField()
                .checkTouristsNumberPick();
    }

    @DisplayName("Проверка доступных полей в поиске отеля")
    @Test
    void checkMainPageHotelSearchFields() {
        search.clickHotelIcon()
                .checkDestinationField()
                .checkDepartureCityFieldDoesNotExist()
                .checkTouristsNumberPick();
    }

    @DisplayName("Проверка доступных полей в поиске экскурсии")
    @Test
    void checkMainPageExcursionSearchFields() {
        search.clickExcursionIcon()
                .checkDestinationField()
                .checkDepartureCityFieldDoesNotExist()
                .checkTouristsNumberDoesNotExist();
    }
}
