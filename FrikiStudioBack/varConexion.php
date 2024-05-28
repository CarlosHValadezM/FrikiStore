<?php
    $mySql = new mysqli("localhost","root","","frikiStore");

    if(!$mySql->connect_error){
        
    }else{
        die("Conexion fracasada");
    }
?>