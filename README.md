# SampleUpdateFirebase

A Sample Update data in Firebase For android, in response for this question on Stackoverflow: 
https://stackoverflow.com/questions/48576560/how-to-update-child-node-data-in-firebase-database/

The application demonstrates that onclick of a button the attribute `done` will be updated to `false` and no new node will be created(after clicking the button).

# Interface
<img src="http://gdurl.com/4P8P" width="300">

# Database
The application is done to test the update of the database. Therefore on launch of the application a new random id using `push()` is created.

<u><b>Sample Database:</b></u>

    rootnode
        users
          123456789
              Tasks
                 pushid
                    done: false
                    name: task 1
                    priority: 5
             
_On relaunch of the application another pushid will be created with the same data._
_On click of the button `done` attribute will be updated to `true` and no new node will be created_
