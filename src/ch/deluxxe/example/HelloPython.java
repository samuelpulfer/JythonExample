package ch.deluxxe.example;


import org.python.core.PyException;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class HelloPython {

    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) throws PyException {

        // Create an instance of the PythonInterpreter
        PythonInterpreter interp = new PythonInterpreter();
        String currentlocation = HelloPython.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        String PythonLib = currentlocation + "JythonScripts";
        System.out.println(PythonLib);

        // The exec() method executes strings of code
        interp.exec("import sys, os");
        interp.exec("sys.path.append('"+ PythonLib + "')");
        interp.exec("print str(sys.path)");
        interp.exec("import otherexample");
        interp.exec("otherexample.testexample()");

        // Set variable values within the PythonInterpreter instance
        interp.set("a", new PyInteger(42));
        interp.set("b", new PyInteger(7));
        interp.exec("x = otherexample.add(a,b)");

        // Obtain the value of an object from the PythonInterpreter and store it
        // into a PyObject.
        PyObject x = interp.get("x");
        System.out.println("x: " + x);
        interp.close();
    }

}