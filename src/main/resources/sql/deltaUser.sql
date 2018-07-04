DROP TABLE IF EXISTS deltaUser;

CREATE TABLE deltaUser (
    firstName nvarchar(255),
    lastName nvarchar(255),
    username nvarchar(255),
    password nvarchar(255),
    defaultScriptId INT DEFAULT 1
);

INSERT INTO deltaUser VALUES ('udit', 'shah', 'udit', '81fe8bfe87576c3ecb22426f8e57847382917acf', 1);
INSERT INTO deltaUser VALUES ('niraj', 'sindhi', 'niraj', '81fe8bfe87576c3ecb22426f8e57847382917acf', 2);
INSERT INTO deltaUser VALUES ('ishan', 'shah', 'raja', '81fe8bfe87576c3ecb22426f8e57847382917acf', 3);
INSERT INTO deltaUser VALUES ('ankit', 'kumawat', 'kalu', '81fe8bfe87576c3ecb22426f8e57847382917acf', 1);