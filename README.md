# Jeu d'aventure texte

L'objectif de ce projet est de créer un [jeu d'aventure texte](https://fr.wikipedia.org/wiki/Jeu_vid%C3%A9o_textuel) en ligne de commandes. Le jeu doit décrire au joueur ce que son personnage voit et ce qui se passe autour de lui; le joueur doit entrer des commandes afin de se déplacer et d'agir sur son environnement.

## Mission 1: lieux et navigation

Avant toute chose, il faut que le jeu décrive au joueur où il se trouve, et qu'il puisse se déplacer d'un endroit à l'autre. Le déroulement du jeu pourrait ressembler à l'exemple suivant:

<details>
<summary>Exemple</summary>

> You are in the bedroom. West is the bathroom, north is the corridor.

`west`

> You are in the bathroom. East is the bedroom.

`west`

> You cannot go into that direction!

> You are in the bathroom. East is the bedroom.

`east`

> You are in the bedroom. West is the bathroom, north is the corridor.

</details>

Afin d'obtenir ce résultat, implémenter les classes ci-après en suivant les spécifications fournies.

### `Room`

- Représente un lieu dans lequel le joueur peut se trouver.

| Méthode | Description |
|---|---|
| _**String** getName()_ | Renvoie le nom du lieu (exemple: `"bedroom"`) |
| _**Room** getRoomInDirection(**Direction** direction)_ | Renvoie le lieu où l'on arrive lorsque l'on part de ce lieu et qu'on emprunte la direction passée en paramètre (exemple: depuis la chambre à coucher, en passant la direction ouest, on devrait obtenir la salle de bain) |

### `Direction`

- Représente une direction que le joueur peut emprunter pour se déplacer d'un lieu à l'autre.

| Méthode | Description |
|---|---|
| _**String** getName()_ | Renvoie le nom de la direction (exemple: `"north"`) |

### `RoomConnection`

- Représente un passage entre deux lieux.

| Méthode | Description |
|---|---|
| _**Room** getFromRoom()_ | Renvoie le lieu dont part le passage |
| _**Room** getToRoom()_ | Renvoie le lieu auquel le passage aboutit |
| _**Direction** getDirection()_ | Renvoie la direction qu'il faut suivre pour emprunter ce passage |

### `Game`

- Représente une partie jouée par le joueur.

| Méthode | Description |
|---|---|
| _**void** setup()_ | Initialise la partie en créant les objets de l'univers (les lieux et les directions) et en les associant les uns aux autres de la manière adéquate, et détermine le lieu de départ |
| _**void** update()_ | Décrit un cycle d'exécution de la partie: décrire le lieu courant, attendre une saisie de l'utilisateur, vérifier qu'elle correspond à une direction, changer de lieu si cette direction est empruntable depuis le lieu dans lequel on se trouve actuellement |
| _**boolean** isRunning()_ | Permet de savoir si la partie est en cours (`true`) ou si elle est terminée (`false`) |
| _**Room** getCurrentRoom()_ | Renvoie le lieu dans lequel le joueur se trouve actuellement |

### `App`

- Point d'entrée de l'application.

| Méthode | Description |
|---|---|
| _**static void** main(**String** args)_ | Processus principal. Crée une nouvelle partie et l'initialise, puis lui demande de réaliser un cycle d'exécution tant qu'elle est en cours. |
