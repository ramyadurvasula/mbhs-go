<?php
/**
* @author Stephan Loh
* Code adapted from: http://www.androidhive.info/2012/05/how-to-connect-android-with-php-mysql/
*/

error_reporting(-1);
ini_set('display_errors', 'On');

	//variable for holding the JSON response
	$response = array();
	
	//include the db connect class
	require_once 'db_connect.php';
	
	$results = $db->query('SELECT * FROM events');
	$response["events"] = array();
	
	foreach($results as $row) {
		echo json_encode($row["name"]);
		/*
		$product = array();
			$product["eventID"] = $row["eventID"];
			$product["start"] = $row["start"];
			$product["name"] = $row["name"];
			$product["description"] = $row["description"];
			$product["location"] = $row["location"];
			$product["end"] = $row["end"];
 
			// push single product into final response array
			array_push($response["events"], $product);
		*/
			
	}
		$response["success"] = 1;
		//echo $response["events"][0]["name"];
		//echo json_encode($response);	 
	
	
	

?>