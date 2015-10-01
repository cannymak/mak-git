--Query 1

--Loading purchase table with its attributes and datatypes respectively
purchase = LOAD 'purchase' AS (year:int,cid:chararray,isbn:chararray,seller:chararray,price:int);

A = GROUP purchase BY seller;--Grouping purchase table by Seller

--Generating the prices of each seller in each group
final = FOREACH A GENERATE group, SUM(purchase.price);

--Displaying and Executing the output
DUMP final;

