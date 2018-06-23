DROP TABLE IF EXISTS deltaUser;

CREATE TABLE deltaUser (
    firstName NVARCHAR(255),
    lastName NVARCHAR(255),
    username NVARCHAR(255) PRIMARY KEY,
    password NVARCHAR(255),
    defaultScriptId INT DEFAULT 1
);

INSERT INTO deltaUser VALUES ('udit', 'shah', 'udit', '81fe8bfe87576c3ecb22426f8e57847382917acf', 1);
INSERT INTO deltaUser VALUES ('niraj', 'sindhi', 'niraj', '81fe8bfe87576c3ecb22426f8e57847382917acf', 2);
INSERT INTO deltaUser VALUES ('ishan', 'shah', 'raja', '81fe8bfe87576c3ecb22426f8e57847382917acf', 3);
INSERT INTO deltaUser VALUES ('ankit', 'kumawat', 'kalu', '81fe8bfe87576c3ecb22426f8e57847382917acf', 1);