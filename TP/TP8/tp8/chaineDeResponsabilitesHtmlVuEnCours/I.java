package chaineDeResponsabilitesHtmlVuEnCours;

public class I extends Handler<StringBuffer>{
 
    public I(Handler handler){
        super(handler);
    }
    public I(){
        super(null);
    }
    
    public boolean handleRequest(StringBuffer sb){
      sb.insert(0,"<I>").append("</I>");
      return super.handleRequest(sb);
    }
}
