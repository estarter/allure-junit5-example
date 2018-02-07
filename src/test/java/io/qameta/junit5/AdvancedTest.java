package io.qameta.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

/**
 * eroshenkoam
 * 24.10.17
 */
public class AdvancedTest {

    @Test
    @DisplayName("Test number 13, critical")
    @Feature("Some feature 324")
    @Severity(SeverityLevel.CRITICAL)
    public void testOutput() {
        firstStep("12");
        secondStep();
        fourthStep();
    }

    @Test
    @DisplayName("Test number 24, normal")
    @Feature("Some feature 25")
    @Severity(SeverityLevel.NORMAL)
    public void testOutput_2() {
        firstStep("12");
        secondStep();
        thirdStep("14");
    }

    @Step
    public void firstStep(String sa) {
        assertEquals("12",sa);
    }

    @Step
    public void secondStep() {
    }

    @Step
    public void thirdStep(String param) {
        assertEquals("12", param);
    }

    @Step
    public void fourthStep() {

    }
}
