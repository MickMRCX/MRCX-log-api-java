# MRCX-log-api-java

**Introduction**

Ce programme est une librairie permettant l'enregistrement rapide de logs dans une base de données.  
Si la base de données n'est pas accessible pour une quelconque raison, l'enregistrement passera sur un fichier local temporairement.  
Une fois la connexion rétablie, l'application enverra en base les données enregistrées dans le fichier, puis l'éffacera.



**Visualisation**  

La visualisation des logs se fera par une application web réalisée a part.