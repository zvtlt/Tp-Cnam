package chaineDeResponsabilitesHtmlVuEnCours;
public class B extends Handler<StringBuffer>{
 
    public B(Handler handler){
        super(handler);
    }
     public B(){
        super(null);
    }
    
    public boolean handleRequest(StringBuffer sb){
      sb.insert(0,"<B>").append("</B>");
      return super.handleRequest(sb);
    }
}
