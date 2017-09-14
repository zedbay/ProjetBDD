<?php 
	$commande = "create R 3 int float string10";
	$detailCommande = explode(" ", $commande);

	$typeCommande =  $detailCommande[0];
	switch ($typeCommande) {
		case "create":
			create($detailCommande[1],$detailCommande[2]);
		break;

		default:
			echo "commande non reconnue";
		break;
	}

	function create($nom,$nombreCol) {
		//echo $nom . $nombreCol;
		$newRelSchema = new RelSchema($nom,$nombreCol);
		echo $newRelSchema->getNom();
	}

?>