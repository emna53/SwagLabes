Feature: Ceckout Produit

  Background: Add produit
    Given je suis sur la page home
    When je clique sur le button add to cart
    And je clique sur button panier
    And je clique sur button checkout

  Scenario: Achter produit avec succes
    When je saisis firstname "emna"
    And je saisis lastname "lih"
    And je saisis le postalecode "77896"
    And je clique sur continue
    And je clique sur finish
    Then le message de confirmation s affiche

   Scenario Outline: Test invalide de checkout
     When je saisis firstname "<firstname>"
     And je saisis lastname "<lastname>"
     And je saisis le postalecode "<postalecode>"
     And je clique sur continue
     Then le message d erreur s affiche "<messagederreur>"

     Examples:
       |firstname | lastname | postalecode|messagederreur|
       |   |liheouel|77896|Error: First Name is required |
       |  emna ||77896|Error: Last Name is required|
       |  emna |liheouel||Error: Postal Code is required|
       |   |||Error: First Name is required|

     Scenario: verification prix total
       When je saisis firstname "emna"
       And je saisis lastname "lih"
       And je saisis le postalecode "77896"
       And je clique sur continue
       Then le prix total doit etre correct

