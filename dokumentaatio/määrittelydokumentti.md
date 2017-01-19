Kehitän työssäni ohjelman, jonka pelaa kivi-sakset-paperi -peliä tulostamalla siirron K,S tai P. Peliä pelataan monta vuoroa ja tekoälyn siirtojen on tarkoitus parantua pelin jatkuessa. 

Suunnittelen mahdollisesti useampaa eri taktiikkaa hyödyntävän algoritmin, joka vaihtaa lähestymistapaa edellisten siirtojensa tuottamien tulosten mukaan ja vastustajan edelliset siirrot huomioiden. Pyrin luomaan muutaman mm. psykologisiin tutkimuksiin perustuvan pelitaktiikan sekä muita perustaktiikoita, joita ohjelma käyttää ja joita se vaihtelee ja vertailee tarpeen mukaan. Lisäksi ohjelma etsii tiettyjä säännönmukaisuuksia ja tendenssejä vastustaja siirroista ja huomioi ne valitessaan pelityyliä seuraavia siirtoja varten.

Ohjelma saa syötteenä vastustajan siirron ja ottaa niitä talteen rajallisen määrän. Syötettä ei siis suoraan tietenkään voi käyttää päätöksen teossa vaan edelliset siirrot vaikuttavat seuraavan siirron valintaan. Käytän toteutuksessa siirtojen tallentamiseen kurssilla sallittuja taulukkorakenteita. Lisäksi tarvitsen muutamia muuttuujia esimerkiksi häviöiden ja voittojen laskemiseen.

Ainakin edellisiä siirtoja sisältävästä taulukoista kuvioita etsiessäni joudun käyttämään jonkinlaista merkkijonohakualgoritmia, jonka aikavaativuus on pahimmassa tapauksessa luokkaa O(k), jossa k=taulukon koko. Pidän taulukon koon kuitenkin pienenä, sillä tarkoitus on päätellä minkälaisella taktiikalla pelaaja sillä hetkellä pelaa. Muuten ohjelman suorituksen aikavaativuus pitäisi pysyä vakiona.
Tilavaativuus on luokkaa O(k), koska muuttujia on kiinteä määrä, mutta listan koko vaikuttaa tilavaativuuteen.

