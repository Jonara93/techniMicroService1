## Créer un nouveau micro service (9004) Expédition

Cette application va gérer les livraisons des commandes.

Il doit afficher les livraisons, retourner une livraison par son id, ajouter une livraison

Il doit notifier lors de l'enregistrement d'une livraison la société de livraison dans le micro service Commandes (
RabbitMQ)

### Entité

La livraison est définie par :

- id
- date de création
- date de livraison estimée
- société de livraison (enum)
- prix du coût de livraison
- orderId

Dans le client UI, ajouter dans le flux de création d'une commande les affichages adhoc

Afficher toutes les commandes dans un component Commandes

## Créer un nouveau Micro Service (9005) Utilisateur

Cette application va gérer nos utilisateurs.

Dans le client UI ajouter un espace profil.

Afficher les infos du client dans le profil.

### Entité

Un utilisateur est défini par :

- id
- pseudo
- mdp
- nom
- prénom
- email
- adresse_facturation
- adresse_livraison
