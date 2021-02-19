# DataMigration

For this project, I performed a data migration exercise from a CSV file to a MySQL database. The file contains details about Employees

The program reads the data from the CSV file using a bufferedReader for the best performance, then imports the data into the database. 

*  Duplicate values were removed by added each employee into a Hashmap. The hashmap uses the employee id as the key so that search times are O(1).
* Once duplicate values where removed, the resulting employees left over as returned in an arraylist. The reason for doing this, was so that the arraylist could be more easily "split" into smaller lists using the subList function.
*  All duplicate employees are stored in an arraylist called "duplicates" however for the purposes of this project nothing more was done with them.
*  Through testing is implimented via JUnit testing to make sure all methods in the project work as intented
*  Performance testing is done for all aspects of the project, including testing execution time!
*  design patterns were used for good clean code standards (DTO, DAO and singleton for the CSV reader class).
*  The use of functional Programming were used were I felt it was better to do so.
*  All exceptions are handled, with a logger used aswell.

* The uploading process into the database can be choosen by the choose of several methods:
  * Upload using *n* threads and using a batch insert process
    * Using 12 threads: 1,524 milliseconds 
    * Using 100 threads: 2,278 millseconds
    * Using 500 threads: 13,348 milliseconds
    * Using 1000 threads: 9,561 milliseconds
  * Upload using *n* threads using a for loop and standard insert query
    * Using 12 threads: 105,799 milliseconds 
  * Upload using a single thread and using a batch process
    * 1,345 milliseconds
  * Upload using a single thread and a for loop and stand insert query
    * 110,542 millseconds

