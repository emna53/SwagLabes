Feature: Connexion au site SauceDemo
@run1 @smoke
  Scenario: Tentative de connexion avec des identifiants valides
    Given Je suis sur la page de connexion de SauceDemo
    When Je saisis le nom d'utilisateur "standard_user"
    And Je saisis le mot de passe "secret_sauce"
    And Je clique sur le bouton de connexion
    Then redirection vers la page Home

@smoke

  Scenario:Tentative de connexion avec  Mot de passe incorrect

    Given Je suis sur la page de connexion de SauceDemo
    When Je saisis le nom d'utilisateur "standard_user"
    And Je saisis le mot de passe "12345"
    And Je clique sur le bouton de connexion
    Then un message d'erreur est affiché

    Scenario Outline: Tentative de connexion  avec des identifiants incorrect
      Given Je suis sur la page de connexion de SauceDemo
      When Je saisis le nom d'utilisateur "<username>"
      And Je saisis le mot de passe "<passeword>"
      And Je clique sur le bouton de connexion
      Then un message d'erreur est affiché "<messageerreur>"
      Examples:
        | username | passeword | messageerreur |
        | standard_user| 12345| Epic sadface: Username and password do not match any user in this service |
        | emna | secret_sauce | Epic sadface: Username and password do not match any user in this service |
        |  | secret_sauce | Epic sadface: Username is required|
        | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |
  Scenario:Tentative de deconnexion
    Given je suis sur la page d acceuil
    When je clique sur menu
    And je clique sur logout
    Then redirection vers la page connexion