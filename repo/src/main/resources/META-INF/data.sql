INSERT INTO USER(USERNAME, PASSWORD, ENABLED) VALUES('lyes', '$2a$04$FQb603owMsZ2xCTtFSslsOvQ9bUSUatuemwR9IX1ebF7iKsOASF66', TRUE);
INSERT INTO USERROLE(ID, ROLE, USER_ID) VALUES(1, 'ROLE_ADMIN', 'lyes');

INSERT INTO USER(USERNAME, PASSWORD, ENABLED) VALUES('kher', '$2a$04$S8gZ6H0A1UJAKuihtrXEd.FOPpvYyQQCNJAhm1MmKrUQumGHPRRLq', TRUE);
INSERT INTO USERROLE(ID, ROLE, USER_ID) VALUES(2, 'ROLE_COUNSELOR', 'kher');


INSERT INTO ADDRESS(id, CITY, COUNTRY, ZIP_CODE, NUM_ADDRESS, STREET_NAME, TYPE_ADDRESS) VALUES(1, 'otr', 'dz', 15550, 10, 'micipsa street', 'STREET');

INSERT INTO PROMOTER(FIRST_NAME, LAST_NAME, BIRTH_DATE, ANEM_CARD, BIRTH_CERT_NUM, BIRTH_CITY, BIRTH_COUNTRY, BIRTH_ZIP_CODE, DEGREE, EDUC_LEVEL, EMAIL, EXPERIENCE, FAMILYSITUATION, FATHER, FAX, GENDER, MOTHER, PHONE, FK_ADDRESS) VALUES('first1', 'last1', '12/12/1989', 15991998, '199812121', 'lni', 'dz', 15540, 'miage', 'OTH', 'sith@yahoo.com', 'Without', 'Single', 'sa', 099999, 'M', 'al', 066666, 1);



INSERT INTO ADDRESS(id, CITY, COUNTRY, ZIP_CODE, NUM_ADDRESS, STREET_NAME, TYPE_ADDRESS) VALUES(2, 'otr', 'dz', 15550, 111, 'massensen road', 'ROAD');

INSERT INTO PROMOTER(FIRST_NAME, LAST_NAME, BIRTH_DATE, ANEM_CARD, BIRTH_CERT_NUM, BIRTH_CITY, BIRTH_COUNTRY, BIRTH_ZIP_CODE, DEGREE, EDUC_LEVEL, EMAIL, EXPERIENCE, FAMILYSITUATION, FATHER, FAX, GENDER, MOTHER, PHONE, FK_ADDRESS) VALUES('first2', 'last2', '13/12/1988', 15991988, '198813122', 'lni', 'dz', 15540, 'istr', 'OTH', 'first2@yahoo.com', 'Without', 'Single', 'da', 099999, 'M', 'ma', 066666, 2);



INSERT INTO ADDRESS(id, CITY, COUNTRY, ZIP_CODE, NUM_ADDRESS, STREET_NAME, TYPE_ADDRESS)  VALUES(3, 'otr', 'dz', 15550, 17, 'takfarinas road', 'ROAD');

INSERT INTO PROMOTER(FIRST_NAME, LAST_NAME, BIRTH_DATE, ANEM_CARD, BIRTH_CERT_NUM, BIRTH_CITY, BIRTH_COUNTRY, BIRTH_ZIP_CODE, DEGREE, EDUC_LEVEL, EMAIL, EXPERIENCE, FAMILYSITUATION, FATHER, FAX, GENDER, MOTHER, PHONE, FK_ADDRESS) VALUES('first3', 'last3', '14/12/1978', 15991978, '197813122', 'lni', 'dz', 15540, 'iisia', 'OTH', 'first3@yahoo.com', 'Without', 'Single', 'ra', 099999, 'M', 'wi', 066666, 3);



INSERT INTO ADDRESS(id, CITY, COUNTRY, ZIP_CODE, NUM_ADDRESS, STREET_NAME, TYPE_ADDRESS) VALUES(4, 'otr', 'dz', 15550, 2, 'tinhinane avenue', 'AVENUE');

INSERT INTO PROMOTER(FIRST_NAME, LAST_NAME, BIRTH_DATE, ANEM_CARD, BIRTH_CERT_NUM, BIRTH_CITY, BIRTH_COUNTRY, BIRTH_ZIP_CODE, DEGREE, EDUC_LEVEL, EMAIL, EXPERIENCE, FAMILYSITUATION, FATHER, FAX, GENDER, MOTHER, PHONE, FK_ADDRESS) VALUES('first4', 'last4', '19/10/1990', 15991990, '199019104', 'lni', 'dz', 15540, 'bio', 'OTH', 'first4@yahoo.com', 'Without', 'Single', 'ha', 099999, 'M', 'ka', 066666, 4);



INSERT INTO ADDRESS(id, CITY, COUNTRY, ZIP_CODE, NUM_ADDRESS, STREET_NAME, TYPE_ADDRESS) VALUES(5, 'otr', 'dz', 15550, 10, 'micipsa street', 'STREET');

INSERT INTO PROMOTER(BIRTH_DATE, FIRST_NAME, LAST_NAME, ANEM_CARD, BIRTH_CERT_NUM, BIRTH_CITY, BIRTH_COUNTRY, BIRTH_ZIP_CODE, DEGREE, EDUC_LEVEL, EMAIL, EXPERIENCE, FAMILYSITUATION, FATHER, FAX, GENDER, MOTHER, PHONE, FK_ADDRESS) VALUES ('12/01/1990', 'lys', 'kh', 151699, '12019099', 'lni', 'Dz', 15550, 'Miage','OTH', 'sith', 'Without', 'Single', 'sl', 9999, 'M', 'al', 6666, 2);
