package steps;

import io.cucumber.java.en.*;
import pages.CommonPage;
import flipkart.automation.utility.ExcelReader;
import pages.EnquirePage;

import java.util.Map;

public class AdmissionEnquirySteps {
    private final String EXCEL_PATH = "E://Automation//HCL//AmazonProject//Flipkart-Automation//src//test//resources//Data//QA_University.xlsx";
    CommonPage commonPage=new CommonPage();
    EnquirePage enquirePage=new EnquirePage();
    @Given("the user navigates to the Sandip University admission page")
    public void the_user_navigates_to_the_sandip_university_admission_page() {
        commonPage.isUinversityHomePageOpen();
    }
    @When("the user fills and submits the enquiry form using data from {string} at row {int}")
    public void the_user_fills_and_submits_the_enquiry_form_using_data_from_at_row(String sheetName, Integer rowNumber) {
        Map<String, String> data = ExcelReader.getData(EXCEL_PATH, sheetName, rowNumber);
        // Fetch inputs from Excel
        String name = data.get("name");
        String email = data.get("email");
        String school = data.get("school");
        String course = data.get("course");
        String state = data.get("State");
        String city = data.get("city");
        String contact = data.get("contact");

        enquirePage.enter_full_name(name);
        enquirePage.enter_email(email);
        enquirePage.select_school(school);
        enquirePage.select_course(course);
        enquirePage.select_state(state);
        enquirePage.select_city(city);
        enquirePage.enter_contact_number(contact);




    }
    @Then("the enquiry form should be submitted successfully")
    public void the_enquiry_form_should_be_submitted_successfully() {
        System.out.println("Sanjeet");

    }

}
