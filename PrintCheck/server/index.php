<?php
header('Content-Type: application/json');

$result = array(
    'id' => 1,
    'bank' => "Ita�",
    'account' => "12345-X",
    'value' => 250.00
   );

echo json_encode($result);