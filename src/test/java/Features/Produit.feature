Feature: Test de  Produit

  Scenario: Ajout de produit au panier
    Given je suis sur la page home
    When  je clique sur le button add to cart
    And je clique sur button panier
    Then le produit est ajouté avec succés


      Scenario: test d incrementation un seul produit au panier
        Given  je suis sur la page home
        When je clique sur le button add to cart
        Then notification d ajout s affiche sur le panier

        Scenario: test d incrementation de deux produits
          Given  je suis sur la page home
          When je clique sur le button add to cart
          And incrementation un seul produit
          And  je clique sur le button add to cart deuxieme produit
          Then incrementation panier


        Scenario: supprimer un produit de panier
          Given je suis sur la page home
          When je clique sur le button add to cart
          And je clique sur button panier
          And je clique sur le button remove
          Then produit est supprime avec succée

      Scenario: tester le  tri des produits
  Given je suis sur la page home
  When je choisi Z to A
  Then produits filtrés selon ZtoA


