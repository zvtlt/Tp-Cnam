package question2;

public class Client{
    private int cMode;
    private String res;

    public void setMode(int i){
        cMode = i;
    }

    public String setUoD (String str){

        if(cMode == 0){
            Factory strDown = new question2.StringDown();
            res = strDown.create(str);
            return res;
        }

        if(cMode == 1){
            Factory strUp = new question2.StringUp();
            res = strUp.create(str);
            return res;
        }

        return null;
    }

    public String toString(){
        return res.toString();
    }
}
