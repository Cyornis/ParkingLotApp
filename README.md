# ParkingLotApp  
## Usage

Usage: Park [ command ] -- [argument]

|command|   alias         |    argument     | description of commands                                                                                   
| ----- | ----------------|-----------------| ---------------------------------------------------   
| -ci   | --checkin       |     none        |  command checkin vehicle                                                                                
| -co   | --checkout      |     vehicleNo   |  command checkout vehicle                                                                                  
| -cp   | --capacity      |     none        |  for calculating capacity of parking lot for vehicles 
| -dov  | --details       |     none        |  for showing details of vehicle and owner

## Details of Commands

1)checkin:

   "-ci"->name,carNo,model,manufacturer,bankbalance,typeOfVehicle,checkinTime

2)checkout:

    "-co"->carNo

3)capacity:

    "-cp"->null

4)detailsOfVehicle:

    "-dov"->none

## Requirements

1)permits only 2 and 4 wheeler.

2)implements relevant fare.

3)the total amount should be rounded to two decimal places.

4)max parking capacity is 40.

5)Mobile number and vehicle number should be unique.
