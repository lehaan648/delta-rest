DROP TABLE test IF EXISTS;

CREATE TABLE test (
    username nvarchar(255),
    password nvarchar(255),
    firstName nvarchar(255),
    lastName nvarchar(255),
    defaultScriptId int DEFAULT 1
);

INSERT INTO test (username, password, firstName, lastname, defaultScriptId)
    VALUES ('udit', '81fe8bfe87576c3ecb22426f8e57847382917acf', 'udit', 'shah', 1);