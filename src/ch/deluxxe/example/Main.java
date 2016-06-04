package ch.deluxxe.example;


import org.python.core.Py;
import org.python.core.PyException;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

public class Main {

    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) throws PyException {

        // Create an instance of the PythonInterpreter
        PythonInterpreter interp = new PythonInterpreter(null, new PySystemState());
        PySystemState pySysStat = Py.getSystemState();
        String currentlocation = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String PythonLib = currentlocation + "JythonScripts";
        System.out.println(PythonLib);
        //pySysStat.path.append(new PyString(PythonLib));

        // The exec() method executes strings of code
        interp.exec("import sys, os");
        interp.exec("print str(sys.path)");
        interp.exec("import testexample");
        interp.exec("testexample.testexample()");

        // Set variable values within the PythonInterpreter instance
        interp.set("a", new PyInteger(42));
        interp.exec("print a");
        interp.exec("x = 2+2");

        // Obtain the value of an object from the PythonInterpreter and store it
        // into a PyObject.
        PyObject x = interp.get("x");
        System.out.println("x: " + x);
        interp.close();
    }

}