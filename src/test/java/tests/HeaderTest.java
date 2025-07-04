package tests;

import components.HeaderComponent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class HeaderTest extends TestBase {

    HeaderComponent header = new HeaderComponent();

    @DisplayName("Проверка открытия модального окна при нажатии Напишите нам")
    @Test
    void contactUsTest() {
        header.contactUsClick()
                .contactUsModelWindowExists();
    }


}
