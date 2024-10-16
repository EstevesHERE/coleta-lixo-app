USE coleta_lixo;

INSERT INTO tbl_caminhao (
    modelo,
    nome_status,
    numero_capacidade,
    numero_max_capacidade
) VALUES
      ('Truck', 'EM_ANDAMENTO', 120, 250),
      ('Truck XL', 'DISPONIVEL', 100, 220),
      ('Mini Truck', 'MANUTENCAO', 80, 180),
      ('Truck 2', 'EM_ANDAMENTO', 150, 300),
      ('Truck 3', 'DISPONIVEL', 90, 200),
      ('Heavy Truck', 'EM_ANDAMENTO', 130, 270),
      ('Cargo Truck', 'DISPONIVEL', 110, 240),
      ('Truck Lite', 'EM_ANDAMENTO', 85, 190),
      ('Super Truck', 'MANUTENCAO', 140, 290),
      ('Giant Truck', 'DISPONIVEL', 160, 320);