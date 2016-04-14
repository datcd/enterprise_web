

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";



CREATE TABLE `account` (
  `AID` int(11) NOT NULL,
  `ARID` int(11) DEFAULT NULL,
  `fId` int(11) DEFAULT NULL,
  `AFirstName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `ALastName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `AUsername` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `APassword` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `AEmail` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `AAddress` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `Aphone` int(11) DEFAULT NULL
) 

CREATE TABLE `accountrole` (
  `ARID` int(11) NOT NULL,
  `ARName` varchar(100) CHARACTER SET utf8 DEFAULT NULL
) 
CREATE TABLE `cmr2` (
  `CMRid` int(11) NOT NULL,
  `cId` int(11) NOT NULL,
  `studentCount` int(11) NOT NULL,
  `meancw1` float NOT NULL,
  `meancw2` float NOT NULL,
  `meanexam` float NOT NULL,
  `mediancw1` float NOT NULL,
  `mediancw2` float NOT NULL,
  `medianexam` float NOT NULL,
  `distributioncw1type1` int(11) NOT NULL,
  `distributioncw2type1` int(11) NOT NULL,
  `distributionexamtype1` int(11) NOT NULL,
  `status` varchar(100) NOT NULL
) 

CREATE TABLE `comment` (
  `COID` int(11) NOT NULL,
  `CMRid` int(11) NOT NULL,
  `content` varchar(200) NOT NULL
) 

CREATE TABLE `course` (
  `cId` int(11) NOT NULL,
  `fId` int(11) DEFAULT NULL,
  `cCode` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `cName` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `cDescription` text COLLATE utf8_vietnamese_ci,
  `cStart` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `cEnd` varchar(100) CHARACTER SET utf8 DEFAULT NULL
) 

CREATE TABLE `courseassigned` (
  `CAID` int(11) NOT NULL,
  `cId` int(11) DEFAULT NULL,
  `CMID` int(11) DEFAULT NULL,
  `CLID` int(11) DEFAULT NULL,
  `cStart` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `cEnd` varchar(100) CHARACTER SET utf8 DEFAULT NULL
)

CREATE TABLE `faculty` (
  `fId` int(11) NOT NULL,
  `fName` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `fCode` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `fDescription` text COLLATE utf8_vietnamese_ci
) 
ALTER TABLE `account`
  ADD PRIMARY KEY (`AID`),
  ADD KEY `ARID` (`ARID`),
  ADD KEY `fId` (`fId`);

--
-- Indexes for table `accountrole`
--
ALTER TABLE `accountrole`
  ADD PRIMARY KEY (`ARID`);

--
-- Indexes for table `cmr`
--


--
-- Indexes for table `cmr2`
--
ALTER TABLE `cmr2`
  ADD PRIMARY KEY (`CMRid`,`cId`),
  ADD KEY `fk_cmr2_course` (`cId`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`COID`),
  ADD KEY `CMRid` (`CMRid`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`cId`),
  ADD UNIQUE KEY `cCode` (`cCode`),
  ADD KEY `fId` (`fId`);

--
-- Indexes for table `courseassigned`
--
ALTER TABLE `courseassigned`
  ADD PRIMARY KEY (`CAID`),
  ADD KEY `cId` (`cId`),
  ADD KEY `CMID` (`CMID`),
  ADD KEY `CLID` (`CLID`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`fId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `AID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `accountrole`
--
ALTER TABLE `accountrole`
  MODIFY `ARID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `cmr2`
--
ALTER TABLE `cmr2`
  MODIFY `CMRid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `cId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `courseassigned`
--
ALTER TABLE `courseassigned`
  MODIFY `CAID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `faculty`
--
ALTER TABLE `faculty`
  MODIFY `fId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`ARID`) REFERENCES `accountrole` (`ARID`),
  ADD CONSTRAINT `account_ibfk_2` FOREIGN KEY (`fId`) REFERENCES `faculty` (`fId`);

--
-- Constraints for table `cmr`
--


--
-- Constraints for table `cmr2`
--
ALTER TABLE `cmr2`
  ADD CONSTRAINT `fk_cmr2_course` FOREIGN KEY (`cId`) REFERENCES `course` (`cId`);

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `fk_Coment_CMR` FOREIGN KEY (`CMRid`) REFERENCES `cmr2` (`CMRid`);

--
-- Constraints for table `courseassigned`
--
ALTER TABLE `courseassigned`
  ADD CONSTRAINT `fk_CL_AC` FOREIGN KEY (`CLID`) REFERENCES `account` (`AID`),
  ADD CONSTRAINT `fk_ca_course` FOREIGN KEY (`cId`) REFERENCES `course` (`cId`),
  ADD CONSTRAINT `fk_cm_course` FOREIGN KEY (`CMID`) REFERENCES `account` (`AID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
