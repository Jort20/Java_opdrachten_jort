## Functional programming

#### Exercise: Immutable Class Design

As you are probably aware, multicore computing is gaining in importance rapidly. Multithread processing, the way
 multicore computing is often executed, poses a lot of challenges to your design and programming skills. 
 You will be required to protect the state of objects from concurrent modifications by several threads 
 at the same time. One way to do this is the use of the synchronized keyword on blocks or methods. 
 Another is the use of immutable objects.  
 
An object is immutable if its state cannot change after construction. Immutable objects don’t expose any
 way for other objects to modify their state; the object’s fields are initialized only once inside the 
 constructor and never change again - every modification of state results in a new instance of the class. 
 A good example is the String class.  

It is your job to refactor the given User class to guarantee immutability of its instances. 
 This class is located in package `nl.bioinf.functional_programming` of the course repository.  
 
 There are several techniques you have to use to achieve this: use of constructors, cloning objects, using 
 `final` modifier and adjusting the presence of setters.

Create appropriate jUnit tests to demonstrate your design.
