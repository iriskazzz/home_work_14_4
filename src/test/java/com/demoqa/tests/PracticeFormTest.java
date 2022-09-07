package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

  @BeforeAll
  static void configure() {
    //только с таким разрешением кнопка submit появилась на экране
    Configuration.browserSize = "765x768";
    Configuration.baseUrl = "https://demoqa.com";
  }

  @Test
  void fillPracticeForm() {
    open("/automation-practice-form");
    $("#firstName").setValue("Irina");
    $("#lastName").setValue("Petrova");
    $("#userEmail").setValue("ira@ya.ru");
    $("#genterWrapper").$(byText("Female")).click();
    $("#userNumber").setValue("1234567889");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption("April");
    $(".react-datepicker__year-select").selectOption("1995");
    $(".react-datepicker__day--015").click();
    $("#subjectsInput").setValue("Economics").pressEnter();
    $("#hobbiesWrapper").scrollTo();
    $("#hobbiesWrapper").$(byText("Music")).click();
    $("#uploadPicture").uploadFromClasspath("foto.png");
    $("#currentAddress").setValue("Sochi");
    $("#state").click();
    $("#stateCity-wrapper").$(byText("Haryana")).click();
    $("#city").click();
    $("#stateCity-wrapper").$(byText("Karnal")).click();

    $("#submit").click();

    $(".modal-dialog").should(appear);
    $(".table-responsive").shouldHave(
            text("Irina Petrova"),
            text("ira@ya.ru"),
            text("Female"),
            text("1234567889"),
            text("15 April,1995"),
            text("Economics"),
            text("Music"),
            text("foto.png"),
            text("Sochi"),
            text("Haryana Karnal"));
  }
}
