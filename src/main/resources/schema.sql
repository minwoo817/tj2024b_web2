-- ---------------------- day08 ---------------------------------- --
DROP TABLE if EXISTS productsample;
create table productsample(
   id int auto_increment ,
    name varchar(20) ,
    price int ,
    comment longtext ,
    constraint primary key ( id )
);
-- ---------------------- ------ ---------------------------------- --