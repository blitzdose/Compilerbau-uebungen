package uebung1;

public class Interpreter {
    public static void main(String[] args) {

        //Interpreter aus Haskell in Java
        double testCalc1 = new PlusExpr(new MultExpr(new Literal(3), new Literal(4)), new Literal(8)).eval();
        System.out.println("(3 * 4) + 8 = " + testCalc1);

        double testCalc2 = new DivExpr(new MinusExpr(new Literal(100), new Literal(10)), new Literal(3)).eval();
        System.out.println("(100 - 10) / 3 = " + testCalc2);

        //Mit Variablen und Scope
        Scope scope = new Scope();
        double testCalc3 = scope.newVariable("foo", new Literal(5)).newVariable("bar", new Literal(3)).expression(new PlusExpr(new Variable("foo", scope), new Variable("bar", scope))).eval();
        System.out.println("foo=5; bar=3; foo + bar = " + testCalc3);

    }

    static class PlusExpr implements Expr {

        Expr expr1;
        Expr expr2;

        PlusExpr(Expr expr1, Expr expr2) {
            this.expr1 = expr1;
            this.expr2 = expr2;
        }

        @Override
        public double eval() {
            return expr1.eval() + expr2.eval();
        }
    }

    static class MinusExpr implements Expr {
        Expr expr1;
        Expr expr2;

        MinusExpr(Expr expr1, Expr expr2) {
            this.expr1 = expr1;
            this.expr2 = expr2;
        }

        @Override
        public double eval() {
            return expr1.eval() - expr2.eval();
        }
    }

    static class MultExpr implements Expr {
        Expr expr1;
        Expr expr2;

        MultExpr(Expr expr1, Expr expr2) {
            this.expr1 = expr1;
            this.expr2 = expr2;
        }

        @Override
        public double eval() {
            return expr1.eval() * expr2.eval();
        }
    }

    static class DivExpr implements Expr {
        Expr expr1;
        Expr expr2;

        DivExpr(Expr expr1, Expr expr2) {
            this.expr1 = expr1;
            this.expr2 = expr2;
        }

        @Override
        public double eval() {
            return expr1.eval() / expr2.eval();
        }
    }

    static class Literal implements Expr {

        double number;

        Literal(double number) {
            this.number = number;
        }

        @Override
        public double eval() {
            return number;
        }
    }
}
