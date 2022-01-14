Feature: ToDos Api

  @test
  Scenario Outline: Get ToDos
    Given Base uri is "https://jsonplaceholder.typicode.com"
    When use "todos" api
    And query by <id>
    Then api response should have <statusCode> and <title> and <userId>

    Examples:
      | id | statusCode | title                 | userId |
      | 29 | 200        | "laborum aut in quam" | 2      |
