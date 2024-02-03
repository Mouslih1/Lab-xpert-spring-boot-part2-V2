# LabXpert - l'API REST via Spring Boot ( Part 2 )

Le laboratoire médical TechLab a besoin d'une application de gestion, LabXpert, pour optimiser ses opérations en améliorant l'efficacité et la précision dans le traitement des analyses médicales.

LabXpert API built in Spring Boot

Prerequisites:
Spring Boot 2.7.6
JDK 1.8
Maven 4.0.0

Ce référentiel contient des classes Java qui représentent les entités du système LabXpert, un laboratoire d'analyse médicale. Ci-dessous, vous trouverez une brève description de chaque classe fournie :

## Analyse
La classe Analyse représente une analyse médicale effectuée par le laboratoire. Elle contient des informations telles que le technicien responsable, l'échantillon associé, le statut du résultat, le type d'analyse, les dates de début et de fin, ainsi que des commentaires.

## Echontillon
La classe Echontillon représente un échantillon médical soumis au laboratoire pour analyse. Elle comprend des détails tels que le patient associé, la date de prélèvement, le statut de l'échantillon, et la liste des analyses effectuées.

## Fournisseur
La classe Fournisseur représente un fournisseur de réactifs médicaux. Elle contient des informations telles que le nom complet du fournisseur, le nom de la société, et la liste des réactifs fournis.

## Patient
La classe Patient hérite de la classe abstraite Person et représente un patient du laboratoire. Elle inclut des détails spécifiques au patient tels que l'âge et la liste des échantillons associés.

## Person
La classe abstraite Person représente une entité générique avec des informations personnelles de base, telles que le nom, le prénom, l'adresse, le numéro de téléphone, la ville, le sexe et la date de naissance.

## Planification
La classe Planification représente la planification d'une analyse. Elle contient des détails tels que l'analyse associée, le technicien en charge, ainsi que les dates de début et de fin de la planification.

## RapportStatistique
La classe RapportStatistique représente un rapport statistique généré par le laboratoire. Elle inclut des informations telles que le type de rapport, la période statistique, les données statistiques et un graphique associé.

## Reactif
La classe Reactif représente un réactif médical utilisé dans les analyses. Elle comprend des informations telles que le nom, la description, la quantité en stock, la date d'expiration, et le fournisseur associé.

## Result
La classe Result représente le résultat d'une sous-analyse. Elle inclut la valeur du résultat, l'unité de mesure, et la sous-analyse associée.

## SousAnalyse
La classe SousAnalyse représente une sous-analyse effectuée dans le cadre d'une analyse principale. Elle contient des informations telles que le titre, les valeurs normales, l'analyse associée, le réactif utilisé, et le statut du résultat.

## User
La classe User représente un utilisateur du système LabXpert. Elle hérite de la classe Person et inclut des détails spécifiques à l'utilisateur tels que l'e-mail, le mot de passe, le rôle, ainsi que les listes d'analyses et de planifications associées.

Ces classes fournissent une structure de base pour modéliser les entités du laboratoire d'analyse médicale dans le système LabXpert.

# Digramme classes

![ConceptionDigrammeClassLabXpert](https://github.com/Mouslih0/lab-xpert-spring-boot/assets/106397107/301080c9-e24c-4a74-9e5a-e7ed6dd01438)

# Digramme Cas Utilisation:

![DiagrammeCasUtilisationLabXpert](https://github.com/Mouslih0/lab-xpert-spring-boot/assets/106397107/cb87d764-a498-4071-8b3b-ce3c77e7552c)


