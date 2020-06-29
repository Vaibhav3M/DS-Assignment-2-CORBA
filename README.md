# DS-Assignment-2-CORBA

## Distributed Player Status System (DPSS) using CORBA

Submitted By : Vaibhav Malhotra - 40079373
Github link : https://github.com/Vaibhav3M/DS-Assignment-2-CORBA/

## Build and Run

All code is written in IntelliJ IDE, Java JDK version 8.

CORBA is not supported after java 8.

### IntelliJ:

-	Open the project in folder DPSS_CORBA
- Add runtime params for all the below classes (-ORBInitialPort 1050 - ORBInitialHost)
-	Run: AmericaGameServer, EuropeGameServer, AsiaGameServer.
-	Run: PlayerClient (to launch a player window)
-	Run:  AdminClient (to launch a Admin window)
-	To run multiple clients change the configuration to “Allow parallel run”.


### From Command Line

- Move to **DPSS_CORBA** directoy: `cd DPSS`.

- Create a new folder named **dist** in the current folder : `mkdir dist`.

- Compile the code (outputting into dist folder): `javac -d dist src/**/*.java`.

- Move to **dist** folder: `cd dist`.

- Run all 3 servers using following commands (will have to open different terminals):

Run ORBD through cmd:
```
start orbd -ORBInitialPort 1050
```
Start Servers: 
```
start java Server.America.AmericaServer -ORBInitialPort 1050 - ORBInitialHost localhost
start java Server.America.AmericaServer -ORBInitialPort 1050 - ORBInitialHost localhost
start java Server.America.AmericaServer -ORBInitialPort 1050 - ORBInitialHost localhost
```

- Run the clients (will have to open in different terminals):

```
java PlayerClient -ORBInitialPort 1050 -ORBInitialHost localhost
java AdminClient -ORBInitialPort 1050 -ORBInitialHost localhost
```


## Concepts implemented

### 1.	CORBA using Java IDL
CORBA is used to a design specification for an Object Request Broker (ORB). This ORB provides the mechanism required for distributed objects to communicate and invoke server methods.

### 2.	UDP
For below communication between server UDP is used:
- transferAccount() - When a user request to trasnfer account to another server, a UDP request with user information is generated which instructs the other server to add player to it's database and reponsds with the status. If succesful the player is removed from old server. 
-	getPlayerStatus() – When admin requests this method on a server, that server sends UDP request to other two servers to get the player info.
-	createPlayer() – When a user tries to create a new player on a server, that server sends a UDP request to other servers to check if Username already exists.
 

### 3.	Multi-threading
-	All servers run on their individual thread
-	All UDP requests are sent on a new thread
- All client requests are sent on a new thread

### 4.	HashTables-DataStructure
Player data on server are stored in a Hashtables. Hashtables are thread-safe and promote concurrency.

### 5. Locks
Lock (ReentrantLock) is used for proper synchronization to allow multiple users to perform operations for the same or different accounts at the same time.


## Test screenshots are avilable in [Report](https://github.com/Vaibhav3M/DS-Assignment-2-CORBA/blob/master/Assignment2-Report.pdf)

