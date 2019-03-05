Name: Linzan Ye
NetID: lye11
Email: lye11@u.rochester.edu
Date: March 4, 2019

Collaboration: Mathew Taruno
NetID: mtaruno

HOW TO BUILD THIS PROJECT

The most difficult part of this project is to create the correct levels of abstraction of the classes, and translate the backtracking algorithm found in the textbook into code. Because of this, we were very conscious of the naming of our variables and organization of methods, to keep the structure of our coding as clear as possible.

Very briefly, our structure is as follows.

We have 6 main classes : 
* Relation
* Constraint
* CSP
* Solver
* Variable
* CSPApplication : This is the class to run to see the output solutions for all the CSP problems, and where all the class specific CSP problems are run

Our sub classes include :

These are subclasses of the CSP class, where we specifically define all the variables required (so for n-queens problem it will be q1, q2, ... ,q8) and connect them to their respective relations and constraints - specific to the problem being worked on (hence the subclass structure)

* AusCSP, JobCSP, QueenCSP

These are subclasses of the Relation class where we define the constraints that we need for each specific problem, which has specific methods overridden from the Relation class and new variables defined:
* AusRelation, DConstraint (for disjunctive constraint), PConstraint (for precedence constraint), QRelation 

These are the subclasses of the Variable class, where we define the domain, assignment, and name of the variable:
* AusVariable, JobVariable, QueenVariable


HOW TO RUN THE PROGRAM TO GET THE SOLUTIONS

Please run the CSPApplication.java class
- Make sure that all of the classes are present in the project package


Comments are available throughout the code that show what is going on on a deeper level. On top of that, the variable names and the way we structured the code was consciously made so that it would make it as self-explanatory as possible.


