--Query 4

--Loading customer relation with its attributes and datatypes respectively
customer = LOAD 'customer' AS (cid:chararray, name:chararray, age:int, city:chararray, sex:chararray);

--Loading purchase relation with its attributes and datatypes respectively
purchase = LOAD 'purchase' AS (year:int, cid:chararray, isbn:chararray, seller:chararray, price:int);

--Joining customer and purchase relation by using common attribute cid
A = JOIN customer BY cid, purchase BY cid;

--Filtering relation A to display only Harry Smith
B = FILTER A BY customer::name == 'Harry Smith' ;

--Generating the isbn for the books bought by Harry Smith
C = FOREACH B GENERATE purchase::isbn as isbn;

--Filtering C to find out who bought all the books as bought by Harry Smith excluding Harry Smith.
D = FILTER A BY customer::name != 'Harry Smith' AND purchase::isbn == isbn;

--Joining C and D by isbn
E = JOIN C by isbn, D by purchase::isbn;

--Grouping E By name as respectively to isbn
F = GROUP E BY name;

--Generating the name of each group, that is the name of the people who bought all the books that harry bought.
final = FOREACH F GENERATE group;

--Displaying  and executing output 
DUMP final;
