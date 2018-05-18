-----------------------------------------------------------------------------------------------------
                   TOY ROBOT Micro-service simulation
-----------------------------------------------------------------------------------------------------
This is Spring-Boot based micro-service that will process commands passed as input. It will simulate robot commands. 
TableTop dimensions are configurable in application.properties file.

Robot Commands:
PLACE, X,Y,F
MOVE
LEFT
RIGHT
REPORT

Test Cases :
It consist of 29 JUnit test cases. It can be run  using "mvn clean install" command on console.

Swagger-UI : http://localhost:8090/swagger-ui.html
--------------------------------------------------------------------------------------------------------
INPUT-

Sample 1 :
{
  "commands": [
    "PLACE 0,0,NORTH",
    "MOVE",
    "REPORT"
  ]
}

Expected Output: 0,1,NORTH
---------------------------------------------------------------------------------------------------
Sample 2 :
{
  "commands": [
    "PLACE 0,0,NORTH",
    "LEFT",
    "REPORT"
  ]
}
Expected Output: 0,0,WEST
---------------------------------------------------------------------------------------------------
Sample 3 :
{
  "commands": [
    "PLACE 1,2,EAST",
    "MOVE",
    "MOVE",
    "LEFT",
    "MOVE",
    "RIGHT",
    "MOVE",
    "MOVE",
    "REPORT"
  ]
}

Expected Output: 5,3,EAST
---------------------------------------------------------------------------------------------------

