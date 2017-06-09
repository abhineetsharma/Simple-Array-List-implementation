
Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 6/8/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in

Insert into the Array if of complexity O(n)
IndexOf uses binary search and in case of multiple occurrence of a element
the index moves towards the first occurrence of the number
(time complexity Average case for binary search is: log n).
remove uses the indexOf to search the element and remove.
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

