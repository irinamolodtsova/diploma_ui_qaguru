package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchComponent {

    private final Faker faker = new Faker();
    private final SelenideElement TOURS_ICON = $("[data-testid = 'SEARCH_TAB_TOURS_DATA_TEST_ID']");
    private final SelenideElement HOTEL_ICON = $("[data-testid = 'SEARCH_TAB_HOTELS_DATA_TEST_ID']");
    private final SelenideElement EXCURSIONS_ICON = $("[data-testid = 'SEARCH_TAB_EXCURSIONS_DATA_TEST_ID']");
    private final SelenideElement DEPARTURE_CITY_FIELD = $("[data-testid = 'DEPARTURE_PICKER_PREVIEW_TEST_ID']");
    private final SelenideElement TOURISTS_NUMBER = $("[data-testid = 'TOURISTS_PICKER_PREVIEW_TEST_ID']");
    private final SelenideElement DESTINATION_FIELD = $("[data-testid = 'DESTINATION_PICKER_PREVIEW_TEST_ID']");
    private final SelenideElement MAP_WHEN_RESULTS = $("[data-testid = 'map-container']");
    private final SelenideElement CHOOSE_COUNTRY = $("[data-testid = 'DESTINATION_PICKER_PREVIEW_TEST_ID']");
    private final SelenideElement CHOOSE_CITY_FROM = $(".lt-departure-picker__value-container");
    private final SelenideElement COUNTRIES_LIST = $(".lt-destination-picker__menu-list");
    private final SelenideElement CITIES_LIST = $(".lt-departure-picker__menu");
    private final ElementsCollection COUNTRY_OPTION = $$(".lt-destination-picker__popularCountries.lt-destination-picker__group");
    private final ElementsCollection CITIES_OPTION = $$(".lt-departure-picker__menu-list");
    private final SelenideElement SEARCH_BUTTON = $(By.xpath("//*[text()='Найти']"));


    @Step("Проверка наличия кнопки - Туры")
    public SearchComponent checkToursIcon() {
        TOURS_ICON.should(exist);
        return this;
    }

    @Step("Проверка наличия кнопки - Отели")
    public SearchComponent checkHotelIcon() {
        HOTEL_ICON.should(exist);
        return this;
    }

    @Step("Проверка наличия кнопки - Экскурсии")
    public SearchComponent checkExcursionIcon() {
        EXCURSIONS_ICON.should(exist);
        return this;
    }

    @Step("Проверка наличия поля - Куда хотите поехать")
    public SearchComponent checkDestinationField() {
        DESTINATION_FIELD.should(exist);
        return this;
    }

    @Step("Проверка наличия поля - Город вылета")
    public SearchComponent checkDepartureCityField() {
        DEPARTURE_CITY_FIELD.should(exist);
        return this;
    }

    @Step("Проверка отсутствия поля - Город вылета")
    public SearchComponent checkDepartureCityFieldDoesNotExist() {
        DEPARTURE_CITY_FIELD.shouldNot(exist);
        return this;
    }

    @Step("Проверка наличия выбора - Кол-во туристов")
    public SearchComponent checkTouristsNumberPick() {
        TOURISTS_NUMBER.should(exist);
        return this;
    }

    @Step("Проверка отсутствия выбора - Кол-во туристов")
    public SearchComponent checkTouristsNumberDoesNotExist() {
        TOURISTS_NUMBER.shouldNot(exist);
        return this;
    }

    @Step("Клик по кнопке - Туры")
    public SearchComponent clickToursIcon() {
        TOURS_ICON.click();
        return this;
    }

    @Step("Клик по кнопке - Отели")
    public SearchComponent clickHotelIcon() {
        HOTEL_ICON.click();
        return this;
    }

    @Step("Клик по кнопке - Экскурсии")
    public SearchComponent clickExcursionIcon() {
        EXCURSIONS_ICON.click();
        return this;
    }

    @Step("Отсутствие карты")
    public SearchComponent smallMapNotExists() {
        MAP_WHEN_RESULTS.shouldNot(exist);
        return this;
    }

    @Step("Присутствие карты")
    public SearchComponent smallMapExists() {
        MAP_WHEN_RESULTS.should(exist);
        return this;
    }

    @Step("Выбираем рандомную страну для путешествия")
    public SearchComponent chooseCountry(){
        CHOOSE_COUNTRY.click();

        // Ждём появления опций
        COUNTRIES_LIST.shouldBe(Condition.visible);

        // Находим все элементы списка стран
        List<SelenideElement> countryOptions = COUNTRY_OPTION.stream()
                .filter(el -> el.isDisplayed())  // только видимые
                .toList();

        // Проверяем, есть ли опции
        if (countryOptions.isEmpty()) {
            throw new RuntimeException("Нет доступных стран для выбора");
        }

        // Генерируем случайный индекс
        int randomIndex = faker.number().numberBetween(0, countryOptions.size());

        // Выбираем случайную страну
        countryOptions.get(randomIndex).click();
        return this;
    }

    @Step("Выбираем рандомный город откуда для путешествия")
    public SearchComponent chooseRandomCity() {
        CHOOSE_CITY_FROM.click();

        // Ждём появления опций
        CITIES_LIST.shouldBe(Condition.visible);

        // Находим все элементы списка городов
        List<SelenideElement> cityOptions = CITIES_OPTION.stream()
                .filter(SelenideElement::isDisplayed)  // только видимые
                .toList();

        // Проверяем, есть ли доступные города
        if (cityOptions.isEmpty()) {
            throw new RuntimeException("Нет доступных городов для выбора");
        }
        // Генерируем случайный индекс
        int randomIndex = faker.number().numberBetween(0, cityOptions.size());

        // Выбираем случайный город
        cityOptions.get(randomIndex).click();

        return this;
    }


    @Step("Клик Найти")
    public SearchComponent searchClick() {
        SEARCH_BUTTON.click();
        return this;
    }


}
