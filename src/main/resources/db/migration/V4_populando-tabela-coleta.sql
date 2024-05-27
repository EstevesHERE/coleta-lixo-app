USE coleta_lixo;

INSERT INTO tbl_coleta (
    nome_bairro,
    numero_volume,
    id_rota,
    data_coleta,
    data_registro
) VALUES
      ('Centro', 150, 2, '2024-05-03 00:00:00', NOW()),
      ('Jardim das Flores', 180, 3, '2024-05-04 00:00:00', NOW()),
      ('Parque Industrial', 210, 4, '2024-05-05 00:00:00', NOW()),
      ('Vila Nova', 250, 5, '2024-05-06 00:00:00', NOW()),
      ('Belo Horizonte', 300, 6, '2024-05-07 00:00:00', NOW()),
      ('Pampulha', 200, 7, '2024-05-08 00:00:00', NOW()),
      ('Savassi', 220, 8, '2024-05-09 00:00:00', NOW()),
      ('Barro Preto', 240, 9, '2024-05-10 00:00:00', NOW());
