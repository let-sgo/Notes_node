drop table login;
create table login (id number(8) primary key,
password varchar2(10));

insert into login values(16118901,'abc123');
insert into login values(16118902,'abc123');
insert into login values(16118903,'abc123');
insert into login values(16118904,'abc123');
insert into login values(16118905,'abc123');
insert into login values(16118906,'abc123');
insert into login values(16118907,'abc123');
insert into login values(16118908,'abc123');
commit;
select * from login;