package com.yuliya1303.github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

//1) Да, селекторы могут вести себя по-разному, т.к. $("h1 div") селектор ищет div (первый) внутри h1 на уровнях child
// and sub-child, а $("h1").$("div") - ищет только child.

public class GitHubSelenideAssertionForJUnitTest {

    @Test
    @DisplayName("JUnit5 should be displayed in SoftAssertions page")
    @Feature("GitHub - Selenide")
    void shouldHaveJUnitInSoftAssertions() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();

        if ($$("#wiki-pages-box li").find(Condition.text("SoftAssertions")).isDisplayed()) {
            $$("#wiki-pages-box li").find(Condition.text("SoftAssertions")).click();
        } else {
            $("#wiki-pages-box button").click();
            $$("#wiki-pages-box li").find(Condition.text("SoftAssertions")).click();
        }

        $$(".markdown-body h4").find(Condition.text("JUnit5")).shouldBe(Condition.visible);
    }

}
