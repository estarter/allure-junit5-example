package io.qameta.junit5;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

/**
 * eroshenkoam
 * 24.10.17
 */
@DisplayName("SUITE: Simple Test")
public class SimpleTest {

    @Test
    @Feature("Feature-1")
    @DisplayName("Test Case: Test output, critical")
    @Description("Test Case: Description string for simple output test number one.")
    @Tag("write")
    @Severity(SeverityLevel.CRITICAL)
    public void testOutput() {
        firstStep();
        secondStep();
        fourthStep();
    }

    @Test
    @DisplayName("TestCase: Test output 2, normal")
    @Description("Test Case: Description string for simple output test number two.")
    @Feature("Feature-2")
    @Tag("read")
    @Flaky
    @Severity(SeverityLevel.NORMAL)
    public void testOutput_2() {
        firstStep();
        secondStep();
        thirdStep();
    }

    @Test
    @DisplayName("Test Case: Very bad test that is always broken")
    @Description("Test Case: just throws always an exception.")
    @Feature("Feature-2")
    @Tag("error")
    @Severity(SeverityLevel.NORMAL)
    public void brockenTest() {
        throw new RuntimeException("Hallöchen mein lieber Freund, dein NPE", new NullPointerException());
    }

    @Step("STEP: step 1")
    public void firstStep() {
        // nothing
    }

    public void secondStep() {
        // nothing
    }

    @Step("STEP: step 3")
    public void thirdStep() {
        saveScreenshot();
    }

    @Step("STEP: step 4")
    public void fourthStep() {
        saveDescription();
    }

    @Step("STEP: Generate Screenshot")
    @Attachment(value = "Example Screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("picture.png").getFile());
        try {
            return FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("STEP: Generate Text Description")
    @Attachment(value = "Description test")
    public String saveDescription() {
        return "Attached textual description";
    }

}
