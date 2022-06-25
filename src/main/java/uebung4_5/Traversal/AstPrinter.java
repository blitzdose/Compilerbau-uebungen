package uebung4_5.Traversal;

import uebung3.Parser.Expr.*;
import uebung3.Parser.Stmts.*;

public class AstPrinter implements ExprVisitor<String>, StmtVisitor<String> {
    public String print(Expr expr) {
        return expr.accept(this);
    }

    public String print(Stmt stmt) {
        return stmt.accept(this);
    }

    @Override
    public String visitAssignExpr(Assign expr) {
        return expr.print();
    }

    @Override
    public String visitBinaryExpr(Binary expr) {
        return mergeStrings("(Binary) ", expr.print());
    }

    @Override
    public String visitCallExpr(Call expr) {
        return mergeStrings("(Call) ", expr.print());
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
        return mergeStrings("(Grouping) ", expr.print());
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
        return mergeStrings("(Literal) ", expr.print());
    }

    @Override
    public String visitLogicalExpr(Logical expr) {
        return mergeStrings("(Logical) ", expr.print());
    }

    @Override
    public String visitUnaryExpr(Unary expr) {
        return mergeStrings("(Unary) ", expr.print());
    }

    @Override
    public String visitVariableExpr(Variable expr) {
        return expr.name.lexeme;
    }

    @Override
    public String visitBlockStmt(Block stmt) {
        return mergeStrings("(Block) ", stmt.print());
    }

    @Override
    public String visitExpressionStmt(Expression stmt) {
        return mergeStrings("(Expression) ", stmt.print());
    }

    @Override
    public String visitFunctionStmt(Function stmt) {
        return mergeStrings("(Function) ", stmt.print());
    }

    @Override
    public String visitIfStmt(If stmt) {
        return mergeStrings("(If) ", stmt.print());
    }

    @Override
    public String visitPrintStmt(Print stmt) {
        return mergeStrings("(Print) ", stmt.print());
    }

    @Override
    public String visitReturnStmt(Return stmt) {
        return mergeStrings("(Return) ", stmt.print());
    }

    @Override
    public String visitVarStmt(Var stmt) {
        return mergeStrings("(Var) ", stmt.print());
    }

    @Override
    public String visitWhileStmt(While stmt) {
        return mergeStrings("(While) ", stmt.print());
    }

    public String mergeStrings(String s1, String s2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s1).append(s2);
        return stringBuilder.toString();
    }
}