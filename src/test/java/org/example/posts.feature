Feature: Posts Api

  @test
  Scenario Outline: Get Posts
    Given Base uri is "https://jsonplaceholder.typicode.com/"
    When use "posts" api
    And query by <id>
    Then api response should have <statusCode> and <userId> and <title>
    Examples:
      | id | statusCode | userId | title                     |
      | 15 | 200        | 2      | "eveniet quod temporibus" |