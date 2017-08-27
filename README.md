# selenium-cucumber
Ryanair booking test with Java, Selenium and Cucumber

# requirements 
* java 1.8
* maven
* chrome or safari web driver 

# how to build and run 
to run with chromedriver 
```bash
mvn clean test -Dchrome.driver.path=path/to/chrome/driver
```

to run with safaridriver 
```bash
mvn clean test -Dsafari.driver.path=path/to/safari/driver
```

to run with embedded chromedriver (Windows) 
```bash
mvn clean test
```

for more please check setUpDriver in [com.ryanair.BaseTest](https://github.com/ugazda/selenium-cucumber/blob/master/src/test/java/com/ryanair/BaseTest.java) 


