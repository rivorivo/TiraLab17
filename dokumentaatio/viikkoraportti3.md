    **Mitä olen tehnyt tällä viikolla?**
	Tällä viikolla muutin ohjelman rakenteen maven-muotoon. Toteutin tekoälylle kokonaan uuden taktiikan, joka perustuu kuviontunnistukseen. Tein myös muutoksia ja parannuksia vanhaan koodiin ja lisäsin kommentteja. Lisäksi tein lisää testejä ja kiinnitin huomiota testauksen rivikattavuuteen. Koska main-luokkaa tuskin on syytä testata, täytyy coberturan raporttia tutkiessa jättää se huomiotta.
    **Miten ohjelma on edistynyt?**
	Ohjelma on edistynyt taas hyvin. Olen erityisen tyytyväinen, että sain uuden taktiikan toimimaan. Uusi taktiikka vaatii vastustajan kaikkien kolmen peräkkäisen siirron sarjojen muistamisen. Koska valmiita tietorakenteita ei saa  käyttää, hyödynsin toteutuksessa kahta kaksiulotteista kokonaisluku-listaa. Ensimmäinen lista on vakiokokoinen ja sisältää kaikki kahden siirron yhdistelmät indekseillä 0-8. Toinen lista taas sisältää tiedon jokaisen näiden yksittäisten yhdistelmien 0-8 jälkeen tehtyjen kolmansien siirtojen 0,1,2 "Kivi,Sakset,Paperi" määrät. Tekoäly-luokka käyttää näitä tietoja hyväkseen ja pyrkii ennustamaan vastustajan siirtoja toistuvien kuvioiden perusteella.
    **Mitä opin tällä viikolla / tänään?**
	Tällä viikolla muistutin taas mieleeni Maven-rakenteen ja Coberturan käyttöä. Lisäksi opin käyttämään yksinkertaisia listoja vähän monimutkaiseen tarkoitukseen. Luin tietysti myös vähän lisää ksp-taktiikoista.
    **Mikä jäi epäselväksi tai tuottanut vaikeuksia?**
	Vähän epäselväksi jäi, että miten testikattavuuden saa joihinkin tiettyihin riveihin(raportti tuntuu välillä epäjohdonmukaiselta).
    **Mitä teen seuraavaksi?**
	Uusia taktiikoita ja mahdollisuuden valita pelin pituuden. Eriytän mahdollisesti joitakin tallennusmetodeita Tuloslista-luokasta omiin luokkiinsa. Ensi viikon hommiin kuuluu tietysti myös vertaisarviointi.
