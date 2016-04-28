<?php
/**
* @author Stephan Loh
* Code adapted from: http://www.androidhive.info/2012/05/how-to-connect-android-with-php-mysql/
*/
	define('DB_USER', "mbhsgo");
	define('DB_PASSWORD', "softwaredesign");
	define('DB_DATABASE', "mbhsweb");
	define('DB_SERVER', "localhost");
	$response = array();

	class DB_CONNECT {
		
		// constructor
		function __construct() {
			$this->connect();
		}
		
		//destructor
		function __destruct() {
			$this->close();
		}
		
		function connect() {
			//import database connection variables
			require_once __DIR__ . '/db_config.php';
			
			// Connecting to mysql database
			$con = mysql_connect(DB_SERVER, DB_USER, DB_PASSWORD) or die(mysql_error());
 
			// Selecing database
			$db = mysql_select_db(DB_DATABASE) or die(mysql_error()) or die(mysql_error());
 
			// returing connection cursor
			return $con;
		}
		
		function close() {
			mysql_close();
		}
	}	
?>