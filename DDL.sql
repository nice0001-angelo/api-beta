create table code_group(
group_code Char(3) not null
,group_name varchar(30) not null
,use_yn char(1) not null default 'Y'
,reg_date timestamp not null default now()
,upd_date timestamp default now()
,primary key(group_code)
);

create table code_detail(
group_code Char(3) not null
,code_value varchar(3) not null
,code_name varchar(30) not null
,sort_seq int not null
,use_yn char(1) not null default 'Y'
,reg_date timestamp not null default now()
,upd_date timestamp default now()
,primary key(group_code,code_value)
);

create table member(
user_no int(5) auto_increment
,user_id varchar(50) not null
,user_pw varchar(100) not null
,user_name varchar(100) not null
,job varchar(3) not null default '00'
,coin int(10) default 0
,reg_date timestamp not null default now()
,upd_date timestamp default now()
,enabled char(1) default '1'
,primary key(user_no)
);

create table member_auth(
user_no int(5) not null
,auth varchar(50) not null
);

alter table member_auth add constraint fk_member_auth_user_no 
foreign key (user_no) references member(user_no);

create table persistent_logins(
username varchar(64) not null
,series varchar(64) not null
,token varchar(64) not null
,last_used timestamp not null
,primary key(series)
);

create table board(
board_no int not null auto_increment
,title varchar(200) not null
,content text
,writer varchar(50) not null
,reg_date timestamp not null default now()
,primary key(board_no)
);


create table notice(
notice_no int not null auto_increment
,title varchar(200) not null
,content text
,reg_date timestamp not null default now()
,primary key(notice_no)
);

create table item(
item_id int(5) auto_increment
,item_name varchar(20)
,price int(6)
,description varchar(50)
,picture_url varchar(200)
,preview_url varchar(200)
,primary key(item_id)
);


create table user_item(
user_item_no int auto_increment
,user_no int(5) not null
,item_id int(5) not null
,reg_date timestamp default now()
,primary key(user_item_no)
);

create table pds(
item_id int(5) auto_increment
,item_name varchar(20)
,view_cnt int(6) default 0
,description varchar(50)
,primary key(item_id)
);

create table pds_attach(
fullName varchar(150) not null
,item_id int(5) auto_increment
,down_cnt int(6) default 0
,reg_date timestamp default now()
,primary key(fullName)
);


create table charge_coin_history(
history_no int auto_increment
,user_no int(5) not null
,amount int(5) not null
,reg_date timestamp default now()
,primary key(history_no)
);


create table pay_coin_history(
history_no int auto_increment
,user_no int(5) not null
,item_id int(5) not null
,amount int(5) not null
,reg_date timestamp default now()
,primary key(history_no)
);


create table login_log(
log_no int not null auto_increment
,user_no int(5) not null
,user_id varchar(50) not null
,remote_addr varchar(50) not null
,reg_date timestamp default now()
,primary key(log_no)
);


create table access_log(
log_no int not null auto_increment
,request_url varchar(200) not null
,class_name varchar(100) not null
,class_simple_name varchar(50) not null
,method_name varchar(100) not null
,remote_addr varchar(50) not null
,reg_date timestamp default now()
,primaaccess_logry key(log_no)
);


create table performance_log(
log_no int not null auto_increment
,signature_name varchar(50) not null
,signature_type_name varchar(100) not null
,duration_time int default 0
,reg_date timestamp default now()
,primary key(log_no)
);

