Meta:
@Versions Release 2,
@tag layer:webservice

Narrative:
In order to earn the most points possible
As a traveller
I want to buy from companies where I will earn Frequent Flyer points

Scenario: Calculate points earned from purchases in hotels
Given I am a frequent flyer
And I have <initial_points> status points
When I spend <amount_spent> in a partner hotel
Then I should earn <points_earned>
And my new account balance should be <updated_points>
Examples:
| initial_points | amount_spent | points_earned | updated_points | notes                 |
| 0              | 100          | 5             | 5              | 1 point per $20 spent |
| 100            | 100          | 5             | 105            |                       |
| 100            | 1000         | 50            | 150            |                       |