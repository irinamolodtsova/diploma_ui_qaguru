package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class HeaderComponent {

    private final SelenideElement CONTACT_US = $("[data-testid = 'HEADER_CONTACT_US_TEST_ID']"),
            CONTACT_US_MODAL = $("[data-testid = 'CONTACT_US_MODAL_TEST_ID']");


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



}
