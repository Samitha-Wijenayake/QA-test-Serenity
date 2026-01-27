Feature: Authentication API - Login

  Scenario: Successful login with valid credentials
    Given User sends login request with username "admin" and password "admin123"
    Then API should return status 200
    And response should contain token and tokenType

  Scenario: Login with invalid password
    Given User sends login request with username "admin" and password "wrongpass"
    Then API should return status 401
    And response message should be "Unauthorized - Use Basic Auth or JWT"

  Scenario: Login with empty username
    Given User sends login request with username "" and password "admin123"
    Then API should return status 401

  Scenario: Login with empty password
    Given User sends login request with username "admin" and password ""
    Then API should return status 401
