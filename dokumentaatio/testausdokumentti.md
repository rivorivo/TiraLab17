**Testausdokumentti**

Ohjelman logiikan ja tietorakenteiden koodia on testattun JUnit-yksikkötestauksella. Coberturan ilmoittama rivikattavuus on Tuloslistaluokalle neljännellä viikolla 100% ja tekoälyluokalle 85%. Testeissä käydään läpi metodien perustoiminnallisuuksia ja yritetään saada useita eri skenaarioita testattua. Välillä epäselvissä tapauksissa asetin tulostuskomennon esimerkiksi yksittäisen ehtolausekkeen sisään ja ajoin ohjelman varmistuen siitä, että ehtolausekkeen sisällä käydään ja se toimii.

Main-luokka ei voi testata kokonaan suoraan yksikkötestauksella, joten olen testannut sitä ajamalla ohjelmaa itse. Koska ohjelma on suoraviivainen, tulee sen käyttöjärjestelmän toiminnot yleensä testattua jokaisella suorituskerralla. Samalla voin testata, että taktiikat toimivat käytännössä. Vaikka itse logiikka testataan yksikkötestauksella, tekoälypelaajan vaikeusastetta voi arvoida pelaamalla ohjelmalla itse, tai vielä paremmin pyytämällä ulkopuolisen kokeilemaan.

![Esimerkki](https://github.com/rivorivo/TiraLab17/blob/master/dokumentaatio/kuvat/kaappaus1.png)
 
Kuvassa näkyy pelin testausta manuaalisesti. Tulosteet "eka" ja "toka" ovat tunnistettavan kolmen siirron kuvion kaksi ensimmäistä siirtoa(1,2,3=kivi,sakset,paperi) ja "alku" on indeksiluku(0-8), jonka perusteella listasta listaB:stä etsitään oikea kohta todennäköisen siirron laskemista varten. Tuloste "Monta" taas kertoo listan pituuden. Tällaiset aputulosteet eivät tietenkään kuulu varsinaiseen ohjelmaan vaan käytän niitä testaamiseen ja epäselvien virheiden selvittämiseen.

