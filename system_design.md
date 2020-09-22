# 1. A rendszer céljai

-

# 2. A rendszer nem céljai

-

# 3. Projekt terv

-

# 4. Üzleti folyamatok modellje

-

# 5. Követelmények

-

# 6. Funkcionális terv

-

# 7. Fizikai környezet

-

# 8. Absztrakt domain modell

-

# 9. Architekturális terv

-

# 10. Adatbázis terv

### Logikai adatmodell:

<img src="./diagrams/db_model.png">

### Fizikai adatmodellt legeneráló SQL szkript:

```sql
create table GameState (
        id bigint not null,
        bluePlayerName varchar(255) not null,
        created timestamp not null,
        redPlayerName varchar(255) not null,
        state varchar(255) not null,
        primary key (id)
    )
```

# 11. Implementációs terv

<img src="https://raw.githubusercontent.com/p-adrian05/SZFM_2020_10_ErrorByNight/master/diagrams/uml_class_diagram.png" alt="UML diagram">

# 12. Tesztterv

-

# 13. Telepítési terv

-

# 14. Karbantartási terv

-
