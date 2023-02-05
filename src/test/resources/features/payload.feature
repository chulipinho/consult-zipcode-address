Feature: Payload

  Scenario: the user enters <scenario>
    When the user enters a zipcode <zipcode>
    Then the API must return <return>

    Examples: 
      | scenario                           | zipcode                    | return                           |
      | valid formatted                    | "35700-000"                | it along with the delivery price |
      | a valid non-formatted              | "35700000"                 | it along with the delivery price |
      | an invalid formatted               | "00000-000"                | a notFound status code           |
      | an invalid non-formatted           | "00000000"                 | a notFound status code           |
      | a valid integer                    |                   35700000 | it along with the delivery price |
      | a valid integer starting with zero |                   01000000 | it along with the delivery price |
      | a single value String Array        | ["35700-000"]              | it along with the delivery price |
      | a multi value Array                | ["35700-000", "35700-210"] | a badRequest status code         |
