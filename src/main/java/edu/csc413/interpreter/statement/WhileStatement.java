package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Condition;

import java.util.List;

public class WhileStatement implements Statement {
    private Condition condition;
    private List<Statement> body;

    public WhileStatement(Condition condition, List<Statement> body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void run(ProgramState programState) {
        if (condition.evaluate((programState))){
            for(Statement statement: body){
                statement.run(programState);
            }
        }
    }
}
