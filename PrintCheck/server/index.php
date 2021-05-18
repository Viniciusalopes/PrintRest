<?php
header('Content-Type: application/json');

$result = array(
    'id' => 1,
    'bank' => "Itaú",
    'account' => "12345-X",
    'value' => 250.00
   );

echo json_encode($result);