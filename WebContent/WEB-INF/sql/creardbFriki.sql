create database dbFriki;

use dbFriki;

create table articulos (
  id_articulo int primary key,
  nombre varchar(30),
  descripcion varchar(80),
  precio double not null,
  stock int not null,
  categoria varchar(30) not null,
  tipo_de_producto varchar(30),
  novedad tinyint(1),
  imagen varchar(120)  
);

create table categorias (
  id_categoria int primary key,
  nombre varchar(30),
  descripcion varchar(80)
);

create table tiposProducto (
  id_tipoProducto int primary key,
  nombre varchar(30),
  descripcion varchar(80)
);

create table pedidos (
  id_pedido int primary key,
  id_cliente int,
  fecha date,
  total_a_pagar double,
  estado varchar(15)
);

create table usuariosCliente (
	id_usuario int primary key,
	nombre varchar(30),
	contrasenya varchar(30),
	dir_postal varchar(100),
	email varchar(50),
	telefono int
);

create table usuariosAdministrador(
	id_usuario int primary key,
	email varchar(50),
	contrasenya varchar(30),
	rol varchar(30)
);

create table roles(
	id_rol int primary key,
	nombre varchar(30)
);

create table lineasPedido(
	id_pedido int,
	id_articulo int,
	cantidad int,
	precio double,
	primary key (id_pedido,id_articulo)
);

alter table pedidos add foreign key fk_id_cliente(id_cliente) references usuariosCliente(id_usuario) on update restrict on delete restrict;

alter table lineasPedido add foreign key fk_id_pedido(id_pedido) references pedidos(id_pedido) on update restrict on delete restrict;
alter table lineasPedido add foreign key fk_id_articulo(id_articulo) references articulos(id_articulo) on update restrict on delete restrict;


INSERT INTO categorias VALUES ('1','Series','Artículo relacionados con una Serie');
INSERT INTO categorias VALUES ('2','Peliculas','Artículo relacionados con una Película');
INSERT INTO categorias VALUES ('3','Otros','Artículo sin vinculación clara');

INSERT INTO tiposProducto VALUES ('1','Ropa','Prendas de ropa');
INSERT INTO tiposProducto VALUES ('2','Peluches','Peluches varios');
INSERT INTO tiposProducto VALUES ('3','Otros','Producto sin vinculación clara');

INSERT INTO articulos VALUES ('1','Camiseta Star Wars','Camiseta Star Wars Episodio1 Talla XL','20.3','12','Series','Ropa','0','img\CamisetaStarWars.jpg');
INSERT INTO articulos VALUES ('2','Camiseta Juego de Tronos','Camiseta Juego de Tronos Winter Talla XL','24.5','30','Series','Ropa','1','img\CamisetaJuegoTronos.jpg');
INSERT INTO articulos VALUES ('3','Peluche Dragón Desdentado','Peluche Desdentado Pelicula Cómo Entrenar a tu Dragón','35.0','6','Peliculas','Peluches','0','img\PelucheDesdentado.jpg');

INSERT INTO usuariosCliente VALUES('1','dkampi73@gmail.com','dkampi','Rue del Percebe,13','dkampi73@gmail.com','645238596');
INSERT INTO usuariosCliente VALUES('2','quermd@gmail.com','quermd','Avda.Diagonal, 91','quermd@gmail.com','648892536');
INSERT INTO usuariosCliente VALUES('3','edmauri@gmail.com','edmauri','Avda.Meridiana, 365','edmauri@gmail.com','637856891');

INSERT INTO pedidos VALUES ('1','3','2015-05-20','114.8','pagado');
INSERT INTO pedidos VALUES ('2','1','2015-05-21','24.5','pdte. de cobro');
INSERT INTO pedidos VALUES ('3','2','2015-05-22','75.6','pagado');

INSERT INTO lineasPedido VALUES('1','1','1','20.3');
INSERT INTO lineasPedido VALUES('1','2','1','24.5');
INSERT INTO lineasPedido VALUES('1','3','2','70.0');
INSERT INTO lineasPedido VALUES('2','2','1','24.5');
INSERT INTO lineasPedido VALUES('3','1','2','40.6');
INSERT INTO lineasPedido VALUES('3','3','1','35.0');

INSERT INTO roles VALUES('1','Admin_total');
INSERT INTO roles VALUES('2','Admin_parcial');
INSERT INTO roles VALUES('3','Ventas');

INSERT INTO usuariosAdministrador VALUES('1','admin1','dkampi','Admin_total');
INSERT INTO usuariosAdministrador VALUES('2','admin2','quermd','Admin_total');
INSERT INTO usuariosAdministrador VALUES('3','admin3','edmauri','Admin_parcial');



