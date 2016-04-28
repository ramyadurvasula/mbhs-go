<?php
/**
* @author Stephan Loh
* Code adapted from: http://www.androidhive.info/2012/05/how-to-connect-android-with-php-mysql/
*/
	//variable for holding the JSON response
	$response = array();
	
	//include the db connect class
	require_once __DIR__ . '/db_connect.php';
	
	//connect to database
	$db = new DB_CONNECT();
	
	$result = mysql_query("SELECT * FROM events")  or die(mysql_error());
	
	if(mysql_num_rows($result) > 0 ){
		$response["events"] = array();
		
		while ($row = mysql_fetch_array($result)) {
			// temp user array
			$product = array();
			$product["eventID"] = $row["eventID"];
			$product["start"] = $row["start"];
			$product["name"] = $row["name"];
			$product["description"] = $row["description"];
			$product["location"] = $row["location"];
			$product["end"] = $row["end"];
 
			// push single product into final response array
			array_push($response["events"], $product);
		}
		$response["success"] = 1;
		
		echo json_encode($response);	
		} 
	} else {
		// no products found
		$response["success"] = 0;
		$response["message"] = "No products found";
	 
		// echo no users JSON
		echo json_encode($response);
	}
	

?>