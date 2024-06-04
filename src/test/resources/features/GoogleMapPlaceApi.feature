Feature: Validating Google Map Place API's

  @AddPlaceAPI
  Scenario Outline: Verify if place is being Successfully added using AddPlaceAPI
    Given Load Place Payload with "<name>" "<language>" "<address>"
    When User calls "addPlaceApi" with "POST" http request
    Then the API call got success with status code 200
    Then "status" in response body is "OK"
    Then "scope" in response body is "APP"
    And User sends the placeid value in the Header
    When User calls "getPlaceApi" with "GET" http request
    Then reponse result name value should match with the request payload "<name>" value

    Examples: 
      | name  | language | address       |
      | peter | English  | George Street |

  @DeletePlaceAPI
  Scenario: Verify place is deleted successfully using DeletePlaceApi
    Given Load delete place payload
    When User calls "deletePlaceApi" with "DELETE" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
