create table quetionPaper(id number(20),
sem_id number(20),
domain_name varchar2(40),
sub_code varchar2(40),
subject varchar2(40),
year1 date,
filename varchar2(60),
filedata blob
 );
 alter table  quetionPaper add constraint fk1 foreign key (sem_id) references semester (sem_id);
 alter table  quetionPaper add constraint fk2 foreign key (sub_code) references subject (sub_code);
 
 alter table  quetionPaper add constraint pkqp primary key (sem_id,domain_name,sub_code,year1);
 