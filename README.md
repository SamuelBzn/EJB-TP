# TP Programmation par composants

## Docker

Pour démarrer l'application dans un conteneur Docker, il faut tout d'abord
packager les différents éléments de l'application et ensuite créer l'image
en elle même. Il suffit de lancer la commande :

~~~
$ gradle deploy

# Pour uniquement empaqueter l'application
$ gradle archive

# Pour uniquement créer l'image Docker
$ gradle createImage
~~~

Pour lancer le conteneur Docker :

~~~
$ docker run -p 8080:8080 -p 9990:9990 -it webserver
~~~

### Connexion à l'interface d'administration

Pour se connecter à l'interface d'administration (i.e. <http://localhost:9990>),
les identifiants sont :

* username: jean-michel
* password: jar
