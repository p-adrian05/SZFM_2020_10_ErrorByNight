# 1. A rendszer céljai

Felhasználóknak egy asztali alkalmazás biztosítása, amelyet akár két felhasználó is használhat felváltva
a játék menete szerint.

- Magyar nyelvű felhasználói felület prezentálása.
- A játék lokális két-játékos módjának megvalósítása.
- Intuitív, bővebb leírást nem igénylő kezelői felület.
- Egyszerű, modern megjelenés biztosítása, az egyszerű kezelés céljából.
- Lehetőség biztosítása a jétékosoknak egyedi nevek megadására, ekkor mindkét játékos megadhatja a nevét (A magyar nyelvben előforduló karakterek támogatásával).
- Új játék kezdésének biztosítása, ekkor a tábla és a lépni következő jétékos neve is alapértelmezett állapotba kerülnek.
- Aktuális játék állapotának (játékos nevek és tábla állapota/korongok helye) elmentése.
- Egy korábban elmentet játék állapotának kitörlése.
- Egy adott játék állapot betöltése, ennek köszönhetően lehetőség van a játék folytatására az adott állapotból.
- A játékos tájékoztatása a játék során a megtehető lépések helyeiről a táblán.
- Platformfüggetlenség.




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
