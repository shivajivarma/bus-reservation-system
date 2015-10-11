SET SQL_SAFE_UPDATES=0;

delete from `brs`.`reserve`;

delete from `brs`.`bus`;
ALTER TABLE `brs`.`bus` AUTO_INCREMENT = 200;

delete from `brs`.`route`;
ALTER TABLE `brs`.`route` AUTO_INCREMENT = 10;

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Visakhapatnam','Hyderabad');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Hyderabad','Visakhapatnam');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Visakhapatnam','Bangalore');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Bangalore','Visakhapatnam');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Visakhapatnam','Tirupati');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Tirupati','Visakhapatnam');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Hyderabad','Bangalore');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Bangalore','Hyderabad');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Hyderabad','Tirupati');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Tirupati','Hyderabad');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Bangalore','Tirupati');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Tirupati','Bangalore');


INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (10,1,1600,'20:00','09:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (10,0,1700,'20:00','06:30');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (10,1,2000,'21:00','07:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (11,0,1500,'18:00','05:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (12,0,1200,'20:00','09:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (12,1,2100,'20:00','18:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (13,0,1700,'21:30','19:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (13,0,800,'14:00','09:30');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (13,1,700,'20:00','19:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (14,0,300,'20:00','09:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (13,1,1800,'19:10','17:00');
