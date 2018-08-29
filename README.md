# Epikord
a simple discord bot written in kotlin

## Purpose
This bot is used only for specific purpose: Add a role to members. To display the help you must type `?Help`. 

## Configuration
The configuration is a Json configuration which contains only 2 fields:

```json
{
  "token": "bot-token-id",
  "name" : "bot name"
}
```
----

## Compile the bot
To compile the bot, you need to have the JVM with Java8 (1.8.1). You can install it by typing `gradlew build` which will compile and generate the jar file into the `build/libs` directory.

## Run the bot
To run the bot, you can use the following command: `java -jar build/libs/epikord.jar_<version> -c <configuration>`
