drop table roll_no;
create table roll_no (sno number(4) primary key,
id number(8));
--select nvl(max(sno),0)+1 from roll_no;
insert into roll_no values(1,16118901);
insert into roll_no values(2,16118902);
insert into roll_no values(3,16118903);
insert into roll_no values(4,16118904);
insert into roll_no values(5,16118905);
insert into roll_no values(6,16118906);
insert into roll_no values(7,16118907);
insert into roll_no values(8,16118908);
insert into roll_no values(9,16118909);
insert into roll_no values(10,16118910);
commit;
select * from roll_no;