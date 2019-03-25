drop table notes;
create table notes (
sno number(8) primary key,
id number(8),
sem_id number(3),
sub_code varchar2(8),
subject varchar2(100),
file_name varchar2(100),
file_data blob,
uploaded varchar2(5) default 'false');
insert into notes(sno,id,sem_id,sub_code,subject,file_name,file_data) values((select nvl(max(sno),0) + 1 from notes),'16118901',6,'IT602','ITC','itc_notes',null);
commit;
select sno,id,sem_id,sub_code,subject,file_name,uploaded from notes;