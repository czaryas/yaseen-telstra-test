Feature: As a developer i want to test the users uri

  Scenario: Is the accounts uri available and functioning
    Given url microserviceUrl
    And path '/oldestAccounts/1'
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # see https://github.com/intuit/karate#schema-validation
    # Define the required schema
    * def quoteSchema = {  id : '#number', login : '#string', html_url : '#string'  }
    # The response should have an array of 1 quote objects
    And match response == '#[1] quoteSchema'
    
    