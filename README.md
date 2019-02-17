# UIAutomationBDD
This cucumber project consists of 2 features : LoginValidation and ProductSearch
and runs them in parallel.

Tags: @Sanity, @LoginValidation , @ProductSearch
Sanity contains both Login and ProductSearch functionality

Example Steps to run:

mvn test -Dcucumber.options="--tags @Sanity" -Dbrowser=firefox
mvn test -Dcucumber.options="--tags @Sanity" -Dbrowser=chrome
mvn test -Dcucumber.options="--tags @ProductSearch" -Dbrowser=chrome
mvn test -Dcucumber.options="--tags @LoginValidation" -Dbrowser=chrome

Reports Generated at below path:
ProjectDirectory/target/cucumber-parallel/{1}/index.html
