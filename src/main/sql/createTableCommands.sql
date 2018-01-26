/**
 * invoicedto
 */
CREATE TABLE `invoicedto` (
  `invoiceNumber` varchar(25) NOT NULL,
  `invoiceDate` date DEFAULT NULL,
  `customerDetails` tinyblob,
  `itemDetailListJSON` longtext,
  `totalAmount` float DEFAULT NULL,
  PRIMARY KEY (`invoiceNumber`),
  UNIQUE KEY `invoiceNumber_UNIQUE` (`invoiceNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * for joining two tables
 */
CREATE TABLE `invoicedto_itemdetailpojodto` (
  `invoiceDto_invoiceNumber` varchar(25) NOT NULL,
  `itemdetailsList_serialNumber` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`invoiceDto_invoiceNumber`),
  UNIQUE KEY `UK_nrl475jros0h2k6sbgve98kr6` (`itemdetailsList_serialNumber`),
  CONSTRAINT `FK_429tewstjdgek89qqg8us30vs` FOREIGN KEY (`invoiceDto_invoiceNumber`) REFERENCES `invoicedto` (`invoiceNumber`),
  CONSTRAINT `FK_nrl475jros0h2k6sbgve98kr6` FOREIGN KEY (`itemdetailsList_serialNumber`) REFERENCES `itemdetailpojodto` (`serialNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/**
 * list of itemdetails table
 */
CREATE TABLE `itemdetailpojodto` (
  `serialNumber` varchar(25) NOT NULL,
  `itemDescription` varchar(45) DEFAULT NULL,
  `itemQuantity` int(11) DEFAULT NULL,
  `itemRate` float DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`serialNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
