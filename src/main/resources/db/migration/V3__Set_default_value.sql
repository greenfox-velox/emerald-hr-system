ALTER TABLE `HRSYSTEM`.`User`
CHANGE COLUMN `role` `role` ENUM('ADMIN', 'USER') NULL DEFAULT 'USER' ;