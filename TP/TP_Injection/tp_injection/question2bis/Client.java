package question2bis;


public class Client{
    private Proxy proxy;
    private String resultat;

    public void setProxy(Proxy proxy){
        this.proxy = proxy;
    }
    
    public String executer(){
        resultat = proxy.executer();
        
        return resultat;
    }
}
