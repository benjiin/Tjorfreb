package de.Tjorfreb_Bremen.Afrooz.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Afrooz Akbari
 */

public class Warenkorb 
{
  //  private List<Position> positionen; // ideal
  private List<Artikel> artikelListe;

  public Warenkorb() 
  {
    artikelListe = new ArrayList<>();
  }

  public double getGesamtPreis() 
  {
    double gesamtPreis = 0.0;
    
    for (Artikel artikel : artikelListe) 
    {
      gesamtPreis += artikel.getPreis();
    }
    return gesamtPreis;
  }

  public void addArtikel(Artikel artikel) 
  {
    artikelListe.add(artikel);
  }

  public List<Artikel> getArtikelListe() 
  {
    return artikelListe;
  }

  public void setArtikelListe(List<Artikel> artikelListe) 
  {
    this.artikelListe = artikelListe;
  }
  
}