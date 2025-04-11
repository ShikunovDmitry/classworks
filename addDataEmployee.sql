CREATE TABLE Employee (EmployeeID INTEGER PRIMARY KEY, FirstName text, LastName text);
CREATE TABLE PersonalData(EmployeeId INTEGER  PRIMARY KEY, DateOfBirth date);
CREATE TABLE Department(DepartmentID integer primary key, DepartmentName text);
CREATE TABLE Skills(SkillId INTEGER PRIMARY KEY, SkillName text);
CREATE TABLE EmployeeSkill(EmployeeId INTEGER NOT NULL, SkillId INTEGER INTEGER NOT NULL,CONSTRAINT EmployeeSkill_pk PRIMARY KEY (EmployeeId, SkillId));


INSERT INTO Employee(EmployeeID, FirstName, LastName) values(1, 'Krist', 'Novoselic');
INSERT INTO Employee(EmployeeID, FirstName, LastName) values(2, 'Dave', 'Grohl');
INSERT INTO Employee(EmployeeID, FirstName, LastName) values(3, 'Kurt', 'Cobain');
INSERT INTO Employee(EmployeeID, FirstName, LastName) values(4, 'Chad', 'Channing');

INSERT INTO PersonalData(EmployeeID, DateOfBirth) values(3, '1967-02-23');
INSERT INTO PersonalData(EmployeeID, DateOfBirth) values(2, '1969-01-14');
INSERT INTO PersonalData(EmployeeID, DateOfBirth) values(1, '1965-05-16');
INSERT INTO PersonalData(EmployeeID, DateOfBirth) values(4, '1967-01-3select 1');

INSERT INTO Department(DepartmentID, DepartmentName) values(1, 'Personal');
INSERT INTO Department(DepartmentID, DepartmentName) values(2, 'IT Service');
INSERT INTO Department(DepartmentID, DepartmentName) values(3, 'Production');
INSERT INTO Department(DepartmentID, DepartmentName) values(4, 'Sales');


ALTER TABLE Employee ADD column DepartmentId INTEGER;

UPDATE Employee SET DepartmentId = 3 WHERE EmployeeID = 1;
UPDATE Employee SET DepartmentId = 3 WHERE EmployeeID = 2;
UPDATE Employee SET DepartmentId = 3 WHERE EmployeeID = 3;
UPDATE Employee SET DepartmentId = 2 WHERE EmployeeID = 4;

INSERT INTO Skills(SkillId, SkillName) values(1, 'Database');
INSERT INTO Skills(SkillId, SkillName) values(2, 'Java');
INSERT INTO Skills(SkillId, SkillName) values(3, 'Groovy');
INSERT INTO Skills(SkillId, SkillName) values(4, 'REST Services');
INSERT INTO Skills(SkillId, SkillName) values(5, 'Sales');
INSERT INTO Skills(SkillId, SkillName) values(6, 'DevOps');


INSERT INTO EmployeeSkill(EmployeeId, SkillId) values(1,1);
INSERT INTO EmployeeSkill(EmployeeId, SkillId) values(2,2);
INSERT INTO EmployeeSkill(EmployeeId, SkillId) values(3,3);
INSERT INTO EmployeeSkill(EmployeeId, SkillId) values(4,4);
INSERT INTO EmployeeSkill(EmployeeId, SkillId) values(1,3);
INSERT INTO EmployeeSkill(EmployeeId, SkillId) values(2,3);
INSERT INTO EmployeeSkill(EmployeeId, SkillId) values(4,1);


SELECT DISTINCT FirstName, LastName, DateOfBirth, DepartmentName, SkillName from Employee e
INNER JOIN Department d on e.DepartmentId = d.DepartmentId
INNER JOIN PersobnalData pd on pd.EmployeeId = e.EmployeeId
INNER JOIN EmployeeSkill es on e.EmployeeId = es.EmployeeId
INNER JOIN Skills s on s.SkillId = es.SkillId

SELECT DISTINCT FirstName, LastName, DepartmentName, SkillName,  ROUND((JULIANDAY(Date('now')) - JULIANDAY(DateOfBirth)) /365) AS age
from Employee e
INNER JOIN Department d on e.DepartmentId = d.DepartmentId
INNER JOIN PersobnalData pd on pd.EmployeeId = e.EmployeeId
INNER JOIN EmployeeSkill es on e.EmployeeId = es.EmployeeId
INNER JOIN Skills s on s.SkillId = es.SkillId



