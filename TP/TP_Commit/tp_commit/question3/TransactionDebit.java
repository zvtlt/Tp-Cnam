package question3;

import question1.*;

public class TransactionDebit extends AbstractTransaction{
    private Gardien gardien;

    public TransactionDebit(Cotisant cotisant){
        super(cotisant);
        this.gardien = new Gardien();
    }

    public void beginTransaction(){
        gardien.setMemento(new Memento(cotisant));
        // � compl�ter
    }

    public void endTransaction(){
        // � compl�ter
    }

    public  void rollbackTransaction(){
        gardien.getMemento().setState(cotisant);
        // � compl�ter
    }
}