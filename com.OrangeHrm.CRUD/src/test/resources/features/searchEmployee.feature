Feature: Employee CRUD Operations

Background:
 Given User launches OrangeHRM
 And User login with valid credentials

Scenario: Search Employee

 When User searches employee "Ullas"
 Then Employee details should be displayed as "Qa"