# Koolektion
### Une manipulation simple
Une application console qui se deleste d'une de ses entrees, indiquee par l'entier en dernier argument.

## Installation
dans le projet collection.crud.parent
```
mvn install 
```

## Utilisation
toujours dans le dossier collection.crud.parent
```
cd collection.crud.app/target
java -jar collection.crud.app-0.0.1-SNAPSHOT.jar "chaine 1" "chaine 2" "chaine 3" "chaine 4" 3
```
## Aide
en cas de mauvaise entree l'aide localisee s'affichera.
les arguments sont de type String... int

## Le choix des armes
Cette application utilise JUnit 4.
Pour le reste c'est du java natif. 
Pas d'injection de dependances. 
Pas de conteneur de servlet requis.
Cependant tout est package en mode EE ready.

Les test unitaires testent sur une methode de signature:
```
String[] remove(String[] args);
```

Cette methode appelle en sous main la methode qui est au coeur de l'exercice:
```
String[] remove(String[] input, int index);
```

Les deux methodes sont publiques. La premiere permet simplement de faire une application console.

### Strategie
L'algorithme de suppression opte pour la copie de portions de tableau plutot que la verification systematique de conditions.
Le resultat permet une utilisation plus rapide et plus evolutive.

## Organisation
### Le package parent
sert a builder le projet simplement et a remplir la configuration commune a tous les autres packages (comme la version java).

### Le package d'exceptions
est vide.
On considere que pour le moment l'application repond toujours par un resultat sans afficher de plantage.
Les exceptions natives sont suffisantes pour notre cadre d'utilisation.
Par consequent Les catch sont compactes car tous sont traites de la meme maniere.
Sinon on pourrait faire des catch separes pour traiter chaque cas separement.

### Le package commons
inclut des outils qui pourraient etre utilises dans n'importe quelle couche.
