<?php 

	require("Codes/RelSchema.php"); 
	require("Codes/PageId.php"); 
	require("Codes/DiskManager.php"); 
	$newDM = new DiskManager();

	init(); 
	function init () {	
		//Création de l'instance unique de DbDef si elle n'existe pas 
		if($_SESSION['InitBd'] != true) { 
			require("Codes/DbDef.php");
			$NewDbDef= new DbDef(array(),0);
			$_SESSION['InitBd'] = true;	
		}
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


	//function create($detailCommande) {
		//$newRelSchema = new RelSchema($detailCommande);
	//}

	function createRelation($detailCommande) {
		$nomRelation = $detailCommande[1];
		$nombreDeColonne = $detailCommande[2];
		$typeColonne = array();
		for($i=3;$i<sizeof($detailCommande);$i++) {
			array_push($typeColonne,$detailCommande[$i]);
		}

	}


	//fonction de test
	function afficheTableau($tab) {
		for($i=0;$i<sizeof($tab);$i++) {
			echo $tab[$i];
			echo " - ";
		}
	}
?>



















