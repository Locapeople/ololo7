package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTest {

    @Test
    void testCorrectInputs() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Фамилия Имя");
        $("[data-test-id=phone] input").setValue("+79998887766");
        $("[data-test-id=agreement]").click();
        $(".button").click();

        $("[data-test-id=order-success]").shouldBe(
                Condition.exactText(
                        "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."
                ));
    }
}
