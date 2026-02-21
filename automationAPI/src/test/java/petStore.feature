Feature: Petsore automation API

  Background:
    * url 'https://petstore.swagger.io/v2'
    * def petId = 78945

    Scenario: 1 - Create a pet
      Given path '/pet'
      And request
        """
          {
            "id": #(petId),
            "category": {
              "id": 1,
              "name": "dog"
            },
            "name": "athenea",
            "photoUrls": [
              "string"
            ],
            "tags": [
              {
                "id": 1,
                "name": "best friend"
              }
            ],
            "status": "available"
          }
        """
      When method POST
      Then status 200
      And match response.name == "athenea"
      And match response.status == "available"

    Scenario: 2 - Retrieve pet by ID
      Given path '/pet', petId
      When method GET
      Then status 200
      And match response.id == petId
      And match response.name == "athenea"

    Scenario: 3 - Update name and status to sold
      Given path '/pet'
      And request
        """
          {
            "id": #(petId),
            "category": {
              "id": 0,
              "name": "dog"
            },
            "name": "max",
            "photoUrls": [
              "string"
            ],
            "tags": [
              {
                "id": 1,
                "name": "best friend"
              }
            ],
            "status": "sold"
          }
        """
      When method PUT
      Then status 200
      And match response.name == "max"
      And match response.status == "sold"

    Scenario: 4 - Retrieve pet by status sold
      Given path '/pet/findByStatus'
      And param status = 'sold'
      When method GET
      Then status 200
      And match response[*].status contains 'sold'

