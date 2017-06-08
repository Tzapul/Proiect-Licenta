-- USER
INSERT INTO USER (ID, FIRST_NAME, LAST_NAME, SSN, GENDER) VALUES (1, 'Victor', 'Paun', '1941024160054', 'MALE');
INSERT INTO USER (ID, FIRST_NAME, LAST_NAME, SSN, GENDER) VALUES (2, 'Georgian', 'Alexandru', '1940826160041', 'MALE');
INSERT INTO USER (ID, FIRST_NAME, LAST_NAME, SSN, GENDER) VALUES (3, 'Diana', 'Micu', '1780405160085', 'FEMALE');
INSERT INTO USER (ID, FIRST_NAME, LAST_NAME, SSN, GENDER) VALUES (4, 'Marius', 'Brezovan', '1540808160021', 'MALE');
INSERT INTO USER (ID, FIRST_NAME, LAST_NAME, SSN, GENDER) VALUES (5, 'Cristian', 'Creanga', '1590806160041', 'MALE');
INSERT INTO USER (ID, FIRST_NAME, LAST_NAME, SSN, GENDER) VALUES (6, 'Andrei', 'Urdiniceanu', '1940505160052', 'MALE');


-- ACCOUNT
INSERT INTO ACCOUNT (ID, USERNAME, PASSWORD, EMAIL, USER_ROLE) VALUES  (1, 'vpaun',
'$2a$10$5ysE1CvqJLSXL5hFChyhFO4gwGIgYjaprBIcrxAgSfgJVhs0UVoTS', 'victorpaun20@yahoo.com', 'STUDENT');
INSERT INTO ACCOUNT (ID, USERNAME, PASSWORD, EMAIL, USER_ROLE) VALUES  (2, 'gvladutu',
'$2a$10$5ysE1CvqJLSXL5hFChyhFO4gwGIgYjaprBIcrxAgSfgJVhs0UVoTS', 'vladutu_georgian_4d@yahoo.com', 'STUDENT');
INSERT INTO ACCOUNT (ID, USERNAME, PASSWORD, EMAIL, USER_ROLE) VALUES  (3, 'dmicu',
'$2a$10$/S3ThIuzyw/UPGzmPXbmTeaYja6KEw8v2g1HBXF8LMAjAFFWSjx32', 'diana.micu@yahoo.com', 'SECRETARY');
INSERT INTO ACCOUNT (ID, USERNAME, PASSWORD, EMAIL, USER_ROLE) VALUES  (4, 'mbrezovan',
'$2a$10$ICaKq1zZgCXmId310qxxhujA0P0V43ggkcdHMHjS4QPMY0GynswwG', 'marius.brezovan@yahoo.com', 'PROFESSOR');
INSERT INTO ACCOUNT (ID, USERNAME, PASSWORD, EMAIL, USER_ROLE) VALUES  (5, 'ccreanga',
'$2a$10$ICaKq1zZgCXmId310qxxhujA0P0V43ggkcdHMHjS4QPMY0GynswwG', 'cristian.creanga@yahoo.com', 'PROFESSOR');
INSERT INTO ACCOUNT (ID, USERNAME, PASSWORD, EMAIL, USER_ROLE) VALUES  (6, 'aurdiniceanu',
'$2a$10$5ysE1CvqJLSXL5hFChyhFO4gwGIgYjaprBIcrxAgSfgJVhs0UVoTS', 'urdi.andrei@gmail.com', 'STUDENT');

-- SUBGROUP
INSERT INTO SUBGROUP(ID, NAME) VALUES (1, 'CEN4.S1');
INSERT INTO SUBGROUP(ID, NAME) VALUES (2, 'CEN4.S2');

-- PROFESSOR
INSERT INTO PROFESSOR(ID, POSITION ) VALUES (4, 'Prof. Dr. Ing.');
INSERT INTO PROFESSOR(ID, POSITION ) VALUES (5, 'Prof.');

-- SECRETARY
INSERT INTO SECRETARY(ID) VALUES (3);

-- STUDENT
INSERT INTO STUDENT(ID, SUBGROUP_ID) VALUES(1, 1);
INSERT INTO STUDENT(ID, SUBGROUP_ID) VALUES(2, 2);
INSERT INTO STUDENT(ID, SUBGROUP_ID) VALUES(6, 2);

-- PLAGIARISM ANALYSER
INSERT INTO PLAGIARISM_ANALYSER(ID, DTYPE) VALUES (1, 'NPA');
INSERT INTO PLAGIARISM_ANALYSER(ID, DTYPE) VALUES (2, 'DPA');