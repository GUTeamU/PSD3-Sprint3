Narrative:
In order to be full
As a cook
I want to create a meal without disasters

Scenario: cook defrosts a chicken
Given a microwave oven
When the defrost mode is selected
And a large chicken is selected
Then cooking time is 25 minutes

Scenario: cook roasts a medium chicken
Given an oven
When a chicken weighing 3 kg is roasted
Then oven temperature is 200 degrees celsius
And roasting time is 140 minutes

Scenario: cooks roasts a small chicken
Given an oven
When a chicken weighing 2 kg is roasted
Then oven temperature is 200 degrees celsius
And roasting time is 100 minutes