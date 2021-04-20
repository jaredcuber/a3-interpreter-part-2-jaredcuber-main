package edu.csc413.interpreter.statement;

import edu.csc413.interpreter.ProgramState;
import edu.csc413.interpreter.expression.Condition;

import javax.management.StandardEmitterMBean;
import java.util.List;

public class ForStatement extends BlockStatement{
    private  String loopVariableName;
    private String rangeStartAsString;
    private String rangeEndAsString;
    private List<Statement> bodyStatements;
    private final String start;
    private final String update;

    public ForStatement(String loopVariableName, String rangeStartAsString, String rangeEndAsString, List<Statement> bodyStatements) {
        super(loopVariableName, rangeStartAsString, rangeEndAsString, bodyStatements);
        this.loopVariableName =  loopVariableName;
        this.rangeStartAsString = rangeStartAsString;
        this.rangeEndAsString = rangeEndAsString;
        this.bodyStatements = bodyStatements;
        this.start =loopVariableName;
        this.update = rangeEndAsString;

    }

    @Override
    public void run(ProgramState programState) {

    }
}
