<?php

	class RelDef {
		
		private $_fildeId;
		private $_relSchema;

		public function __construct($fileId,$relSchema) {
			$this->setFileId($fileId);
			$this->setRelSchema($relSchema);
		}

		public function setFileId($fileId) { $this->_fildeId = $fileId; }
		public function setRelSchema($relShema) { $this->_relSchema = $relShema; }

		public function getFileId() { return($this->_fildeId); }
		public function getRelSchema() { return($this->_relSchema); }
		
	}
?>