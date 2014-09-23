Meta:

Narrative:
In order to know where I can fly
As a traveller
I want to know what airports are served by Flying High flights

Scenario: List serviced airports
Given I need to know what cities I can fly to
When I ask for a list of airports
Then I should obtain at least the following:
| country   | name          | code   |
| Australia | Sydney        | SYD    |
| Australia | Melbourne     | MLB    |
| Australia | Brisbane      | BNE    |
| USA       | San Francisco | SFO    |
| USA       | Los Angeles   | LAX    |
