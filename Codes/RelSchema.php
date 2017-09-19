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
				//Expression régulière ; commence par "string" puis (et fini par) un chiffre d* (d chiffre)
				case (preg_match('#^string(\d)*$#', $typeColRajout) ? true : false):
					array_push($this->_typeCol, $typeColRajout);
				break;
				default:
					$erreur = "Type non reconnue";
				break;
			}
		}

		public function getNom() { return($this->_nom); }
		public function getNombreCol() { return($this->_nombreCol); }
		public function getTypeCol() { return($this->_typeCol); }

		public function toString() {
			$detail = "La relation " . $this->_nom . " possède " . $this->_nombreCol . " colonne(s) de type(s) ; ";
			for($i=0;$i<(($this->_nombreCol)-1);$i++){
				$detail = $detail . $this->_typeCol[$i] . " - ";
			}
			$detail = $detail . $this->_typeCol[($this->_nombreCol)-1];
			return($detail);
		}
	}
 ?>
















