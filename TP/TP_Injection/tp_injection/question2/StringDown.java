package question2;


public class StringDown implements Factory{

    public String create(String s){
        return new String(s).toLowerCase();
    }
}
