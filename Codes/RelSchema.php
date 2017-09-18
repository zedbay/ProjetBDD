<?php 

	class RelSchema {
		
		private $_nombreCol;
		private $_typeCol = array();
		private $_stringT = 20;
		private $_nom;

		public function __construct($detailCommande) {
			$this->setNom($detailCommande[1]);
			$this->setNombreCol(count($detailCommande)-3);
			for($i=0;$i<$this->_nombreCol;$i++) {
				$this->setTypeCol($detailCommande[($i+3)]);
			}
			$this->afficheTypeCol();
		}

		public function setNom($nom) { $this->_nom = $nom; }
		public function setNombreCol($nombreCol) { $this->_nombreCol = $nombreCol; }

		public function setTypeCol($typeColRajout) { 
			switch($typeColRajout) {
				case "int":
					array_push($this->_typeCol, $typeColRajout);
				break;
				case "float":
					array_push($this->_typeCol, $typeColRajout);
				break;
				case "string10":
					array_push($this->_typeCol, $typeColRajout);
				break;
				default:
				break;
			}
		}

		public function getNom() { return($this->_nom); }
		public function getNombreCol() { return($this->_nombreCol); }
		public function getTypeCol() { return($this->_typeCol); }


		//fonction de dev =>
		public function afficheTypeCol() {
			print_r($this->_typeCol);
		}
	}
 ?>