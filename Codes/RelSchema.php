<?php 

	class RelSchema {
		
		private $nom;
		private $nombreCol;
		private $typeCol;
		private $stringT = 20;

		public function __construct($nom,$nombreCol) {
			$this->setNom($nom);
			$this->setNombreCol($nombreCol);
			//$this->setTypeCol($typeCol);
		} 

		public function setNom($nom) {
			$this->$nom = $nom;
		}

		public function setNombreCol($nombreCol) {
			$this->$nombreCol = $nombreCol;
		}

		public function setTypeCol($typeCol) {
			$this->$typeCol = $typeCol;
		}

		public function getNom() {
			echo $this->nom;
			//return($this->$nom);
		}

	}

	//echo "hello world"; 

 ?>