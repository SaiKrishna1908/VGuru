create table course (id bigint not null auto_increment, name varchar(255), standard integer, primary key (id)) engine=MyISAM
create table hibernate_sequence (next_val bigint) engine=MyISAM
insert into hibernate_sequence values ( 1 )
create table lecture (id bigint not null auto_increment, name varchar(255), url varchar(255), course_id bigint, primary key (id)) engine=MyISAM
create table student (email varchar(255) not null, student_id bigint not null, username varchar(255) not null, admin bit, password varchar(255) not null, standard integer, primary key (email, student_id, username)) engine=MyISAM
create table student_courses (email varchar(255) not null, student_id bigint not null, username varchar(255) not null, course_id bigint not null, primary key (email, student_id, username, course_id)) engine=MyISAM
alter table lecture add constraint FKjoc9yetfohpygdvx5wv385vwb foreign key (course_id) references course (id)
alter table student_courses add constraint FKc614in0kdhj9sih7vw304qxgj foreign key (course_id) references course (id)
alter table student_courses add constraint FKmuoa8nxov0yrswuca6n5tkndf foreign key (email, student_id, username) references student (email, student_id, username)
