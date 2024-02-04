DROP TBLE IF EXISTS Employee;

CREATE TABLE `Employee`(
    `id` int NOT NULL,
    `firstName` varchar(255) DEFAULT NULL,
    `lastName` varchar(255) DEFAULT NULL,
    `dob` varchar(10) DEFAULT NULL,
    PRIMARY KEY (`id`)
);
