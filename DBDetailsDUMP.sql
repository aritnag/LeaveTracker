CREATE DATABASE  IF NOT EXISTS `projects` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `projects`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projects
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activities`
--

DROP TABLE IF EXISTS `activities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES (1,'VMware portal team hosting Potluck on March 20th'),(2,'Congratulations Srikanth Giduthoori, Akhilesh Tummalapalli on getting Spot Awards!'),(3,'VMware Team Sports Team hosting friendly football match on March 16th'),(4,'Congratulations Rajendra Dhodda on getting married this month!'),(5,'Welcome newcomers Rishab, Gopi and Billla to the team!'),(6,'10 participents for the vmware weight loss program');
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaves`
--

DROP TABLE IF EXISTS `leaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leaves` (
  `leave_id` int(11) NOT NULL AUTO_INCREMENT,
  `leave_type` varchar(100) NOT NULL,
  `is_active` varchar(45) NOT NULL,
  PRIMARY KEY (`leave_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaves`
--

LOCK TABLES `leaves` WRITE;
/*!40000 ALTER TABLE `leaves` DISABLE KEYS */;
INSERT INTO `leaves` VALUES (1,'PTO','Y'),(2,'HOLIDAY','Y'),(3,'PAID LEAVE','Y'),(4,'MATERNITY LEAVE','Y');
/*!40000 ALTER TABLE `leaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `people` (
  `people_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`people_id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (1,'Naresh Kumar','Palabatla','npalabatla@deloitte.com'),(2,'Khyathi','Balusu','kbalusu@deloitte.com'),(3,'Sudhir','Thutika','sthutika@deloitte.com'),(4,'Ramesh','Malapoli','ramalapoli@deloitte.com'),(5,'Chandrasekhar','Pentakota','cpentakota@vmware.com'),(6,'Srikanth','Giduthoori','sgiduthoori@deloitte.com'),(7,'Pulkit','Shah','pulshah@deloitte.com'),(8,'Sasikar','Pudi','spudi@deloitte.com'),(9,'Aritra','Nag','aritnag@deloitte.com'),(10,'Tejendra','Mallikarjun','tmallikarjun@deloitte.com'),(11,'Swapna','Vemula','svemula@deloitte.com'),(12,'Salam','Basleeb','sbasleeb@deloitte.com'),(13,'Viveganandan','Nadar','vnadar@deloitte.com'),(14,'Anish','Chadha','anchadha@deloitte.com'),(15,'Harsha','Yadavalli','sryadavalli@deloitte.com'),(16,'Rambabu','Polineti','rpolineti@vmware.com'),(17,'Gopikrishna','B','gopb@deloitte.com'),(18,'Rishabh','Tyagi','rityagi@deloitte.com'),(19,'Ankita','Bathwal','abathwal@deloitte.com'),(20,'Krishna','Teja Billa','kbillla@deloitte.com'),(21,'Sai Ram','Yellisetti','ysairam@deloitte.com'),(22,'Maheswar Reddy','Vannapusala','mvannapusala@deloitte.com'),(23,'Ganesh','nimmagadda','gnimmagadda@deloitte.com'),(24,'Ganesh','Pasupuleti','gpasupuleti@deloitte.com'),(25,'Deepika Reddy','Konreddy','dkonreddy@deloitte.com'),(26,'Ghosh','Tamoghna','tamghosh@deloitte.com'),(27,'Suganya Devi','P V','sugpv@deloitte.com'),(28,'Kumar Swamy','Challapall','kchallapalli@deloitte.com'),(29,'Neha','Pujary','npujary@deloitte.com'),(30,'Atul','Singh','atulrsingh@deloitte.com'),(31,'Arnav','Arya','ararya@deloitte.com'),(32,'Debashish','Pradhan','dpradhan@vmware.com'),(33,'Saurabh','Sawarkar','ssawarkar@deloitte.com'),(34,'Sanket','Pardeshi','spardeshi@deloitte.com'),(35,'Vipin','Singh','vipsingh@deloitte.com'),(36,'Prathishtha','Pandey','pratpandey@deloitte.com'),(37,'Singam','Sathyavathi','sasingam@deloitte.com'),(38,'Rahaman','Anzamam ','arahaman@deloitte.com'),(39,'Rahul','Singhania','rasinghania@deloitte.com'),(40,'Ganesh','Sahu','gsahu@deloitte.com'),(41,'Yamini','Pinapatruni ','ypinapatruni@DELOITTE.com'),(42,'Garvit','Gupta','ggupta@deloitte.com'),(43,'Ajay','Petluri','apetluri@deloitte.com'),(44,'Sabbu','Krishna','ksabbu@deloitte.com'),(45,'Rashmi','Edu','raedu@deloitte.com'),(46,'Akhilesh','Lakshmi Tummalapalli','atummalapalli@deloitte.com'),(47,'Rajendraprasad','Dodda','rdodda@DELOITTE.com '),(48,'Vishnu','Lal','vilal@deloitte.com'),(49,'Mahendhar','Sanipalli','msanipalli@deloitte.com'),(50,'Divya','Maurya','dmaurya@deloitte.com'),(51,'Debojyoti','Mahapatra','dmahapatra@deloitte.com'),(52,'Rupavani','Atchula','ratchula@deloitte.com'),(53,'Debashis','Kayal','dkayal@deloitte.com'),(54,'Divya','Kotteti','dkotteti@deloitte.com'),(55,'Abhilash','Kashyap R','akashyapr@deloitte.com'),(56,'Pavankumar','Potti','ppotti@deloitte.com'),(57,'Chandana','Narendra','cnarendra@deloitte.com'),(58,'Sai Anusha','Yadali','syadali@deloitte.com'),(59,'Prashant','Solanki','prasolanki@deloitte.com'),(60,'Lakshmi','Pokala','lpokala@deloitte.com'),(61,'Lakshmi Sri Venkateswara','Kakaraparthi','lkakaraparthi@DELOITTE.com'),(62,'Quazi','Fasahat','qfasahat@deloitte.com'),(63,'Manoj','rout','marout@deloitte.com'),(64,'Renu','Gupta','rengupta@deloitte.com'),(65,'Rajendra','Jain','rajenjain@DELOITTE.com'),(66,'Pradeep','Shaman','spradeep@deloitte.com'),(67,'Rajesh','Sachar','rsachar@deloitte.com'),(68,'Pandith','Asrar','apandith@deloitte.com'),(69,'Haldar','Payal','pahaldar@deloitte.com'),(70,'Devesh','Pande','depande@DELOITTE.com'),(71,'Madhan Kumar','Sugumar','msugumar@deloitte.com'),(72,'Mathur','Yash','ymathur@deloitte.com    '),(73,'Vivek','Singh','vivesingh@deloitte.com'),(74,'Vinod','Ranga','rangav@vmware.com'),(75,'Niranjan','Hardageri','nhardageri@deloitte.com'),(76,'Manisha','Sharma','mansinha@deloitte.com'),(77,'Archana','Sharma','arcsharma@DELOITTE.com'),(78,'Shruthi','Gaddam','shrgaddam@deloitte.com'),(79,'Vivek Kowndinya','Kesavarajugari','vkesavarajugari@deloitte.com'),(80,'Debasis','Kayal','asanivarapu@deloitte.com'),(81,'Aditya','Sanivarpu','dkayal@deloitte.com'),(82,'A Raju','Shankar','arshankar@deloitte.com');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people_leave_request_action`
--

DROP TABLE IF EXISTS `people_leave_request_action`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `people_leave_request_action` (
  `people_leave_request_action_id` int(11) NOT NULL AUTO_INCREMENT,
  `people_leave_id` int(11) NOT NULL,
  `action_taken` varchar(100) DEFAULT NULL,
  `people_id` int(11) NOT NULL,
  `action_taken_by` int(11) NOT NULL,
  PRIMARY KEY (`people_leave_request_action_id`),
  UNIQUE KEY `people_leave_id_UNIQUE` (`people_leave_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people_leave_request_action`
--

LOCK TABLES `people_leave_request_action` WRITE;
/*!40000 ALTER TABLE `people_leave_request_action` DISABLE KEYS */;
INSERT INTO `people_leave_request_action` VALUES (1,1,'Approved',1,3),(2,3,'Approved',1,3),(3,4,'Approved',2,4),(4,5,'Rejected',1,3);
/*!40000 ALTER TABLE `people_leave_request_action` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people_leaves`
--

DROP TABLE IF EXISTS `people_leaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `people_leaves` (
  `people_leave_id` int(11) NOT NULL,
  `leave_id` int(11) NOT NULL,
  `people_id` int(11) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `leave_start_date` varchar(100) NOT NULL,
  `leave_end_date` varchar(100) NOT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`people_leave_id`),
  KEY `foreign_key_1_idx` (`leave_id`),
  KEY `foreign_key_2_idx` (`people_id`),
  CONSTRAINT `foreign_key_1` FOREIGN KEY (`leave_id`) REFERENCES `leaves` (`leave_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `foreign_key_2` FOREIGN KEY (`people_id`) REFERENCES `people` (`people_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people_leaves`
--

LOCK TABLES `people_leaves` WRITE;
/*!40000 ALTER TABLE `people_leaves` DISABLE KEYS */;
INSERT INTO `people_leaves` VALUES (1,1,1,'1','15-MAY-2017','15-MAY-2017','Approved'),(2,1,2,'2','13-MAY-2017','15-MAY-2017','Submitted'),(3,2,1,'1','10-APR-2017','10-APR-2017','Approved'),(4,2,2,'1','10-APR-2017','10-APR-2017','Approved'),(5,1,1,'10','01-JAN-2017','10-JAN-2017','Rejected');
/*!40000 ALTER TABLE `people_leaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people_role_hierarchy`
--

DROP TABLE IF EXISTS `people_role_hierarchy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `people_role_hierarchy` (
  `people_role_hierarchy_id` int(11) NOT NULL,
  `people_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `is_active` varchar(10) NOT NULL,
  `people_id_reported_to` int(11) DEFAULT NULL,
  PRIMARY KEY (`people_role_hierarchy_id`),
  KEY `people_id_foregin_key_idx` (`people_id`),
  KEY `role_id_foreign_ket_idx` (`role_id`),
  CONSTRAINT `people_id_foregin_key` FOREIGN KEY (`people_id`) REFERENCES `people` (`people_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `role_id_foreign_ket` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people_role_hierarchy`
--

LOCK TABLES `people_role_hierarchy` WRITE;
/*!40000 ALTER TABLE `people_role_hierarchy` DISABLE KEYS */;
INSERT INTO `people_role_hierarchy` VALUES (1,3,5,'Y',NULL),(2,4,6,'Y',3),(3,9,7,'Y',4),(4,82,8,'Y',9),(5,38,7,'Y',3),(6,42,7,'Y',4);
/*!40000 ALTER TABLE `people_role_hierarchy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `project_name` varchar(50) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`project_id`),
  UNIQUE KEY `project_name_UNIQUE` (`project_name`),
  KEY `category_id_fk_idx` (`category_id`),
  CONSTRAINT `category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `project_category` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,2,'Digital Marketing','Suporting VMware Dot Com team with Change requests'),(2,2,'Education Roadmap','Upgrading MyLearn to new Technology Stack - Srikanth and Pulkit'),(3,2,'SAAS Roadmap','Enhancements to Admin portal and Partner partner flows'),(4,2,'VMware CDF','Content deployment framework to enhance the user experience through site catalyst analytics'),(5,2,'Trade Compliance','Screening the customers based on Denied party list maintained by third party teams along with Caching the parties'),(10,2,'Subscription Billing Resiliency Improvements','API to ensure that all tenant generated usage which got missed in the initial flow is successfully received by SDP – RMQ mode'),(11,2,'CSP Portal','Cloud service provider to place trial paid orders'),(26,2,'SAAS Roles and Permissions','Modifying the existing MyVmware portal roles and permissions framework for CSP by extending the permissions adding the capability to have customizable roles'),(27,2,'Portal Baseline','Support MyVMware applications and working on Multiple Change requests'),(28,3,'Eloqua Baseline','Deals with multiple projects, User stories & Defects -  Eloqua related requests'),(29,3,'FMW Baseline','Managing all Non-Prod environments, supporting Production defects and Migrations'),(30,3,'CSP-SDDCaaS','Delivering easy and repeatable value for teams building new cloud services within VMware'),(31,2,'AirWatch End State','Export and Import features for admin portal in AirWatch'),(32,2,'Portal Roadmap','Support MyVMware applications and working on Multiple Change requests'),(33,5,'IOS','IOS Applications'),(34,5,'Android','Android Applications'),(35,5,'Apps','Mobile Applications'),(36,5,'MyVMware','MyVMware Application'),(37,1,'vNavigator','Application to navigate any vmware offices across the globe'),(38,2,'Sales Edge','Sales Edge features'),(39,1,'PeopleFinder','Search users and tenant onboarding'),(40,1,'vApprove','vApprove App provides single platform for users to view and to take action(Approve/Reject) on the approval requests which are generated through various systems like Concur,Coupa,ServiceNow, etc. This app is extendible in future for adding more enterprise applications'),(41,1,'vAssist','vAssist is a virtual enterprise assistant that empowers employees with ability to easily get instant insights from different enterprise systems and Improve search capability for all incidents and requests'),(42,2,'Helpnow','Helpnow aims at revamping the existing front end of Helpnow service now ticketing tool using a custom portal via API service'),(43,2,'Pivotal Cloud Foundry','Script Automation for deploying applications into cloud platform'),(46,7,'Workday-IVM Integration','Automation and timely integrations from Workday and CCURE integration to IVM'),(47,7,'SaaS SDP Roadmap','Provide solutions to various billing and order management enhancements'),(48,7,'RS2 Performance Improvement','Cleanup of Informatica code and collating redundant transformations'),(49,7,'EEE/IB Services','Automated tool used by business to get all the IB’s related to a particular parent quote'),(50,7,'Infa Baseline','Supporting Non-Prod Issues across the projects and ERFC\'s pertaining to production bugs'),(51,7,'Joint Business Plan','New integration between the EDW and VMSTAR for Booking data'),(52,7,'Clarity','Integration added between the EBS and VMSTAR for Booking data'),(53,7,'NRS','Data integrations between various end systems such as EBS,CP,Changepoint'),(54,6,'AEM Roadmap','Engaged in Roadmap and microsite migration'),(55,3,'ESG Migration','Migration of ESG development to Mulesoft');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_category`
--

DROP TABLE IF EXISTS `project_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_category`
--

LOCK TABLES `project_category` WRITE;
/*!40000 ALTER TABLE `project_category` DISABLE KEYS */;
INSERT INTO `project_category` VALUES (1,'Mobile','Mobile Applications'),(2,'Portal','Portal related projects'),(3,'FMW','FMW'),(5,'UI','Front End Experience'),(6,'AEM','Content Mangement'),(7,'Informatica',NULL);
/*!40000 ALTER TABLE `project_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_member`
--

DROP TABLE IF EXISTS `project_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `people_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project_id_fk_idx` (`project_id`),
  KEY `people_id_fk_idx` (`people_id`),
  CONSTRAINT `people_id_fk` FOREIGN KEY (`people_id`) REFERENCES `people` (`people_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `project_id_fk` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_member`
--

LOCK TABLES `project_member` WRITE;
/*!40000 ALTER TABLE `project_member` DISABLE KEYS */;
INSERT INTO `project_member` VALUES (7,1,5),(8,28,52),(9,29,53),(10,29,54),(11,29,55),(12,30,56),(13,30,57),(14,30,58),(15,11,25),(16,11,26),(17,31,27),(18,31,28),(19,37,2),(20,1,5),(21,2,6),(22,2,7),(23,3,8),(24,3,9),(25,4,10),(26,27,11),(27,27,12),(28,27,13),(29,27,14),(30,27,15),(31,27,16),(32,26,17),(33,26,18),(34,26,19),(35,26,20),(36,26,21),(37,32,22),(38,32,23),(39,32,24),(40,33,29),(41,33,30),(42,33,31),(43,34,32),(44,34,33),(45,35,34),(46,35,35),(47,35,36),(48,36,37),(49,38,38),(50,39,39),(51,42,40),(52,40,41),(53,40,42),(54,39,43),(55,26,44),(56,10,45),(57,5,46),(58,26,47),(59,27,48),(60,4,49),(61,38,50),(62,27,51),(63,41,59),(64,4,60),(65,43,1),(66,46,61),(67,46,62),(68,47,63),(69,48,64),(70,49,65),(71,50,61),(72,50,66),(73,50,67),(74,51,68),(75,52,69),(76,53,70),(77,53,68),(78,54,71),(79,54,72),(80,54,73),(81,54,74),(82,54,75),(83,54,76),(84,54,77),(85,54,78),(86,54,79),(87,55,80),(88,55,81);
/*!40000 ALTER TABLE `project_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_people`
--

DROP TABLE IF EXISTS `project_people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_people` (
  `project_people_id` int(11) NOT NULL AUTO_INCREMENT,
  `people_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `project_lead` int(11) DEFAULT NULL,
  PRIMARY KEY (`project_people_id`),
  KEY `foreign_key_1_idx` (`project_id`),
  KEY `foreign_key_2_idx` (`people_id`),
  KEY `foreign_key_2_idx1` (`project_lead`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_people`
--

LOCK TABLES `project_people` WRITE;
/*!40000 ALTER TABLE `project_people` DISABLE KEYS */;
INSERT INTO `project_people` VALUES (1,1,37,3),(2,2,37,3),(3,9,11,4);
/*!40000 ALTER TABLE `project_people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(100) NOT NULL,
  `project_details` varchar(400) DEFAULT NULL,
  `is_active` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Digital Marketing','Suporting VMware Dot Com team with Change requests','Y'),(2,'Education Roadmap','Upgrading MyLearn to new Technology Stack - Srikanth and Pulkit','Y'),(3,'SAAS Roadmap','Enhancements to Admin portal and Partner partner flows','Y'),(4,'VMware CDF','Content deployment framework to enhance the user experience through site catalyst analytics','Y'),(5,'Trade Compliance','Screening the customers based on Denied party list maintained by third party teams along with Caching the parties','Y'),(10,'Subscription Billing Resiliency Improvements','API to ensure that all tenant generated usage which got missed in the initial flow is successfully received by SDP – RMQ mode','Y'),(11,'CSP Portal','Cloud service provider to place trial paid orders','Y'),(26,'SAAS Roles and Permissions','Modifying the existing MyVmware portal roles and permissions framework for CSP by extending the permissions adding the capability to have customizable roles','Y'),(27,'Portal Baseline','Support MyVMware applications and working on Multiple Change requests','Y'),(28,'Eloqua Baseline','Deals with multiple projects, User stories & Defects -  Eloqua related requests','Y'),(29,'FMW Baseline','Managing all Non-Prod environments, supporting Production defects and Migrations','Y'),(30,'CSP-SDDCaaS','Delivering easy and repeatable value for teams building new cloud services within VMware','Y'),(31,'AirWatch End State','Export and Import features for admin portal in AirWatch','Y'),(32,'Portal Roadmap','Support MyVMware applications and working on Multiple Change requests','Y'),(33,'IOS','IOS Applications','Y'),(34,'Android','Android Applications','Y'),(35,'Apps','Mobile Applications','Y'),(36,'MyVMware','MyVMware Application','Y'),(37,'vNavigator','Application to navigate any vmware offices across the globe','Y'),(38,'Sales Edge','Sales Edge features','Y'),(39,'PeopleFinder','Search users and tenant onboarding','Y'),(40,'vApprove','vApprove App provides single platform for users to view and to take action(Approve/Reject) on the approval requests which are generated through various systems like Concur,Coupa,ServiceNow, etc. This app is extendible in future for adding more enterprise applications','Y'),(41,'vAssist','vAssist is a virtual enterprise assistant that empowers employees with ability to easily get instant insights from different enterprise systems and Improve search capability for all incidents and requests','Y'),(42,'Helpnow','Helpnow aims at revamping the existing front end of Helpnow service now ticketing tool using a custom portal via API service','Y'),(43,'Pivotal Cloud Foundry','Script Automation for deploying applications into cloud platform','Y'),(46,'Workday-IVM Integration','Automation and timely integrations from Workday and CCURE integration to IVM','Y'),(47,'SaaS SDP Roadmap','Provide solutions to various billing and order management enhancements','Y'),(48,'RS2 Performance Improvement','Cleanup of Informatica code and collating redundant transformations','Y'),(49,'EEE/IB Services','Automated tool used by business to get all the IB’s related to a particular parent quote','Y'),(50,'Infa Baseline','Supporting Non-Prod Issues across the projects and ERFC\'s pertaining to production bugs','Y'),(51,'Joint Business Plan','New integration between the EDW and VMSTAR for Booking data','Y'),(52,'Clarity','Integration added between the EBS and VMSTAR for Booking data','Y'),(53,'NRS','Data integrations between various end systems such as EBS,CP,Changepoint','Y'),(54,'AEM Roadmap','Engaged in Roadmap and microsite migration','Y'),(55,'ESG Migration','Migration of ESG development to Mulesoft','Y');
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(120) NOT NULL,
  `is_active` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN','Y'),(2,'PARTNER','Y'),(3,'DIRECTOR','Y'),(4,'SENIOR MANAGER','Y'),(5,'MANAGER','Y'),(6,'SENIOR CONSULTANT','Y'),(7,'CONSULTANT','Y'),(8,'BUSINESS TECHNOLOGY ANALYST','Y'),(9,'ASSOCIATE ANALYST','Y');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-16 10:25:43
