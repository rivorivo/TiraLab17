**Toteutusdokumentti**

Ohjelmassa on Main-luokka, joka tuottaa tekstikäyttöliittymän ja käynnistää pelin. Tekoäly-luokan vastuulla taas on tehdä päätös seuraavasta siirrosta edellisten tietojen perusteella. Sillä on kolme eri taktiikka. 

Eniten käytössä on "toistuvatKuviot"-metodin taktiikka. Sen aika- ja tilavaativuudet pysyvät vakiona, sillä se käy pahimmassa tapauksessakin läpi vakiokokoiset listat "kuviotA" ja indeksin perusteella "kuviotB":stä valitun sisäisen kolmen alkion listan.

Toisissa taktiikkametodeissa "menestyksenPerusteella" ja "vastustajaParas" on käytävä läpi koko lista. Niiden tilavaativuus pysyy vakiona, koska tallennettuna on aina vain samat apumuuttujat, mutta aikavaativuus kasvaa suhteessa O(n), n ollessa listan koko. Metodeita käytetään toistaiseksi vain alussa, kun lista on pieni, joten vaikutuksia suorituskykyyn ei näe.

Tuloslista-luokan tehtävä on kirjata pelien tulokset ylös. Sen aikavaativuus on vakio, sillä se tallettaa joka kierrokselta aina samanlaiset tiedot. Sen "lisaaSiirto"-metodin tilavaativuus on kuitenkin luokkaa O(2n), sillä sen kaksi listaa kasvavat aina suhteessa pelattujen pelien määrään.


