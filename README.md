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
- Maven 3.8.3
- Eclipse IDE 2021‑09
- JDK 11
- Spring Boot 2.5.6
- Git
- Travis

### Solution

Create a new spring boot project from https://start.spring.io/
Add the dependencies : 
* Spring Web
* Spring Data JPA
* H2 for memory databases

## Run

To run and test the kata, you can checkout the git project and run the maven command

```
git clone https://github.com/hboufaied/myProfile.git
```

```
./mvnw clean install -B
```
