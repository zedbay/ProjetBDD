<?php 
	
	class DbDef {

		private $_relDef; 
		private $_compteurDeRelation;
		public function __construct ($relDef,$compteurDeRelation) {
			$this->setRelDef($relDef);
			$this->setCompteurDeRealtion($compteurDeRelation);
		}

		public function setRelDef ($relDef) { $this->_relDef = $relDef; }
		public function setCompteurDeRealtion ($compteurDeRelation) { $this->_compteurDeRelation = $compteurDeRelation; }

		public function getRelDef () { return($this->_relDef); }
		public function getCompteurDeRelation () { return($this->_compteurDeRelation); }

		public function incrementationCompteur() {
			$this->_compteurDeRelation += 1;
		}
		public function ajoutRelation () {
			$this->incrementationCompteur();
		}
	}


 ?>