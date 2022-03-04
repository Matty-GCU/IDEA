use test;

create table canteen(
                        Cno int(3) primary key auto_increment,
                        Cname varchar(5) not null unique,
                        Cexval double(2,1) unsigned Default 2.0
);

create table stores(
                       Sno int(5) primary key auto_increment,
                       Cno int(3),
                       Sname varchar(10) not null unique,
                       Sexval double(2,1) unsigned default 2.0,
                       constraint Can_con foreign key(Cno) references canteen(Cno)
);

create table dashes(
                       Dno int(5) primary key auto_increment,
                       Sno int(5),
                       Dname varchar(10) not null,
                       Price double(4,2) unsigned,
                       Repertory int(5) unsigned,
                       Flavor varchar(3),
                       Dexval double(2,1) unsigned default 2.00,
                       constraint Sto_sno foreign key(Sno) references Stores(Sno)
);

insert into canteen values(1,'第一饭堂',4);
insert into canteen values(2,'第二饭堂',3);
select * from canteen;

insert into stores values(1,1,'潮汕风味',4);
insert into stores values(2,1,'啫啫堡',3);
insert into stores values(3,2,'酸菜鱼',2);
insert into stores values(4,2,'五谷渔粉',3);
select * from stores;

insert into dashes values(1,1,'招牌肉饼饭',9,500,'咸',4);
insert into dashes values(2,1,'咖哩鸡米饭',11,500,'辣',2);
insert into dashes values(3,2,'黑椒牛柳煲',12,500,'咸',3);
insert into dashes values(4,2,'可乐鸡煲',12,500,'甜',3);
insert into dashes values(5,3,'酸菜无骨鱼',10,500,'酸辣',2);
insert into dashes values(6,3,'柠檬无骨鱼',11,500,'酸',2);
insert into dashes values(7,4,'金汤鱼蛋渔粉',13,500,'辣',4);
insert into dashes values(8,4,'番茄渔粉',12,500,'酸',3);
select * from dashes;

select *
from canteen,stores
where canteen.cno = stores.cno
  and stores.cno=2;
