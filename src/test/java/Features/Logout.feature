Feature: deconnexion au site SauceDemo




Background: Tentative de connexion avec des identifiants valides
Given Je suis sur la page de connexion de SauceDemo
When Je saisis le nom d'utilisateur "standard_user"
And Je saisis le mot de passe "secret_sauce"
And Je clique sur le bouton de connexion
Then redirection vers la page Home


Scenario:Tentative de deconnexion
When je clique sur menu
And je clique sur logout
Then redirection vers la page connexion