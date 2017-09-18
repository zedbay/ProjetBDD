<?php 
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
?>