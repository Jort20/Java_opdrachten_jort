# Design Pattern Exercises

For all these exercises you are strongly encouraged to use JUnit tests to demonstrate their use.


## Builder (1)

Package `builder` under the current package contains a class, `ClubMember` that models a sports club membership. 
You should use the Builder pattern to instantiate objects of this type according to the specifications given above 
each instance variable declaration. Take special care with the Sports. At least one should be provided (or else 
throw an `IllegalStateException`). Also think about how to instantiate addresses within this build process 
(there are several solutions).
It is advisable to create (generate) a `toString()` method.

## Builder (2)

Given the `Snp` class in package `section6_design.part2_patterns.builder`. You should implement the Builder pattern as a means to
instantiate objects of this class. Take care of required versus optional properties. 
Implement everything within the current package.
Demonstrate it using a JUnit test method.

## Filter

Using almost exactly the same class, `ClubMember` under package `filter`. You are allowed to use your own 
implementation from the previous assignment for this one.
You should create a Filter interface, or use the one from `java.util.function`, `Predicate`. 
You should explicitly NOT use the Java Streams API for this although that is a bit more logical.
Next, create a few implementers of the Filter interface, always taking a ClubMember instance and returning true 
or false. These Filters are mandatory:

- AdultFilter -- is the member an adult?
- Non-participating member -- does the member participate in at least one sport?
- Gender filter
- Specific sports filter -- e.g. only let Hockey players pass.

Finally, also implement a Composite filter; a class that wraps a chain of one or more individual filters. 
For instance, create a composite that filters Male Adult members playing Fitness.

You should first implement method `getAllMembers()` to create a list of club members.

## Observer pattern (1)

Sticking to the ClubMember class for a last exercise.
The `observer.clubs` package contains three classes: `ClubRegistration`, `ClubTeams` and `ClubAdmin`.
ClubRegistration is the place where new members are registered and unsubscribed, through methods 
`register(ClubMember newMember)` en `unsubscribe(ClubMember leavingMember)`.
Two classes are interested in these events: ClubTeams en ClubAdmin.

ClubTeams should inspect the member and enter them in a correct sports team (beware of maximum team sizes!). 
ClubAdmin will want to take care of subscription fees (differing between adults, teenagers and youngsters of course).

Large parts of the app have not been implemented yet. It is up to you to do so according to the use case described 
above, using the Observer Pattern of course.

## Observer pattern (2)

In package `section6_design.part2_patterns.observer.fermenter` you will find class `Fermenter`. This class models a microbial fermenter
in a laboratory setting. There are three pieces of peripheral equipment that are able to help the fermenter from reaching
fatal conditions: a Cooler, a GlucoseInjector and a PhAdjuster. Each of these devices needs to be updated of change in the
Fermentor state so that they can act before it is too late: the Fermentor needs to have the internal state between these boundaries:

- glucose between 30 and 100 millimolar
- pH between 4 and 8
- temperature between 33 and 40 degrees celcius

Of course, as in all Fermentors, Glucose and pH only go down and temperature goes up.

You may add classes, interfaces, enums and change existing code, but you are not allowed to change
the functionality of `addBase()`, `cool()` and `addGlucose()`. Nor are you allowed to change the essence of
method `ferment()` - only add a few lines of code if required.

Use a JUnit test method instead of `main()` to test and demonstrate your functionality.

## Strategy

In this exercise you are going to implement a variation of the strategy pattern. Instead of letting each object 
have their own strategy object you are going to do this at the class level.
There are several ways in which the melting point temperature Tm of a primer can be calculated. These are: 

1. Marmur formula: Tm = 4 x GC + 2 x AT. Not recommended for more than 13nt.
2. Wallace formula: Tm = 64.9 +41*(yG+zC-16.4)/(wA+xT+yG+zC)
3. Nearest-Neighbor Thermodynamics. SantaLucia 1998, thermodynamics & salt correction. A pretty complex algorithm 
4. that will not be implemented here. 

Use the Strategy pattern in a static context to create an app in which melting temperature calculations can be 
exchanged at runtime (for instance, when the app is going te serve the backend of a web app). Implement the 
first 2 algorithms, and throw an UnsupportedOperationException when the third is set. 

## Template method and Builder

In this exercise you are going to create a data model using a template-within-a-template pattern.
Create a workout builder using the Template Method pattern. Each Workout has a warmup, a core workout and a cooldown. 
Warmups always consist of a 10-minute run and the cooldown of a 10-minute slow run followed by a stretch session.
The core workout itself consists of a series of Exercises, each with a number of reps followed by a short rest.
You should implement construction of the Workout and Exercise classes using the Builder pattern.

## Template method (2)

Ordering an item in a store consists of the following steps:  

1. select item
2. pay item
3. gift-wrap if it is a gift
4. deliver item

Create a model of this procedure using the template method pattern for online shopping and in-store shopping.
Do you see a case for the Strategy pattern anywhere? If so, build that into the model as well.


## Decorator

The bakery package in the starter project contains partial code for a bakery. The bakery makes two types of 
cakes: vanilla and chocolate. They now want to make more complex cakes such as a "Multi-layered Vanilla 
cake with sprinkles that says 'Hello World!'"

Change the code so that an order can contain such complex cakes using the Decorator Pattern:

Create the necessary decorator classes:
For multi-layered cakes, add $5 and print "Multi-layered" out at the front of the name.
For sprinkles, add $2 and print "with sprinkles" at the end of the name.
For a cake with the saying X, add nothing to the cost, and print "with saying 'X'" at the end of the name.
Add the new type of cake: strawberry cake, which costs twice as much as a Cake.
Change the client to add the following to an Order, and print the Order:
Chocolate cake
Vanilla cake with saying "PLAIN!"
Vanilla cake with sprinkles with saying "FANCY"
Multi-layered Strawberry cake with double sprinkles and two sayings "One of" and "EVERYTHING"
Suggested output is: Multi-layered Strawberry cake with sprinkles with sprinkles with saying "One of" with saying "EVERYTHING"
Sample output

Constraints
Adding a new type of cake does not change any existing code (except to instantiate it)
Adding a new way to decorate or style the cake (such as multi-layer, or with sprinkles) does not change any 
existing code (except to instantiate it)


## Singleton

In this exercise you are going to implement a Singleton pattern. The `section6_design.part2_patterns.singleton` 
package contains a class `Logger` that is supposed to be a Singleton.
The Logger class is a simple class that logs messages to the console. It has a single method `log(String message)`
that logs the message to the console. The Logger class should be a Singleton, meaning that there should only be one 
instance of the Logger class in the entire application. 
Implement the Logger class as a Singleton in at least two different ways.
You should also implement a JUnit test to verify that the Logger class is a Singleton.

## Adapter

In this exercise you are going to implement an Adapter pattern. The `section6_design.part2_patterns.adapter` package
contains a class `TemperatureSensor` that is supposed to be an adapter. The `TemperatureSensor` class is a simple class
that has a method `getTemperature()` that returns the temperature in degrees Celsius. The `TemperatureSensor` class
should be an adapter that adapts the `TemperatureSensor` class to the `Temperature` interface. The `Temperature` interface

## Factory

In this exercise you are going to implement a Factory pattern mixed with Strategy. 
The `section6_design.part2_patterns.factory` package contains a Readme that describes the factory pattern assignment.

