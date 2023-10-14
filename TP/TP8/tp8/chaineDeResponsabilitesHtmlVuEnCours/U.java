package chaineDeResponsabilitesHtmlVuEnCours;

public class U extends Handler<StringBuffer>{
 
    public U(Handler handler){
        super(handler);
    }
    public U(){
        super(null);
    }
    
    public boolean handleRequest(StringBuffer sb){
      sb.insert(0,"<U>").append("</U>");
      return super.handleRequest(sb);
    }
}
