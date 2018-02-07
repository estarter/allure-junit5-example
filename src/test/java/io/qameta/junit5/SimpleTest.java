package io.qameta.junit5;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * eroshenkoam
 * 24.10.17
 */
public class SimpleTest {

    @Test
    @DisplayName("Test number 1, critical")
    @Feature("Some feature")
    @Severity(SeverityLevel.CRITICAL)
    public void testOutput() {
        firstStep();
        secondStep();
        fourthStep();
    }

    @Test
    @DisplayName("Test number 2, normal")
    @Feature("Some feature 2")
    @Severity(SeverityLevel.NORMAL)
    public void testOutput_2() {
        firstStep();
        secondStep();
        thirdStep();
    }

    @Step
    public void firstStep() {
//        assertEquals("12","14");
    }

    @Step
    public void secondStep() {

    }

    @Step
    public void thirdStep() {

    }

    @Step
    public void fourthStep() {

    }
}
