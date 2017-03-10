**Toteutusdokumentti**

Ohjelmassa on Main-luokka, joka tuottaa tekstikäyttöliittymän ja käynnistää pelin. Tekoäly-luokan vastuulla taas on tehdä päätös seuraavasta siirrosta edellisten tietojen perusteella. Sillä on kolme eri taktiikka. 

Eniten käytössä on "toistuvatKuviot"-metodin taktiikka. Sen aika- ja tilavaativuudet pysyvät vakiona, sillä se käy pahimmassa tapauksessakin läpi vakiokokoiset listat "kuviotA" ja indeksin perusteella "kuviotB":stä valitun sisäisen kolmen alkion listan.

Toisissa taktiikkametodeissa "menestyksenPerusteella" ja "vastustajaParas" on käytävä läpi koko lista. Niiden tilavaativuus pysyy vakiona, koska tallennettuna on aina vain samat apumuuttujat, mutta aikavaativuus kasvaa suhteessa O(n), n ollessa listan koko. Metodeita käytetään toistaiseksi vain alussa, kun lista on pieni, joten vaikutuksia suorituskykyyn ei näe.

Tuloslista-luokan tehtävä on kirjata pelien tulokset ylös. Sen aikavaativuus on vakio, sillä se tallettaa joka kierrokselta aina samanlaiset tiedot. Sen "lisaaSiirto"-metodin tilavaativuus on kuitenkin luokkaa O(2n), sillä sen kaksi listaa kasvavat aina suhteessa pelattujen pelien määrään.

Viidennellä viikolla loin Linkedlist-luokan, joka on taaksepäin linkitetty lista. Avuksi tein alkioluokan. Se tuottaa alkioita, joilla on arvo ja tieto edellisestä. Listaluokan toteutuksen vuoksi jouduin muuttamaan laskennassa käytettyjen siirto- ja voittotietojen koodauksen pääosassa int-tyyppisiksi String-tyyppisten sijaan. Alunperinkin olisi kannattanut toimia näin ja käyttää String-muotoa vasta tulostuksessa. Listarakenteella sain korvattua kaikki yksiulotteiset listat ja sain käytettyä sitä kätevästi eri tarkoituksiin.

Kaksiulotteiset tietorakenteet korvasin Siirtopuu-nimisellä luokalla, joka käyttää Solmu-luokan olioita. Rakenne on puumainen rakenne, jonka solmuilla on kolme (siirtoja 'kivi, sakset,paperi' kuvaavaa) lasta. Rakennetta käytetään Kuviolista-luokassa peräkkäisten siirtokuvioiden tallentamiseen.

Toteutin ohjelman käytettävyyttä parantaakseni lopuksi vielä yksinkertaisen graafisen käyttöliittymän. Käytin sen tekemiseen netbeansin GUI-generaattoria. Käyttöliittymä teki ohjelman käyttämisestä kevyempää ja varsinkin useamman peräkkäisen pelin pelaaminen ja empiirinen testaaminen helpottuivat.


