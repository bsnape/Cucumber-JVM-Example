Feature: Mercury API feeds
  In order to generate front-end features
  As a backend enabler
  I want to be able to provide appropriate API's

  Scenario Outline: Verify the Most Watched Feed across Platforms

    Given I request the <type> Most Watched Feed for <platform>
    Then I get a successful <type> response with the correct <platform>

  Examples:
    | type | platform |
    | json | DotCom   |
    | xml  | DotCom   |
    | xml  | PS3      |
    | xml  | YouView  |
    | xml  | Samsung  |
    | xml  | Android  |
