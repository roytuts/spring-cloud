CREATE TABLE `forex_value` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`from_curr` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	`rate` DOUBLE NULL DEFAULT NULL,
	`to_curr` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_unicode_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_unicode_ci'
ENGINE=InnoDB
AUTO_INCREMENT=4;

insert into forex_value(from_curr,to_curr,rate)
values('USD','INR',71);
insert into forex_value(from_curr,to_curr,rate)
values('EUR','INR',85);
insert into forex_value(from_curr,to_curr,rate)
values('AUD','INR',39);
