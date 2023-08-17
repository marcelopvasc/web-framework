The project consists of automating a web application using the following methodology:

1 - Application recognition (Exploration)\
2 - Test modeling using mind map with Xmind\
3 - Framework architecture definition to support the tests using principles of Reusability and Maintainability.
Framework Composition:
*  Configuration layer (Where there are all the webdriver configurations) and also base project configurations.
* Utility Layer for useful functions within the project such as file reading and Listener configuration of the tool used for reports
* Layer of Pages, the project used Page Objects and Page Factory to concentrate all the elements and behaviors of a specific page and thus achieve Reusability and Maintainability.
* Test layer where the tests are concentrated
* Layer of reports where all configuration of reports is done
* The organization of tests within the application, order of execution, parallelism, etc. is done with TestNG.

Tech stack used:

* Java, Selenium WebDriver, Allure Reports, TestNG

Automation Coverage is <strong>76,9%</strong>. 

To run the tests:
* Clone the repository
* Have the following environment to run the test, you need:
Java, Allure, and Maven are configured on the machine.
* Run the RegressionAllSuite.xml file to run all the tests

Let me know if you have any questions.
marcelopvam@gmail.com
