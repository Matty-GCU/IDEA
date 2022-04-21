drop database if exists javaee;
create database javaee;

use javaee;
-- 书架表
create table bookshelf(
    bname varchar(10) not null,
    id int PRIMARY KEY AUTO_INCREMENT
    );
insert into bookshelf(bname) values ('教材'),('文学'),('生活');
select * from bookshelf;

-- 书本表;
create table book (
    name varchar(20) NOT NULL,
    id int PRIMARY KEY AUTO_INCREMENT,
    price double ,
    author varchar(20),
    number int ,
    shelfid int ,
    CONSTRAINT FOREIGN KEY(shelfid) REFERENCES bookshelf(id)
    );
insert into book(name,price,author,number,shelfid) values ('Java从入门到精通',73.4,'明日科技',5,1),
    ('JavaEE零基础入门',63.5,'史胜辉',10,1),('Web前端基础',82.6,'刘兵',5,1),('Vue.js实际与实现',119.8,'霍春阳',8,1),
    ('sql从入门到精髓',24.9,'陈贻品',6,1),('sql即查即用',73.4,'明日科技',6,1),('你当像鸟飞往你的山',34.8,'塔拉韦斯特弗',4,2),
    ('心安即是归处',41.8,'季羡林',5,2),('时间从来不语，却回答了所有问题',52.7,'季羡林',5,2),
    ('马未都讲透唐诗：全三册',189.1,'马未都',3,2),('皮囊',49.8,'蔡宗达',4,2),('月光搂在左手上',58.0,'余秀华',6,2),
    ('500个侦探推理游戏',16.9,'黄青翔',6,3),('答案之书(我的人生解答书)',32.4,'保罗，酷威文化',5,3),
    ('猫咪家庭医学大百科',106.2,'林政毅',3,3),('阶梯围棋基本训练',21.3,'张杰',5,3),('有趣得让人睡不着得思维游戏',9.8,'李异鸣',7,3);
select * from book;

-- 借书卡表
create table borrowerCard(
	id int(10) not null auto_increment,
    code varchar(10),
    primary key(id)
);
insert into borrowerCard(code) values ('001'),('002'),('003'),('004'),('005'),('006'),('007'),('008'),('009'),('010');
-- 用户表 
create table user(
	uid int(10) not null auto_increment,
    uname varchar(20),
    borrowerCard_id int(10) not null,
    primary key(uid),
    constraint borrowerCard_id foreign key(borrowerCard_id) references borrowerCard (id)
);

insert into user(uname,borrowerCard_id) values('范保佳',1),('李佳玲',2),('张甜甜',3),('张熙',4),('蒋沁怡',5),
	('邱雷超',6),('古春方',7),('李臻',8),('李萍',9),('贾柳林',10);
    
-- 借书单
create table borrowerList(
	id int(10) not null auto_increment,
    user_id int(10) default null,
    book_id int(10) default null,
    primary key(id),
    constraint user_id foreign key(user_id) references user(uid),
    constraint book_id foreign key(book_id) references book(id)
);
insert into borrowerList(user_id,book_id) values(1,1),(1,2),(1,3),(4,4),(5,5),(6,6),(7,7),(8,8),(9,9),(10,10);