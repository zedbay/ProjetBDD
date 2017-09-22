<?php

	class DiskManager {

		public function createFile($fileId) {
			//définition du nom du fichier 
			$nameFile = "DB/Data_" . $fileId . ".rf";
			//Création du fichier ou ouverture s'il existe
			$newFile = fopen($nameFile, "w+");
		}

		public function addPage($idx) {

		}

		public function readPage($PageId, $Buffer) {

		}

		public function writePage($PageId, $Buffer) {

		}
	}
?>