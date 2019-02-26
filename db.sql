CREATE DATABASE `outline` /*!40100 DEFAULT CHARACTER SET utf8*/
use outline;
create table goods_info
(
  gid         bigint auto_increment
  comment '商品id'
    primary key,
  goods_key   varchar(100)        not null
  comment '链接outline服务器的key',
  key_port    varchar(10)         not null
  comment '当前key所占用的端口',
  create_time varchar(100)        null
  comment '商品创建时间',
  status      tinyint default '1' not null
  comment '是否已经被使用0代表已经使用',
  uid         bigint              not null
  comment '被谁使用了uid'
)
  charset = utf8;

create table pay_code
(
  pid         bigint                    not null
  comment '支付代码的id'
    primary key,
  pay_code    varchar(100) charset utf8 not null
  comment '支付代码',
  status      tinyint default '1'       not null
  comment '是否被使用',
  create_time varchar(100) charset utf8 not null
  comment '创建时间'
);

create table system_info
(
  sid            bigint default '1' not null
  comment '系统信息表,这张表就一条记录',
  account        varchar(100)       not null
  comment '管理员账号默认admin',
  password       varchar(100)       not null
  comment '管理员密码默认',
  domain         varchar(100)       not null
  comment '绑定的域名',
  email          varchar(100)       not null
  comment '管理员邮箱',
  email_host     varchar(100)       not null
  comment '系统邮件主机',
  email_account  varchar(100)       not null
  comment '发送通知所使用的邮箱账号',
  email_password varchar(100)       not null
  comment '发送通知邮件账号的密码'
)
  charset = utf8;

create table user_info
(
  uid         bigint auto_increment
  comment '用户ID'
    primary key,
  email       varchar(50)                 not null
  comment '用户邮箱登录账户',
  password    varchar(100)                not null
  comment '用户密码加密存储',
  create_time varchar(100)                not null
  comment '用户创建时间',
  now_key     varchar(500) default 'null' not null
  comment '用户当前的链接key',
  due_time    varchar(100)                not null
  comment 'key到期时间',
  status      tinyint default '0'         not null
  comment '当前账户是否启用',
  Invite_code varchar(100)                null
  comment '邀请码',
  update_time varchar(100)                null
  comment '最后一次更新时间'
)
  charset = utf8;

create table user_log
(
  logid       bigint auto_increment
  comment '用户日志表ID'
    primary key,
  login_ip    varchar(100) not null
  comment '用户登录系统的ip',
  uid         bigint       not null
  comment '本条log对应用户id',
  event       varchar(100) not null
  comment '用户操作的事件记录',
  update_time varchar(100) not null
  comment '用户操作时间记录'
)
  charset = utf8;

