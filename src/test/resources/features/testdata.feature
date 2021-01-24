Feature: Create Employee
  Scenario: WITH ALL REQUIRED FIELDS IS SUCCESSFUL
    Given user want to create an employee with following attributes
      | id  | firstName | lastName   | dateOfBirth | startDate  | employmentType | email                |
      | 100 | Subbareddy| Nallamachu | 1990-10-01  | 2020-10-20 | Permanent      | subbareddy@gmail.com |
    And with the following phone numbers
      | id  | type   | isdCode | phoneNumber | extension |
      | 102 | Mobile | +971    | 0553371243  |           |
      | 103 | Office | +91     | 9164278483  | 1243      |
    When user saves the new employee 'WITH ALL REQUIRED FIELDS'
    Then the save 'IS SUCCESSFUL'