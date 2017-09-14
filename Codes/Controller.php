<?php 
	if (isset($_POST['commande'])) {
		$commande = $_POST['commande'];
		$detailCommande = explode(" ", $commande);
		$typeCommande =  $detailCommande[0];
		switch ($typeCommande) {
			case "create":
				create($detailCommande[1],$detailCommande[2]);
			break;

			default:
				$erreur = "Commande non reconnue";
			break;
		}
	}

	function create($nom,$nombreCol) {
		$newRelSchema = new RelSchema($nom,$nombreCol);
	}
?>