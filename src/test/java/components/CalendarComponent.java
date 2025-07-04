package components;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent {

    private final SelenideElement DEPARTURE = $("#start"),
            RETURN_DATE = $("#end");


    private final Faker faker = new Faker();

    // Вспомогательный метод: клик по дню
    private void clickDay(int day) {
        String dayLocator = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)",
                String.format("%02d", day));
        $(dayLocator).click();
    }

    @Step("Выбор даты вылета")
    public CalendarComponent selectRandomDepartureDate() {
        LocalDate departureDate = LocalDate.now().plusDays(1);
        int day = departureDate.getDayOfMonth();

        DEPARTURE.click(); // Открыть календарь
        clickDay(day);
        return this;
    }

    // Метод для случайного выбора даты обратно в диапазоне [завтра + 1 ... завтра + 20]
    @Step("Выбор даты прилета")
    public CalendarComponent selectRandomReturnDate() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        // Генерируем случайное число от 1 до 20
        int randomOffset = faker.number().numberBetween(1, 21); // [1, 20]
        LocalDate returnDate = tomorrow.plusDays(randomOffset);

        int day = returnDate.getDayOfMonth();

        RETURN_DATE.click(); // Открыть календарь
        clickDay(day);
        return this;
    }
}
