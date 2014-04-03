[![Stories in Ready](https://badge.waffle.io/zhouhao/abuse-reporting-system.png?label=ready&title=Ready)](https://waffle.io/zhouhao/abuse-reporting-system)
#Abuse Reporting System
================================

The start of the Abuse Reporting System write.
Wed Feb 5 12:49 EDT 2014

# Installation and Setup

## Client Application

### Prerequisites<a name="prereq">
The client application is built using a combination technologies: jFinal, Git, AngularJS, RequireJS, and Bower.

Git is required for pulling down source.

 - Download and install Git.  Git can be found at <a href="http://git-scm.com/" target="_blank">http://git-scm.com/</a>
 
NPM is required for installing bower.

 - Download and install NPM.  NPM can be found at <a href="http://nodejs.org/" target="_blank">http://nodejs.org/</a>

### Build

 - Check out this project into your workspace.

 - Using Command Prompt or Terminal, navigate to the project's root directory.

 **It is important to install and run bower relative to its respective configuration file which is bower.json.
 
  - Install bower which depends on Node and npm.  It's installed globally using npm.
  
  	 > npm install -g bower

  - Install project external JavaScript dependencies using Bower.  Bower reads the bower.json in it's current context path to determine which dependencies are required.

     > bower install

### Tomcat Deployment

This configuration uses NON-MINIFIED web content during development.

 - Deploy using the context "abuse".  Ensure your Tomcat deployment has a reference to the environment configuration below.

 (../conf/Catalina/localhost/abuse.xml)

*Change docBase and Environment values accordingly.*

    <Context
            docBase="/Users/dev1/Desktop/Projects/Abuse-Reporting-System/WebRoot"
            crossContext="false"
            privileged="false"
            allowLinking="false"
            reloadable="true">

    </Context>

 - Build the complete application

    > ant

 - Run application in web browser

    > http://localhost:8080/abuse/

# Help Docs and Credits

### Help Docs

* [How to run this web app in your own computer](docs/HowToRunOnYourOwnComputer.md)
* [JFinal MVC framework](http://git.oschina.net/jfinal/jfinal)

### Credits
* Hao Zhou - CS - royhzhou@gmail.com       
* Kexin Liu - ECE - kliu2@wpi.edu
* Cheng Deng [Github](https://github.com/cdeng)
* Sihao Chen - ECE - schen2@wpi.edu  
* Chao Ren - ECE - renchao96825@gmail.com
* Guanxiong Liu - ECE - sylorbeijing@gmail.com  

