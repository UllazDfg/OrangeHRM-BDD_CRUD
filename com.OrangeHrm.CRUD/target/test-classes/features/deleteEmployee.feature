Feature: Employee CRUD Operations

Background:
 Given User launches OrangeHRM
 And User login with valid credentials

Scenario: Delete Employee

When User searches employee "Ullas"
  And User deletes employee "Ullas"
  Then Employee should be removed successfully