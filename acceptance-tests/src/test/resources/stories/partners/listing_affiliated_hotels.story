Meta:
@Versions Release 1, Iteration 1.1

Narrative:
In order to earn the most points possible
As a traveller
I want to know what hotels will let me earn poitns


Scenario: List partner hotels
Given I am a frequent flyer
When I ask to see what hotels I should go to to earn more points
Then I should see the list of partner hotels
