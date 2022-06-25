package uebung4_5.Traversal.InterpreterUtils;


import uebung3.Parser.Stmts.Function;
import uebung4_5.Traversal.Interpreter;

import java.util.List;

public class LoxFunction implements LoxCallable {
    private final Function declaration;
    private final Environment closure;

    public LoxFunction(Function declaration, Environment closure) {
        this.closure = closure;
        this.declaration = declaration;
    }

    @Override
    public int arity() {
        return declaration.parameters.size();
    }

    @Override
    public String toString() {
        return "<fn " + declaration.name.lexeme + ">";
    }

    @Override
    public Object call(Interpreter interpreter,
                       List<Object> arguments) {
        Environment environment = new Environment(closure);
        for (int i = 0; i < declaration.parameters.size(); i++) {
            environment.define(declaration.parameters.get(i).lexeme,
                    arguments.get(i));
        }

        try {
            interpreter.executeBlock(declaration.body, environment);
        } catch (LoxReturn returnValue) {
            return returnValue.value;
        }
        return null;
    }
}