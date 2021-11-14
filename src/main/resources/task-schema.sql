drop table if exists `task` CASCADE;
create table
	`task`
(
	id integer AUTO_INCREMENT,
	task varchar(255),
	dateAdded varchar(255),
	dateCompleted varchar(255),
	type varchar(255),
	primary key (id)
);