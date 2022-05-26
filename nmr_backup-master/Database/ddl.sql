CREATE DATABASE nmr;
USE nmr;

SELECT e.admin FROM user AS u, employee AS e WHERE u.email = e.email AND e.job_title = 'owner';

SELECT e.admin FROM employee as e WHERE email = 'douglas.beaver@gmail.com';

DELIMITER $$
DROP PROCEDURE IF EXISTS `findAdmin` $$
CREATE PROCEDURE `findAdmin` (email VARCHAR(255))
BEGIN
    SELECT e.admin FROM user AS u, employee AS e WHERE u.email = e.email;
END $$
DELIMITER ;