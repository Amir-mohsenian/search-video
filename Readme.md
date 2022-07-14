Video Search in Clean architecture

A simple app for searching Video in filmnet server.

At the first of starting project I added Dagger-hilt third party then
I created structure of packages in the application.
At this point I added retrofit and okhttp libraries after that I provided them by hilt.
I Add the remoteDataSource for providing a connection to server, it was done by a parent class
and call services in the child class for preventing boilerplate code but I didn't because in this project
there is just one service.
For the first time I've built ui by compose and I did not care about it because you said that.

For testing this project it just enough to add a text into textfield and press the search button. 