# metro-world
Trying to simulate a city metro transportation



### Requirements

- Train can move from station to station
- One line is a connection of multiple stations together
- Passengers wants to go from station A to station B
- There can be multiple trains in one line
- Number of train in a station could be limited
- Time of travel between two stations should not be constant, but dependant of time



#### Moving

Train goes from station A to station B

take time t, depending on the distance, so stations need to have pos x and y to determine distance

##### Line

- Connect stations together
- may have max number of trains

#####  Trains

- constant speed
- contains passengers
- max number of passenger
- in a station
- with a direction

##### Passenger

- wants to go from A to B
- Choice of B depends on popularity

- have a plan (take the shortest path)
  - Each shortest path have been preprocessed and sorted in a hash table, so access is O(1) and no need to recalculate it twice.
  - Time of travel is dependent to distance so shortest path considered distance-wise
  - Find the shortest path is done by a greedy search
  - fuck this will take so much time

- appears randomly









