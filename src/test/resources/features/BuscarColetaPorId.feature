# language: pt
Funcionalidade: Validar o contrato ao realizar uma busca bem-sucedida de uma coleta
  Como usuário da API
  Quero buscar uma coleta por id bem-sucedido
  Para que eu consiga validar se o contrato esta conforme o esperado
  Cenario: Validar contrato da busca bem-sucedido da coleta
    Dado que eu receba os seguintes dados da coleta:
      | campo          |  valor                                |
      | dataColeta     |  2024-10-30T21:40:43.000+00:00        |
      | dataRegistro   |  2024-10-30T21:40:43.000+00:00        |
      | nome_bairro    |  Vila cesar                               |
      | numero_volume  |  15000                                    |
      | rota           |  null                                 |
      | idColeta       |  2                                    |
    Quando eu enviar a requisição para o endpoint "/agendamento" de busca de coleta
    Então o status code da resposta da busca deve ser 200