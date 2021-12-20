

CREATE TABLE Bicycles1 (
    id SERIAL NOT NULL PRIMARY KEY,
	brand VARCHAR(100) NOT NULL,
	description varchar (255) NOT null
	
);

CREATE TABLE Orders1(
	orderId SERIAL NOT NULL,
	Order_Date VARCHAR(30) NOT NULL,
	OrderNumber VARCHAR NOT NULL,
	Id int,
	PRIMARY KEY (OrderId),
    CONSTRAINT FK_bicycleOrder FOREIGN KEY (id)
    REFERENCES Bicycles1(id)
);
COMMIT;



INSERT INTO Bicycles1 (id, brand, description)

VALUES ('1','Merida','bike perfect for commuting');

INSERT INTO Order1 (OrderId,Order_Date ,OrderNumber);

VALUES ('53459399','12/25/2021','WWS');

SELECT * FROM Bicycles1 WHERE id= 1;

SELECT * FROM Orders1 WHERE OrderNumber = 'WWS';
COMMIT;

ALTER TABLE Orders1
DROP COLUMN OrderNumber;

ALTER TABLE Orders1
ADD OrderNumber varchar(255);

COMMIT;

COMMIT TRANSACTION;