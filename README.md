# My Profile
<img src="https://app.travis-ci.com/hboufaied/myProfile.svg?branch=master" alt="Build Status" />


## Statement
### Besoins métier
En tant que fondateur d’une startup, j’ai observé une belle opportunité pour lancer un nouveau produit. Les sociétés, de petites et grandes structures, ont de plus en plus besoin d'experts IT afin de développer les applications qui répondent à leurs besoins en temps et en heure.  J'aimerais pouvoir héberger un ensemble de profils en ligne, au même titre que monster ou linkedIn.
 
J'ai donc besoin d'une application explosant des APIs REST avec les fonctionnalités suivantes :
1. **publier mon profil** (editer les différentes sections et écriture en base de données)
2. **Obtenir et éditer les compétences d'un profil**
    - 5 sections (sommaire, expérience, études, licences ou certification, formation, compétences)
    - Sommaire : Nom, Prénom, Date de naissance, pays, ville/région,    Intitulé du profil, expertise, à propos (sommaire)
    - Expérience : titre, type (temps plein ou partiel), société, lieu, date début, date fin, description
    - Éducation : école, niveau d’étude, domaine d’étude, date début, date fin, description
    - Licences ou certification : nom, organisme émetteur, date d’émission, identifiant, lien
    - Formation : titre, description, date
    - Compétences: libellé, description, niveau (1-10), 
3. **lister un ensemble de profils** (1 seul endpoint)
    -  trier par ordre alphabétique, par
        - nom
        - prénom
        - ville
        - titre
    - 5 exporter cette liste triée sous format excel
        - première ligne : libellé "nombre de profils"
        - deuxième ligne : nombre de profils en chiffre
        - 3e ligne vide
        - 4e ligne : entête pour les 4 champs (nom, prénom, ville, titre)
        - ensuite, une ligne par profil
    - 6 envoyer ce profil par email, et ce email est soit
        - Récupéré dans la requête passé, l’utilisateur peut entrer une liste de destinataires
        - Récupéré sur l’utilisateur connecté (JWT)
7. **rechercher les profils par mots clés** (un ou plusieurs mots)
    -  afficher une liste de profils par ordre selon pertinence selon critère de recherche. La pertinence se base sur les règles suivantes:
        - 1 mot trouvé dans le profil : 1 x o occurrences = (1o)
        - m mot trouvé sur n mot clés dans le profil : m x o occurrences - n x 0,5 x o occurrence du m= (mo - 0,5no)
        - l'ordre est décroissant par nombre d'occurrences (o).Le profil qui a le plus d'occurrences est affiché en premier (en haut de la liste)
8. **exporter un profil** détaillé et complet (format pdf)
9. **Importer mon profil** (upload avec un fichier Word ou Excel)
10. Importer un profil via un API linkedIn

## Implementation

### Environment
Was developed and tested with:
Prerequisites
Here are the prerequisites for this project. If you don’t have these on your system go ahead and install them if you want to practice on your machine.
* Java 11
* IntelliJ IDEA
* Spring Boot 2.5.6
* H2 Database
* JUnit 5
* Maven
* Project Lombok
* Postman
* REST-assured
* Git
* Travis


- Java Runtime and SDK: We need java runtime and SDK for the Java applications to run. This is the core component for running Java applications.
- IntelliJ IDEA: We need an IDE to develop this application. There are other IDEs such as NetBeans, Eclipse IDE, etc. Eclipse is an open-source IDE and has very good community support.
- Spring Boot: Spring is a framework that makes our life easy to develop these java based applications. Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can “just run”.
- H2 Database: H2 Database is a very fast, open-source, JDBC API, and in-memory database. We use this as a database for our project.
- JUnit 5: JUnit 5 is the testing framework for Java applications.
- Maven: We need Maven to install dependencies, package, and build the project.
- Project Lombok: This is a java library that automatically plugs into your editor and builds tools, spicing up your java. You would never write another getter or equals method again, with one annotation your class has a fully-featured builder, Automate your logging variables, and much more.
- Postman: Manual testing your APIs
- REST-assured: Testing and validating REST services in Java

### User Stories
1. As a User, I want to create create a new profile

## Run

To run and test the kata, you can checkout the git project and run the maven command

```
git clone https://github.com/hboufaied/myProfile.git
```

```
./mvnw clean install -B
```
