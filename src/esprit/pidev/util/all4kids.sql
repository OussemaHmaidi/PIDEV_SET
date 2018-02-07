-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: all4kids
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `mp` varchar(45) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rue` varchar(45) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `ville` int(11) DEFAULT NULL,
  `x` text,
  `y` text,
  PRIMARY KEY (`id`),
  KEY `ville_fk_idx` (`ville`),
  CONSTRAINT `ville_fk` FOREIGN KEY (`ville`) REFERENCES `ville` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresse`
--

LOCK TABLES `adresse` WRITE;
/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annonce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `description` text,
  `prix` float DEFAULT NULL,
  `produit` int(11) DEFAULT NULL,
  `bon_plan` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bonPlan_fk_idx` (`produit`,`bon_plan`),
  KEY `produit_fk_idx` (`produit`),
  KEY `bonplan_fk` (`bon_plan`),
  CONSTRAINT `bonplan_fk` FOREIGN KEY (`bon_plan`) REFERENCES `bon_plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `produit_fk` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annonce`
--

LOCK TABLES `annonce` WRITE;
/*!40000 ALTER TABLE `annonce` DISABLE KEYS */;
/*!40000 ALTER TABLE `annonce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(45) DEFAULT NULL,
  `categorie` varchar(45) DEFAULT NULL,
  `contenu` text,
  `admin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `admin_fk_idx` (`admin`),
  CONSTRAINT `admin_fk` FOREIGN KEY (`admin`) REFERENCES `admin` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avis`
--

DROP TABLE IF EXISTS `avis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text,
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avis`
--

LOCK TABLES `avis` WRITE;
/*!40000 ALTER TABLE `avis` DISABLE KEYS */;
/*!40000 ALTER TABLE `avis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `babysitter`
--

DROP TABLE IF EXISTS `babysitter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `babysitter` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `mp` varchar(45) DEFAULT NULL,
  `cin` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `salaire` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `babysitter`
--

LOCK TABLES `babysitter` WRITE;
/*!40000 ALTER TABLE `babysitter` DISABLE KEYS */;
/*!40000 ALTER TABLE `babysitter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bon_plan`
--

DROP TABLE IF EXISTS `bon_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bon_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(45) DEFAULT NULL,
  `description` text,
  `categorie` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `remise` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bon_plan`
--

LOCK TABLES `bon_plan` WRITE;
/*!40000 ALTER TABLE `bon_plan` DISABLE KEYS */;
/*!40000 ALTER TABLE `bon_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cours`
--

DROP TABLE IF EXISTS `cours`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(45) DEFAULT NULL,
  `classe` varchar(45) DEFAULT NULL,
  `categorie` varchar(45) DEFAULT NULL,
  `pdf` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cours`
--

LOCK TABLES `cours` WRITE;
/*!40000 ALTER TABLE `cours` DISABLE KEYS */;
/*!40000 ALTER TABLE `cours` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dessin_anime`
--

DROP TABLE IF EXISTS `dessin_anime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dessin_anime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `chaine` varchar(45) DEFAULT NULL,
  `url` text,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dessin_anime`
--

LOCK TABLES `dessin_anime` WRITE;
/*!40000 ALTER TABLE `dessin_anime` DISABLE KEYS */;
/*!40000 ALTER TABLE `dessin_anime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfant`
--

DROP TABLE IF EXISTS `enfant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `sexe` varchar(45) DEFAULT NULL,
  `classe` varchar(45) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_fk_idx` (`parent`),
  CONSTRAINT `parent_fk` FOREIGN KEY (`parent`) REFERENCES `parent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfant`
--

LOCK TABLES `enfant` WRITE;
/*!40000 ALTER TABLE `enfant` DISABLE KEYS */;
/*!40000 ALTER TABLE `enfant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfant_vaccin`
--

DROP TABLE IF EXISTS `enfant_vaccin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enfant_vaccin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enfant` int(11) DEFAULT NULL,
  `vaccin` int(11) DEFAULT NULL,
  `statut` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `vaccin_fk_idx` (`vaccin`),
  CONSTRAINT `vaccin_fk` FOREIGN KEY (`vaccin`) REFERENCES `vaccin` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfant_vaccin`
--

LOCK TABLES `enfant_vaccin` WRITE;
/*!40000 ALTER TABLE `enfant_vaccin` DISABLE KEYS */;
/*!40000 ALTER TABLE `enfant_vaccin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evenement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `description` text,
  `prix` float DEFAULT NULL,
  `adresse` int(11) DEFAULT NULL,
  `bon_plan` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `adresse_fk_idx` (`adresse`),
  KEY `bonplan_fk_idx` (`bon_plan`),
  KEY `bonplan_fk` (`bon_plan`),
  CONSTRAINT `adresse_fk` FOREIGN KEY (`adresse`) REFERENCES `adresse` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_bonplan` FOREIGN KEY (`bon_plan`) REFERENCES `bon_plan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evenement`
--

LOCK TABLES `evenement` WRITE;
/*!40000 ALTER TABLE `evenement` DISABLE KEYS */;
/*!40000 ALTER TABLE `evenement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garderie`
--

DROP TABLE IF EXISTS `garderie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `garderie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `description` text,
  `adresse` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_adresse_idx` (`adresse`),
  CONSTRAINT `fk_adresse` FOREIGN KEY (`adresse`) REFERENCES `adresse` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garderie`
--

LOCK TABLES `garderie` WRITE;
/*!40000 ALTER TABLE `garderie` DISABLE KEYS */;
/*!40000 ALTER TABLE `garderie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jeu`
--

DROP TABLE IF EXISTS `jeu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jeu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `url` text,
  `type` varchar(45) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jeu`
--

LOCK TABLES `jeu` WRITE;
/*!40000 ALTER TABLE `jeu` DISABLE KEYS */;
/*!40000 ALTER TABLE `jeu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parc`
--

DROP TABLE IF EXISTS `parc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `decription` text,
  `adresse` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parc_adresse_fk_idx` (`adresse`),
  CONSTRAINT `parc_adresse_fk` FOREIGN KEY (`adresse`) REFERENCES `adresse` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parc`
--

LOCK TABLES `parc` WRITE;
/*!40000 ALTER TABLE `parc` DISABLE KEYS */;
/*!40000 ALTER TABLE `parc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parent`
--

DROP TABLE IF EXISTS `parent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `mp` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `cin` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parent`
--

LOCK TABLES `parent` WRITE;
/*!40000 ALTER TABLE `parent` DISABLE KEYS */;
/*!40000 ALTER TABLE `parent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacie`
--

DROP TABLE IF EXISTS `pharmacie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pharmacie` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `adresse` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pharmacie_adresse_fk_idx` (`adresse`),
  CONSTRAINT `pharmacie_adresse_fk` FOREIGN KEY (`adresse`) REFERENCES `adresse` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacie`
--

LOCK TABLES `pharmacie` WRITE;
/*!40000 ALTER TABLE `pharmacie` DISABLE KEYS */;
/*!40000 ALTER TABLE `pharmacie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plannification`
--

DROP TABLE IF EXISTS `plannification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plannification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `babysitter` int(11) DEFAULT NULL,
  `parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `babysitter_plannification_fk_idx` (`babysitter`),
  KEY `parent_plannification_fk_idx` (`parent`),
  CONSTRAINT `babysitter_plannification_fk` FOREIGN KEY (`babysitter`) REFERENCES `babysitter` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `parent_plannification_fk` FOREIGN KEY (`parent`) REFERENCES `parent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plannification`
--

LOCK TABLES `plannification` WRITE;
/*!40000 ALTER TABLE `plannification` DISABLE KEYS */;
/*!40000 ALTER TABLE `plannification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produit`
--

DROP TABLE IF EXISTS `produit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `description` text,
  `categorie` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produit`
--

LOCK TABLES `produit` WRITE;
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publication`
--

DROP TABLE IF EXISTS `publication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `contenu` text,
  `parent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_publication_fk_idx` (`parent`),
  CONSTRAINT `parent_publication_fk` FOREIGN KEY (`parent`) REFERENCES `parent` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publication`
--

LOCK TABLES `publication` WRITE;
/*!40000 ALTER TABLE `publication` DISABLE KEYS */;
/*!40000 ALTER TABLE `publication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaccin`
--

DROP TABLE IF EXISTS `vaccin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vaccin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `description` text,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaccin`
--

LOCK TABLES `vaccin` WRITE;
/*!40000 ALTER TABLE `vaccin` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaccin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ville`
--

DROP TABLE IF EXISTS `ville`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ville` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `code_postal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ville`
--

LOCK TABLES `ville` WRITE;
/*!40000 ALTER TABLE `ville` DISABLE KEYS */;
/*!40000 ALTER TABLE `ville` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-07 11:04:20
