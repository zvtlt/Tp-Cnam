package question2;

public class StringUp implements Factory {
    public String create(String s){
        return new String(s).toUpperCase();
    }
}