package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;

import java.util.List;

public class DefineFunctionStatement implements Statement {
    private String parseExpression;
    private List<String> ParameterNames;
    private List<Statement> functionStatements;
    public DefineFunctionStatement(String parseExpression, List<String> parameterNames, List<Statement> functionStatements) {
        this.ParameterNames = parameterNames;
        this.parseExpression = parseExpression;
        this.functionStatements = functionStatements;
    }

    @Override
    public void run(ProgramState programState) {
    programState.registerFunction(parseExpression, ParameterNames);

    }
}
