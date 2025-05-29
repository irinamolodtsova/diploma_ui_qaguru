package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderComponent {

    private final SelenideElement CONTACT_US = $("[data-testid = 'HEADER_CONTACT_US_TEST_ID']"),
            SERVICES = $("[data-testid = 'HEADER_SERVICES_TEST_ID']"),
            HELP = $("[data-testid = 'HEADER_HELP_TEST_ID']"),
            MY_LIST = $("[data-testid = 'HEADER_MY_LIST_TEST_ID']"),
            LOGIN = $("[data-testid = 'HEADER_LOGIN_TEST_ID']"),
            SERVICES_DROPDOWN = $$(".HeaderMenuDropdown_dropdown__04614").get(0),
            HELP_DROPDOWN = $$(".HeaderMenuDropdown_dropdown__04614").get(1),
            CONTACT_US_MODAL = $("[data-testid = 'CONTACT_US_MODAL_TEST_ID']");


    @Step("Check ContactUs icon exists")
    public HeaderComponent contactUsIconExists() {
        CONTACT_US.should(Condition.exist);
        return this;
    }

    @Step("Check Services icon exists")
    public HeaderComponent servicesIconExists() {
        SERVICES.should(Condition.exist);
        return this;
    }

    @Step("Check Help icon exists")
    public HeaderComponent helpIconExists() {
        HELP.should(Condition.exist);
        return this;
    }

    @Step("Check My list icon should not exists")
    public HeaderComponent myListDoesNotExists() {
        MY_LIST.shouldNot(Condition.exist);
        return this;
    }

    @Step("Check Login icon exists")
    public HeaderComponent loginExists() {
        LOGIN.should(Condition.exist);
        return this;
    }

    @Step("Click Contact us")
    public HeaderComponent contactUsClick() {
        CONTACT_US.click();
        return this;
    }

    @Step("Check Contact Us Model window exists")
    public HeaderComponent contactUsModelWindowExists() {
        CONTACT_US_MODAL.should(Condition.exist);
        return this;
    }

    @Step("Hover Services")
    public HeaderComponent servicesHover() {
        SERVICES.hover();
        return this;
    }

    @Step("Hover Help")
    public HeaderComponent helpHover() {
        HELP.hover();
        return this;
    }

    @Step("Check Available Services Dropdown")
    public HeaderComponent checkServices(String value) {
        SERVICES_DROPDOWN.shouldHave(text(value));
        return this;

    }

    @Step("Check Available Help Dropdown")
    public HeaderComponent checkHelp(String value) {
        HELP_DROPDOWN.shouldHave(text(value));
        return this;

    }


}
