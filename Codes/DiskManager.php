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
			$newFile = fopen($nameFile, "w+");
			for($i=0;$i<4096;$i++) {
				fputs($newFile, $pageVide);
			}
			fclose($newFile);
		}

		public function readPage($pageId, $buffer) {

		}

		public function writePage($pageId, $buffer) {

		}
	}
?>