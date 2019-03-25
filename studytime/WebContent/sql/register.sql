drop table register;
create table register (id number(8) references login(id),
fname varchar2(10),
lname varchar2(10),
email varchar2(30));

insert into register values(16118901,'akash','verma','tanugauraha172@gmail.com');
insert into register values(16118902,'akash','verma','tanugauraha172@gmail.com');
insert into register values(16118903,'akash','verma','tanugauraha172@gmail.com');
insert into register values(16118904,'akash','verma','tanugauraha172@gmail.com');
insert into register values(16118905,'akash','verma','tanugauraha172@gmail.com');
insert into register values(16118906,'akash','verma','tanugauraha172@gmail.com');
insert into register values(16118907,'akash','verma','tanugauraha172@gmail.com');
insert into register values(16118908,'akash','verma','tanugauraha172@gmail.com');
commit;
select * from register;