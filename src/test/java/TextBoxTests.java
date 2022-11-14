import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

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
        $("[id=genterWrapper]").$(new ByText("Male")).click();
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
        $("[id=hobbiesWrapper]").$(new ByText("Sports")).click();
        //upload file
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/testfile.jpg"));
        //select State
        $("[id=state]").click();
        $("[id=stateCity-wrapper]").$(new ByText("NCR")).click();
        //select City
        $("[id=city]").click();
        $("[id=stateCity-wrapper]").$(new ByText("Delhi")).click();
        //click on Submit button
        $("[id=submit]").click();
        //Result checking
        $x("//div[@class='modal-content']").shouldBe(Condition.visible);
        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName+" "+lastName), (text(userEmail)), (text("Male")), (text(userNumber)), (text("01 January,1993")), (text("Maths")),
        (text("Sports")), (text("testfile.jpg")), (text(currentAddress)), (text("NCR Delhi")));
    }
}
