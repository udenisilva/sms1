DROP DATABASE IF EXISTS nbrodb;
CREATE DATABASE  nbrodb
DEFAULT CHARACTER SET  =UTF8
DEFAULT COLLATE =UTF8_GENERAL_CI ;

CREATE USER 'nbro_user'@'%' IDENTIFIED BY 'nbro_user';		
GRANT ALL ON nbrodb.* TO 'nbro_user'@'%';