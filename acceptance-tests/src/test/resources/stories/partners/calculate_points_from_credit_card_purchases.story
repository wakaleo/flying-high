Meta:
@Versions Release 2
@tag layer:webservice

Narrative:
In order to earn the most points possible
As a traveller
I want to use a credit card that earns Frequent Flyer points

Scenario: Calculate points earned from purchases using an affiliated credit card
Given I am a frequent flyer
And I have <initial_points> status points
When I spend <amount_spent> using an affilliated credit card <card>
Then I should earn <points_earned>
And my new account balance should be <updated_points>
Examples:
| initial_points | amount_spent | card            | points_earned | notes                    |
| 0              | 100          | VISA            | 5             | 1 point per $20 spent    |
| 100            | 1000         | MASTERCARD      | 5             |                          |
| 0              | 100          | VISA GOLD       | 7.5           | 1.5 points per $20 spent |
| 100            | 1000         | MASTERCARD GOLD | 8             | 8 points per $100 spentt |
| 100            | 100          | AMEX            | 10            | 2 points per $20 spent   |