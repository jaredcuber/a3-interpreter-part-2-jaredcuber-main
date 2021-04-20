package edu.csc413.interpreter.statement;
import edu.csc413.interpreter.expression.Condition;
import edu.csc413.interpreter.ProgramState;
import java.util.List;
public abstract class BlockStatement implements Statement {
    private List<Statement> statements;
    private Condition condition;

    public BlockStatement(Condition condition, List<Statement> list){
        this.statements = list;
        this.condition = condition;
    }

    public BlockStatement(String loopVariableName, String rangeStartAsString, String rangeEndAsString, List<Statement> bodyStatements) {

    }

    protected Condition getCondition(){
        return condition;
    }
    protected void Block(ProgramState programState){
        for (Statement statement: statements){
            statement.run(programState);
            if(programState.hasReturnValue()){
                return;
            }
        }
    }
}
