
package de.Tjorfreb_Bremen.Afrooz.model;

/**
*
* @author Afrooz Akbari
*/
public class Position 
{
  private int id;
  private int menge;
  private Artikel artikel;
  private int rabatt;

  public Position() 
  {
  }

  public Position(int id, int menge, Artikel artikel) 
  {
    this.id = id;
    this.menge = menge;
    this.artikel = artikel;
  }

  public int getId() 
  {
    return id;
  }

  public void setId(int id) 
  {
    this.id = id;
  }

  public int getMenge() 
  {
    return menge;
  }

  public void setMenge(int menge) 
  {
    this.menge = menge;
  }

  public Artikel getArtikel() 
  {
    return artikel;
  }

  public void setArtikel(Artikel artikel) 
  {
    this.artikel = artikel;
  }
  
}