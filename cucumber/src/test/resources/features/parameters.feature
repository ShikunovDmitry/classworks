@All
Feature: Test Different parameters for steps


  @1
  Scenario: Collection list test
    Given there is collection of elements element1,element2
    And some other elements element4, element4 exist

  @2
  Scenario: Get list of elements in parameters
    Given there are elements
      | element1 |
      | element2 |
      | element3 |

  @3
  Scenario: Map of elements test
    Given there is map of string element
      | key1 | value |
      | key2 | value |
    And there is a map of integer elements
      | key1 | 1 |
      | key2 | 2 |
    And there is a map of boolean elements
      | key1 | true |
      | key2 | false |

    @4
    Scenario: Menu test
      Given menu objects are available
        | title     | isAvailable | subMenuCount |
        | File      | true        | 5            |
        | Configure | false       | 8            |
        | About     | true        | 2            |


