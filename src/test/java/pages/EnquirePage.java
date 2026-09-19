package WebAutomationBase.pages;

import org.openqa.selenium.By;

public class EnquirePage extends BasePage {

    // Locators defined as By objects for reuse with BasePage actions
    public static final By FULL_NAME = By.xpath("//input[@name='full_name']");
    public static final By EMAIL = By.xpath("//input[@name='email']");
    public static final By SCHOOL = By.xpath("//select[@title='School']");
    public static final By COURSES = By.xpath("//select[@name='specialisation']");
    public static final By STATE = By.xpath("//select[@title='State']");
    public static final By CITY = By.xpath("//select[@title='City']");
    public static final By CONTACT_NUMBER = By.xpath("//input[@title='Contact Number']");

    public void enter_full_name(String name) {
        sendKeys(FULL_NAME, name);
    }

    public void enter_email(String mail) {
        sendKeys(EMAIL, mail);
    }

    public void select_school(String schoolName) {
        selectByVisibleText(SCHOOL, schoolName);
    }

    public void select_course(String courseName) {
        selectByVisibleText(COURSES, courseName);
    }

    public void select_state(String stateName) {
        selectByVisibleText(STATE, stateName);
    }

    public void select_city(String cityName) {
        selectByVisibleText(CITY, cityName);
    }

    public void enter_contact_number(String contact) {
        sendKeys(CONTACT_NUMBER, contact);
    }
}