Feature: Payload

  Scenario: The user enters <scenario> zipcode
    When the user enters a zipcode <zipcode>
    Then the API must <api>
    And return <return>

    Examples: 
      | scenario                                | zipcode                    | api                  | return                           |
      | null value                              | ""                         | throw an exception   | a badRequest status code         |
      | valid formatted                         | "35700-000"                | find the address     | it along with the delivery price |
      | a valid non-formatted                   | "35700000"                 | find the address     | it along with the delivery price |
      | an invalid formatted                    | "00000-000"                | not find the address | a zipcode not found message      |
      | an invalid non-formatted                | "00000000"                 | not find the address | a zipcode not found message      |
      | a valid integer as a                    |                   35700000 | find the address     | it along with the delivery price |
      | a valid integer starting with zero as a |                   01000000 | find the address     | it along with the delivery price |
      | a single value String Array as a        | ["35700-000"]              | throw an exception   | it along with the delivery price |
      | a multi value Array as a                | ["35700-000", "35700-210"] | find the address     | a badRequest status code         |
      | an Object as a                          | {"value": "35700-000"}     | throw an exception   | a badRequest status code         |
