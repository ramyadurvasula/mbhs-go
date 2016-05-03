<?php
/**
* @author Stephan Loh
* Code adapted from: http://code.tutsplus.com/tutorials/why-you-should-be-using-phps-pdo-for-database-access--net-12059
*/
	require'db_config.php';
	try {
		$db = new PDO("mysql:host=$host;dbname=$database", $user, $password);
		$db->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING );
	} catch (PDOException $e) {
		echo $e->getMessage();
	}
	
	
	
?>