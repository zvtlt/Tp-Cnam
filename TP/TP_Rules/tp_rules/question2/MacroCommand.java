package question2;

public class MacroCommand<E,R> extends CompositeCommand<E,R>{

    public R execute(E e, R r) throws Exception{/* TODO */
        
        for (CommandI command : super.commands) {
            r = (R) command.execute(e, r);
        }
        
        return r;
    }

}
