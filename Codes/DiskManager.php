<?php

	class DiskManager {

		public function createFile($fileId) {
			//définition du nom du fichier 
			$nameFile = "DB/Data_" . $fileId . ".rf";
			//Création du fichier ou ouverture s'il existe
			$newFile = fopen($nameFile, "w+");
			fclose($newFile);
		}

		public function addPage($fileIdx) {
			$pageVide = "0";
			$nameFile = "DB/Data_" . $fileIdx . ".rf";
			$newFile = fopen($nameFile, "a+");
			for($i=0;$i<4096;$i++) {
				fputs($newFile, $pageVide);
			}
			$tailleFichier = filesize($nameFile);
			fclose($newFile);
			$newPageId = new PageId($fileIdx,(($tailleFichier/4096)-1));
			return($newPageId);
		}

		public function readPage($pageId) {
			$buffer;
			$nameFile = "DB/Data_" . $pageId->getFildeId() . ".rf";
			$newFile = fopen($nameFile, "r");
			$pageIdx = $pageId->getIdx();
			fseek($newFile, ($pageIdx*4096));
			$buffer = fread($newFile, 4096);
			fclose($newFile);
			return($buffer);
		}

		public function writePage($pageId, $buffer) {
			$nameFile = "DB/Data_" . $pageId->getFildeId() . ".rf";
			$newFile = fopen($nameFile, "a+");
			$pageIdx = $pageId->getIdx();
			$newTaille = (filesize($nameFile)-4096);
			fseek($newFile, ($pageIdx*4096));
			ftruncate($newFile, $newTaille);
			fputs($newFile,$buffer);
			fclose($newFile);
		}
	}
?>