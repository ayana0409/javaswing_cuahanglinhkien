/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     25/12/2024 4:25:19 CH                        */
/*==============================================================*/
create database java_cuahanglinhkien;

use java_cuahanglinhkien;

alter table Employee 
   drop foreign key FK_EMPLOYEE_ASSOCIATI_ROLE;

alter table Inventory 
   drop foreign key FK_INVENTOR_ASSOCIATI_PRODUCT;

alter table OrderDetail 
   drop foreign key FK_ORDERDET_ASSOCIATI_PRODUCT;

alter table OrderDetail 
   drop foreign key FK_ORDERDET_ASSOCIATI_ORDERS;

alter table Orders 
   drop foreign key FK_ORDERS_ASSOCIATI_EMPLOYEE;

alter table Orders 
   drop foreign key FK_ORDERS_ASSOCIATI_CUSTOMER;

alter table Product 
   drop foreign key FK_PRODUCT_ASSOCIATI_CATEGORY;

alter table Product 
   drop foreign key FK_PRODUCT_ASSOCIATI_MANUFACT;

drop table if exists Category;

drop table if exists Customer;


alter table Employee 
   drop foreign key FK_EMPLOYEE_ASSOCIATI_ROLE;

drop table if exists Employee;


alter table Inventory 
   drop foreign key FK_INVENTOR_ASSOCIATI_PRODUCT;

drop table if exists Inventory;

drop table if exists Manufacturer;


alter table OrderDetail 
   drop foreign key FK_ORDERDET_ASSOCIATI_PRODUCT;

alter table OrderDetail 
   drop foreign key FK_ORDERDET_ASSOCIATI_ORDERS;

drop table if exists OrderDetail;


alter table Orders 
   drop foreign key FK_ORDERS_ASSOCIATI_EMPLOYEE;

alter table Orders 
   drop foreign key FK_ORDERS_ASSOCIATI_CUSTOMER;

drop table if exists Orders;


alter table Product 
   drop foreign key FK_PRODUCT_ASSOCIATI_CATEGORY;

alter table Product 
   drop foreign key FK_PRODUCT_ASSOCIATI_MANUFACT;

drop table if exists Product;

drop table if exists Role;

/*==============================================================*/
/* Table: Category                                              */
/*==============================================================*/
create table Category
(
   Id                   int not null auto_increment comment '',
   Name                 varchar(254)  comment '',
   primary key (Id)
);

/*==============================================================*/
/* Table: Customer                                              */
/*==============================================================*/
create table Customer
(
   PhoneNumber          varchar(254) not null  comment '',
   Name                 varchar(254)  comment '',
   Address              varchar(254)  comment '',
   primary key (PhoneNumber)
);

/*==============================================================*/
/* Table: Employee                                              */
/*==============================================================*/
create table Employee
(
   Id                   int not null auto_increment comment '',
   Rol_Id               int not null  comment '',
   Name                 tinytext  comment '',
   Birthday             datetime  comment '',
   Gender               tinytext  comment '',
   Address              tinytext  comment '',
   PhoneNumber          tinytext  comment '',
   Status               tinytext  comment '',
   Username             tinytext  comment '',
   Password             tinytext  comment '',
   primary key (Id)
);

/*==============================================================*/
/* Table: Inventory                                             */
/*==============================================================*/
create table Inventory
(
   Id                   int not null  auto_increment comment '',
   Pro_Id               int  comment '',
   ImportDate           datetime  comment '',
   BatchNumber          varchar(254)  comment '',
   Total                float  comment '',
   QuantityImported     int  comment '',
   ImportPrice          float  comment '',
   StockQuantity        int  comment '',
   primary key (Id)
);

/*==============================================================*/
/* Table: Manufacturer                                          */
/*==============================================================*/
create table Manufacturer
(
   Id                   int not null auto_increment comment '',
   Name                 varchar(254)  comment '',
   primary key (Id)
);

/*==============================================================*/
/* Table: OrderDetail                                           */
/*==============================================================*/
create table OrderDetail
(
   Pro_Id               int not null comment '',
   Id                   int not null comment '',
   SalePrice            float  comment '',
   QuantitySold         int  comment '',
   primary key (Pro_Id, Id)
);

/*==============================================================*/
/* Table: Orders                                                */
/*==============================================================*/
create table Orders
(
   Id                   int not null auto_increment comment '',
   Emp_Id               int not null  comment '',
   PhoneNumber          varchar(254) not null  comment '',
   PuchaseDate          datetime  comment '',
   Status               varchar(254)  comment '',
   TotalAmount          float  comment '',
   primary key (Id)
);

/*==============================================================*/
/* Table: Product                                               */
/*==============================================================*/
create table Product
(
   Id                   int not null auto_increment comment '',
   Cat_Id               int not null  comment '',
   Man_Id               int not null  comment '',
   Name                 tinytext  comment '',
   Details              text  comment '',
   Quantity             int  comment '',
   Price                float  comment '',
   Image                tinytext  comment '',
   primary key (Id)
);

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
create table Role
(
   Id                   int not null comment '',
   Name                 varchar(254)  comment '',
   primary key (Id)
);

alter table Employee add constraint FK_EMPLOYEE_ASSOCIATI_ROLE foreign key (Rol_Id)
      references Role (Id);

alter table Inventory add constraint FK_INVENTOR_ASSOCIATI_PRODUCT foreign key (Pro_Id)
      references Product (Id);

alter table OrderDetail add constraint FK_ORDERDET_ASSOCIATI_PRODUCT foreign key (Pro_Id)
      references Product (Id);

alter table OrderDetail add constraint FK_ORDERDET_ASSOCIATI_ORDERS foreign key (Id)
      references Orders (Id);

     
alter table Orders add constraint FK_ORDERS_ASSOCIATI_EMPLOYEE foreign key (Emp_Id)
      references Employee (Id);

     
alter table Orders add constraint FK_ORDERS_ASSOCIATI_CUSTOMER foreign key (PhoneNumber)
      references Customer (PhoneNumber);

     
alter table Product add constraint FK_PRODUCT_ASSOCIATI_CATEGORY foreign key (Cat_Id)
      references Category (Id);

   
alter table Product add constraint FK_PRODUCT_ASSOCIATI_MANUFACT foreign key (Man_Id)
      references Manufacturer (Id);

insert into  java_cuahanglinhkien.`role` (id, Name) values (1, 'Admin');
insert into  java_cuahanglinhkien.`role` (id, Name) values (2, 'Manager');
insert into  java_cuahanglinhkien.`role` (id, Name) values (3, 'Employee');
     
     
     
