DROP TABLE deltaUser IF EXISTS;

CREATE TABLE deltaUser (
    username nvarchar(255),
    password nvarchar(255),
    firstName nvarchar(255),
    lastName nvarchar(255),
    defaultScriptId int DEFAULT 1
);

INSERT INTO deltaUser (username, password, firstName, lastname, defaultScriptId)
    VALUES ('udit', '81fe8bfe87576c3ecb22426f8e57847382917acf', 'udit', 'shah', 1);
INSERT INTO deltaUser (username, password, firstName, lastname, defaultScriptId)
    VALUES ('ankit', '81fe8bfe87576c3ecb22426f8e57847382917acf', 'ankit', 'kumawat', 2);
INSERT INTO deltaUser (username, password, firstName, lastname, defaultScriptId)
    VALUES ('ishan', '81fe8bfe87576c3ecb22426f8e57847382917acf', 'ishan', 'shah', 1);
INSERT INTO deltaUser (username, password, firstName, lastname, defaultScriptId)
    VALUES ('niraj', '81fe8bfe87576c3ecb22426f8e57847382917acf', 'niraj', 'sindhi', 2);