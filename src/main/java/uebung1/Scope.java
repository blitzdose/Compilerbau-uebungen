package uebung1;

import java.util.HashMap;
import java.util.Map;

public class Scope implements Expr {
    public Map<String, Double> memory = new HashMap<>();
    private Expr expr;

    public Scope() {
    }

    public Scope newVariable(String id, Expr value) {
        this.memory.put(id, value.eval());
        return this;
    }

    public Scope expression(Expr expr) {
        this.expr = expr;
        return this;
    }

    @Override
    public double eval() {
        return expr.eval();
    }
}
