<?php
    if($_SERVER["REQUEST_METHOD"] == "POST"){
        require_once '../../varConexion.php';
        $user = $_POST["user"];
        $password = $_POST["password"];

        $query = 'select * from encargados where usuario = "'.$user.'"';

        $resultado = $mySql->query($query);
        if($mySql->affected_rows > 0){ 
            while ($row=$resultado->fetch_assoc()) {
                $array["Resultado"] = $row;
            }

            if($array["Resultado"]["Contraseña"] == md5($password)){ // codigo 1, para usuario autenticado correctamente
                $array["codigo"] = 1;
            }else{ // codigo 2, para usuario no autenticado
                $array["Resultado"] = [
                    "idEncargado" => "",
                    "idPuesto" => "",
                    "idArea" => "",
                    "Nombre" => "",
                    "Usuario" => "",
                    "Contraseña" => ""
                ];
                $array["codigo"] = 2;
            }
        }else{ // codigo 0, para usuario no encontrado
            $array["Resultado"] = [
                "idEncargado" => "",
                "idPuesto" => "",
                "idArea" => "",
                "Nombre" => "",
                "Usuario" => "",
                "Contraseña" => ""
            ];
            $array["codigo"] = 0;
        }
        
        echo json_encode($array);
    }    
?>
