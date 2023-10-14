package question3;

import question1.*;
import question2.*;
/**
 * Visisteur d'instruction, chaque classe concr�te poss�de une impl�mentation de la visite
 * 
 */
public class VisiteurInstEvaluation extends VisiteurInstruction<Contexte>{

    private VisiteurExpression<Integer> vi;
    private VisiteurExpressionBooleenne<Boolean> vb;

    /** Cr�ation d'un visiteur d'instructions
     * @param vi le visiteur d'expressions arithm�tiques
     * @param vb le visiteur d'expression bool�ennes
     */
    public VisiteurInstEvaluation(VisiteurExpression<Integer> vi, VisiteurExpressionBooleenne<Boolean> vb){
        this.vi = vi;
        this.vb = vb;
    }

    /** obtention du contexte, ici celui du visiteur d'expression arithm�tiques 
     * @return le contexte ici de vi(le visiteur d'expression)
     */
    public Contexte contexte(){
        return this.vi.contexte();
    }

    /** Visite d'une instance de la classe Affectation.
     * 
     * l'affectation, X = Exp, Exp est une expression arithm�tique <br> 
     * <code>
     * 
     *     M,Exp -interprete-> N       <br>      
     * ________________________________<br>               
     * M, X = Exp -interprete-> M[X]=N <br>
     * </code>
     * 
     * @param a  une affectation
     * @return la m�moire r�sultante 
     */
    public Contexte visite(Affectation a){
        vi.contexte().ecrire(a.v().nom(), a.exp().accepter(vi)); // � compl�ter

        return vi.contexte(); // � compl�ter en retournant le contexte modifi�;
    }

    /** Visite d'une s�quence seq(I1,I2) <br>
     * <code>
     * 
     *    M,I1 -interprete-> M1        <br>
     *    M1,I2 -interprete-> M2       <br>
     * ________________________________<br>
     *    M,seq(I,I2)-interprete-> M2  <br>
     *</code>
     * 
     * @param seq  une s�quence
     * @return la m�moire r�sultante 
     */
    public Contexte visite(Sequence seq){
        seq.i1().accepter(this);
        seq.i2().accepter(this);
        return vi.contexte();
    }

    /** Visiste d'une s�lection si (Bexp) alors I1 sinon I2 fsi <br>
     * ou si (Bexp) alors I1 fsi <br>
     *
     * <code>
     * 
     *      M,Bexp-interprete-> vrai             <br>
     *      M,I1 -interprete-> M1                <br>
     * _________________________________________ <br>               
     * M,si(Bexp)alorsI1 sinon I2-interprete-> M1<br>
     * 
     *      M,Bexp -interprete-> faux            <br>
     *      M,I2 -interprete-> M2                <br>
     * __________________________________________<br>
     * M,si(Bexp)alorsI1 sinon I2-interprete->M2 <br>
     * </code>
     * 
     * @param sel  une s�lection
     * @return la m�moire r�sultante 
     */
    public Contexte visite(Selection sel){
        if ( sel.cond().accepter(vb)){
            sel.i1().accepter(this);
        } else {
            if (sel.i2() != null)
                sel.i2().accepter(this);
        }

        // � compl�ter
        return vi.contexte(); // � compl�ter en retournant le contexte modifi�;
    }

    /** La boucle tantque(Bexp,I1)<br>
     * <code>
     * 
     *     M,Bexp -interprete->faux              <br>
     * _________________________________________ <br>
     * M,tantque(Bexp) faire I1-interprete-> M   <br>
     * <br>
     * M,Bexp -interprete-> vrai                          <br>
     * M,seq(I1,tantque(Bexp)faire I1)-interprete-> M1    <br>
     * ___________________________________________________<br>                 
     * M,tantque(Bexp)faire I1-interprete-> M1
     * </code>
     * 
     * @param tq  une it�ration de la classe tantque
     * @return la m�moire r�sultante 
     */
    public Contexte visite(TantQue tq){

        if(tq.cond().accepter(vb)){
            new Sequence(tq.i1(), tq).accepter(this);
        }

        // � compl�ter, en utilisant les r�gles d'inf�rence ci-dessus
        // les tests jnews v�rifient que l'instruction while de Java n'est pas utilis�e
        // � compl�ter
        return vi.contexte();
    }

    /** La boucle pour(init,Bexp,inc)I1<br>
     * <code>
     * M,seq(init,tantque(Bexp)seq(I1,inc))-visite->faux <br>
     * _____________________________________________________ <br>
     * M,pour(init,Bexp,inc) faire I1-visite-> M         <br>
     * </code>
     * 
     * @param pour  une it�ration de la classe Pour
     * @return la m�moire r�sultante 
     */  
    public Contexte visite(Pour pour){

        new Sequence(pour.init(),new TantQue(pour.cond(),new Sequence(pour.i1(), pour.inc()))).accepter(this);
        // � compl�ter, en utilisant les r�gles d'inf�rence ci-dessus
        // les tests jnews v�rifient que l'instruction for (ou while) de Java n'est pas utilis�e

        return vi.contexte(); // � compl�ter en retournant le contexte modifi�;
    }

    /** L'affichage<br>
     * <code>
     *     
     *    M,Exp-visite-> n                              <br>
     * ________________________________System.out.print(n)<br>                 
     * M,afficher(Exp)-visite-> M
     * </code>
     * 
     * @param a  une instruction d'affichage d'une expression arithm�tique
     * @return la m�moire intacte 
     */
    public Contexte visite(Afficher a){
        System.out.println(a.exp().accepter(this.vi));
        return this.vi.contexte();
    }

    /** Une assertion, 
     * si celle-ci �choue une exception est lev�e, 
     * emploi de la clause <a href=http://java.sun.com/j2se/1.5.0/docs/guide/language/assert.html> assert</a> Expr : "un Message";
     * 
     * @param a  une assertion
     * @return la m�moire intacte 
     * @throws une exception AssertionError
     */
    public Contexte visite(Assertion a) {
        try{
            boolean condition = a.cond().accepter(vb);
            assert condition;
        }catch(AssertionError ae){
            throw ae;
        }
        
        boolean temp = a.cond().accepter(vb);
        
        if(temp)
            assert temp;
        else
            throw new AssertionError();
        // � compl�ter par l'usage de assert de java, installer l'option \"-ea\" ligne 480 de bluej.defs soit bluej.vm.args=-ea

        return vi.contexte(); // � compl�ter en retournant le contexte modifi�;
    }
}
