package uebung3.Parser;

import uebung3.Token;

public class ParserError {
    static void error(Token token, String message) {
        System.out.printf("%d %s\n", token.line, message);
    }
}
