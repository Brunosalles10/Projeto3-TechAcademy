<?php

session_start();


if (isset($_GET['comando']) && isset($_GET['save'])) {
    $comando = rawurlencode($_GET['comando']);
    $save = rawurlencode($_GET['save']);
    $conteudo = file_get_contents("http://localhost:4567/{$comando}/{$save}");
} else if(isset($_GET['comando'])) {
    $comando = rawurlencode($_GET['comando']);
    $conteudo = file_get_contents("http://localhost:4567/{$comando}");
} else {
    $conteudo = file_get_contents("http://localhost:4567");
}
$arrayAssociativo = json_decode($conteudo);

if (isset($arrayAssociativo->mensagem)) {
    if (!isset($_SESSION['historico'])) {
        $_SESSION['historico'] = ''; 
    }
    $_SESSION['historico'] .= $arrayAssociativo->mensagem . "\n\n\n";
}

if (isset($_GET['reset'])) {
    unset($_SESSION['historico']);
}


include "template.phtml";
?>

