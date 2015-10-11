DROP SCHEMA IF EXISTS `brs` ;

CREATE SCHEMA `brs` ;

CREATE TABLE `brs`.`route` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `origin` VARCHAR(20) NOT NULL,
    `destination` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
  AUTO_INCREMENT=10;
  
CREATE UNIQUE INDEX ROUTE_UNIQUE ON `brs`.`route`(`origin`, `destination`);

CREATE TABLE  `brs`.`bus` (	
	`id` INT NOT NULL AUTO_INCREMENT,
	`routeid` INT NOT NULL,
	`ac` boolean NOT NULL, 
	`fare` int NOT NULL, 
	`departuretime` VARCHAR(6)  NOT NULL, 
	`ARRIVALTIME` VARCHAR(6) NOT NULL, 
	 PRIMARY KEY (`id`), 
	 FOREIGN KEY (`routeid`) REFERENCES  `brs`.`route` (`id`))
     AUTO_INCREMENT=200;
     
CREATE TABLE  `brs`.`passenger` (	
	`id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(20) NOT NULL UNIQUE, 
	`password` VARCHAR(20) NOT NULL, 
	`name` VARCHAR(40) NOT NULL, 
	`email` VARCHAR(32) NOT NULL, 
	`mobile` bigint NOT NULL, 
	 PRIMARY KEY (`id`))
     AUTO_INCREMENT = 500;
     
CREATE TABLE  `brs`.`reserve` (	
	`id` INT NOT NULL AUTO_INCREMENT, 
	`passengerid` int NOT NULL, 
	`busid` int NOT NULL, 
	`dt` DATE NOT NULL, 
	`tstamp` DATE NOT NULL, 
	`seat` int NOT NULL, 
	 PRIMARY KEY (`id`), 
	 FOREIGN KEY (`passengerid`) REFERENCES  `brs`.`passenger` (`id`), 
	 FOREIGN KEY (`busid`) REFERENCES  `brs`.`bus` (`id`))
	 AUTO_INCREMENT = 1000;
     
CREATE UNIQUE INDEX SEAT_UNIQUE ON `brs`.`reserve`(`busid`, `dt`, `seat`);

CREATE VIEW `brs`.`reservation` AS
    SELECT 
        `reserve`.`id` AS `id`,
        `reserve`.`passengerid` AS `passengerid`,
        `reserve`.`busid` AS `busid`,
        `reserve`.`seat` AS `seat`,
        `reserve`.`dt` AS `dt`,
        `reserve`.`tstamp` AS `tstamp`,
        `route`.`origin` AS `origin`,
        `route`.`destination` AS `destination`,
        `bus`.`departuretime` AS `departuretime`,
        `bus`.`ARRIVALTIME` AS `arrivaltime`
    FROM
        ((`brs`.`reserve`
        JOIN `brs`.`bus`)
        JOIN `brs`.`route`)
    WHERE
        ((`reserve`.`busid` = `bus`.`id`)
            AND (`route`.`id` = `bus`.`routeid`))
    ORDER BY `reserve`.`id`;