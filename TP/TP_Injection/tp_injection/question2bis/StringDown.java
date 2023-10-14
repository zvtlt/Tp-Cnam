package question2bis;


public class StringDown implements Proxy{
    private Proxy proxy;
    private String s;
    
    public void setProxy(Proxy proxy){
        this.proxy = proxy;
    }
    
    public void setString(String s){
        this.s = s;
    }
    
    public String executer(){
        if(s.length()<20){
            return s.toLowerCase();
        }
        return proxy.executer();
    }
}
