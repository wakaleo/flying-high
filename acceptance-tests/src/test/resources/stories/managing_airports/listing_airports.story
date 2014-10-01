Meta:
@Versions Release 1, Iteration 1.0

Narrative:
In order to know where I can fly
As a traveller
I want to know what airports are served by Flying High flights


Scenario: List serviced airports
Meta:
@tag layer:webservice

Given I need to know what cities I can fly to
When I ask for a list of airports
Then I should obtain at least the following:
| country   | name          | code   |
| Australia | Sydney        | SYD    |
| Australia | Melbourne     | MEL    |
| Australia | Brisbane      | BNE    |
| USA       | San Francisco | SFO    |
| USA       | Los Angeles   | LAX    |

Scenario: Display available destinations on the home page
Meta:
@tag layer:web

Given I need to know what cities I can fly to
When I go to the home page
Then I should see the list of possibile destinations
