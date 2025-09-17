Feature: Login Feature

Scenario: Login Scenario

Given User is on login page
When User Enters username and password
And clicks on login button
Then User is redirected to Task Manager App Dashboard Page


Scenario Outline: Login with multiple users
  Given User is on login page
  When User Enters "<username>" and "<password>"
  And clicks on login button
  Then User is redirected to Task Manager App Dashboard Page
  

Examples:
  | username | password    |
  | Karthik  | 12345678    |
  | sai  | 12345678    |
  | Maruthi  | 12345678    |
  | Vemanth  | rtyhg    |
  | karthik  | 1234gtr    |
