# 1. A rendszer céljai és nem céljai

### A rendszer céljai:

Felhasználóknak egy asztali alkalmazás biztosítása, amelyet akár két felhasználó is használhat felváltva
a játék menete szerint.

- Lehetőség biztosítása a jétékosoknak egyedi nevek megadására, ekkor mindkét játékos megadhatja a nevét.
- Új játék kezdésének biztosítása, ekkor a tábla és a lépni következő jétékos neve is alapértelmezett állapotba kerülnek.
- Aktuális játék állapotának (játékos nevek és tábla állapota/korongok helye) elmentése.
- Egy korábban elmentet játék állapotának kitörlése.
- Egy adott játék állapot betöltése, ennek köszönhetően lehetőség van a játék folytatására az adott állapotból.
- A játékos tájékoztatása a játék során a megtehető lépések helyeiről a táblán.

### A rendszer nem cáljai:

- Játékosok regisztrálása és beléptető mechanizmus biztosítása.
- A játékohoz tartozó animációk és reszponzív felhasználói felület biztosítása.
- Program bezárásakor figyelmeztető ablak megjelenítése.
- A játék elmentése során visszajelző ablak, üzenet kiírása.
- Internet kapcsolat létrehozása.

# 2. Jelenlegi helyzet leírása

-

# 3. Vágyálom rendszer leírása

-

# 4. Jelenlegi üzleti folyamatok modellje

-

# 5. Igényelt üzleti folyamatok modellje

-

# 6. Követelménylista

-

# 7. Használati esetek

Aktorok: _játékos_

Funkciók:

- játékosok neveinek megadása
- új játék indítása
- lépés a játékban
- játék vége
- kilépés

<img src="./use_cases/useCase.svg">

# 8. Megfeleltetés, hogyan fedik le a használati esetek a követelményeket

- Elrendezve 4 kék és 4 piros korong egy 5 × 4 mezőből álló táblán.
  - 5x4 tábla 4-4 piros/kék korong.
- Az egyik játékos színe kék, másiké a piros.
  - Piros/kék korongok a táblán.
- Felváltva következnek lépni, amely során egy saját színű korongot mozdítanak el egy üres mezőre.
  - 2 játékos 1-1 lépés.
- Egy játékos akkor nyer, ha egymás mellett függőlegesen, vízszintesen vagy átlósan sikerül elhelyezni 3 saját színű korongot.
  - A nyerő állásba lépett játékos nyer.
- Játékállás mentése a játék menete során.
  - Játékállás mentés.
- Korábbi elmentett játékállás betöltése.
  - Játékállás betöltés.
- Régebbi játékállás törlése.
  - Játékállás törlése.
- Játékos nevek megadása.
  - Játékos nevek megadása színenként.

# 9. Képernyő tervek

A képernyő tervek [Screen Builder](https://gluonhq.com/products/scene-builder/) segítségével készültek, előzetes megtekintéséhez a Sreen Builder alkalmazással szükséges
megnyitni a mellékelt fxml fájlokat.

[Képernyő tervek](https://github.com/p-adrian05/SZFM_2020_10_ErrorByNight/tree/master/screen_plans)

# 10. Forgatókönyvek

Az alkalmazás megnyitásakor a főképernyő jelenik meg. Ezen a képernyőn jelenik meg a játékban használt tábla, amelyen a korongok kezdetben alul és felül helyezkednek. A tábla felett jelenik meg az éppen lépni következő játékos neve. Továbbá a név mellett, az alkalmazás jobb felső sarkában funkció gombok találhatóak.

##### A játék megkezdése előtt:

- Beállítható a játékosok nevei egy gomb megnyomásával, ahol egy kis felugró ablakban van erre lehetőség.
- Lehetőség van egy régebbi, elmentet játék állapotát megjeleníteni. Egy gomb megnyomására egy új oldal jelenik meg, ahol kiválasztható egy listából egy játék állapot, amely egy név pár és egy dátummal van felcimkézve. Kiválasztást követően visszatér a főképernyőre, ahol az adott játék állapot jelenik meg.

##### A játék közben:

- Egy korongra kattint a lépni következő játékos a táblán, ekkor megjelennek zöld színnel a táblán azok a helyek, ahova
  léphet a játékos a választott koronggal.
- Lehetőség van egy gomb segítségével elmenteni az adott játék állását, játékos nevek és táblán
  lévő korongok helyét.
- Egy gomb segítségével kitörölni egy adott játék állását, abból a listából amelyben megjelennek az elmentett játék állapotok.
- Dátum és nevek szerint sorrendbe rendezni a listában játék állásokat.

##### A játék végén:

- Megjelenik a győztes neve a tábla felett, majd lehetőség van új játékot indítani egy gomb segítségével, amely kezdőállapotba helyezi a játék táblát és a nevek egy alapértermezett értéket vesznek fel.

Ha egy funkció nem elérhető a játék egy adott állapotában, akkor a funkciót elérő gomb nem kattintható, letiltásra kerül.

# 11. Funkció – követelmény megfeleltetés

- Elrendezve 4 kék és 4 piros korong egy 5 × 4 mezőből álló táblán.
  - A játék táblája a megfelelő méretben megjelenik a főképernyőn.
- Az egyik játékos színe kék, másiké a piros.
  - Piros és kék színű korongok jelennek meg a táblán, amely a két játékost reprezentálja.
- Felváltva következnek lépni, amely során egy saját színű korongot mozdítanak el egy üres mezőre.
  - A jétékosok felváltva lépnek a táblán, a számukra lehetséges mezőkre.
- Egy játékos akkor nyer, ha egymás mellett függőlegesen, vízszintesen vagy átlósan sikerül elhelyezni 3 saját színű korongot.
  - A nyerő állásban az utoljára lépett játékos nyer, neve kiírásra kerül a tábla tetejére.
- Játékállás mentése és korábbi játékállás betöltése.
  - Adott játékállás mentése egy listába.
- Korábbi játékállás betöltése.
  - Megfelelő állás kiválasztása és betöltése a listából.
- Régebbi játékállás törlése.
  - Adott játékállás kiválasztása és törlése a listából.
- Játékos nevek megadása színek szerint.
  - A jétékosok megadják nevüket a megfelelő színhez párosítva.
