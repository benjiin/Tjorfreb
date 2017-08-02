package de.Tjorfreb_Bremen.Afrooz.model;

/**
*
* @author Afrooz Akbari
*/
import java.util.ArrayList;
import java.util.List;

public class ArtikelService 
{
  private List<Artikel> artikelListe;
  private static ArtikelService artikelService;
  
  // statische Factory-Methode
  public static ArtikelService getInstance() 
  {
    if (artikelService == null)
      artikelService = new ArtikelService();
    return artikelService;
  }
  
  private ArtikelService() 
  {
    // Bei Datenbanken immer neu einlesen in der Methode getArtikel()
    artikelListe = getStatischeArtikelListe(); 
  }
  
  public List<Artikel> getArtikel() 
  {
    // ...
    return artikelListe;
  }

  private List<Artikel> getStatischeArtikelListe() 
  {
    List<Artikel> artikelListe = new ArrayList<>();
    Artikel art = new Artikel(1,"USB-Stick", 25,"");
    artikelListe.add(art);
    art = new Artikel(2,"Logitech Maus", 15,"");
    artikelListe.add(art);
    art = new Artikel(3,"Funktastatur", 12,"");
    artikelListe.add(art);
    art = new Artikel(4,"BenQ-Bildschirm 19\"", 130,"");
    artikelListe.add(art);
    return artikelListe;
  }

  public Artikel getArtikel(int id) 
  {
    for (Artikel art : artikelListe) 
    {
      if (art.getId() == id)
        return art;
    }
    return null;
  }
}