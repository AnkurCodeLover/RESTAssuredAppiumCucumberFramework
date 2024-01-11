Feature: verify different get Operation using Rest-Assured

  Scenario Outline: Verify new user is created
    Given Add User Payload with "<name>"  "<gender>" "<email>"
    When user calls "AddUserAPI" with "POST" http request
    Then the API call got success with status code 201
    And "status" in response body is "active"
    And verify user_Id created maps to "<name>" using "getUserAPI"

    Examples:
      | name     | gender | email                         |
      | Harsitam | male   | testworking9@test.com |


 Scenario: Verify get user is functionality is working
   When user calls "getUserAPI" with "GET" http request
   Then the API call got success with status code 200


  Scenario: Verify if Delete User functionality is working
    When user calls "deleteUserAPI" with "DELETE" http request
    Then the API call got success with status code 204

  Scenario: Verify negative scenario
    When user calls "getUserAPI" with "GET" http request
    Then the API call got success with status code 404

