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
A sample for [Apache Log4j 2] (https://logging.apache.org/log4j)


--------
FEATURES
--------
The simple example demonstrating logging with log4j2. Writes to both console and
file.


--------------
IMPLEMENTATION
--------------
## Built With
* [Maven](https://maven.apache.org) - Dependency management


## Libraries
* [Apache Log4j 2] (https://logging.apache.org/log4j) - logger library

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
    N/A
Application Server:
    N/A
Operating System:
    *nix. Has been built and tested on Ubuntu 16.
    Likely it will also will run on Mac, Solaris and Windows.


1 - Applications:
Install the following applications in your runtime environment:
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


3 - Logging Configuration (optional):
You can configure the log file outputs by modifying the following config file:
    log4j2Demo/src/main/resources/log4j2.xml



-------
RUNNING
-------
The class demonstrating functionality is a unit test class:
    com.michaelwakahe.log4j2.LogDemo

It has a main method that you can invoke from your favourite IDE.


-------
TESTING
-------
Observe the logs written to command line as well as the ones to file.


-------------------
FUTURE DEVELOPMENTS
-------------------
None


----
FAQ
----
Q: Can I change the output folder of the logs?
A: Yes you can. You just need to modify log4j2.xml appropriately.


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
https://github.com/MichaelWakahe/log4j2Demo

## Contributing
All contributions are welcome. You can pull requests to us via GitHub.


--------
LICENSE
--------
This project is licensed under the Open Software License v. 3.0 (OSL-3.0) - see
the [LICENSE.md](LICENSE.md) file for details.
