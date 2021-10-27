DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS company; 
DROP TABLE IF EXISTS profile;
DROP TABLE IF EXISTS experience;

CREATE TABLE address (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  city VARCHAR(250) NOT NULL,
  region VARCHAR(250) NOT NULL,
  country VARCHAR(250) NOT NULL
);

CREATE TABLE company (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  address_id int,
  FOREIGN KEY (address_id) REFERENCES address(id)
);

CREATE TABLE profile (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  birth_date DATE,
  profile_title VARCHAR(250),
  expertise VARCHAR(250),
  summary VARCHAR(500),
  address_id int,
  FOREIGN KEY (address_id) REFERENCES address(id)
  
);

CREATE TABLE experience (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  type ENUM('FULL_TIME', 'PART_TIME') DEFAULT 'FULL_TIME',
  start_date DATE NOT NULL,
  end_date DATE NULL,
  description VARCHAR(250),
  company_id int,
  FOREIGN KEY (company_id) REFERENCES company(id)
);
INSERT INTO address(city, region, country) VALUES ('Bougival', 'Ile de France', 'France');
INSERT INTO address(city, region, country) VALUES ('Paris 7', 'Ile de France', 'France');

INSERT INTO profile(first_name, last_name, birth_date, profile_title, expertise, summary, address_id) 
	VALUES ('Hamda', 'BOUFAIED', '1981-08-26', 'ARCHITECTE LOGICIEL', 'Java, JEE, Spring', 'Architecte logiciel...', 1);

INSERT INTO company(name, address_id) VALUES ('Wemanity', 2);
INSERT INTO experience(title, type, start_date, end_date, description, company_id) 
	VALUES ('Tech Lead', 'FULL_TIME', '2021-09-01', NULL, 'Ninja', 1);
