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

## Mission 2: objets et interactions

Maintenant que nos joueurs sont capables de se déplacer d'un lieu à une autre, il faudrait ajouter des éléments (objets, personnages, monstres…) avec lesquels ils pourront interagir.

<details>
<summary>Exemple</summary>

> You are in the bedroom. West is the bathroom, north is the corridor. There is a bed and a mirror.

`use bed`

> You take a quick nap. You feel refreshed!

`use mirror`

> You see your reflection. Looking good!

`open mirror`

> This does not open!

`talk to mirror`

> Silence...

`use toothbrush`

> There is no such item here!

</details>

### 1. Intégrer des objets à l'univers

- Écrire une classe `Item`, qui représente les éléments interactifs de l'univers.
- Chaque élément doit avoir un nom.
- Chaqué élément doit être visible ou non (c'est-à-dire que le joueur voit son nom affiché dans le jeu, et peut interagir avec, ou non).
- Chaque pièce peut contenir une quantité indéterminée d'éléments. La liste des éléments visibles doit être affichée automatiquement dans chaque pièce.

### 2. Interagir avec des éléments

- Écrire une classe `Command` qui représente une commande que l'utilisateur peut entrer dans la console.
- Chaque commande doit avoir un texte par défaut qui s'affichera si jamais l'utilisateur tente de l'utiliser avec un élément qui n'a pas été prévu pour (exemple: `talk to mirror`).
- Chaque élément peut réagir à un nombre indéterminé de commandes. Dans un premier temps, utiliser une commande particulière avec un élément particulier doit produire l'affichage d'un texte particulier.

### 3. Programmer des interactions complexes

Utiliser une commande sur un élément doit pouvoir produire une variété d'effets, dont afficher un texte n'est qu'un exemple.

Implémenter une ou plusieurs des classes suivantes:

| Classe | Description |
|---|---|
| **MessageEffect** | Produit l'affichage d'un message dans la console. |
| **EndGameEffect** | Termine la partie en cours. |
| **ChangeCurrentRoomEffect** | Change le lieu dans lequel le joueur se trouve actuellement. |
| **ChangeItemVisibilityEffect** | Change la visibilité d'un élément interactif. |
| **ModifyInventoryEffect** | Ajoute ou retire un élément interactif de l'inventaire du joueur. |

- Chaque élément peut réagir à chaque commande en utilisant l'un des effets proposés ci-dessus (au lieu de simplement afficher un message comme précédemment demandé).
- BONUS: Chaque élément peut réagir à chaque commande en utilisant une série d'effets, au lieu d'un seul effet.

#### Exemples d'interactions à implémenter

- Manger le biscuit sur la table de la cuisine (`eat cookie`) doit produire sa disparition de la pièce.
- Ouvrir le tiroir du bureau dans la chambre (`open drawer`) doit rendre visible un élément présent dans celui-ci (par exemple, un carnet de notes), le refermer (`close drawer`) doit le rendre invisible.
- Utiliser la voiture dans le garage (`use car`) doit produire le déplacement du joueur vers un autre lieu (par exemple, la ville). Utiliser la voiture dans ce dernier lieu doit produire le retour du joueur au garage.
- Ramasser une brosse à dents dans la salle de bain (`pick up toothbrush`) doit provoquer son ajout à l'inventaire et sa disparition de la pièce.
- Toucher une prise électrique (`touch plug`) doit produire la mort du héros, et donc la fin de la partie.

Si le bonus de l'étape 3 a été réalisé, chaque interaction doit être accompagnée d'au moins un message décrivant l'effet obtenu.

## Mission 3: Harmoniser les commandes

Le processus principal qui permet de faire fonctionner le jeu est désormais capable de reconnaître les saisies utilisateur qui correspondent à une direction (`east`, `south`, `west`…) ainsi que celles qui correspondent à une interaction avec un objet (`use bed`, `open drawer`, `pick up notepad`…). À ce stade, nous aimerions ajouter des commandes générales comme `help` qui pourrait afficher la liste des commandes possibles, ou encore `exit` qui permettrait d'interrompre le jeu. Cependant, nous commençons à entrevoir que le fait de rajouter des nouvelles commandes de la sorte risque de complexifier le processus principal du jeu, qui est déjà bien chargé: car si nous continuons sur notre lancée, chaque nouveau type de commandes va devoir être traité séparément des autres.

Dans un premier temps, considérant qu'il est de la responsabilité de chaque commande de savoir quel effet elle est censée produire, il pourrait être judicieux d'alléger le processus principal en déplaçant les différents effets possibles (quitter le jeu, afficher les commandes disponibles, changer de lieu, etc…) dans la classe correspondante.

De plus, considérant que les nouvelles commandes que nous souhaiterions implémenter, mais aussi les directions, et les actions que nous pouvons utiliser sur les éléments interactifs, sont finalement toutes des types de commandes qui ont simplement leur particularités, l'objectif ultime de cette mission est de parvenir à refactoriser le code de manière que tous les types de commandes soient traités de la mème manière, au lieu d'ètre traités séparément.

<details>
<summary>Illustration</summary>

La logique actuelle:
```java
class Game
{
    public void update()
    {
        // Attend une saisie utilisateur
        // Si la saisie utilisateur correspond à la commande "quitter le jeu"
            // Termine la partie
        // Si la saisie utilisateur correspond à la commande "afficher l'aide"
            // Affiche la liste des commandes
        // Si la saisie utilisateur correspond à une direction
            // Modifie le lieu actuel
        // Si la saisie utilisateur correspond à une interaction avec un élément présent dans le lieu actuel
            // Déclenche l'effet correspondant à la commande spécifiée sur cet élément
        // etc…
    }
}
```

La logique désirée:
```java
class Game
{
    public void update()
    {
        // Attend une saisie utilisateur
        // Pour chaque commande possible, peu importe son type réel (commande globale, direction, interaction…)
            // Demande à la commande de traiter la saisie utilisateur. Si la commande correspond à la saisie utilisateur, elle réalise l'effet de la commande par elle-même, et la boucle est interrompue. Sinon, rien ne se passe.
    }
}
```

</details>

### 1. Ajouter des commandes globales

- Implémenter une ou plusieurs des classes suivantes:

| Classe | Description |
|---|---|
| **ExitCommand** | Termine la partie en cours. |
| **HelpCommand** | Affiche la liste de toutes les commandes possibles. |
| **ResetCommand** | Recommence une nouvelle partie. |

> - Chacune de ces classes doit posséder une propriété **Game** qui fait référence à la partie en cours.
> - Chacune de ces classes doit posséder une méthode _**boolean** process(**String** userInput)_. Le rôle de cette méthode est de traiter une saisie utilisateur. Si la saisie utilisateur correspond à la commande concernée, alors elle doit produire l'effet de la commande et renvoyer **true**. Sinon, elle doit ne rien faire et renvoyer **false**.
- Ajouter au processus principal dans la classe **Game** une condition demandant à une instance de chacune de ces classes de traiter par elle-même la saisie utilisateur.

### 2. Refactoriser les directions

- Renommer la classe **Direction** en **DirectionCommand**.
- Adapter la classe **DirectionCommand** pour qu'elle corresponde aux même spécifications que les commandes globales, énumérées au point 1.
- Adapter le processus principal dans la classe **Game** de façon que celui-ci se contente de demander à chaque direction de traiter par elle-même la saisie utilisateur.

### 3. Refactoriser les interactions avec les éléments

- Renommer la classe **Command** en **ItemCommand**.
- Adapter la classe **ItemCommand** pour qu'elle corresponde aux même spécifications que les commandes globales, énumérées au point 1.
- Adapter le processus principal dans la classe **Game** de façon que celui-ci se contente de demander à chaque commande représentant une interaction avec un élément de traiter par elle-même la saisie utilisateur.

### 4. Unifier tous les types de commandes

- Écrire une interface **Command** qui synthétise la structure commune à toutes les classes de commandes crées précédemment. Toutes les classes de commandes doivent implémenter cette interface.
- Refactoriser le processus principal dans la classe **Game** de façon à rassembler tous les appels aux méthodes _process_ en un seul et même appel.
