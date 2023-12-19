package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTest {

    @Test
    void testCorrectInputs() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(".form.form_size_m.form_theme_alfa-on-white");
        form.$("[data-test-id=name] input").setValue("Фамилия Имя");
        form.$("[data-test-id=phone] input").setValue("+79998887766");
        form.$("[data-test-id=agreement]").click();
        form.$(".button.button_view_extra.button_size_m.button_theme_alfa-on-white").click();

        $("[data-test-id=order-success]").shouldBe(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void testIncorrectInputs() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(".form.form_size_m.form_theme_alfa-on-white");
        form.$("[data-test-id=name] input").setValue("Фамилия"); // Имя не указано, должно падать, но не падает!
        form.$("[data-test-id=phone] input").setValue("+79998887766");
        form.$("[data-test-id=agreement]").click();
        form.$(".button.button_view_extra.button_size_m.button_theme_alfa-on-white").click();

        $("[data-test-id=order-success]").shouldBe(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
