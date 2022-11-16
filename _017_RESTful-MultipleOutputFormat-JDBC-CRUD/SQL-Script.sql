CREATE SCHEMA `firmaveritabani` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

CREATE TABLE `firmaveritabani`.`Musteri` (
  `musteriId` INT NOT NULL AUTO_INCREMENT,
  `musteriNo` INT NULL,
  `musteriAdi` VARCHAR(45) NULL,
  `musteriSoyadi` VARCHAR(50) NULL,
  PRIMARY KEY (`musteriId`));
  
  
INSERT INTO `firmaveritabani`.`Musteri` (`musteriNo`, `musteriAdi`, `musteriSoyadi`) VALUES ('100', 'Burak', 'Yılmaz');
INSERT INTO `firmaveritabani`.`Musteri` (`musteriNo`, `musteriAdi`, `musteriSoyadi`) VALUES ('101', 'Burhan', 'Güven');
INSERT INTO `firmaveritabani`.`Musteri` (`musteriNo`, `musteriAdi`, `musteriSoyadi`) VALUES ('206', 'Anıl', 'Erdoğan');
INSERT INTO `firmaveritabani`.`Musteri` (`musteriNo`, `musteriAdi`, `musteriSoyadi`) VALUES ('307', 'Mustafa', 'Şen');

  
SELECT * FROM firmaveritabani.Musteri;
