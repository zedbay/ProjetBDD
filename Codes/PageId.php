<?php 

	class PageId {

		private $_fileId;
		private $_idx; 

		public function __construct($fileId, $idx) {
			$this->setFileId($fileId);
			$this->setIdx($idx);
		}

		public function setFileId ($fileId) { $this->_fileId=$fileId; }
		public function setIdx ($idx) { $this->_idx=$idx; }

		public function getFildeId () { return($this->_fileId); }
		public function getIdx () { return($this->_idx); }
		
	}
 ?>