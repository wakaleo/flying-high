Meta:
@Versions Release 1, Iteration 1.1

Narrative:
As a traveller
I want to know how many points I need to go to a given destination
So that I can plan my next trip with Flying High Airlines

Notes: 2 points required per km

Scenario: Calculate required points
Meta:
@tag layer:web

Given I am a frequent flyer
And I am on the My Account page
When I calculate the points needed to go from <departure> to <destination>
Then I should see <requiredPoints> points
Examples:
|departure  |destination   |requiredPoints|
|Sydney     |Melbourne     |1700          |
|Melbourne  |Wellington    |4400          |


Scenario: Required points between different destinations
Meta:
@tag layer:webservice

Given I want to go from <departure> to <destination>
When I calculate the number of required points
Then I should obtain <requiredPoints>
Examples:
|departure  |destination   |requiredPoints|
|SYD        |MEL           |1700          |
|MEL        |SYD           |1700          |
|SYD        |SFO           |13000         |
|MEL        |WLG           |4400          |
|MEL        |LAX           |12400         |
|BNE        |SYD           |1700          |
|BNE        |LAX           |12400         |
|LAX        |BNE           |12400         |

