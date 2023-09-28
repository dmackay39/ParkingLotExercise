# ParkingLotExercise
Individual task to make an MVC application around a parking lot payment concept
We are going to create a parking lot application to calculate fees in for stays in a parking lot.

This is to be an MVC application

Business rules

There will be two components in the Model:  The Ticket and the Parking Lot

The Ticket object will know the entry and exit DateTimes.  
Based on these two pieces of data, the ticket will calculate the duration of the stay in Days, Hours and Minutes
When the stay duration is requested from the ticket it will report these three values as integers
The Ticket will be responsible for things like leap year, daylight savings time, etc.

The Parking Lot will get the duration from the Ticket (in Days, Hours, and Minutes) and use these 3 integers to calculate the fee
Rules for calculating the fee are:
1.  $2 per hour
2.  Always round up (even 1 minute rounds up to the next hour!)
3.  Maximum charge per day is $15.  (ie, if you are there for 10 hours you are billed $15, not $20)
4.  On the first day, if you leave within half an hour of arriving there is no charge

First Pass classes:
App class (Contains main() and start() functions
Parking Lot View (user enters entry and exit date-times and the fee is displayed
Controller
Ticket
Parking Lot

Second Pass:
Create an IParking Lot interface and allow for different lots with different rate structures
Examples:  Long term parking, daily parking, nearby parking, etc
Use radio buttons to select the parking lot

Key design aspect:  Use a factory object to create the correct lot
