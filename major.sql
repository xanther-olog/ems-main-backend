-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 21, 2020 at 09:35 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `major`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_regis`
--

CREATE TABLE `admin_regis` (
  `name` varchar(757) NOT NULL,
  `dob` varchar(757) NOT NULL,
  `clgid` varchar(757) NOT NULL,
  `pwd` varchar(757) NOT NULL,
  `phone` varchar(757) NOT NULL,
  `email` varchar(757) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_regis`
--

INSERT INTO `admin_regis` (`name`, `dob`, `clgid`, `pwd`, `phone`, `email`) VALUES
('Arkadeep Basu', '2019-12-17', '123', '12', 'wefr', 'arkadeepbasu2@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `userID` varchar(757) NOT NULL,
  `P` varchar(757) NOT NULL,
  `C` varchar(757) NOT NULL,
  `B` varchar(757) NOT NULL,
  `M` varchar(757) NOT NULL,
  `G` varchar(757) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`userID`, `P`, `C`, `B`, `M`, `G`) VALUES
('2020201912207294', 'yes', 'yes', 'yes', 'yes', 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `Merit`
--

CREATE TABLE `Merit` (
  `userID` varchar(255) NOT NULL,
  `P` int(255) NOT NULL,
  `C` int(255) NOT NULL,
  `B` int(255) NOT NULL,
  `M` int(255) NOT NULL,
  `G` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Merit`
--

INSERT INTO `Merit` (`userID`, `P`, `C`, `B`, `M`, `G`) VALUES
('1234', 79, 69, 39, 29, 19);

-- --------------------------------------------------------

--
-- Table structure for table `ques`
--

CREATE TABLE `ques` (
  `subject` varchar(40) NOT NULL,
  `ques_id` varchar(40) NOT NULL,
  `ques` varchar(750) NOT NULL,
  `option1` varchar(200) NOT NULL,
  `option2` varchar(200) NOT NULL,
  `option3` varchar(200) NOT NULL,
  `option4` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ques`
--

INSERT INTO `ques` (`subject`, `ques_id`, `ques`, `option1`, `option2`, `option3`, `option4`) VALUES
('subject_1', '1', 'Curabitur convallis.', 'adipiscing lorem vitae', 'non', 'tempor turpis nec', 'at vulputate'),
('subject_1', '2', 'Praesent blandit.', 'dolor', 'sed sagittis', 'purus sit', 'venenatis lacinia'),
('subject_1', '3', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.', 'at nunc', 'metus sapien ut', 'dui proin leo', 'nec'),
('subject_1', '4', 'In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', 'amet sem fusce', 'neque libero convallis', 'cubilia', 'integer pede justo'),
('subject_1', '5', 'In eleifend quam a odio. In hac habitasse platea dictumst.', 'vitae ipsum aliquam', 'interdum mauris', 'egestas', 'vestibulum ante'),
('subject_1', '6', 'Nunc nisl. Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', 'lacinia nisi venenatis', 'vitae nisi', 'ac consequat metus', 'amet'),
('subject_1', '7', 'Donec posuere metus vitae ipsum. Aliquam non mauris.', 'ligula', 'at', 'erat volutpat in', 'sit amet nunc'),
('subject_1', '8', 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', 'sapien non', 'ut ultrices vel', 'lobortis', 'in'),
('subject_1', '9', 'Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', 'tincidunt ante vel', 'ante ipsum primis', 'sit amet', 'gravida nisi at'),
('subject_1', '10', 'Integer ac leo.', 'metus', 'odio', 'felis', 'in hac habitasse'),
('subject_1', '11', 'Phasellus id sapien in sapien iaculis congue.', 'rhoncus aliquam', 'amet erat nulla', 'donec', 'phasellus in'),
('subject_1', '12', 'Aenean lectus.', 'donec vitae', 'pretium', 'ultrices', 'non'),
('subject_1', '13', 'Vivamus vestibulum sagittis sapien.', 'augue vestibulum rutrum', 'praesent blandit lacinia', 'nulla', 'in congue'),
('subject_1', '14', 'Suspendisse potenti.', 'leo', 'sapien cursus vestibulum', 'aenean sit amet', 'tempus vel pede'),
('subject_1', '15', 'Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue. Aliquam erat volutpat.', 'scelerisque', 'est donec', 'nec', 'ipsum'),
('subject_1', '16', 'Aliquam quis turpis eget elit sodales scelerisque.', 'dolor sit amet', 'in faucibus', 'ipsum dolor sit', 'ante nulla justo'),
('subject_1', '17', 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', 'vestibulum sed magna', 'mauris eget', 'convallis', 'enim leo'),
('subject_1', '18', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.', 'erat', 'vel lectus in', 'nec', 'elit proin'),
('subject_1', '19', 'Suspendisse ornare consequat lectus.', 'dolor sit amet', 'eget', 'placerat', 'id consequat'),
('subject_1', '20', 'Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', 'fermentum', 'non velit donec', 'libero ut', 'feugiat et eros'),
('subject_1', '21', 'In hac habitasse platea dictumst.', 'nulla pede', 'habitasse platea', 'blandit non interdum', 'cubilia'),
('subject_1', '22', 'Donec semper sapien a libero.', 'in', 'vitae', 'justo in', 'libero non'),
('subject_1', '23', 'Nunc rhoncus dui vel sem.', 'elementum nullam', 'duis bibendum felis', 'placerat ante nulla', 'dictumst'),
('subject_1', '24', 'Nulla tellus. In sagittis dui vel nisl. Duis ac nibh.', 'duis', 'sapien ut nunc', 'augue vestibulum ante', 'nulla'),
('subject_1', '25', 'Integer ac neque.', 'sapien in', 'in magna', 'odio donec', 'tempus'),
('subject_1', '26', 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.', 'maecenas tincidunt', 'nibh', 'congue', 'mi nulla'),
('subject_1', '27', 'Morbi vel lectus in quam fringilla rhoncus. Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', 'blandit lacinia erat', 'libero nullam sit', 'mi integer', 'faucibus accumsan odio'),
('subject_1', '28', 'Pellentesque ultrices mattis odio. Donec vitae nisi.', 'metus aenean fermentum', 'montes', 'nec euismod scelerisque', 'hac habitasse platea'),
('subject_1', '29', 'Aliquam erat volutpat. In congue. Etiam justo.', 'suscipit nulla elit', 'penatibus et magnis', 'ipsum', 'ligula'),
('subject_1', '30', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', 'sit amet', 'in leo maecenas', 'consequat varius integer', 'magnis dis'),
('subject_1', '31', 'Nam tristique tortor eu pede.', 'proin', 'tempus semper est', 'eleifend', 'vestibulum vestibulum'),
('subject_1', '32', 'Suspendisse ornare consequat lectus.', 'facilisi cras non', 'eget semper rutrum', 'lorem quisque ut', 'in tempor turpis'),
('subject_1', '33', 'Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 'ipsum primis', 'augue vestibulum rutrum', 'sit amet justo', 'rhoncus'),
('subject_1', '34', 'Nunc rhoncus dui vel sem.', 'morbi', 'lobortis est phasellus', 'sit amet', 'potenti nullam'),
('subject_1', '35', 'Vivamus vel nulla eget eros elementum pellentesque.', 'integer a', 'nonummy integer non', 'posuere cubilia curae', 'vitae mattis nibh'),
('subject_1', '36', 'Nulla facilisi.', 'magna at', 'cursus vestibulum proin', 'posuere', 'elit sodales scelerisque'),
('subject_1', '37', 'Suspendisse potenti.', 'in ante vestibulum', 'dui nec', 'ut', 'potenti cras in'),
('subject_1', '38', 'Donec ut dolor.', 'faucibus', 'donec pharetra magna', 'tempor', 'luctus nec molestie'),
('subject_1', '39', 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.', 'pharetra', 'pulvinar sed nisl', 'pretium', 'ligula in lacus'),
('subject_1', '40', 'Donec posuere metus vitae ipsum. Aliquam non mauris.', 'luctus', 'nulla', 'molestie sed justo', 'amet nulla quisque'),
('subject_1', '41', 'Mauris lacinia sapien quis libero.', 'potenti nullam', 'nascetur', 'integer ac neque', 'sed accumsan'),
('subject_1', '42', 'Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl. Nunc rhoncus dui vel sem.', 'augue vestibulum', 'pede', 'ipsum', 'sed tincidunt'),
('subject_1', '43', 'Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', 'nulla', 'proin eu mi', 'elementum', 'non'),
('subject_1', '44', 'Vivamus vel nulla eget eros elementum pellentesque.', 'luctus ultricies', 'aenean', 'euismod scelerisque quam', 'dolor'),
('subject_1', '45', 'Aenean sit amet justo.', 'eget vulputate ut', 'scelerisque', 'ipsum primis in', 'tristique'),
('subject_1', '46', 'Nam dui. Proin leo odio, porttitor id, consequat in, consequat ut, nulla.', 'ultrices posuere', 'commodo placerat', 'luctus tincidunt nulla', 'vel'),
('subject_1', '47', 'In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.', 'ac neque', 'suspendisse', 'eros', 'at nunc commodo'),
('subject_1', '48', 'Nulla nisl.', 'id turpis', 'sed vestibulum sit', 'nisl aenean', 'a'),
('subject_1', '49', 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.', 'mauris sit', 'faucibus orci luctus', 'interdum venenatis turpis', 'quis'),
('subject_1', '50', 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.', 'augue vestibulum', 'ultrices vel', 'vestibulum ante', 'cras'),
('subject_1', '51', 'Donec ut mauris eget massa tempor convallis.', 'convallis nulla neque', 'pretium iaculis diam', 'eu magna', 'dui luctus'),
('subject_1', '52', 'Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna.', 'posuere', 'potenti nullam porttitor', 'ipsum primis in', 'velit id'),
('subject_1', '53', 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 'sem mauris laoreet', 'amet', 'rhoncus', 'interdum venenatis'),
('subject_1', '54', 'Morbi vel lectus in quam fringilla rhoncus.', 'at velit vivamus', 'lacinia sapien quis', 'vivamus', 'natoque penatibus'),
('subject_1', '55', 'Nulla tellus. In sagittis dui vel nisl.', 'dictumst aliquam augue', 'vestibulum', 'sem sed', 'venenatis'),
('subject_1', '56', 'Proin at turpis a pede posuere nonummy.', 'lorem quisque', 'cras', 'dui', 'suspendisse potenti'),
('subject_1', '57', 'Nulla facilisi. Cras non velit nec nisi vulputate nonummy.', 'diam neque vestibulum', 'vulputate justo', 'curae nulla dapibus', 'massa tempor convallis'),
('subject_1', '58', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 'lacus', 'sed nisl nunc', 'odio', 'dictumst maecenas'),
('subject_1', '59', 'Nulla ut erat id mauris vulputate elementum.', 'eros elementum', 'mauris enim', 'phasellus in', 'vitae'),
('subject_1', '60', 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.', 'nec nisi volutpat', 'vestibulum', 'donec odio', 'phasellus in felis'),
('subject_1', '61', 'Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius.', 'quam', 'nec', 'augue', 'lectus pellentesque'),
('subject_1', '62', 'Nullam sit amet turpis elementum ligula vehicula consequat. Morbi a ipsum.', 'nam', 'sed sagittis', 'at vulputate', 'placerat praesent'),
('subject_1', '63', 'Quisque ut erat.', 'cubilia curae', 'at', 'at lorem', 'varius'),
('subject_1', '64', 'Duis bibendum. Morbi non quam nec dui luctus rutrum.', 'sit', 'vel', 'metus', 'in lectus'),
('subject_1', '65', 'Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam.', 'nullam porttitor lacus', 'vel', 'sit amet', 'vitae mattis nibh'),
('subject_1', '66', 'Etiam pretium iaculis justo.', 'faucibus orci luctus', 'nibh fusce', 'consectetuer', 'mauris'),
('subject_1', '67', 'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci. Nullam molestie nibh in lectus. Pellentesque at nulla.', 'rhoncus sed', 'id pretium iaculis', 'pede', 'amet'),
('subject_1', '68', 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', 'ligula', 'nisl venenatis', 'venenatis non', 'luctus et'),
('subject_1', '69', 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', 'tincidunt', 'porta', 'placerat ante', 'dignissim'),
('subject_1', '70', 'Vivamus vestibulum sagittis sapien.', 'at dolor quis', 'nulla sed', 'pellentesque ultrices phasellus', 'sapien'),
('subject_1', '71', 'Duis at velit eu est congue elementum. In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.', 'tristique est', 'magna ac consequat', 'tellus semper interdum', 'orci pede'),
('subject_1', '72', 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.', 'lobortis vel dapibus', 'faucibus', 'et magnis', 'pede ullamcorper'),
('subject_1', '73', 'In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat. Nulla nisl.', 'eu tincidunt', 'vestibulum', 'in', 'nunc nisl duis'),
('subject_1', '74', 'Vivamus tortor. Duis mattis egestas metus. Aenean fermentum.', 'mi pede malesuada', 'lacus', 'magna vestibulum', 'et'),
('subject_1', '75', 'In congue.', 'consequat varius', 'nec euismod scelerisque', 'lacinia', 'placerat'),
('subject_1', '76', 'Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis.', 'ut', 'faucibus orci', 'donec', 'rhoncus aliquam lacus'),
('subject_1', '77', 'Cras non velit nec nisi vulputate nonummy.', 'arcu libero rutrum', 'urna pretium', 'vel ipsum praesent', 'sapien iaculis'),
('subject_1', '78', 'Ut tellus. Nulla ut erat id mauris vulputate elementum.', 'fusce', 'erat', 'aenean lectus', 'ligula nec'),
('subject_1', '79', 'Aliquam non mauris. Morbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet.', 'nunc proin', 'sit amet', 'maecenas rhoncus', 'proin interdum'),
('subject_1', '80', 'In congue.', 'suspendisse potenti', 'nam dui proin', 'primis', 'eget elit sodales'),
('subject_1', '81', 'Sed ante. Vivamus tortor. Duis mattis egestas metus.', 'vestibulum', 'nisl nunc', 'consequat', 'quis tortor'),
('subject_1', '82', 'Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', 'arcu libero rutrum', 'molestie sed', 'vel nulla eget', 'curabitur convallis'),
('subject_1', '83', 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', 'vulputate elementum', 'eu', 'donec ut dolor', 'lacus purus'),
('subject_1', '84', 'Nulla justo. Aliquam quis turpis eget elit sodales scelerisque.', 'integer', 'nisl ut', 'odio donec', 'odio'),
('subject_1', '85', 'Vivamus vel nulla eget eros elementum pellentesque.', 'pellentesque volutpat dui', 'massa donec dapibus', 'enim', 'sit amet diam'),
('subject_1', '86', 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue. Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl.', 'curae', 'pretium quis', 'lacus', 'aliquam lacus'),
('subject_1', '87', 'Nulla tempus. Vivamus in felis eu sapien cursus vestibulum.', 'amet', 'in congue etiam', 'rutrum rutrum neque', 'sapien cursus'),
('subject_1', '88', 'Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.', 'quam', 'in porttitor pede', 'molestie sed', 'nam congue risus'),
('subject_1', '89', 'In est risus, auctor sed, tristique in, tempus sit amet, sem.', 'semper interdum mauris', 'interdum mauris', 'tristique est et', 'in'),
('subject_1', '90', 'Ut at dolor quis odio consequat varius. Integer ac leo. Pellentesque ultrices mattis odio.', 'lacinia eget', 'suscipit nulla elit', 'rutrum', 'nulla');

-- --------------------------------------------------------

--
-- Table structure for table `regis`
--

CREATE TABLE `regis` (
  `userID` varchar(757) NOT NULL,
  `name` varchar(757) NOT NULL,
  `dob` varchar(757) NOT NULL,
  `fname` varchar(757) NOT NULL,
  `pwd` varchar(757) NOT NULL,
  `sex` varchar(757) NOT NULL,
  `idtype` varchar(757) NOT NULL,
  `uidno` varchar(757) NOT NULL,
  `phone` varchar(757) NOT NULL,
  `email` varchar(757) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `regis`
--

INSERT INTO `regis` (`userID`, `name`, `dob`, `fname`, `pwd`, `sex`, `idtype`, `uidno`, `phone`, `email`) VALUES
('2020201912207294', 'Arkadeep Basu', '2019-12-20', 'wdef', '12', 'Male', 'passport', 'wde', 'wefr', 'arkadeepbasu2@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_regis`
--
ALTER TABLE `admin_regis`
  ADD PRIMARY KEY (`clgid`,`phone`,`email`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `regis`
--
ALTER TABLE `regis`
  ADD PRIMARY KEY (`userID`,`email`,`uidno`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
