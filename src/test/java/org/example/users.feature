Feature: Users Api

  @test
  Scenario Outline: Get Users
    Given Base uri is "https://jsonplaceholder.typicode.com/"
    When use "users" api
    And query by <id>
    Then api response should have <statusCode> and <name> and <street> and <lat> and <catchPhrase>
    Examples:
      | id | statusCode | name               | street         | lat        | catchPhrase                            |
      | 5  | 200        | "Chelsey Dietrich" | "Skiles Walks" | "-31.8129" | "User-centric fault-tolerant solution" |