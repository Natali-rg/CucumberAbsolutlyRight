@TestCertificate
Feature: Checking the existence of a certificate

  Scenario Outline: Test check certificate
    When I open site "https://certificate.ithillel.ua/"
    And Enter certificate code "<cer>"
    Then Check result
    Examples:
      | cer      |
      | 124578   |
      | 4579545  |
      | 12444589 |
      | 11124    |
      | 78008248 |
