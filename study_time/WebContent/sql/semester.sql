drop table semester;
create table semester (sem_id number(3) primary key,semester varchar2(3));
insert into semester values(3,3);
insert into semester values(4,4);
insert into semester values(5,5);
insert into semester values(6,6);
insert into semester values(7,7);
insert into semester values(8,8);
commit;
select * from semester;