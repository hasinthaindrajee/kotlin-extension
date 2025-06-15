**Important** : Kotlin extensions are not used by known WSO2 systems. If you are planning to use, use it with your own RISK !!!!

# Identity Event Handler extension.

Steps

1. Build the source using `./gradlew clean build` command.
2. Copy /com-organization-1.0-SNAPSHOT.jar file into <IS_HOME>/repository/components/dropins/ folder.
3. Add the following configurations to <IS_HOME>/repository/conf/deployement.toml file

```
[[event_handler]]
name= "customUserRegistration"
subscriptions =["PRE_ADD_USER"]
```

4. Download the kotlin-stdlib dependency and add it to repository/complonents/libs. The one tested was 2.2.0 RC2 from https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib/2.2.0-RC2
5. Restart the server.


