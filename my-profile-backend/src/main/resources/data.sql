INSERT INTO address(city, region, country) VALUES ('Bougival', 'Ile de France', 'France');
INSERT INTO address(city, region, country) VALUES ('Paris 7', 'Ile de France', 'France');

INSERT INTO profile(first_name, last_name, birth_date, profile_title, expertise, summary, address_id) 
	VALUES ('Hamda', 'BOUFAIED', '1981-08-26', 'ARCHITECTE LOGICIEL', 'Java, JEE, Spring', 'Architecte logiciel...', 1);

INSERT INTO company(name, address_id) VALUES ('Wemanity', 2);
INSERT INTO experience(title, type, start_date, end_date, description, company_id, profile_id) 
	VALUES ('Tech Lead', 'FULL_TIME', '2021-09-01', NULL, 'Ninja', 1, 1);
	
INSERT INTO education(school, study_level, study_specialization, start_date, end_date, description, profile_id)
	VALUES('ENIS', 'Engineer', 'Software Engineering', '2002-09-01', '2006-06-30', 'Software Engineering', 1);

INSERT INTO certification(name, organization, date, identifier, link, profile_id) 
	VALUES ('TOGAF 9', 'ORSYS', '2018-01-01', '', '', 1);
INSERT INTO certification(name, organization, date, identifier, link, profile_id) 
	VALUES ('Scrum Master', 'ORSYS', '2014-01-01', '', '', 1);
INSERT INTO certification(name, organization, date, identifier, link, profile_id) 
	VALUES ('INTRODUCTION À LA PROGRAMMATION FONCTIONNELLE AVEC HASKEL', 'ORSYS', '2015-01-01', '', '', 1);
INSERT INTO certification(name, organization, date, identifier, link, profile_id) 
	VALUES ('Scala', 'ORSYS', '2015-01-01', '', '', 1);

INSERT INTO training (title, description, date, profile_id) 
	VALUES ('Angular 12', 'Devéloppement des applications Front avec Angular', '2021-10-01', 1);
INSERT INTO training (title, description, date, profile_id) 
	VALUES ('Architecture Hexagonal', 'DDD, BDD, TDD, CQRS', '2021-11-01', 1);

INSERT INTO skill(label, description, expertise_level, profile_id) VALUES ('JAVA', 'Development Java', 9, 1);
INSERT INTO skill(label, description, expertise_level, profile_id) VALUES ('Spring', 'Spring4/5, SpringBoot, Spring AOP...', 8, 1);
INSERT INTO skill(label, description, expertise_level, profile_id) VALUES ('DataBases', 'Oracle, PostgreSQL, MySQL', 7, 1);
INSERT INTO skill(label, description, expertise_level, profile_id) VALUES ('JAX-WS', 'CXF, Apache Axis', 6, 1);
INSERT INTO skill(label, description, expertise_level, profile_id) VALUES ('MicroService', 'Development des application MicroServcices', 6, 1);