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
);

CREATE TABLE SaleDetail(
	idSaleDetail SMALLINT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	idSale SMALLINT FOREIGN KEY REFERENCES Sale(idSale) NOT NULL,
	idProduct SMALLINT FOREIGN KEY REFERENCES Product(idProduct) NOT NULL,
	Quantity SMALLINT NOT NULL,
);

INSERT INTO Users VALUES('admin','admin','Luis','Quiroz Burga','luisquiroz@synapsesystems.tech','Av. La Merced 1015 G-504',980655030, 'A');
INSERT INTO Users VALUES('user','user','Apruebeme','Profesor Porfavor','apruebeme_profe@porfavor.com','Av. Vivolejos 112', 999988656, 'U');

INSERT INTO Product VALUES('P0001', 'Jarrón Colonial', '1', 50.50, 10, 'N');
INSERT INTO Product VALUES('P0002', 'Bolsas Plásticas', '100x1', 1.50, 2, 'N');
INSERT INTO Product VALUES('P0003', 'Lechuza de Harry Potter', '1', 250.90, 4, 'N');
INSERT INTO Product VALUES('P0004', 'Celular Motorola', '1', 499.90, 5, 'N');

INSERT INTO Client VALUES('C0001', 'Pepito', 'Aquiles Parto', '2018-11-15', 'N');
INSERT INTO Client VALUES('C0002', 'Juancito', 'Vaca Negra', '2018-11-11', 'N');
INSERT INTO Client VALUES('C0003', 'Panchito', 'De Las Jatos', '2018-12-11', 'N');
INSERT INTO Client VALUES('C0004', 'Luchito', 'EL Rojo', '2018-10-12', 'N');

INSERT INTO Sale VALUES(2, 1, 'V0001', '2018-11-11',20.0);
INSERT INTO Sale VALUES(2, 2, 'V0002', '2018-05-11',10.0);
INSERT INTO Sale VALUES(2, 2, 'V0003', '2018-04-04',24.0);
INSERT INTO Sale VALUES(2, 3, 'V0004', '2018-10-25',22.0);
INSERT INTO Sale VALUES(2, 4, 'V0004', '2018-10-28',22.0);
INSERT INTO Sale VALUES(2, 4, 'V0004', '2018-10-29',51.50);

INSERT INTO SaleDetail VALUES(1, 1, 1);
INSERT INTO SaleDetail VALUES(1, 2, 2);
INSERT INTO SaleDetail VALUES(1, 3, 3);
INSERT INTO SaleDetail VALUES(1, 4, 4);
INSERT INTO SaleDetail VALUES(2, 1, 5);
INSERT INTO SaleDetail VALUES(2, 2, 6);
INSERT INTO SaleDetail VALUES(2, 3, 7);
INSERT INTO SaleDetail VALUES(2, 4, 8);


SELECT * FROM Users;
SELECT * FROM Product;
SELECT * FROM Client;
SELECT * FROM Sale;
SELECT * FROM SaleDetail;