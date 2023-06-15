-- creacion de la base de datos principal
CREATE DATABASE BDProduccion;
-- creacion de la tabla productos donde se almacenara toda la descripcion solicitada




CREATE TABLE productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo_articulo VARCHAR(20),
    tipo VARCHAR(20),
    descripcion VARCHAR(100),
    stock_inicial INT,
    um VARCHAR(10),
    ingresos INT,
    salidas INT,
    stock INT,
    um_stock VARCHAR(10)
);
-- cracion de los Lign para los usuarios y permisos
CREATE TABLE usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  usuario VARCHAR(100) NOT NULL,
  contraseña VARCHAR(100) NOT NULL,
  rol_id INT,
  permisos VARCHAR(255),
  FOREIGN KEY (rol_id) REFERENCES roles(id)
);
-- ------------------------------
CREATE TABLE roles (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  descripcion VARCHAR(255)
);

CREATE TABLE permisos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  descripcion VARCHAR(255)
);

CREATE TABLE roles_permisos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  rol_id INT,
  permiso_id INT,
  FOREIGN KEY (rol_id) REFERENCES roles(id),
  FOREIGN KEY (permiso_id) REFERENCES permisos(id)
);

CREATE TABLE usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  usuario VARCHAR(100) NOT NULL,
  contraseña VARCHAR(100) NOT NULL,
  rol_id INT,
  FOREIGN KEY (rol_id) REFERENCES roles(id)
);
INSERT INTO `BDProduccion`.`usuarios` (`nombre`, `usuario`, `contraseña`) VALUES ('cesar alva', 'admin', 'admin');



ALTER TABLE usuarios ADD COLUMN rol VARCHAR(50);

