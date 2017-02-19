package Tietorakenteet;
import javax.annotation.Nullable;
public class Linklist{
  Alkio alku;
  Alkio uusi;
  Alkio vika;
  int luku;

  public Linklist(){
    alku=null;
    uusi=null;
    vika=null;
    luku=0;
  }

  public void uusiAlkio(int numero){
    uusi = new Alkio(numero, vika);
    if (alku==null){
      alku=uusi;
    }
    vika=uusi;
  }

  public Alkio getVika(){
    return vika;
  }

  public Alkio getAlkio(int uutuus){
    Alkio a=vika;
    for(int i=0;i<uutuus;i++){
      a=vika.getEdellinen();
    }
    return a;
  }

  
    public int pituus(){
    Alkio a = vika;
    int pituus=0;
    while(a!=null){
       a=a.getEdellinen();
       pituus++;
    }
    return pituus;      
  }

}


