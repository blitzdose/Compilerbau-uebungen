package uebung4_5.Traversal.InterpreterUtils;

import uebung3.Token;

public class RuntimeError extends RuntimeException {
    final Token token;

    public RuntimeError(Token token, String message) {
        super(message);
        this.token = token;
    }
}