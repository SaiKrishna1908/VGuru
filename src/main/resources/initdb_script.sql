CREATE DATABASE vguru;

CREATE USER 'admin'@'localhost' IDENTITFIED BY 'admin123';
CREATE USER 'admin'@'%' IDENTIFIED BY 'admin123';

GRANT SELECT ON vguru.* to 'admin'@'localhost';
GRANT ALTER ON vguru.* to 'admin'@'localhost';
GRANT INSERT ON vguru.* to 'admin'@'localhost';
GRANT UPDATE ON vguru.* to 'admin'@'localhost';
GRANT DELETE ON vguru.* to 'admin'@'localhost';


GRANT SELECT ON vguru.* to 'admin'@'%';
GRANT ALTER ON vguru.* to 'admin'@'%';
GRANT INSERT ON vguru.* to 'admin'@'%';
GRANT UPDATE ON vguru.* to 'admin'@'%';
GRANT DELETE ON vguru.* to 'admin'@'%';