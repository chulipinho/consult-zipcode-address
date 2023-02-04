Feature: Delivery value

  Scenario: A valid address to the calculate function
    Given the following address
      | cep         | logradouro    | complemento  | bairro | localidade  | uf   | ibge      | gia    | ddd  | siafi  |
      | "01001-000" | "Praça da Sé" | "lado ímpar" | "Sé"   | "São Paulo" | "SP" | "3550308" | "1004" | "11" | "7107" |
    When the calculate method is called
    Then it must return 7.85
