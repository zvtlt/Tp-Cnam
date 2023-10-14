package question4;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.text.DateFormat;

public class Log extends Handler<Requete>{
    public Log(Handler<Requete> handler) {
        super(handler);
    }

    public Log(){super(null);}

    public boolean handleRequest(Requete requete){
        Calendar c = Calendar.getInstance();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,Locale.FRANCE);
        DateFormat dt = DateFormat.getTimeInstance(DateFormat.SHORT,Locale.FRANCE);
        String date = df.format(c.getTime()) + "-" + dt.format(c.getTime());
        System.out.println("Log: " + date + ", requête: " + requete );
        return super.handleRequest(requete);
    }

}
