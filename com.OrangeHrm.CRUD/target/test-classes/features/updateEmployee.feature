Feature: Employee CRUD Operations

Background:
 Given User launches OrangeHRM
 And User login with valid credentials
Scenario: Update Employee

 When User searches employee "Ullas"
 Then  User updates employee lastname to "QA"
  And Employee should be updated successfully as "Ullas" "Qa"
