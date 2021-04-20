package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Expression;

public class ReturnStatement implements Statement {
    private final String output;
    public ReturnStatement(String output) {
        this.output = output;
    }


    @Override
    public void run(ProgramState programState) {

    }
}
