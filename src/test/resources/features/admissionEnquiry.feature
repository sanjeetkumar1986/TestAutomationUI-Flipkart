Feature: Sandip University Admission Enquiry Form
  As a prospective student
  I want to submit an enquiry form
  So that I can receive information about admissions for the Academic Year 2026-27

  Background:
    Given the user navigates to the Sandip University admission page
@admission
  Scenario Outline: Successfully submit the enquiry form with valid details from Excel
    When the user fills and submits the enquiry form using data from "<SheetName>" at row <RowNumber>
    Then the enquiry form should be submitted successfully

    Examples:
      | SheetName   | RowNumber |
      | Admissions  | 1         |
      | Admissions  | 2         |