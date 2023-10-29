create database Control2BD;
use Control2BD;
create table Producto(
id int primary key auto_increment,
nombre varchar(30),
descripcion varchar(30),
cantidad int,
fecha_venc date
);
insert into Producto values (null,'producto1','descripcion1',4,'2023-10-27'),(null,'producto2','descripcion2',2,'2023-11-27'),
(null,'producto3','descripcion3',4,'2024-09-27'),(null,'producto4','descripcion4',14,'2024-12-27'),(null,'producto4','descripcion4',14,'2024-12-27');

