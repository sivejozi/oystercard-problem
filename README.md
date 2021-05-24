# oystercard-problem

## The Oyster Card Problem ##
You are required to model the following fare card system which is a limited version of
London’s Oyster card system. At the end of the test, you should be able to demonstrate a
user loading a card with £30, and taking the following trips, and then viewing the balance.

	1. Tube Holborn to Earl’s Court
	2. 328 bus from Earl’s Court to Chelsea
	3. Tube Earl’s court to Hammersmith

## Operation ##
When the user passes through the inward barrier at the station, their oyster card is charged
the maximum fare.
When they pass out of the barrier at the exit station, the fare is calculated and the maximum
fare transaction removed and replaced with the real transaction (in this way, if the user
doesn’t swipe out, they are charged the maximum fare).All bus journeys are charged at the same price.
The system should favour the customer where more than one fare is possible for a given
journey. E.g. Holburn to Earl’s Court is charged at £2.50.
For the purposes of this test use the following data:
Stations and zones:

## Station Zone(s) ##
	1. Holborn 1
	2. Earl’s Court 1, 2
	3. Wimbledon 3
	4. Hammersmith 2

Fares:

## Journey Fare ##
	1. Anywhere in Zone 1 £2.50
	2. Any one zone outside zone 1 £2.00
	3. Any two zones including zone 1 £3.00
	4. Any two zones excluding zone 1 £2.25
	5. Any three zones £3.20
	6. Any bus journey £1.80
	7. The maximum possible fare is therefore £3.20.


## To Run ##
build the project, then get "oystercard-problem-1.0.0-jar-with-dependencies.jar", using the following command
## java -jar oystercard-problem-1.0.0-jar-with-dependencies.jar ##

## Output Result ##
1. Card has been loaded with 30.0 Pounds
2. Balance after Holborn to Earl’s Court 27.5 Pounds
3. Balance after 328 bus from Earl’s Court to Chelsea 25.7 Pounds
4. Balance after Earl’s court to Hammersmith 23.7 Pounds