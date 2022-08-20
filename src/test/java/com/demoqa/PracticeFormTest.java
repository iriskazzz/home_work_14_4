package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

  @BeforeAll
  static void configure() {
    Configuration.baseUrl = "https://demoqa.com";
  }

  @Test
  void fillFormTest2() {
    open("/automation-practice-form");
    $("#firstName").setValue("Irina");
    $("#lastName").setValue("Petrova");
    $("#userEmail").setValue("ira@ya.ru");
    $("#userNumber").setValue("1234567889");
  //  $("#userName").setValue("Irina");
    $("#currentAddress").setValue("Sochi");
    $("#submit").scrollTo();
    $("#submit").click();

  }
}
