package uebung1;

public class Variable implements Expr {
    String id;
    Scope scope;

    public Variable(String id, Scope scope) {
        this.id = id;
        this.scope = scope;
    }

    @Override
    public double eval() {
        return scope.memory.get(id);
    }
}
