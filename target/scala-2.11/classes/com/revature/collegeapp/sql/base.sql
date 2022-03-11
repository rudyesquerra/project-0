drop database if exists college;
create database college;
use college;
drop table if exists students;
drop table if exists courses;
create table courses(
    id int auto_increment primary key,
    courseName varchar(20) not null,
    professor varchar(20) not null,
    doWeek enum('Monday','Tuesday','Wednesday','Thursday','Friday','Saturday'), -- An enumeration refers to a group of named constants
    shift enum('Morning','Evening','Night')
);
create table students(
    studentId int auto_increment primary key,
    firstName varchar(25) not null,
    lastName varchar(25) not null,
    age int,
    courseId int not null
);
alter table students
    add constraint FK_students_courseId
    foreign key(courseId)
    references courses(id);