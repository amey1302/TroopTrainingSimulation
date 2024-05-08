## Problem Statement :
Problem Statement
Troop training simulation is inspired by Clash of Clans games. As a gaming programmer, you have to create a simulation software using which gamers can train army troops.

Army Troops
There are two kinds of troops: Archers and Barbarians. Each trooper (archer/barbarian) has the following characteristics:

|Troops | Training Time| Training Cost|Weapon|
-------|-------|----------|---|
|Barbarian| 3 |10 |Sword|
|Archer | 6|20 |Bow and Arrow|

Barracks
Barracks are where each trooper gets trained. The following rules apply to barracks:

Only one trooper can be trained at a given point of time.
The maximum seat capacity of a barracks is 10.
Others have to wait outside the barracks.
Barracks can have a mix of troopers, e.g., 5 Archers and 5 Barbarians, or 4 Archers and 6 Barbarians, or 10 Archers, or 10 Barbarians.
Army Camp
The army camp is where troops assemble after training.

Scenario 1
Simulate the training and train barbarians and/or archers. As a gamer:

You should be able to input the number of barbarians and/or archers you would like to train.
You should be able to see how many troops are trained and available in the troop camp after training completes.
-----------------------
## Analysis
### package : org.amaap.troopsimulationgame
 ## Domain
   - model
     - Archer
      - state :
         - int id
         - int trainingTime
         - int trainingCost
      - behaviour :
         - getters
     - Barbarian
      - state :
         - int id
         - int trainingTime
         - int trainingCost
      - behaviour :
         - getters
     - value Objects(enum)
       - Troop
         - TroopType
   - service
     - TrainTroops

 ## Controller :
   ### TroopController
        - The role of this controller is to create the troops via TroopService
          and store that in TroopRepository
   ### BarrackController
        - The role of this controller is to use the troops that are stored in the
          TroopRepository via BarrackService
        - It will call internally to the TrainTroop Service of domain to train the troops
        - After Training the troops are stored in the ArmyCampRepository
   ### ArmyCampController
        - It will get the data from the ArmyCampRepository via ArmyCampService and
          displays the troopCount(Archer and Barbarian)

 ## Service  :
    ### TroopService :
        - It validates the troopCount and TroopType String Validation and after that
          it will create the troop and store in the TroopRepository
    ### BarrackService :
        - It takes troop from the TroopRepository and call the domain service TrainTroops
        - After training the troops are stored in ArmyCampRepository
    ### ArmyCampService :
       - It reads the data from the ArmyCampRepository and displays the count of the Troops

 ## Repository :
    ### TroopRepository :
       - Stores the troops
    ### BarrackRepository :
       - Stores the data of troops which are trained
    ### ArmyCampRepository :
       - stores the troopCount

