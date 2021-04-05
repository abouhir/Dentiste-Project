-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 05 avr. 2021 à 13:29
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `lp_java_mini_project`
--

-- --------------------------------------------------------

--
-- Structure de la table `certificat`
--

CREATE TABLE `certificat` (
  `cert_id` bigint(20) NOT NULL,
  `fvst_id` bigint(20) NOT NULL,
  `cert_date` datetime DEFAULT NULL,
  `cert_description` varchar(1024) DEFAULT NULL,
  `cert_duree` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `cli_id` bigint(20) NOT NULL,
  `cli_fullName` varchar(254) DEFAULT NULL,
  `cli_cin` varchar(254) DEFAULT NULL,
  `cli_tele` varchar(254) DEFAULT NULL,
  `cli_address` varchar(254) DEFAULT NULL,
  `cli_email` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`cli_id`, `cli_fullName`, `cli_cin`, `cli_tele`, `cli_address`, `cli_email`) VALUES
(12, 'anass bouhir', 'bouhir', 'bouhir', 'bouhir', 'bouhir'),
(27, 'dvdv', 'dvdv', 'dvdv', 'dvdv', 'aazzzzz'),
(28, 'anass bouhir', 'BR789654', '0664433418', '97 boumdiane el gheouti hay dakhla casablanca', 'anass@gmail.com'),
(30, 'ùaradona', 'c dc', 'dscxs', 'sxcdc', 'dcx'),
(31, 'bouhir abderrahmane', 'BL155590', '0652157462', '97 boumdiane el gheouti hay dakhla', 'abouhir14@gmail.com'),
(37, 'ecd', 'xxxxxxxxxxxx', 'xxxxxxxxxxxxx', 'xxxxxxxxxxx', 'xxxxxxxxxxxx');

-- --------------------------------------------------------

--
-- Structure de la table `contenir`
--

CREATE TABLE `contenir` (
  `ford_id` int(11) NOT NULL,
  `fmedic_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `contenir`
--

INSERT INTO `contenir` (`ford_id`, `fmedic_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 2),
(2, 3),
(21, 1),
(21, 2),
(22, 1),
(22, 2),
(23, 1),
(23, 2),
(23, 4),
(23, 5),
(24, 1),
(24, 2),
(24, 4),
(24, 5),
(25, 1),
(25, 2),
(25, 4),
(25, 5),
(26, 1),
(26, 2),
(26, 4),
(26, 5),
(27, 1),
(27, 2),
(28, 1),
(28, 2),
(29, 7),
(30, 10),
(31, 2),
(32, 1),
(32, 2);

-- --------------------------------------------------------

--
-- Structure de la table `dentiste`
--

CREATE TABLE `dentiste` (
  `dent_id` bigint(20) NOT NULL,
  `dent_fullName` varchar(254) DEFAULT NULL,
  `dent_cin` varchar(254) DEFAULT NULL,
  `dent_tele` varchar(254) DEFAULT NULL,
  `dent_address` varchar(254) DEFAULT NULL,
  `dent_email` varchar(254) DEFAULT NULL,
  `dent_usernm` varchar(254) DEFAULT NULL,
  `dent_passwd` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `dentiste`
--

INSERT INTO `dentiste` (`dent_id`, `dent_fullName`, `dent_cin`, `dent_tele`, `dent_address`, `dent_email`, `dent_usernm`, `dent_passwd`) VALUES
(1, '', '', '', '', '', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

CREATE TABLE `facture` (
  `fact_id` bigint(20) NOT NULL,
  `fvst_id` bigint(20) NOT NULL,
  `fact_prixTotale` decimal(8,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `infermier`
--

CREATE TABLE `infermier` (
  `inf_id` bigint(20) NOT NULL,
  `inf_fullName` varchar(254) DEFAULT NULL,
  `inf_cin` varchar(254) DEFAULT NULL,
  `inf_tele` varchar(254) DEFAULT NULL,
  `inf_address` varchar(254) DEFAULT NULL,
  `inf_email` varchar(254) DEFAULT NULL,
  `inf_usernm` varchar(254) DEFAULT NULL,
  `inf_passwd` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `infermier`
--

INSERT INTO `infermier` (`inf_id`, `inf_fullName`, `inf_cin`, `inf_tele`, `inf_address`, `inf_email`, `inf_usernm`, `inf_passwd`) VALUES
(1, 'soumiya', 'br89562', '0659874563', 'casablanca', 'soumiya@gmail.com', 'admin0', 'admin0');

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

CREATE TABLE `medicament` (
  `medic_id` int(11) NOT NULL,
  `medic_nom` varchar(254) DEFAULT NULL,
  `medic_description` varchar(1024) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medicament`
--

INSERT INTO `medicament` (`medic_id`, `medic_nom`, `medic_description`) VALUES
(1, 'dolipranne', 'mezyane'),
(2, 'rasp', 'description'),
(3, '', 'description'),
(4, 'karlose', 'description'),
(5, 'rasberry', 'description'),
(6, 'mamzyanch', 'description'),
(7, 'ftcfvc', 'description'),
(8, 'soba', 'description'),
(9, 'aspro', 'description'),
(10, 'vvvv', 'description');

-- --------------------------------------------------------

--
-- Structure de la table `ordonnance`
--

CREATE TABLE `ordonnance` (
  `ord_id` int(11) NOT NULL,
  `fvst_id` bigint(20) NOT NULL,
  `ord_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ordonnance`
--

INSERT INTO `ordonnance` (`ord_id`, `fvst_id`, `ord_date`) VALUES
(1, 2, '2021-03-22 09:32:27'),
(2, 37, '2021-03-27 13:46:14'),
(3, 38, '2021-03-27 13:49:13'),
(4, 39, '2021-03-27 13:53:46'),
(5, 40, '2021-03-27 13:58:03'),
(6, 41, '2021-03-27 14:01:44'),
(7, 42, '2021-03-27 14:06:40'),
(8, 43, '2021-03-27 14:09:05'),
(9, 44, '2021-03-27 14:10:51'),
(10, 45, '2021-03-27 14:16:15'),
(11, 46, '2021-03-27 14:20:30'),
(12, 47, '2021-03-27 14:24:30'),
(13, 48, '2021-03-27 14:30:47'),
(14, 49, '2021-03-27 14:34:45'),
(15, 50, '2021-03-27 14:35:51'),
(16, 51, '2021-03-27 14:40:10'),
(17, 52, '2021-03-27 14:47:05'),
(18, 53, '2021-03-27 14:49:08'),
(19, 54, '2021-03-27 14:52:10'),
(20, 55, '2021-03-27 14:53:56'),
(21, 56, '2021-03-27 14:55:18'),
(22, 57, '2021-03-27 14:56:46'),
(23, 60, '2021-03-28 10:30:10'),
(24, 60, '2021-03-28 10:30:59'),
(25, 60, '2021-03-28 10:31:45'),
(26, 61, '2021-03-28 10:36:58'),
(27, 62, '2021-03-28 10:39:58'),
(28, 63, '2021-03-28 10:47:14'),
(29, 65, '2021-04-03 17:23:29'),
(30, 66, '2021-04-05 10:56:42'),
(31, 67, '2021-04-05 11:21:06'),
(32, 68, '2021-04-05 11:26:28');

-- --------------------------------------------------------

--
-- Structure de la table `rendezvous`
--

CREATE TABLE `rendezvous` (
  `rdv_id` bigint(20) NOT NULL,
  `finf_id` bigint(20) NOT NULL,
  `fcli_id` bigint(20) NOT NULL,
  `rdv_date` date DEFAULT NULL,
  `rdv_createdAt` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `rendezvous`
--

INSERT INTO `rendezvous` (`rdv_id`, `finf_id`, `fcli_id`, `rdv_date`, `rdv_createdAt`) VALUES
(2, 1, 12, '2021-03-15', NULL),
(3, 1, 12, '2021-03-23', NULL),
(4, 1, 12, '2021-03-31', NULL),
(5, 1, 12, '2021-03-15', NULL),
(6, 1, 12, '2021-03-30', NULL),
(7, 1, 12, '2021-03-31', '2021-03-17 16:13:28'),
(8, 1, 12, '2021-03-24', '2021-03-17 16:47:26'),
(9, 1, 12, '2021-03-17', '2021-03-17 19:01:50'),
(10, 1, 27, '2021-03-17', '2021-03-17 22:29:02'),
(11, 1, 28, '2021-03-18', '2021-03-18 14:17:06'),
(12, 1, 12, '2021-03-18', '2021-03-18 15:20:56'),
(13, 1, 12, '2021-03-18', '2021-03-18 16:06:05'),
(14, 1, 30, '2021-03-19', '2021-03-19 10:03:05'),
(15, 1, 31, '2021-03-20', '2021-03-20 09:55:04'),
(16, 1, 31, '2021-03-21', '2021-03-21 11:31:31'),
(17, 1, 27, '2021-03-26', '2021-03-26 12:47:20'),
(18, 1, 12, '2021-03-28', '2021-03-28 12:05:20'),
(19, 1, 27, '2021-03-28', '2021-03-28 12:08:59');

-- --------------------------------------------------------

--
-- Structure de la table `visite`
--

CREATE TABLE `visite` (
  `vst_id` bigint(20) NOT NULL,
  `fcli_id` bigint(20) NOT NULL,
  `fdent_id` bigint(20) NOT NULL,
  `vst_date` datetime DEFAULT NULL,
  `vst_traitement` varchar(1024) DEFAULT NULL,
  `vst_remarque` varchar(1024) DEFAULT NULL,
  `price` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `visite`
--

INSERT INTO `visite` (`vst_id`, `fcli_id`, `fdent_id`, `vst_date`, `vst_traitement`, `vst_remarque`, `price`) VALUES
(2, 31, 1, '2021-03-24 11:31:46', 'bouh', '', NULL),
(31, 28, 1, '2021-03-27 14:25:41', 'f f ', 'txtRemarque.getText()', NULL),
(32, 27, 1, '2021-03-27 14:27:36', 'dvdcvc', 'txtRemarque.getText()', NULL),
(37, 31, 1, '2021-03-27 14:46:04', 'cdv cv', 'txtRemarque.getText()', NULL),
(38, 30, 1, '2021-03-27 14:49:03', 'fv fv fv', 'txtRemarque.getText()', NULL),
(39, 30, 1, '2021-03-27 14:53:33', 'dvdvdv', 'txtRemarque.getText()', NULL),
(40, 27, 1, '2021-03-27 14:57:53', 'fvfbvb', 'txtRemarque.getText()', NULL),
(41, 28, 1, '2021-03-27 15:01:33', 'anasssssssss', 'txtRemarque.getText()', NULL),
(42, 27, 1, '2021-03-27 15:06:29', 'vdvdvfb', 'txtRemarque.getText()', NULL),
(43, 27, 1, '2021-03-27 15:08:53', 'bcjscbdjc', 'txtRemarque.getText()', NULL),
(44, 28, 1, '2021-03-27 15:10:37', 'vvvvvvvvvvvvvvv', 'txtRemarque.getText()', NULL),
(45, 28, 1, '2021-03-27 15:16:04', 'dvfvbfbfb', 'txtRemarque.getText()', NULL),
(46, 27, 1, '2021-03-27 15:20:21', 'xxxxxxxxxxxxxxxxxxxx', 'txtRemarque.getText()', NULL),
(47, 28, 1, '2021-03-27 15:24:17', 'vvvvvvvvvvvvvvnbgb', 'txtRemarque.getText()', NULL),
(48, 30, 1, '2021-03-27 15:30:33', 'ijioj,h hh hhuouhhhhuhuhu hohuih', 'txtRemarque.getText()', NULL),
(49, 28, 1, '2021-03-27 15:34:35', 'vvfvfvfv', 'txtRemarque.getText()', NULL),
(50, 27, 1, '2021-03-27 15:35:41', ',ooooooodcdvdvdv', 'txtRemarque.getText()', NULL),
(51, 28, 1, '2021-03-27 15:39:59', 'cdvbdhvb', 'txtRemarque.getText()', NULL),
(52, 27, 1, '2021-03-27 15:44:04', 'igygyubbib', 'txtRemarque.getText()', NULL),
(53, 30, 1, '2021-03-27 15:48:56', 'dvdvdv', 'txtRemarque.getText()', NULL),
(54, 28, 1, '2021-03-27 15:52:02', 'bbbbbbfvbfvf', 'txtRemarque.getText()', NULL),
(55, 27, 1, '2021-03-27 15:53:44', 'cdvdcvbfvb', 'txtRemarque.getText()', NULL),
(56, 27, 1, '2021-03-27 15:55:10', 'f fb fbfvgf', 'txtRemarque.getText()', NULL),
(57, 27, 1, '2021-03-27 15:56:36', 'CCCCCCCCCCCCC', 'txtRemarque.getText()', NULL),
(58, 28, 1, '2021-03-28 11:27:10', 'anass bouhir 1988 ', 'txtRemarque.getText()', NULL),
(59, 27, 1, '2021-03-28 11:28:06', 'bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb', 'txtRemarque.getText()', NULL),
(60, 27, 1, '2021-03-28 11:29:46', 'ddddddddd', 'txtRemarque.getText()', NULL),
(61, 28, 1, '2021-03-28 11:36:45', 'edecfdvcdfvfv', 'txtRemarque.getText()', NULL),
(62, 28, 1, '2021-03-28 11:39:44', 'dcdvfv', 'txtRemarque.getText()', NULL),
(63, 28, 1, '2021-03-28 11:46:58', 'scdcd', 'txtRemarque.getText()', NULL),
(64, 27, 1, '2021-04-03 18:17:29', 'anana', 'txtRemarque.getText()', NULL),
(65, 12, 1, '2021-04-03 18:23:11', 'dcdv', 'txtRemarque.getText()', NULL),
(66, 12, 1, '2021-04-05 11:56:09', 'bouhir', 'txtRemarque.getText()', NULL),
(67, 27, 1, '2021-04-05 12:20:57', 'ccccc', 'txtRemarque.getText()', NULL),
(68, 27, 1, '2021-04-05 12:26:06', 'writa', 'txtRemarque.getText()', NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `certificat`
--
ALTER TABLE `certificat`
  ADD PRIMARY KEY (`cert_id`),
  ADD KEY `FK_association8` (`fvst_id`);

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`cli_id`);

--
-- Index pour la table `contenir`
--
ALTER TABLE `contenir`
  ADD PRIMARY KEY (`ford_id`,`fmedic_id`),
  ADD KEY `FK_CONTENIR1` (`fmedic_id`);

--
-- Index pour la table `dentiste`
--
ALTER TABLE `dentiste`
  ADD PRIMARY KEY (`dent_id`);

--
-- Index pour la table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`fact_id`),
  ADD KEY `FK_association11` (`fvst_id`);

--
-- Index pour la table `infermier`
--
ALTER TABLE `infermier`
  ADD PRIMARY KEY (`inf_id`);

--
-- Index pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD PRIMARY KEY (`medic_id`);

--
-- Index pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD PRIMARY KEY (`ord_id`),
  ADD KEY `FK_association4` (`fvst_id`);

--
-- Index pour la table `rendezvous`
--
ALTER TABLE `rendezvous`
  ADD PRIMARY KEY (`rdv_id`),
  ADD KEY `FK_association1` (`fcli_id`),
  ADD KEY `FK_association9` (`finf_id`);

--
-- Index pour la table `visite`
--
ALTER TABLE `visite`
  ADD PRIMARY KEY (`vst_id`),
  ADD KEY `FK_Relationship_7` (`fcli_id`),
  ADD KEY `FK_association10` (`fdent_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `certificat`
--
ALTER TABLE `certificat`
  MODIFY `cert_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `cli_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT pour la table `dentiste`
--
ALTER TABLE `dentiste`
  MODIFY `dent_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `facture`
--
ALTER TABLE `facture`
  MODIFY `fact_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `infermier`
--
ALTER TABLE `infermier`
  MODIFY `inf_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `medicament`
--
ALTER TABLE `medicament`
  MODIFY `medic_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  MODIFY `ord_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT pour la table `rendezvous`
--
ALTER TABLE `rendezvous`
  MODIFY `rdv_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `visite`
--
ALTER TABLE `visite`
  MODIFY `vst_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `certificat`
--
ALTER TABLE `certificat`
  ADD CONSTRAINT `FK_association8` FOREIGN KEY (`fvst_id`) REFERENCES `visite` (`vst_id`);

--
-- Contraintes pour la table `contenir`
--
ALTER TABLE `contenir`
  ADD CONSTRAINT `FK_CONTENIR1` FOREIGN KEY (`fmedic_id`) REFERENCES `medicament` (`medic_id`),
  ADD CONSTRAINT `FK_CONTENIR2` FOREIGN KEY (`ford_id`) REFERENCES `ordonnance` (`ord_id`);

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `FK_association11` FOREIGN KEY (`fvst_id`) REFERENCES `visite` (`vst_id`);

--
-- Contraintes pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD CONSTRAINT `FK_association4` FOREIGN KEY (`fvst_id`) REFERENCES `visite` (`vst_id`);

--
-- Contraintes pour la table `rendezvous`
--
ALTER TABLE `rendezvous`
  ADD CONSTRAINT `FK_association1` FOREIGN KEY (`fcli_id`) REFERENCES `client` (`cli_id`),
  ADD CONSTRAINT `FK_association9` FOREIGN KEY (`finf_id`) REFERENCES `infermier` (`inf_id`);

--
-- Contraintes pour la table `visite`
--
ALTER TABLE `visite`
  ADD CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`fcli_id`) REFERENCES `client` (`cli_id`),
  ADD CONSTRAINT `FK_association10` FOREIGN KEY (`fdent_id`) REFERENCES `dentiste` (`dent_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
