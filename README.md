# MediConnect

MediConnect is a connection-oriented network communication system 
built on a server-client architecture designed for hospital systems. 


## Built With 
[![Java][JAVA]][JAVA-url] [![Socket][Socket]][Socket-url]

- Java for backend implementation.
- Socket programming for network communication.
- Multithreading for concurrent client requests handling.

## Features
- Appointment Scheduling: Patients can schedule appointments with doctors in the hospital system. 
- Appointment Cancellation: Patients can cancel their appointments if needed.
- Doctor Management: The system manages doctor information, including IDs, names, availability, and associated patient appointments.
- Client-Server Communication: Utilizes a client-server architecture for communication between patients (clients) and the hospital system (server).
- Concurrent Requests Handling: The server can handle multiple appointment requests and cancellations concurrently using multithreading.
- Descriptive Response Messages: Provides descriptive messages to clients indicating the success or failure of appointment scheduling or cancellation.


## Potential Enhancements

- Implement user authentication for security.
- Add support for additional features such as appointment reminders or rescheduling.
- Improve error handling and exception management.
- Implement a graphical user interface (GUI) for client interactions.
- Integrate with a database for persistent data storage.

## Getting Started

Clone the project and Run the Server
```
git clone https://github.com/AbdallahSalah003/MediConnect.git
java src/Server.java
```

In another terminals you can Init multiple Clients
```
java src/Client.java
```




[JAVA]: https://img.shields.io/badge/Java-orange?style=for-the-badge&logo=CoffeeScript
[JAVA-url]: https://www.java.com/
[Socket]: https://img.shields.io/badge/Socket-black?style=for-the-badge&logo=Socket.io
[Socket-url]: https://Socket.io/
