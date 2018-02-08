package io.qameta.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

/**
 * eroshenkoam
 * 24.10.17
 */
@DisplayName("SUITE: AdvancedTest")
public class AdvancedTest {

    @Test
    @DisplayName("Test Case: another critical test")
    @Feature("Feature-2")
    @Tag("read")
    @Severity(SeverityLevel.CRITICAL)
    public void testOutput() {
        firstStep(5);
        secondStep();
        fourthStep();
    }

    @Test
    @Flaky
    @DisplayName("Test Case: another normal test")
    @Feature("Feature-1")
    @Tag("write")
    @Severity(SeverityLevel.NORMAL)
    public void testOutput_2() {
        firstStep(5);
        secondStep();
        thirdStep(7);
    }

    @Step
    public void firstStep(int sa) {
        assertEquals(5, sa);
    }

    @Step
    public void secondStep() {
    }

    @Step
    public void thirdStep(int param) {
        assertEquals(5, param);
    }

    @Step
    public void fourthStep() {

    }

}
