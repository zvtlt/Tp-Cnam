package question1;



public class StringUpDown {
    
    private String str;
    
    public String setToUpperCase (String str){
        this.str = str.toUpperCase();
        return this.str;
    }
    
    public String setToLowerCase (String str){
        this.str = str.toLowerCase();
        return this.str;
    }
    
    public String toString(){
        return str.toString();
    }
}
