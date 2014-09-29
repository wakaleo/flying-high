Earning Frequent Flyer points from purchases

Meta:
@Versions Release 2
@tag layer:webservice

Narrative:
In order to encourage travellers to book with Flying High Airlines more frequently
As the Flying High sales manager
I want travellers to earn Frequent Flyer points when they fly with us

Scenario: Earning points when I buy something in a supermarket
Given I am shopping at Woolworths
And Woolworths is a partner organisation
When I purchase a box of sardines for 5.00
Then I should earn 5 points