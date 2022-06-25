package uebung3;

import org.junit.jupiter.api.Test;
import uebung3.Parser.Parser;
import uebung3.Parser.Stmts.Function;
import uebung3.Parser.Stmts.Print;
import uebung3.Parser.Stmts.Stmt;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    static final String program = """
            fun printSum(a,b) {
            print a+b;
            }
            print 25+60;
            """;

    @Test
    void parseTest() {
        Scanner scanner = new Scanner(program);
        List<Token> actual = scanner.scan();
        Parser parser = new Parser(actual);
        List<Stmt> statements = parser.parse();
        assertTrue(statements.get(0) instanceof Function, "Expected Type Function got " + actual.get(0).getClass().getName());
        assertTrue(statements.get(1) instanceof Print, "Expected Type Print got " + actual.get(0).getClass().getName());
        assertTrue(((Function) statements.get(0)).body.get(0) instanceof Print, "Expected Type Print in function");
        assertEquals(((Function) statements.get(0)).parameters.get(0).type, TokenType.IDENTIFIER, "Expected first function parameter to be identifier");

    }
}