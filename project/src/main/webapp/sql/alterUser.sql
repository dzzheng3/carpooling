ALTER TABLE `carpooling`.`users` 
CHANGE COLUMN `city` `city` VARCHAR(50) CHARACTER SET 'utf8' NULL ,
CHANGE COLUMN `street` `street` VARCHAR(50) CHARACTER SET 'utf8' NULL ,
CHANGE COLUMN `birthyear` `birthyear` INT(4) UNSIGNED NULL ;