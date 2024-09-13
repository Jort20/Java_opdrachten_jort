# Introduction to programming with Java #

This is the assignments and code demo repository for the courses Java of bioinformatics.
We will be using IntelliJ Idea as IDE.   
You need a licence for this IDE, but these are free for students of registered educational institutes.

### What is this repository for?

* Project with assignments and JUnit tests that can check your solutions.
* Code demos for the lectures.
* &copy; copyright Michiel Noback, Hanze University of Applied Sciences 2015-2024

### How do I get set up?

* **Clone** this repository to your local computer. 

* **Open** the project in IntelliJ (simply select the folder and follow the steps of the wizard - if any are required).
 You may need to configure the Java Development Kit (SDK/JDK), via the Project Structure dialog:  
    - File &rarr; Project Structure &rarr; SDKs (use /usr/local/jdk&lt;CURRENT VERSION&GT;)

* Start working on the assignments, as specified in the sequentially organized packages under `src/main/java/`. 
The [course program](https://michielnoback.github.io/bincourses/course_contents/java_intro/course_program.html) 
tells you which assignment to make at which point of the course. 

* Make sure you read the contents of the `Readme.md` Markdown file located within each package. 
* These outline the details of that particular assignment (IntelliJ provides a nice HTML preview for Markdown). 

* Three alternatives are available to test your solution of a single exercise (method), or a whole class:  
    - Select the method or class name in the editor &rarr; Right click &rarr; Go To &rarr; Test (or simply select the Test class in `src/test/java/`).
    - You can run individual test methods by opening the test class in the editor and clicking on the small green 
     triangle within the editor margin next to the method name. 
    - Alternatively, in the test class, right-click anywhere and select "Run ...". 

* To test all your work so far: Select `src/test/java/` in the Project panel, 
  right-click and select "Run 'All Tests'". 
    - The Gradle task `verification/test` will do the same (Gradle Tool Window on the right).

* The test view will open and all selected tests will run. The orange and red symbols indicate failures 
  while green shows you solved the assignment correctly. 
  Beware, test methods are really picky so a space too many or a lowercase letter where an uppercase 
  is expected will lead to a failed test!  

### Keyboard shortcuts
It will make you much more productive if you try to learn the most important keyboard shortcuts. 
Check out the keyboard shortcuts for IntelliJ 
[here](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf).
My personal favorites are [here](https://michielnoback.github.io/java_book/keyboard_shortcuts.html)

