Feature: Delivery value

  Scenario: A valid address to the calculate function
    When the API enters <uf> as an UF
    Then the DefaultDeliveryFeeCalculator calculate method is called
    And it must return <value>

    Examples: 
      | uf | value |
      | sp |  7.85 |
      | rj |  7.85 |
      | es |  7.85 |
      | mg |  7.85 |
      | mt | 12.50 |
      | ms | 12.50 |
      | go | 12.50 |
      | ma | 15.98 |
      | pi | 15.98 |
      | ce | 15.98 |
      | rn | 15.98 |
      | pe | 15.98 |
      | pb | 15.98 |
      | se | 15.98 |
      | al | 15.98 |
      | ba | 15.98 |
      | pr | 17.30 |
      | rs | 17.30 |
      | sc | 17.30 |
      | am | 20.83 |
      | rr | 20.83 |
      | ap | 20.83 |
      | pa | 20.83 |
      | to | 20.83 |
      | ro | 20.83 |
      | ac | 20.83 |
