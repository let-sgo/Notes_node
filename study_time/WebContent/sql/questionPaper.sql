drop table questionpaper;
create table questionpaper(
id number(20),
sem_id number(20),
domain_name varchar2(40),
sub_code varchar2(40),
subject varchar2(40),
year1 varchar2(15),
filename varchar2(60),
filedata blob
 );
 commit;
 
 select sem_id,domain_name,sub_code,subject,year1,filename from questionpaper;
 alter table  questionpaper add constraint fkk1 foreign key (sem_id) references semester (sem_id);
 alter table  questionpaper add constraint fkk2 foreign key (sub_code) references subject (sub_code);
 
 alter table  questionpaper add constraint pkk1 primary key (sem_id,domain_name,sub_code,year1);