Meta:
@Versions Release 1, Iteration 1.0
@tag layer:web

Narrative:
In order to know how many points I have earned
As a traveller
I want to see my total points

Scenario: View point balance
Given Sarah is a Frequent Flyer member with 800 points
When she views her account details
Then she should see an account balance of 800 points
