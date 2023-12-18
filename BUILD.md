# Building Process:

1. Init with the tool: [start.spring.io](https://start.spring.io).

   <br>

   <img src="./assets/Springboot Initialize.jpg" alt="Employee data" width="500" height="270" title="None">
2. Refine modularize projects.

   <br>

   <img src="./assets/Module Init.jpg" alt="Employee data" width="320" height="120" title="None">
3. Manage the backend.
5. Install Angular [CLI](https://angular.io/cli).

   - Use `ng new youtube-clone-ui --directory` to define the frontend ui module.
   - Go into youtube-clone-ui folder and `npm install`.
   - In youtube-clone-ui, `npm start`.
   - Install Angular Materials with `ng add @angular/material`.
   - To use maven to build the frontend project, integrate [frontend-maven-plugin](https://mvnrepository.com/artifact/com.github.eirslett/frontend-maven-plugin/1.12.0) in frontend pom. (Reload if dependencies unsolved.)

     > ng build could create folders to contain all the build files(minified js files, HTML files, and CSS files). It would be stored in `<resources></<resources>` in the pom.
     >

   <br>

   <img src="./assets/Init BackFront.jpg" alt="Employee data" width="300" height="150" title="None">
6. Install MongoDB [Mac (ARM64)](https://www.mongodb.com/try/download/community) and [GUI](https://www.mongodb.com/try/download/compass).

   NOTES (2023/12/17), installing issues, solutions:
   (1) [BREW Install MongoDB on Mac (Apple M1/M2 chip)](https://www.youtube.com/watch?v=UQbZADfCqjs)
   (2) [mongo command not found](https://www.youtube.com/watch?v=xVOAVIumuJk), mongosh

   ```
   mongosh --version
   brew services start mongodb-community@6.0
   mongosh

       Using MongoDB:		6.0.10
       Using Mongosh:		2.1.1

       For mongosh info see: https://docs.mongodb.com/mongodb-shell/
       ------
       The server generated these startup warnings when booting
       2023-12-17T05:23:14.761-05:00: Access control is not enabled for the database. Read and write access to data and configuration is unrestricted
       ------

       test> show databases
       admin    8.00 KiB
       config  12.00 KiB
       local    8.00 KiB
       test> quit
   ```
   <br>


7. Local Database configured in resources > application.properties.  
