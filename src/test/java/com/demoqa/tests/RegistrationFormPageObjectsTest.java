package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPageObjectsTest {

  RegistrationFormPage registrationFormPage = new RegistrationFormPage();

  @BeforeAll
  static void configure() {
    Configuration.baseUrl = "https://demoqa.com";
  }

  @Test
  void fillPracticeForm() {
    registrationFormPage.openPage()
            .setFirstName("Irina")
            .setLastName("Petrova")
            .setEmail("ira@ya.ru")
            .setGenter("Female")
            .setNumber("1234567889")
            .setBirthDate("15", "April", "1995")
            .setSubjects("Economics")
            .setHobbies("Music")
            .setPicture("img/foto.png")
            .setCurrentAddress("Sochi")
            .setState("Haryana")
            .setCity("Karnal");

    registrationFormPage.clickSubmit();

    registrationFormPage.checkResultTable()
            .checkResult("Student Name", "Irina Petrova")
            .checkResult("Student Email", "ira@ya.ru")
            .checkResult("Gender", "Female")
            .checkResult("Mobile", "1234567889")
            .checkResult("Date of Birth", "15 April,1995")
            .checkResult("Subjects", "Economics")
            .checkResult("Hobbies", "Music")
            .checkResult("Picture", "foto.png")
            .checkResult("Address", "Sochi")
            .checkResult("State and City", "Haryana Karnal");
  }

  @Test
  void fillPracticeWithMinimumDataForm() {
    registrationFormPage.openPage()
            .setFirstName("Irina")
            .setLastName("Petrova")
            .setGenter("Female")
            .setNumber("1234567889");

    registrationFormPage.clickSubmit();

    registrationFormPage.checkResultTable()
            .checkResult("Student Name", "Irina Petrova")
            .checkResult("Gender", "Female")
            .checkResult("Mobile", "1234567889");
  }
}
