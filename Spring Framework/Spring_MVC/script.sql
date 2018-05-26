create database fresher_training;

use fresher_training;

CREATE TABLE students (
     student_id INT NOT NULL AUTO_INCREMENT,
     fullname CHAR(30) NOT NULL,
     sex CHAR(1) NOT NULL,
     address varchar(100),
     PRIMARY KEY (student_id)
);

insert into students (fullname, sex, address) values ('Nguyen An', 'F', 'Viet Name');
insert into students (fullname, sex, address) values ('Nguyen Hung', 'M', 'Viet Name');

select * from students;

use mysql;
update user set password=PASSWORD("root") where User='root';