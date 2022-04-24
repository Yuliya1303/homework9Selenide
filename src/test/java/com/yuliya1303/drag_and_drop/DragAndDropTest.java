package com.yuliya1303.drag_and_drop;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @Test
    @DisplayName("Test moving block A to block B using Drag and Drop")
    @Feature("Drag and Drop")
    void shouldMoveAtoBByDragAndDrop() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://the-internet.herokuapp.com/drag_and_drop");
//        actions().dragAndDrop($("#column-a"),$("#column-b")).perform(); - doesn't work
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(Condition.text("B"));
        $("#column-b").shouldHave(Condition.text("A"));


    }
}
