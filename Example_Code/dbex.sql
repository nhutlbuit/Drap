create database fresherex;
use fresherex;
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(10) NOT NULL,
  `lastname` varchar(20) NOT NULL,
  `age` int(10) NOT NULL,
  `sex` BIT(1) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  UNIQUE KEY `UNI_STUDENT_NAME` (`username`),
  UNIQUE KEY `UNI_STUDENT_ID` (`student_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `score`;
CREATE TABLE  `score` (
  `score_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `subject` varchar(10) NOT NULL,
  `score` float(6,2) DEFAULT NULL,  
  `student_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`score_id`) USING BTREE,
  KEY `FK_STUDENT_ID` (`student_id`),
  CONSTRAINT `FK_STUDENT_ID` FOREIGN KEY (`student_id`) 
  REFERENCES `student` (`student_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `address`;
CREATE TABLE  `address` (
  `student_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `street` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,  
  PRIMARY KEY (`student_id`) USING BTREE,
  CONSTRAINT `FK_ADD_STUDENT_ID` FOREIGN KEY (`student_id`)
  REFERENCES `student` (`student_id`) 
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;