# DataMigration

For this project, I performed a data migration exercise from a CSV file to a MySQL database. The file contains details about Employees

The program reads the data from the CSV file using a bufferedReader for the best performance, then imports the data into the database. 

<ul> Duplicate values were removed by added each employee into a Hashmap. The hashmap uses the employee id as the key so that search times are O(1).
- Once duplicate values where removed, the resulting employees left over as returned in an arraylist. The reason for doing this, was so that the arraylist could be more easily "split" into smaller lists using the subList function.
- All duplicate employees are stored in an arraylist called "duplicates" however for the purposes of this project nothing more was done with them.
- Through testing is implimented via JUnit testing to make sure all methods in the project work as intented
- Performance testing is done for all aspects of the project, including testing execution time!
- design patterns were used for good clean code standards (DTO, DAO and singleton for the CSV reader class).
- The use of functional Programming were used were I felt it was better to do so.
- All exceptions are handled, with a logger used aswell.
