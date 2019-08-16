## Automated web tests using Serenity, Cucumber and mvn

A simple example of some BDD-style automated acceptance criteria, running against https://www.amazon.in. 

Run the tests like this:

```
mvn clean verify
```

By default, the tests run with chrome, to modify the serenity.properties file or run the tests like this:
```
mvn clean verify -Dwebdriver.driver=firefox
```

The reports will be generated in `target/site/serenity`.
