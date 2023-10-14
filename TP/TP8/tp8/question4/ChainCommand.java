package question4;

public class ChainCommand implements Command<Requete>{
    private Handler<Requete> chain;

    public void setChain(Handler<Requete> chain){
        this.chain = chain;
    }

    public void send(Requete request)throws Exception{
        chain.handleRequest(request);
    }

}
