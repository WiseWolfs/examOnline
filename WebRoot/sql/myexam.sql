/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/3/9 16:43:52                            */
/*==============================================================*/


drop table if exists blankchp;

drop table if exists blankdiff;

drop table if exists blankinfo;

drop table if exists paper;

drop table if exists selectchp;

drop table if exists selectdiff;

drop table if exists selectinfo;

drop table if exists user;

/*==============================================================*/
/* Table: blankchp                                              */
/*==============================================================*/
create table blankchp
(
   id                   int not null,
   chp_r                double,
   chp                  varbinary(20),
   primary key (id)
);

/*==============================================================*/
/* Table: blankdiff                                             */
/*==============================================================*/
create table blankdiff
(
   id                   int not null,
   d1_r                 double,
   d2_r                 double,
   d3_r                 double,
   d4_r                 double,
   primary key (id)
);

/*==============================================================*/
/* Table: blankinfo                                             */
/*==============================================================*/
create table blankinfo
(
   id                   int not null,
   timu                 varbinary(20),
   ans                  varbinary(20),
   chp                  int,
   diff                 int,
   primary key (id)
);

/*==============================================================*/
/* Table: paper                                                 */
/*==============================================================*/
create table paper
(
   id                   int not null,
   paper_user           varbinary(10),
   blank_num            int,
   operate_num          int,
   select_num           int,
   select_value         int,
   operate_value        int,
   blank_value          int,
   paper_type           int,
   primary key (id)
);

/*==============================================================*/
/* Table: selectchp                                             */
/*==============================================================*/
create table selectchp
(
   id                   int not null,
   chp                  varbinary(20),
   chp_r                double,
   primary key (id)
);

/*==============================================================*/
/* Table: selectdiff                                            */
/*==============================================================*/
create table selectdiff
(
   id                   int not null,
   d1_r                 double,
   d2_r                 double,
   d3_r                 double,
   d4_r                 double,
   primary key (id)
);

/*==============================================================*/
/* Table: selectinfo                                            */
/*==============================================================*/
create table selectinfo
(
   timu_id              int not null,
   timu                 varbinary(100),
   ans                  varbinary(100),
   a                    varbinary(100),
   b                    varbinary(100),
   c                    varbinary(100),
   d                    varbinary(100),
   chp                  int,
   diff                 int,
   primary key (timu_id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   uid                  varbinary(10),
   password             varbinary(10),
   status               int,
   name                 varbinary(20),
   banji                varbinary(20),
   yuanxi               varbinary(20),
   finals               double,
   refinals             double,
   ispass               int
);

insert into user values('admin','admin',1,'admin','','',0,0,0);