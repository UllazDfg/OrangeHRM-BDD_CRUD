Feature: Employee CRUD Operations

Background:
 Given User launches OrangeHRM
 And User login with valid credentials

Scenario: Create Employee

 When User navigates to PIM module
 And User adds employee "Ullas" "QA"
 Then Employee should be created successfully