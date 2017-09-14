<?php 
	
	class RelSchema {
		
		private $nom;
		private $nombreCol;
		private $typeCol;
		private $stringT = 20;

		public function __construct($nom,$nombreCol,$typeCol) {
			$this->setNom($nom);
			$this->setNombreCol($nombreCol);
			$this->setTypeCol($typeCol);
		} 

		public function setNom($nom) {
			$this->$nom;
		}

		public function setNombreCol($nombreCol) {
			$this->$nombreCol;
		}

		public function setTypeCol($typeCol) {
			$this->$typeCol;
		}
		
	}

 ?>