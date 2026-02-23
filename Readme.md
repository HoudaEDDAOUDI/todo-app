# Mini projet JAVA

Ce projet est mon **premier projet Java**.  
Je l'ai réalisé pour apprendre les bases de ce langage de programmation.  
Il s'agit d'une application de gestion de tâches en ligne de commande.

---

## Fonctionnalités

- Ajouter une tâche avec un titre et un statut
- Afficher toutes les tâches
- Voir le détail d'une tâche par son id
- Supprimer une tâche par son id
- Menu interactif en boucle
- Sauvegarde automatique des tâches dans un fichier texte — les tâches sont conservées même après avoir quitté le programme

---

## Comment lancer le projet

### Prérequis
- Avoir [Java](https://www.oracle.com/java/technologies/downloads/) installé sur votre machine

### Étapes

1. Clone le projet
```bash
git clone https://github.com/HoudaEDDAOUDI/todo-app.git
cd todo-app
```

2. Crée le fichier de sauvegarde à la racine du projet
```bash
touch allMyTasks.txt
```

3. Compile les fichiers
```bash
javac src/Main.java src/Task.java src/TasksManager.java
```

4. Lance le programme
```bash
java -cp src Main
```

---

## Utilisation

Une fois lancé, le programme affiche un menu :

```
Bonjour, que souhaitez-vous faire aujourd'hui?
Ajouter | Supprimer | Afficher | Voir une tache | Quitter
```

Tape simplement l'action souhaitée et suis les instructions.

---

## Architecture du projet

```
todo-app/
├── src/
│   ├── Main.java           # Point d'entrée, menu interactif (Controller)
│   ├── Task.java           # Modèle de données (Model)
│   └── TasksManager.java   # Logique métier (Service)
├── allMyTasks.txt          # Fichier de sauvegarde des tâches
└── README.md
```

Le projet suit une architecture **MVC** (Model / Service / Controller).

---

## Ce que j'ai appris

Ce projet m'a permis de découvrir et pratiquer :

- La **programmation orientée objet** : classes, constructeurs, attributs privés
- Les **collections Java** : `ArrayList`, `List`
- Les **lambdas** et `stream()` pour filtrer une liste
- La gestion des **entrées utilisateur** avec `Scanner`
- La lecture et l'écriture de fichiers avec FileWriter, BufferedWriter, FileReader et BufferedReader
- La structure d'un projet Java avec séparation des responsabilités
- La compilation et l'exécution en ligne de commande avec `javac` et `java`