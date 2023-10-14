package question3;

public class TraceRule2<E,R> extends DecoratorRule<E,R>{

    public TraceRule2(RuleI<E,R> rule){
        super(rule);
    }

    public TraceRule2(){
        super();
    }

    public R execute(E e,R r) throws Exception {
        String res1 = rule.toString();
        res1 = res1.substring(0, 3);
        
        String res2 = rule.toString();
        res2 = res2.substring(3, res2.length());
        
        String res = res1 + e + " " + res2;
        
        System.out.print("pre_execute:[e/" + e + ",r/" + r + "]");
        System.out.print("  " + res);
        R r1 = super.rule.execute(e,r);
        System.out.println("  post_execute:[r'/" + r1 + "]");
        return r1;
    }
} 