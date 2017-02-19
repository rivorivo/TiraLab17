package Tietorakenteet;
public class Alkio{

  int luku;
  Alkio edellinen;

  public Alkio(int luku, Alkio edellinen){
    this.luku=luku;
    this.edellinen=edellinen;
  }

  public int getArvo(){
  	return luku;
  }

  public Alkio getEdellinen(){
    return edellinen;
  }

  public void setEdellinen(Alkio a){
  	edellinen = a;
  }

  public void setArvo(int a){
  	luku = a;
  }

}