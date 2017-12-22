#########################
# CONTENTS OF THIS FILE #
#########################

 * Introduction
 * Features
 * Implementation
 * Installation and Configuration
 * Running
 * Testing
 * Future Developments
 * FAQ
 * Credits / Contact
 * Versioning
 * License
 * Useful Resources


------------
INTRODUCTION
------------
A HelloWorld example for Java Hibernate.


--------
FEATURES
--------
The program demonstrates CRUD operations with Hibernate using a simple Book
POJO. Sample is easy to run from within an IDE, driven by JUnit


--------------
IMPLEMENTATION
--------------
## Built With
* [Maven](https://maven.apache.org) - Dependency management
* [MySQL](https://www.mysql.com) - Relational Database Management System


## Libraries
* [JUnit] (http://www.junit.org) - unit and system testing
* [Hibernate] (http://hibernate.org) - Java ORM framework
* [HikariCP] (https://brettwooldridge.github.io/HikariCP) - database connection pooling

The application is tested with JSE 1.8.


------------------------------
INSTALLATION AND CONFIGURATION
------------------------------

0 - Prerequisites:
JDK:
    1.8 or above
Memory:
    For best performance, computer should have at least 500MB RAM
Disk:
    Approximately 200MB free space
RDBMS:
    MySQL 5.5 and above
Application Server:
    N/A
Operating System:
    *nix. Has been built and tested on Ubuntu 16.
    Likely it will also will run on Mac, Solaris and Windows.


1 - Applications:
Install the following applications in your runtime environment:
* MySQL 5.5 and above
* Maven 3.3.9 and above
* For source code editing, you can install the IDE of choice for example
  Eclipse, Spring Tool Suite, Intellj IDEA or Netbeans


2 - Environment Variables:
Ensure that the following environment variables are properly set up:
JAVA_HOME

For example, on Ubuntu, add the following lines to the .bashrc file in the user
home folder:

    export JAVA_HOME=/opt/jdks/jdk1.8.0
    export PATH=${JAVA_HOME}/bin:$PATH

The above assumes that JDK 1.8 is unpacked in the folder '/opt/jdks'


3 - Configure MySQL:
Ensure that the client and server versions of MySQL or MariaDB are installed on
your local machine

Create the database user account as follows:
        % mysql -h localhost -u root -p
        Enter password: ******
        mysql> CREATE USER 'user1'@'localhost' IDENTIFIED BY 'pass';
        mysql> GRANT ALL ON hibernatedb1.* TO 'user1'@'localhost';
        Query OK, 0 rows affected (0.09 sec)
        mysql> quit
        Bye

    In the commands shown, the '%' represents the prompt displayed by your shell
    or command interpreter, and 'mysql>' is the prompt displayed by mysql.


Create the database as follows:
        % mysql -h localhost -u user1 -p
        Enter password: ******
        mysql> CREATE DATABASE hibernatedb1;
        Query OK, 0 rows affected (0.09 sec)
        mysql> quit
        Bye

Locate the SQL and data import script in the folder 'src/main/scripts/sql/data'
Execute the script as follows:
        % mysql -h localhost -u user1 -p hibernatedb1 < book.sql

    The password for the above is 'pass'.

You can verify either from command line or from MySQL Workbench that the tables
have been created and the sample data has been imported.



-------
RUNNING
-------
The class demonstrating functionality is a unit test class:
    com.michaelwakahe.hibernate.project1.AppTest

You can invoke Junit from your favourite IDE or use Maven on the command line.

To use Maven on the command line:
    mvn clean test


-------
TESTING
-------
See the section RUNNING above.



-------------------
FUTURE DEVELOPMENTS
-------------------
* Dependency Injection to be achieved with Spring framework


----
FAQ
----
Q: Can I use an RDBMS other than MySQL?
A: Yes, it is also compatible with MariaDB 10


-----------------
CREDITS / CONTACT
-----------------
## Current Maintainers:
* Michael Wakahe - www.michaelwakahe.com

## Contributors:
None so far

## Acknowledgments
None


----------
VERSIONING
----------
The project uses git via GitHub. The project repository can be viewed here:
https://github.com/MichaelWakahe/HibernateProject1

## Contributing
All contributions are welcome. You can pull requests to us via GitHub.


--------
LICENSE
--------
This project is licensed under the Open Software License v. 3.0 (OSL-3.0) - see
the [LICENSE.md](LICENSE.md) file for details.
