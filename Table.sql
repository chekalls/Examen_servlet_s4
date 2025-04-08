CREATE DATABASE db_servlet_exam;
USE db_servlet_exam;

CREATE TABLE Previsions(
    idPrevision INTEGER PRIMARY KEY AUTO_INCREMENT,
    libelle VARCHAR(50),
    montant DECIMAL(13,3)
);


CREATE TABLE Depense(
    idDepense INTEGER PRIMARY KEY AUTO_INCREMENT,
    idPrevision INTEGER,
    montant DECIMAL,
    dateDepense DATETIME
);

CREATE OR REPLACE VIEW Etat AS SELECT p.idPrevision,p.montant as prevision,SUM(d.montant)as depense,(p.montant-SUM(d.montant)) as rest FROM Previsions p 
LEFT JOIN Depense d ON p.idPrevision=d.idPrevision GROUP BY d.idPrevision;
