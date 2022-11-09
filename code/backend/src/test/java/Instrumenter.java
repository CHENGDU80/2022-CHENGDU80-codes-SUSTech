/*
 * InvokeStaticInstrumenter inserts count instructions before
 * INVOKESTATIC bytecode in a program. The instrumented program will
 * report how many static invocations happen in a run.
 *
 * Goal:
 *   Insert counter instruction before static invocation instruction.
 *   Report counters before program's normal exit point.
 *
 * Approach:
 *   1. Create a counter class which has a counter field, and
 *      a reporting method.
 *   2. Take each method body, go through each instruction, and
 *      insert count instructions before INVOKESTATIC.
 *   3. Make a call of reporting method of the counter class.
 *
 * Things to learn from this example:
 *   1. How to use Soot to examine a Java class.
 *   2. How to insert profiling instructions in a class.
 */

/* InvokeStaticInstrumenter extends the abstract class BodyTransformer,
 * and implements <pre>internalTransform</pre> method.
 */

import soot.*;
import soot.jimple.*;
import soot.util.Chain;

import java.util.Iterator;
import java.util.Map;

public class Instrumenter extends BodyTransformer {
    static SootClass util,admin;
    static SootMethod report_method, report_infor;
    static int method_cnt = 0; //the "internalTransform" does not deal with the constructor?

    static {
        Scene.v().setSootClassPath("./");
        util = Scene.v().loadClassAndSupport("Util");
        report_method = util.getMethod("void report_method(java.lang.String)");
        report_infor = util.getMethod("void report_infor(int)");


    }

    protected void internalTransform(Body body, String phase, Map options) {
        // body's method
        SootMethod method = body.getMethod();
        method_cnt++;

        // debugging
        System.out.println("instrumenting method : " + method.getSignature()+" cnt:"+method_cnt);


        // get body's unit as a chain
        Chain units = body.getUnits();
        Iterator stmtIt = units.snapshotIterator();
        InvokeExpr expr;
        Stmt insert_stmt;
        while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt) stmtIt.next();
            if ((stmt instanceof ReturnStmt)
                    || (stmt instanceof ReturnVoidStmt)) {
                expr = Jimple.v().newStaticInvokeExpr(
                        report_method.makeRef(),StringConstant.v(method.getSignature()));
                insert_stmt = Jimple.v().newInvokeStmt(expr);
                units.insertBefore(insert_stmt, stmt);

            }
        }

        String signature = method.getSubSignature();
        boolean isMain = signature.equals("void main(java.lang.String[])");
        if (isMain) {
            stmtIt = units.snapshotIterator();
            while (stmtIt.hasNext()) {
                Stmt stmt = (Stmt) stmtIt.next();
                if ((stmt instanceof ReturnStmt)
                        || (stmt instanceof ReturnVoidStmt)) {
//                    System.out.println("before:"+method_cnt);
                    expr = Jimple.v().newStaticInvokeExpr(
                            report_infor.makeRef(),IntConstant.v(method_cnt));
                    insert_stmt = Jimple.v().newInvokeStmt(expr);
                    units.insertBefore(insert_stmt, stmt);
                }
            }
        }
    }


}
