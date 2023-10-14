package question2;

import question1.VisiteurExpression;

public class VisiteurBoolEvaluation extends VisiteurExpressionBooleenne<Boolean> {

    private VisiteurExpression<Integer> ve;

    public VisiteurBoolEvaluation(VisiteurExpression<Integer> ve) {
        this.ve = ve;
    }

    public Boolean visite(Vrai v) {
        return true; /* a completer */
    }

    public Boolean visite(Faux f) {
        return false; /* a completer */
    }

    public Boolean visite(Non n) { 
        return !(n.bop().accepter(this)); /* a completer */
    }

    public Boolean visite(Ou ou) {
        Boolean res = ou.bop1().accepter(this) || ou.bop2().accepter(this);
        return res; /* a completer */
    }

    public Boolean visite(Et et) {
        Boolean res = et.bop1().accepter(this) && et.bop2().accepter(this);
        return res; /* a completer */
    }
    

    public Boolean visite(Sup sup) {
        Boolean res = sup.op1().accepter(ve) > sup.op2().accepter(ve);
        return res; /* a completer */
    }

    public Boolean visite(Egal eg) {
        Boolean res = eg.op1().accepter(ve) == eg.op2().accepter(ve);
        return res; /* a completer */
    }

    public Boolean visite(Inf inf) {
        Boolean res = inf.op1().accepter(ve) < inf.op2().accepter(ve);
        return res; /* a completer */
    }

}
