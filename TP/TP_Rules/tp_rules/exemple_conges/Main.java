package exemple_conges;
// https://www.service-public.fr/particuliers/vosdroits/N19978
//
import container.*;
import question1.SpecificationI;
import question2.*;
import question3.*;

import java.util.*;

public class Main{
    static Mairie mairie; // pour les tests
    static Agent agent;
    
    static{
        mairie = new Mairie("Porto-Vecchio","Corse");
        mairie.setJoursDuMaire(5);
        mairie.setServices(new String[]{"Voierie","Environnement","Ecoles"});
        
        agent = new Agent("Pasquale","Portivechju");
        agent.setMairie(mairie);
        agent.setService("Voierie");
        agent.setAnciennete(15);
    }

    public static void TestSansFemtoContainer(){
        ConditionAnciennete anciennete = new ConditionAnciennete();
        anciennete.setNombreDAnneesDAncienneteRequis(5);
        ConditionPenibiliteDuService penibilite = new ConditionPenibiliteDuService();
        penibilite.setServices(new String[]{"Egouts","Voierie"});
        ConditionJoursDuMaire joursDuMaire = new ConditionJoursDuMaire();

        ResultatConges conges = new ResultatConges();
        // en règle if/the java
        if(anciennete.isSatisfiedBy(agent))
           conges.incrementer(5);
        if(penibilite.isSatisfiedBy(agent))
           conges.incrementer(10);
        if(joursDuMaire.isSatisfiedBy(agent))
           conges.incrementer(10);
           
        System.out.println("conges de "+ agent + ":" + conges);
           
        conges = new ResultatConges();
        // en règles 
        CommandeCumulConges inc = new CommandeCumulConges();
        inc.setNombre(1);
        MacroCommand<Agent,ResultatConges> inc5 = new MacroCommand<>();
        CommandI<Agent,ResultatConges>[] tab= new CommandI[]{inc,inc,inc,inc,inc};
        inc5.setCommands(new CommandI[]{inc,inc,inc,inc,inc});
        MacroCommand<Agent,ResultatConges> inc10 = new MacroCommand<>();
        inc10.setCommands(new CommandI[]{inc5,inc5});
                
        Rule<Agent,ResultatConges> regleAnciennete = new Rule<>();
        regleAnciennete.setSpecification(anciennete);
        regleAnciennete.setCommand(inc5);
        Rule<Agent,ResultatConges> reglePenibilite = new Rule<>();
        reglePenibilite.setSpecification(penibilite);
        reglePenibilite.setCommand(inc10);
        
        Rule<Agent,ResultatConges> regleJoursDuMaire = new Rule<>();
        regleJoursDuMaire.setSpecification(joursDuMaire);
        regleJoursDuMaire.setCommand(inc10);
        
        //Rules<Agent,ResultatConges> rules = new Rules<>();
        //System.out.println("conges de "+ agent + ":" + conges);

    }
    
    public static void TestAvecFemtoContainer() throws Exception{
        ApplicationContext ctx = Factory.createApplicationContext("./exemple_conges/README.TXT");
        ResultatConges conges = new ResultatConges();
        
        //RuleI<Agent,ResultatConges> rule1 = ctx.getBean("regles_conges");
        RuleI<Agent,ResultatConges> rule1 = ctx.getBean("trace_regles_conges");
        conges = rule1.execute(agent,conges);
        //System.out.println("rule1: "+ rule1);
        System.out.println("conges de "+ agent + ":" + conges);
        
        // Quels sont les services municipaux ? entite:Mairie, résultat:Une liste
        //RuleI<Mairie,List<String>> rule2 = ctx.getBean("regles_services");
        RuleI<Mairie,List<String>> rule2 = ctx.getBean("trace_regles_services");
        List<String> services = new ArrayList<>();
        services = rule2.execute(mairie,services);
        System.out.println("services de "+ mairie + ":" + services);
    }
}
