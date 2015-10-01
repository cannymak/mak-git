--Query 2

--Registering the jar that I have to use in this query
REGISTER myudfs.jar;

--Loading customer relation with its attributes and datatypes respectively 
customer = LOAD 'customer' AS (cid:chararray, name:chararray, age:int, city:chararray, sex:chararray);

--Loading purchase relation with its attributes and datatypes respectively
purchase = LOAD 'purchase' AS (year:int, cid:chararray, isbn:chararray, seller:chararray, price:int);

--Joining purchase and customer relations by using common attribute cid 
A = JOIN customer BY cid, purchase BY cid;

--Using my UDF 'Family' for splitting the name attribute and generate only the Last Name and its price
B = FOREACH A GENERATE Family(name) AS name, price AS price;

--Grouping the Last Name
C = group B by name;

--Generating the price for the respective groups
final = FOREACH C GENERATE group, SUM(B.price);

--Executing and Displaying the output
DUMP final;
