<?php require("Codes/RelSchema.php"); ?>
<?php require("Codes/PageId.php"); ?>
<?php include("Codes/Controller.php") ?>

<!DOCTYPE html>
<html>
<head>
	<title> Projet SGBD </title>
	<link rel="stylesheet" type="text/css" href="index.css">
</head>
<body>
	<div id="requete">
		<p>Votre requête : 
			<?php if(isset($commande)) { echo $commande; } ?>
		</p>
	</div>
	<div id="Console">
		<form method="POST" action="" id="requeteSQL" enctype="multipart/form-data">
			<table>
				<tr>
					<td>
						<input type="text" name="commande" id="commande" placeholder="<?php if(isset($commande)) { echo $commande; } ?>" required="required"/>
					</td>
					<td>
						<input type="submit" value="RUN" id="run" name="run"/>
					</td>
				</tr>
				<tr>
					<td id="erreur">
						<?php if(isset($erreur)) { echo $erreur; } ?>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>