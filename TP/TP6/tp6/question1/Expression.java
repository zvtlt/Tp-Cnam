package question1;

/**
 * Une expression arithm�tique
 */
public abstract class Expression {

    public abstract <T> T accepter(VisiteurExpression<T> v);

}