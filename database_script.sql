USE master;
GO
CREATE DATABASE FinalSolWeb;
GO
USE FinalSolWeb;
GO
CREATE TABLE Users(
	idUser SMALLINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	username VARCHAR(45) NOT NULL,
	password VARCHAR(45) NULL,
	firstname VARCHAR(45) NOT NULL,
	lastname VARCHAR(45) NULL, 
	email VARCHAR(45) NULL, 
	address VARCHAR(45) NULL, 
	phone INT NULL,
	typeUser CHAR(1) NULL,
	active CHAR(1) NULL,
);
CREATE TABLE Product(
	idProduct SMALLINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	ProductCode CHAR(5) NOT NULL,
	ProductName VARCHAR(40) NOT NULL,
	QuantityPerUnit VARCHAR(20) NOT NULL,
	UnitPrice DECIMAL(10,2) NOT NULL,
	UnitsInStock SMALLINT NOT NULL,
	Discontinued CHAR(1) NOT NULL,
);
CREATE TABLE Client(
	idClient SMALLINT PRIMARY KEY IDENTITY(1,1),
	ClientCode CHAR(5) NOT NULL,
	FirstName VARCHAR(40) NOT NULL,
	LastName VARCHAR(40) NOT NULL,
	RegisterDate DATE NOT NULL,
	Discontinued CHAR(1) NOT NULL,
);
CREATE TABLE Sale(
	idSale SMALLINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	idUser SMALLINT FOREIGN KEY REFERENCES Users(idUser) NOT NULL,
	idClient SMALLINT FOREIGN KEY REFERENCES Client(idClient) NOT NULL,
	SaleCode CHAR(5) NOT NULL,
	SaleDate DATE NOT NULL,
	Total DECIMAL(10,2) NOT NULL,
	Deleted CHAR(1) NOT NULL,
);

CREATE TABLE SaleDetail(
	idSaleDetail SMALLINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	idSale SMALLINT FOREIGN KEY REFERENCES Sale(idSale) NOT NULL,
	idProduct SMALLINT FOREIGN KEY REFERENCES Product(idProduct) NOT NULL,
	Quantity SMALLINT NOT NULL,
);

INSERT INTO Users VALUES('admin','admin','Luis','Quiroz Burga','luisquiroz@synapsesystems.tech','Av. La Merced 1015 G-504',980655030, 'A', 'Y');
INSERT INTO Users VALUES('user','user','Apruebeme','Profesor Porfavor','apruebeme_profe@porfavor.com','Av. Vivolejos 112', 999988656, 'U', 'Y');

INSERT INTO Product VALUES('P0001', 'Azucar', '1kg', 3.00, 12, 'N');
INSERT INTO Product VALUES('P0002', 'Arroz', '1kg', 4.50, 8, 'N');
INSERT INTO Product VALUES('P0003', 'Aceite', '1L', 6.90, 10, 'N');
INSERT INTO Product VALUES('P0004', 'Fideos', '500g', 1.80, 13, 'N');
INSERT INTO Product VALUES('P0005', 'Leche Condensada', '390g', 3.99, 6, 'N');
INSERT INTO Product VALUES('P0006', 'Conserva', '820g', 5.70, 5, 'N');
INSERT INTO Product VALUES('P0007', 'Avena Premiun', '1kg', 6.29 ,9, 'N');
INSERT INTO Product VALUES('P0008', 'Atun', '175g', 5.00, 7, 'N');
INSERT INTO Product VALUES('P0009', 'Yogurt', '966ml', 5.80, 10, 'N');
INSERT INTO Product VALUES('P0010', 'Vinagre', '500ml', 5.30, 7, 'N');
INSERT INTO Product VALUES('P0011', 'Sillao', '85ml', 2.80, 10, 'N');
INSERT INTO Product VALUES('P0012', 'Sal', '500gr', 1.50, 6, 'N');
INSERT INTO Product VALUES('P0013', 'Mermelada', '400g', 4.80, 10, 'N');
INSERT INTO Product VALUES('P0014', 'Manteguilla', '200g', 4.39, 12, 'N');
INSERT INTO Product VALUES('P0015', 'Queso', '100g',4.60 ,6, 'N');
INSERT INTO Product VALUES('P0016', 'Jamon', '100g', 3.99, 7, 'N');
INSERT INTO Product VALUES('P0017', 'cafe soluble', '750g', 15.00, 9, 'N');
INSERT INTO Product VALUES('P0018', 'Ecco', '750g', 8.00, 13, 'N');
INSERT INTO Product VALUES('P0019', 'Harina', '1kg', 499.90, 5, 'N');
INSERT INTO Product VALUES('P0020', 'Huevo', '1', 0.50, 2, 'N');
INSERT INTO Product VALUES('P0021', 'Pomarola', '200g', 2.50, 11, 'N');
INSERT INTO Product VALUES('P0022', 'Lavavajillas', '900g', 5.60, 7, 'N');
INSERT INTO Product VALUES('P0023', 'Cereal', '220g', 4.90, 5, 'N');
INSERT INTO Product VALUES('P0024', 'Detergente', '250g', 5.90, 13, 'N');
INSERT INTO Product VALUES('P0025', 'Suavitel', '1L', 9.80, 4, 'N');
INSERT INTO Product VALUES('P0026', 'Shampoo', '400g', 28.00, 7, 'N');
INSERT INTO Product VALUES('P0027', 'Acondicionador', '400g',28.00, 10, 'N');
INSERT INTO Product VALUES('P0028', 'Paños Húmedos', '600g', 11.90, 5, 'N');
INSERT INTO Product VALUES('P0029', 'Papel Higienico', '1', 1.00, 12, 'N');
INSERT INTO Product VALUES('P0030', 'Pasta Dental', '75g', 9.80, 5, 'N');
INSERT INTO Product VALUES('P0031', 'Jabón', '125g', 4.30, 8, 'N');
INSERT INTO Product VALUES('P0032', 'Lejía', '3L', 6.20, 6, 'N');

INSERT INTO Client VALUES('C0001', 'Cliente', 'Estandar', '2018-11-15', 'N');
INSERT INTO Client VALUES('C0002', 'Juancito', 'Vaca Negra', '2018-11-11', 'N');
INSERT INTO Client VALUES('C0003', 'Panchito', 'De Las Jatos', '2018-12-11', 'N');
INSERT INTO Client VALUES('C0004', 'Luchito', 'EL Rojo', '2018-10-12', 'N');

INSERT INTO Sale VALUES(1, 1, 'V0001', '2018-11-11',20.0,'N');
INSERT INTO Sale VALUES(2, 2, 'V0002', '2018-05-11',10.0,'N');
INSERT INTO Sale VALUES(1, 2, 'V0003', '2018-04-04',24.0,'N');
INSERT INTO Sale VALUES(1, 3, 'V0004', '2018-10-25',22.0,'N');
INSERT INTO Sale VALUES(2, 4, 'V0005', '2018-10-28',22.0,'N');
INSERT INTO Sale VALUES(2, 4, 'V0006', '2018-10-29',51.50,'N');

INSERT INTO SaleDetail VALUES(1, 1, 1);
INSERT INTO SaleDetail VALUES(1, 2, 2);
INSERT INTO SaleDetail VALUES(1, 3, 3);
INSERT INTO SaleDetail VALUES(1, 4, 4);
INSERT INTO SaleDetail VALUES(2, 1, 5);
INSERT INTO SaleDetail VALUES(2, 25, 6);
INSERT INTO SaleDetail VALUES(2, 3, 7);
INSERT INTO SaleDetail VALUES(2, 4, 8);
INSERT INTO SaleDetail VALUES(3, 11, 11);
INSERT INTO SaleDetail VALUES(3, 4, 12);
INSERT INTO SaleDetail VALUES(4, 12, 1);
INSERT INTO SaleDetail VALUES(4, 3, 2);
INSERT INTO SaleDetail VALUES(5, 13, 2);
INSERT INTO SaleDetail VALUES(5, 14, 12);
INSERT INTO SaleDetail VALUES(6, 21, 20);

SELECT * FROM Users;
SELECT * FROM Product;
SELECT * FROM Client;
SELECT * FROM Sale;
SELECT * FROM SaleDetail;


