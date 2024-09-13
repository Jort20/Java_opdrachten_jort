# jUnit exercise repo

This project serves as starting point for the exercises covering jUnit, as part of the course Application Design.

## Exercises

### jUnit Exercise 1

Create a test class covering the Primer class constructor and methods getGcPercentage and getMeltingTemperature.
 Each tested method should be covered by at least three different test cases: a “sunny day scenario” and two or
 three boundary/illegal usage scenarios. Consider refactoring the original code at some points based on your
 test environment (e.g. maybe you discover some design flaws in the given code when working out the jUnit tests).

### jUnit Exercise 2: Test-driven design

Create a test class first that will test class HomopolymerFilter to be developed.
 So, first create an empty class stub called HomopolymerFilter.java (implementing the PrimerFilter interface!).
 Then create a test class (PrimerFilterTest) covering both methods of the PrimerFilter interface, again
 creating several test cases for each interface method - in particular method isOK() of course.
 After you create the test class, you can implement the Filter itself. When it passes all PrimerFilterTest
 test cases, you are done. Compare and discuss your results with a colleague.
 
 As an **extra challenge or workout** (you may want to revisit this exercise later), create some other filter
  classes you think are appropriate, create tests covering the relevant methods and implement the Filter pattern.

### jUnit Exercise 3

Given the Line.java class, create a test class covering the getSlope, getDistance and parallelTo
methods. Each test should contain three different test cases.
Because of rounding errors, it is bad practice to test double values for exact equality (actually,
this type of test is deprecated). To get around this, you can pass a small value (such as .0001 or 1E-15)
to assertEquals to be used as a delta.
(Exercise copied from http://cs.umw.edu/~finlayson/class/fall13/cpsc330/labs/13-testing1.html)

### jUnit Exercise 4: test with parameters

Create a new Primer test class that you can use to perform parameterized tests on method `getGcPercentage()`.
 Create na set of 5 primers to be tested automatically.

### jUnit Exercise 5: Test-driven design 2

For this lab, you will write a class for representing a sphere. You will also write a unit test for the class.
 Following the idea of test-driven development, you will write the unit test first.
 The sphere should store its radius, and have methods for computing the surface area and volume.

1.	Start by creating a unit test class, perhaps called SphereTest.
2.	Add test cases for testing the sphere's volume and surface area with a few tests.
3.	Once the test is written, work on implementing the Sphere class.
4.	When the test case passes, you're done.

(Exercise copied from http://cs.umw.edu/~finlayson/class/fall13/cpsc330/labs/14-testing2.html)

### jUnit Exercise 6: Test suite

Class `Protein` is a class with two public methods: `setSequence(String sequence)` and
`getAminoAcidFraction(char aminoAcid)`. Most code has already been implemented.

It is your task to create test cases that cover both methods to ensure test coverage of both
sunny-day scenarios and boundary cases. All tests should pass when you're finished. Therefore, you may have to adjust
the existing code to make this happen.
You should use the following techniques when relevant:  

- Class and/or test case setup code,
- Parameterized tests,
- Various test annotations   
