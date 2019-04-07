drop table roll_no;
create table roll_no (
id number(8),
year number(1),
isSlider varchar2(1)
);
--select nvl(max(sno),0)+1 from roll_no;

insert into roll_no values(16118901,3,'y');
insert into roll_no values(16118902,3,'y');
insert into roll_no values(16118903,3,'y');
commit;
select * from roll_no;