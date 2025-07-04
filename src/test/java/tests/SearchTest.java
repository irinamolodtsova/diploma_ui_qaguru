package tests;

import components.CalendarComponent;
import components.SearchComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends TestBase {

    final SearchComponent search = new SearchComponent();
    final CalendarComponent calendar = new CalendarComponent();

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

    @DisplayName("Поиск тура не осуществляется без выбора дат")
    @Test
    void noSearchTourWithoutDates() {
        search.chooseCountry()
                .chooseRandomCity()
                .searchClick()
                .smallMapNotExists();
    }

    @DisplayName("Открытие страницы результата поиска тура")
    @Test
    void searchTourPage() {
        search.chooseCountry();
        calendar.selectRandomDepartureDate()
                .selectRandomReturnDate();
        search.chooseRandomCity()
                .searchClick()
                .smallMapExists();
    }
}
