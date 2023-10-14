package decorateurHtmlVuEnCours;

public abstract class TexteDecore implements TexteI{
  private TexteI unTexte; // ? le texte � d�corer
  public TexteDecore(){}
  public void setUnTexte(TexteI unTexte){
      this.unTexte = unTexte;
    }
  public TexteDecore(TexteI unTexte){
    this.unTexte = unTexte; 
  }
  public String toHTML(){
    return unTexte.toHTML(); // ? le texte d�cor�
  }
}