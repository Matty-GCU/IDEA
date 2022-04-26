create database if not exists javaee_test;
use javaee_test;


# 书架表
alter table book drop constraint book_fk;
drop table if exists book_shelf;
create table book_shelf (
                            id int primary key auto_increment,
                            name varchar(10) not null comment 'category'
);
insert into book_shelf (name)
VALUES ('教材'),('文学'),('生活');


# 书表
drop table if exists book;
create table book (
                      id int primary key auto_increment,
                      name varchar(30) not null comment 'title',
                      price double,
                      author varchar(20) comment 'authorName',
                      number int,
                      shelfId int,
                      constraint book_fk foreign key(shelfId) references book_shelf(id)
);
insert into book(name,price,author,number,shelfId)
values
('Java从入门到精通',73.4,'明日科技',5,1),
('JavaEE零基础入门',63.5,'史胜辉',10,1),('Web前端基础',82.6,'刘兵',5,1),('Vue.js实际与实现',119.8,'霍春阳',8,1),
('sql从入门到精髓',24.9,'陈贻品',6,1),('sql即查即用',73.4,'明日科技',6,1),('你当像鸟飞往你的山',34.8,'塔拉韦斯特弗',4,2),
('心安即是归处',41.8,'季羡林',5,2),('时间从来不语，却回答了所有问题',52.7,'季羡林',5,2),
('马未都讲透唐诗：全三册',189.1,'马未都',3,2),('皮囊',49.8,'蔡宗达',4,2),('月光搂在左手上',58.0,'余秀华',6,2),
('500个侦探推理游戏',16.9,'黄青翔',6,3),('答案之书(我的人生解答书)',32.4,'保罗，酷威文化',5,3),
('猫咪家庭医学大百科',106.2,'林政毅',3,3),('阶梯围棋基本训练',21.3,'张杰',5,3),('有趣得让人睡不着得思维游戏',9.8,'李异鸣',7,3);


# 用户表
drop table if exists user;
create table user (
                      userId int primary key,
                      userName varchar(10)
);
insert into user (userId, userName) VALUES (1, '小吴'), (2, '小张');

# 借书记录表
drop table if exists record;
create table record (
                        userId int,
                        bookId int,
                        date date
);
insert into record (userId, bookId, date)
VALUES
(1, 5, '2022-04-20'),
(1, 3, '2022-04-21'),
(2, 3, '2022-04-22'),
(2, 4, '2022-04-23'),
(2, 10, '2022-04-24');


# 用户借书卡（类似校园卡/会员卡）
drop table if exists borrowCard;
create  table borrowCard (
                             userId int comment '所属用户',
                             code long comment '卡编号'
);
insert into borrowCard
values
(1, 202010098109),
(2, 202011111111),
(3, 202022222222),
(4, 202033333333);