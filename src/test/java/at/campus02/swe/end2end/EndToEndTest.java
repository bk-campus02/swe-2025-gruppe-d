package at.campus02.swe.end2end;

import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;
import at.campus02.swe.logic.CalculatorImpl;
import at.campus02.swe.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class EndToEndTest {

    @Test
    public void endToEndSubtraction() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);
        File file = new File("src/test/resources/endtoend_sub.xml");
        double result = parser.parse(file);

        assertEquals(4,result,0);
    }

    @Test
    public void endToEndModulo() throws CalculatorException, XMLStreamException, FileNotFoundException {
        Calculator calculator = new CalculatorImpl();
        Parser parser = new Parser(calculator);
        File file = new File("src/test/resources/endtoend_mod.xml");
        double result = parser.parse(file);

        assertEquals(3,result,0);
    }
// Sinus Test

    @Test
    public void endToEndSinus() throws Exception {

        CalculatorImpl calc = new CalculatorImpl();
        Parser par = new Parser(calc);

        double result = par.parse(new File("src/test/resources/endtoend_sin.xml"));
        Assert.assertEquals(0.84147, result,0.001);
    }
// Cosinus Test
    @Test
    public void endToEndCosinus() throws Exception {

        CalculatorImpl calc = new CalculatorImpl();
        Parser par = new Parser(calc);

        double result = par.parse(new File("src/test/resources/endtoend_cos.xml"));
        Assert.assertEquals(0.5403, result,0.001);
    }

}
