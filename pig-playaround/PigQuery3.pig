--Query 3

--Loading purchase relation with its attributes and datatypes respectively
purchase = LOAD 'purchase' AS (year:int, cid:chararray, isbn:chararray, seller:chararray, price:int);

--Loading book relation with its attributes and datatypes respectively
book = LOAD 'book' AS (isbn:chararray, name:chararray);

--Filtering the seller to display only Amazon
fil1 = FILTER purchase BY seller == 'Amazon';

--Filtering the seller to display other seller apart from Amazon
fil2 = FILTER purchase BY seller != 'Amazon';

--Joining both the filtered output by using isbn as common attribute
join1 = JOIN fil1 BY isbn, fil2 BY isbn;

--Generating two seller attributes, two price attributes and one common isbn attribute from the joined result
gen1 = FOREACH join1 GENERATE fil1::seller AS seller1, fil1::price AS price1, fil1::isbn AS isbn, fil2::seller AS seller2, fil2::price AS price2;

--Splitting the sellers by comparing with Lowest price and Equal price of Amazon and loading in relations A(lowest) and B(Equal)
SPLIT gen1 INTO A IF price1<price2, B IF price1==price2;

--Generating isbn from relation A
gen2 = FOREACH A GENERATE isbn;

--Generating isbn from relation B
gen3 = FOREACH B GENERATE isbn;

--Joining isbn's of relation book and relation gen2
join2 = JOIN gen2 BY isbn, book BY isbn;

--Joining isbn's of relation book and relation gen3
join3 = JOIN gen3 BY isbn, book BY isbn;

--Generating name of the book from relation join2
gen4 = FOREACH join2 GENERATE book::name;

--Generating name of the book from relation join3
gen5 = FOREACH join3 GENERATE book::name;

--Union operation to join both the relations gen4 and gen5
final = UNION gen4, gen5;

--Executing and Displaying the output
DUMP final;


