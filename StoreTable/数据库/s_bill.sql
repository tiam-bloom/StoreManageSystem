/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.12 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `s_bill` (
	`id` int (20),
	`name` varchar (60),
	`cname` varchar (60),
	`amountb` int (20),
	`time` varchar (60),
	`price` int (20)
); 
insert into `s_bill` (`id`, `name`, `cname`, `amountb`, `time`, `price`) values('3','apple','王六','21','2021-06-18','1200');
insert into `s_bill` (`id`, `name`, `cname`, `amountb`, `time`, `price`) values('11','笔记本','李华','11','2021-06-01','6999');
insert into `s_bill` (`id`, `name`, `cname`, `amountb`, `time`, `price`) values('83','鞠婧祎','改变','98','2021-08-11','99999');
insert into `s_bill` (`id`, `name`, `cname`, `amountb`, `time`, `price`) values('86','Dell ','小胖','3','2021-06-18','12000');
insert into `s_bill` (`id`, `name`, `cname`, `amountb`, `time`, `price`) values('87','iPhone 12','马欢','4','2021-06-09','6920');
insert into `s_bill` (`id`, `name`, `cname`, `amountb`, `time`, `price`) values('89','奥利给','八哥','21','2021-07-11','1200');
