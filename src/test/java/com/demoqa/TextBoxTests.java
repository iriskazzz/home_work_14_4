package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests {

  @BeforeAll
  static void configure() {
    Configuration.baseUrl = "https://demoqa.com";
//    Configuration.timeout = 10000; //10 sec
//    Configuration.browser = "opera";
//    Configuration.browserSize = "100*100";
  }

  @Test
  void fillFormTest(){
    open("/text-box");
    //$("[id=userName]").setValue("Irina");
    $("#userName").setValue("Irina");
    $("#userEmail").setValue("ira@ya.ru");
    $("#currentAddress").setValue("Sochi");
    $("#permanentAddress").setValue("Penza");
    $("#submit").scrollTo();
    $("#submit").click();

    $("#output #name").shouldHave(text("Irina"));
    $("#output #email").shouldHave(text("ira@ya.ru"));
    $("#output #currentAddress").shouldHave(text("Sochi"));
    $("#output #permanentAddress").shouldHave(text("Penza"));
  }
}
