# TP Programmation par composants

## Docker

Pour démarrer l'application dans un conteneur Docker, il faut tout d'abord
packager les différents éléments de l'application et ensuite créer l'image
en elle même. Il suffit de lancer la commande :

~~~
$ gradle deploy

# Pour uniquement empaqueter les projets en JAR et WAR
$ gradle archive

# Pour empaqueter l'application en EAR
$ gradle ear

# Pour uniquement créer l'image Docker
$ gradle createImage
~~~

Pour lancer le conteneur Docker :

~~~
$ docker run -p 8080:8080 -p 9990:9990 -it webserver
~~~

Des données sont déjà présentes en base, pour se connecter avec un
utilisateur administrateur existant :

* username: Mouloud
* password: s3cr3t

### Connexion à l'interface d'administration

Pour se connecter à l'interface d'administration (i.e. <http://localhost:9990>),
les identifiants sont :

* username: jean-michel
* password: jar
