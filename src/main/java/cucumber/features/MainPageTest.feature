@MainPageFeature
Feature: MainPageTest
  test

  Scenario: Test text description
    When I open site "https://dnipro.ithillel.ua/"
    Then Text description button must equals "Вдосконалюйся!"

  Scenario: Test city buttons titles
    When I open site "https://dnipro.ithillel.ua/"
    Then Check titles on buttons
      | Київ   |
      | Одеса  |
      | Дніпро |

  Scenario: FormConsultation
    When I open site "https://dnipro.ithillel.ua/"
    And Click button consultation
    And Sent text
      | Name | email       | telephone |
      | Mark | gg@mail.com | 254512888 |
      | Bill |jjj@mail.com | 216689444 |
    Then Sleep

  Scenario Outline: Test
    When I open site "https://dnipro.ithillel.ua/"
    And Click button consultation
    And Send "<name>", "<email>", "<tel>"
    Then Sleep
    Examples:
      | name | email        | tel       |
      | Mark | gg@mail.com  | 254512888 |
      | Bill | jjj@mail.com | 216689444 |
      | Nata | nnn@mail.com | 124578999 |




