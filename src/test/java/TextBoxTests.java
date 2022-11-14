import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

@BeforeAll
static void beforeAll() {
    holdBrowserOpen = true;
    browserSize = "1920x1080";
    baseUrl = "https://demoqa.com";
}

    @Test
    void fillFormTest(){
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        //text boxes filling
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userEmail = "test@test.com";
        String userNumber = "9999999999";
        String currentAddress = "Earth";

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $("[id=currentAddress]").setValue(currentAddress);
        //select Gender
        $x("//label[@for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("9999999999");
        //select DateOfBirth
        $("[id=dateOfBirthInput]").click();
        $x("//div[contains(@class, 'react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select')]").click();
        $x("//option[contains(@value, '0')]").click();
        $x("//div[contains(@class, 'react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select')]").click();
        $x("//option[contains(@value, '1993')]").click();
        $x("//div[contains(@class, 'react-datepicker__day react-datepicker__day--001')]").click();
        //select Subject
        $x("//div[contains(@class, 'subjects-auto-complete__value-container')]").click();
        $("[id=subjectsInput]").setValue("M");
        $("[id=react-select-2-option-0]").click();
        //select Hobbies
        $x("//label[@for='hobbies-checkbox-1']").click();
        //select State
        $("[id=state]").click();
        $("[id=react-select-3-option-0]").click();
        //select City
        $("[id=city]").click();
        $("[id=react-select-4-option-0]").click();
        //click on Submit button
        $("[id=submit]").click();
        //Result checking
        $x("//div[@class='modal-content']").shouldBe(Condition.visible);
        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $x("//div//tr[1]//td[2]").shouldHave(text(firstName+" "+lastName));
        $x("//div//tr[2]//td[2]").shouldHave(text(userEmail));
        $x("//div//tr[3]//td[2]").shouldHave(text("Male"));
        $x("//div//tr[4]//td[2]").shouldHave(text(userNumber));
        $x("//div//tr[5]//td[2]").shouldHave(text("01 January,1993"));
        $x("//div//tr[6]//td[2]").shouldHave(text("Maths"));
        $x("//div//tr[7]//td[2]").shouldHave(text("Sports"));
        $x("//div//tr[9]//td[2]").shouldHave(text(currentAddress));
        $x("//div//tr[10]//td[2]").shouldHave(text("NCR Delhi"));

    }
}
