<?php
header('Content-Type: application/json');

$result = array(
    array(
        'id' => 1, 
        'registration' => '001122',
        'rg' => '223344',
        'value' => 100.00,
        'number' => 11,
        'written_value' => 'Cem reais', 
        'associate_name' => 'Vinicius Araujo Lopes',
        'date' => '2021-05-22',
        'limit_per_sheet' => 1000.00,
        'validity' => '2021-05-31'
    ),
    array(
        'id' => 2, 
        'registration' => '001122',
        'rg' => '223344',
        'value' => 200.00,
        'number' => 12,
        'written_value' => 'Duzentos reais', 
        'associate_name' => 'Vinicius Araujo Lopes',
        'date' => '2021-05-22',
        'limit_per_sheet' => 2000.00,
        'validity' => '2021-05-31'
    )
);

echo json_encode($result);