Feature: Purchase products

  @purchaseProducts
  Scenario: Add two products successfully
    Given Miguel is logged in the platform
    When he adds the following products to the cart
    |Samsung galaxy s6|
    |Nokia lumia 1520 |
    And he places the order with the folloing information
    |name   |Miguel  |
    |country|Colombia|
    |city   |Bogota  |
    |card   |4578854 |
    |month  |02      |
    |year   |2026    |
    Then he see the success message after purchasing the products