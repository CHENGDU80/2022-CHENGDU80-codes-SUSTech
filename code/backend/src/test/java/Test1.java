/* Usage: java MainDriver [soot-options] appClass
 */

/* import necessary soot packages */
import soot.Pack;
import soot.PackManager;
import soot.Transform;

public class Test1 {
    public static void main(String[] args) {

        /* check the arguments */
        if (args.length == 0) {
            System.err.println("Usage: java MainDriver [options] classname");
            System.exit(0);
        }

        /* add a phase to transformer pack by call Pack.add */
        Pack jtp = PackManager.v().getPack("jtp");
        jtp.add(new Transform("jtp.instrumenter",
                new Instrumenter()));

        /*
         * Give control to Soot to process all options,
         * InvokeStaticInstrumenter.internalTransform will get called.
         */

		for(String arg:args){
			System.out.println(arg);
		}
        soot.Main.main(args);
    }
}