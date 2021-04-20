package edu.csc413.interpreter;

import edu.csc413.interpreter.statement.Statement;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProgramState represents the Program's storage information at any point in time while the program is running. It
 * should keep track of all defined variables, as well as their assigned values, and allow the running program to read
 * or set those values.
 */
public class ProgramState {
    private final Stack<HashMap<String, Integer>> callStack;
    private final List<String> funct = new ArrayList<>();
    private final Map<String, List<String>> parameterNames = new HashMap<>();
    private final Map<String, List<Statement>> functionStatements = new HashMap<>();

    private final boolean returnCheck = false;
    private final int returnValueCheck = -1;


    public ProgramState() {
        callStack = new Stack<>();
        addCallFrame();

        // TODO: Implement. Initialize any instance variables you added.
    }

    /** Returns the integer value associated with the specified variable name in the current call frame. */
    public int getVariable(String variable) {
        HashMap<String, Integer> topCallFrame = callStack.peek();
        if (!topCallFrame.containsKey(variable)) {
            throw new RuntimeException("Undefined variable: " + variable);
        }
        return topCallFrame.get(variable);
    }

    /** Sets the value for the specified variable name to the specified value in the current call frame. */
    public void setVariable(String variable, int value) {
        callStack.peek().put(variable, value);
    }

    /** Adds a new, empty call frame to the top of the call stack, making it the new current call frame. */
    public void addCallFrame() {
        callStack.push(new HashMap<>());
    }

    /**
     * Removes the topmost call frame from the call stack. The current call frame becomes the previous one in the stack.
     */
    public void removeCallFrame() {
        if (callStack.size() <= 1) {
            throw new RuntimeException("Current call frame is the main program call frame, and cannot be removed.");
        }
        callStack.pop();
    }

    /**
     * Registers a function's parameter names and function statements so that they can be looked up later on using just
     * the function name.
     */
    private final Map<String, List<String>> functionParameters = new HashMap<>();
    private Integer returnVal;
    public void registerFunction(String functionName, List<String> parameterNames) {
        parameterNames = new ArrayList<>(parameterNames);
        functionParameters.put(functionName, parameterNames);
    }

    /** Returns the list of parameter names associated with the specified function name. */
    public List<String> getParameterNames(String funct) {
       while(!functionParameters.isEmpty() && functionParameters.containsKey(funct)){
           return functionParameters.get(funct);
       }
        return null;
    }

    /** Returns the list of function statements associated with the specified function name. */
    public List<Statement> getFunctionStatements(String functionName) {
        return functionStatements.get(functionName);

    }

    /** Returns whether or not a return value has been recorded. */
    public boolean hasReturnValue() {

        return returnCheck;
    }

    /** Returns the recorded return value, if it exists. */
    public int getReturnValue() {
       if(returnCheck) return returnValueCheck;
        return -1;
    }

    /** Records a return value. hasReturnValue should return true after this method is called. */
    public void setReturnValue(int returnValue) {
      returnVal = Integer.valueOf(returnValue);
    }

    /** Clears the recorded return value. hasReturnValue should return false after this method is called. */
    public void clearReturnValue() {
        returnVal = null;
    }
}
