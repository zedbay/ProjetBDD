<?php 

	require("Codes/RelSchema.php"); 
	require("Codes/PageId.php"); 
	require("Codes/DiskManager.php");
	require("Codes/RelDef.php"); 

	init(); 
	function init () {	
		//Création de l'instance unique de DbDef si elle n'existe pas 
		if($_SESSION['InitBd'] != true) { 
			$_SESSION['NewDbDef'] = new DbDef(array(),0);
			$_SESSION['InitBd'] = true;		
		}
		$_SESSION['newDM'] = new DiskManager();
	}

	//$newPageId = $newDM->addPage(8);
	//$buffer = $newDM->readPage($newPageId);	
	//$newDM->writePage($newPageId,$buffer);
	
	if (isset($_POST['commande'])) {
		//récupération de la commande de l'utilisateur
		$commande = $_POST['commande'];
		//découpage des arguments en tableau
		$detailCommande = explode(" ", $commande);
		$typeCommande =  $detailCommande[0];
		switch ($typeCommande) {
			case "create":
				createRelation($detailCommande);
			break;
			default:
				$erreur = "Commande non reconnue";
			break;
		}
	}

	function createRelation($detailCommande) {
		$newRelSchema = new RelSchema($detailCommande);
		$newRelDef = new RelDef($_SESSION['NewDbDef']->getCompteurDeRelation(),$newRelSchema);
		$_SESSION['NewDbDef']->ajoutRelation($newRelDef);
		//mettre une condition au cas ou sa écrase
		$_SESSION['newDM']->createFile($newRelDef->getFileId());
		//pour chaque type de colonne dans la commande
		for($i=1;$i<sizeof($detailCommande);$i++) {
			//ajoute une page
			$newPI = $_SESSION['newDM']->addPage($newRelDef->getFileId());
			$_SESSION['newDM']->writePage($newPI,toBuffer($detailCommande[$i]));
		}
		
	}

	//fonction de test
	function afficheTableau($tab) {
		for($i=0;$i<sizeof($tab);$i++) {
			echo $tab[$i];
			echo " - ";
		}
	}

	function toBuffer($var) {
		$taille = 4096 - strlen($var);
		for($i=0;$i<$taille;$i++){
			$var = $var . "0";
		}
		return($var);
	}
?>



















