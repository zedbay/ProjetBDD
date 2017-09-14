<?php 

	class RelSchema {
		
		private $_nom;
		private $_nombreCol;
		private $_typeCol;
		private $_stringT = 20;

		public function __construct($nom,$nombreCol) {
			$this->setNom($nom);
			$this->setNombreCol($nombreCol);
			//$this->setTypeCol($typeCol);
		} 

		public function setNom($nom) { $this->_nom = $nom; }
		public function setNombreCol($nombreCol) { $this->_nombreCol = $nombreCol; }
		public function setTypeCol($typeCol) { $this->_typeCol = $typeCol; }

		public function getNom() { return($this->_nom); }
		public function getNombreCol() { return($this->_nombreCol); }
		public function getTypeCol() { return($this->_typeCol); }

	}

	//echo "hello world"; 

 ?>