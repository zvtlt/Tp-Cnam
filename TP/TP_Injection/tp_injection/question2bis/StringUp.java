package question2bis;


public class StringUp implements Proxy {
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
            return s.toUpperCase();
        }
        return proxy.executer();
    }
}
