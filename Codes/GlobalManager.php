<?php 

	require("Codes/RelSchema.php"); 
	require("Codes/PageId.php"); 
	require("Codes/DiskManager.php"); 

	init(); 
	function init () {	
		//Création de l'instance unique de DbDef si elle n'existe pas 
		if($_SESSION['InitBd'] != true) { 
			require("Codes/DbDef.php");
			$NewDbDef= new DbDef(array(),0);
			$_SESSION['InitBd'] = true;	
		}
	}
	$newDM = new DiskManager();
	$newDM->addPage(8);	
	
	if (isset($_POST['commande'])) {
		$commande = $_POST['commande'];
		$detailCommande = explode(" ", $commande);
		$typeCommande =  $detailCommande[0];
		switch ($typeCommande) {
			case "create":
				create($detailCommande);
			break;
			default:
				$erreur = "Commande non reconnue";
			break;
		}
	}


	function create($detailCommande) {
		$newRelSchema = new RelSchema($detailCommande);
	}

	function createRelation($nomRelation,$nombreColonnes,$TypesDesColonnes) {
		$NewDbDef->ajoutRelation();
	}
?>