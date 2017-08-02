package de.Tjorfreb_Bremen.Afrooz.model;

/**
*
* @author Afrooz Akbari
*/
import java.io.Serializable;

public class Artikel implements Serializable
{
  
  private int id;
  private String bezeichnung;
  private double preis;
  private String beschreibung;
  
  public Artikel() 
  {
    super();
  }
  
  public Artikel(String bezeichnung, double preis) 
  {
    super();
    this.bezeichnung = bezeichnung;
    this.preis = preis;
  }

  public Artikel(String bezeichnung, double preis, String beschreibung) 
  {
    super();
    this.bezeichnung = bezeichnung;
    this.preis = preis;
    this.beschreibung = beschreibung;
  }
  
  public Artikel(int id, String bezeichnung, double preis, String beschreibung) 
  {
    super();
    this.id = id;
    this.bezeichnung = bezeichnung;
    this.preis = preis;
    this.beschreibung = beschreibung;
  }

  public String getBezeichnung() 
  {
    return bezeichnung;
  }

  public void setBezeichnung(String bezeichnung) 
  {
    this.bezeichnung = bezeichnung;
  }

  public double getPreis() 
  {
    return preis;
  }

  public void setPreis(double preis) 
  {
    this.preis = preis;
  }

  public String getBeschreibung() 
  {
    return beschreibung;
  }

  public void setBeschreibung(String beschreibung) 
  {
    this.beschreibung = beschreibung;
  }

  @Override
  public String toString() 
  {
    return String.format("(%d) - %s - %.2f", id, bezeichnung, preis);
  }

  public int getId() 
  {
    return id;
  }

  public void setId(int id) 
  {
    this.id = id;
  }
}