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

	$newPageId = $newDM->addPage(8);
	$buffer = $newDM->readPage($newPageId);	
	$newDM->writePage($newPageId,$buffer);
	
	if (isset($_POST['commande'])) {
		//récupération de la commande de l'utilisateur
		$commande = $_POST['commande'];
		//découpage des arguments en tableau
		$detailCommande = explode(" ", $commande);
		$typeCommande =  $detailCommande[0];
		switch ($typeCommande) {
			case "create":
				$typesDesColonnes = array();
				for($i=3;$i<$detailCommande.sizeof();$i++) {
					array_push($typesDesColonnes, $detailCommande[$i]);
				}
				createRelation($detailCommande[1],$detailCommande[2],$typesDesColonnes);
			break;
			default:
				$erreur = "Commande non reconnue";
			break;
		}
	}


	//function create($detailCommande) {
		//$newRelSchema = new RelSchema($detailCommande);
	//}

	function createRelation($nomRelation,$nombreColonnes,$typesDesColonnes) {
		//echo "Nom de la relation : " . $nomRelation;
		//echo "Nombre de colonnes" . $nombreColonnes;
		echo $typesDesColonnes[O];
		for($i=0;$i<$typesDesColonnes.sizeof();$i++) {
			echo "type" . $i . " : " . $typesDesColonnes[$i];
		}
		//$NewDbDef->ajoutRelation();
	}
?>



















