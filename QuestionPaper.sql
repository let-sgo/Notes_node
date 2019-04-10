create table quetionPaper(id number(20),
sem_id number(20),
domain_name varchar2(40),
sub_code varchar2(40),
subject varchar2(40),
year1 date,
filename varchar2(60),
filedata blob,
primary key (domain_name,sub_code,year1)
 );
 