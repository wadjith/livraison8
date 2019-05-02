-- --------------------------------------------------------
-- Hôte :                        localhost
-- Version du serveur:           5.7.19 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour pharmacie
CREATE DATABASE IF NOT EXISTS `pharmacie` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pharmacie`;

-- Export de la structure de la table pharmacie. produit
CREATE TABLE IF NOT EXISTS `produit` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `reference` varchar(5) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `prix` double NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ` (`reference`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COMMENT='Les produits à manipuler dans l''application';

-- Export de données de la table pharmacie.produit : ~4 rows (environ)
/*!40000 ALTER TABLE `produit` DISABLE KEYS */;
INSERT INTO `produit` (`id`, `reference`, `libelle`, `prix`, `quantite`) VALUES
	(1, 'ref1', 'produit 1', 125, 143),
	(2, 'ref2', 'produit 2', 150, 15),
	(4, 'ref3', 'produit 3', 1230, 7),
	(5, 'ref4', 'Produit 4', 125, 15),
	(6, 'ref5', 'produit 5', 126, 12),
	(7, 'Ref6', 'Produit 6', 124, 12),
	(8, 'Ref7', 'Produit 7', 1245, 25);
/*!40000 ALTER TABLE `produit` ENABLE KEYS */;

-- Export de la structure de la table pharmacie. utilisateur
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(100) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Export de données de la table pharmacie.utilisateur : ~0 rows (environ)
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `telephone`, `login`, `password`) VALUES
	(2, 'wadji', 'thierry', NULL, 'thierry', 'toto');
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
