# Projet Interface Graphique

Le projet se retrouve dans le dossier Projet. Le dossier Mini_Projet est une ancienne version.

## Application

L'application est un jeu qui va permettre aux enfants d'apprendre les couleurs, les chiffres et les différents types de véhicules. Le nom est "Learn CVN", cvn étant les premières lettres de "colors", "vehicles" et "numbers". 

Voici le logo de l'app:

![ic_logo_96x96](https://user-images.githubusercontent.com/48416661/109680177-8dcb3c80-7b7c-11eb-8216-c2f6f03160e8.png)

Elle est disponible en anglais et en français.


## Navigation:

La navigation est la suivante:

![Screenshot from 2021-05-02 23-07-06](https://user-images.githubusercontent.com/48416661/116827824-6bb16300-ab9b-11eb-9528-bf4c319f4280.png)

D'une part on a la partie Learn, qui est constitué de listes. Voici l'exemple pour les couleurs:

![Screenshot_20210502_231246_com example projet(1)](https://user-images.githubusercontent.com/48416661/116828047-9c45cc80-ab9c-11eb-8611-b33c75f8f268.jpg)

D'autre part nous avons la partie Train. On peut s'entraîner de deux façons.

1) Retrouver un élément

![Screenshot_20210502_231549_com example projet](https://user-images.githubusercontent.com/48416661/116828026-791b1d00-ab9c-11eb-99df-dae7deb7d647.jpg)

2) Écrire un élément

![Screenshot_20210502_231604_com example projet](https://user-images.githubusercontent.com/48416661/116828033-833d1b80-ab9c-11eb-9765-5d7309c3e66e.jpg)


## Animations:

Deux animations sont utilisées. La première quand on va vers MenuLearn depuis le menu, et la deuxième lorsqu'on va du menu vers MenuTrain.


## TODO:

  -Bugg: Superposition de fragments: On peut cliquer sur des boutons qui appartiennent à l'ancien fragment.
  -Bugg: Bouton retour et "colors" depuis "menu train" ne fonctionnent si on les clique en premier.
  
  -Add: Audios lorqu'on clique sur l'icône du haut-parleur dans Learn.
  -Add: Plus de commentaires.
  -Add: Fire base.
  -Add: Documentation.
  


## Changement de langue:

La classe LocaleHelper a été récupérée, dans la page https://devdeeds.com/android-change-language-at-runtime/ l'auteur est Jayakrishnan P.M.
