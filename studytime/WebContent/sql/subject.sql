drop table subject;
create table subject (sub_code varchar2(8) primary key,subject varchar2(100));
insert into  subject values('IT301','CM');
insert into  subject values('IT302','Basic Electronic');
insert into  subject values('IT303','DS');
insert into  subject values('IT304','M3');
insert into  subject values('IT305','OOPS');
insert into  subject values('IT306','DELD');
insert into  subject values('IT401','SMP');
insert into  subject values('IT402','Discrete Maths');
insert into  subject values('IT403','Computer Organization');
insert into  subject values('IT404','PCS');
insert into  subject values('IT405','TOC');
insert into  subject values('IT406','Operating System');
insert into  subject values('IT501','CN');
insert into  subject values('IT502','DAA');
insert into  subject values('IT503','Microprocessor');
insert into  subject values('IT504','DBMS');
insert into  subject values('IT505','Computer Graphics');
insert into  subject values('IT506','E-Commerce');
insert into  subject values('IT601','Compiler Design');
insert into  subject values('IT602','ITC');
insert into  subject values('IT603','IWT');
insert into  subject values('IT604','CMC');
insert into  subject values('IT605','Software Engineering');
insert into  subject values('IT606','NNFL');
insert into  subject values('IT701','MIS');
insert into  subject values('IT702','AI and Expert System');
insert into  subject values('IT703','Elective 1');
insert into  subject values('IT704','Elective 2');
insert into  subject values('IT801','Data Mining and Ware-Housing');
insert into  subject values('IT802','Cryptography');
insert into  subject values('IT803','Elective 1');
insert into  subject values('IT804','Elective 2');
commit;
select * from subject;