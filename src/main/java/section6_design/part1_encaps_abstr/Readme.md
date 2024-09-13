# Exercise Encapsulation, Abstraction, Design and Testing

This package holds a single class, `Snp`. It publishes **a public API you should implement**.
The public API should **not be changed or extended**. 
You can add any number of supporting **_private_** methods, constructors, inner classes and variables.

The public API is the abstraction.

Implement this class **well-encapsulated**: no fields, utility methods and public methods should expose 
the inner logic of the class. Besides this, take into account all the lessons learned from SOLID and the Refactoring presentation.  

You may notice that the published data is very unlike the inner data representation.

The factory method used for creating Snp instances should better be replaced by the **builder pattern**; 
that is an extra challenge for you if you want it.

As Junit testing exercise your could also **create a test suite** covering the public API.