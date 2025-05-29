package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Search {

    private final SelenideElement TOURS_ICON = $("[data-testid = 'SEARCH_TAB_TOURS_DATA_TEST_ID']"),
            HOTEL_ICON = $("[data-testid = 'SEARCH_TAB_HOTELS_DATA_TEST_ID']"),
            EXCURSIONS_ICON = $("[data-testid = 'SEARCH_TAB_EXCURSIONS_DATA_TEST_ID']"),
            DEPARTURE_CITY_FIELD = $("[data-testid = 'DEPARTURE_PICKER_PREVIEW_TEST_ID']"),
            TOURISTS_NUMBER = $("[data-testid = 'TOURISTS_PICKER_PREVIEW_TEST_ID']"),
            DESTINATION_FIELD = $("[data-testid = 'DESTINATION_PICKER_PREVIEW_TEST_ID']");


    @Step("Проверка наличия кнопки - Туры")
    public Search checkToursIcon() {
        TOURS_ICON.should(Condition.exist);
        return this;
    }

    @Step("Проверка наличия кнопки - Отели")
    public Search checkHotelIcon() {
        HOTEL_ICON.should(Condition.exist);
        return this;
    }

    @Step("Проверка наличия кнопки - Экскурсии")
    public Search checkExcursionIcon() {
        EXCURSIONS_ICON.should(Condition.exist);
        return this;
    }

    @Step("Проверка наличия поля - Куда хотите поехать")
    public Search checkDestinationField() {
        DESTINATION_FIELD.should(Condition.exist);
        return this;
    }

    @Step("Проверка наличия поля - Город вылета")
    public Search checkDepartureCityField() {
        DEPARTURE_CITY_FIELD.should(Condition.exist);
        return this;
    }

    @Step("Проверка отсутствия поля - Город вылета")
    public Search checkDepartureCityFieldDoesNotExist() {
        DEPARTURE_CITY_FIELD.shouldNot(Condition.exist);
        return this;
    }

    @Step("Проверка наличия выбора - Кол-во туристов")
    public Search checkTouristsNumberPick() {
        TOURISTS_NUMBER.should(Condition.exist);
        return this;
    }

    @Step("Проверка отсутствия выбора - Кол-во туристов")
    public Search checkTouristsNumberDoesNotExist() {
        TOURISTS_NUMBER.shouldNot(Condition.exist);
        return this;
    }

    @Step("Клик по кнопке - Туры")
    public Search clickToursIcon() {
        TOURS_ICON.click();
        return this;
    }

    @Step("Клик по кнопке - Отели")
    public Search clickHotelIcon() {
        HOTEL_ICON.click();
        return this;
    }

    @Step("Клик по кнопке - Экскурсии")
    public Search clickExcursionIcon() {
        EXCURSIONS_ICON.click();
        return this;
    }

}
