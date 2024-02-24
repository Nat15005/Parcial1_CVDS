package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;
import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;
public class TarifasTest {
    @Test
    public void testSinDescuento() {
        double tarifaBase = 100000;
        int diasAntelacion = 15;
        int edad = 30;

        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);

        Assert.assertEquals(tarifaBase, tarifaFinal, 0.01); // No hay descuento
    }
    @Test
    public void testDescuento15Porciento() {
        double tarifaBase = 100000;
        int diasAntelacion = 25;
        int edad = 30;

        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaEsperada = tarifaBase * 0.85; // Descuento del 15%

        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
    }

    @Test
    public void testDescuento20Porciento() {
        double tarifaBase = 100000;
        int diasAntelacion = 25;
        int edad = 15;

        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaEsperada = tarifaBase * 0.80; // Descuento del 20%

        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
    }

    @Test
    public void testDescuento23Porciento() {
        double tarifaBase = 100000;
        int diasAntelacion = 25;
        int edad = 67;

        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaEsperada = tarifaBase * 0.77; // Descuento del 23%

        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
    }
    @Test
    public void testDescuento5Porciento() {
        double tarifaBase = 100000;
        int diasAntelacion = 10;
        int edad = 16;

        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaEsperada = tarifaBase * 0.95; // Descuento del 5%

        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
    }
    @Test
    public void testDescuento8Porciento() {
        double tarifaBase = 100000;
        int diasAntelacion = 15;
        int edad = 70;

        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaEsperada = tarifaBase * 0.92; // Descuento del 8%

        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
    }
    @Test
    public void testDescuento8PorcientoConEdadLimite() {
        double tarifaBase = 100000;
        int diasAntelacion = 10;
        int edad = 66;

        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaEsperada = tarifaBase * 0.92; // Descuento del 8%

        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
    }
    @Test
    public void testDescuento5PorcientoConEdadLimite() {
        double tarifaBase = 100000;
        int diasAntelacion = 10;
        int edad = 17;
        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaEsperada = tarifaBase * 0.95; // Descuento del 5%
        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
    }
    @Test
    public void testDescuentoConEdadLimite() {
        double tarifaBase = 100000;
        int diasAntelacion = 10;
        int edad = 0;
        int edad1 = 18;
        int edad2 = 65;
        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaFinal2 = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad1);
        double tarifaFinal3 = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad2);

        double tarifaEsperada = tarifaBase * 0.95; // Descuento del 5%
        double tarifaEsperada2 = tarifaBase;
        double tarifaEsperada3 = tarifaBase;

        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
        Assert.assertEquals(tarifaEsperada2, tarifaFinal2, 0.01);
        Assert.assertEquals(tarifaEsperada3, tarifaFinal3, 0.01);
    }
    @Test
    public void testDescuento15PorcientoConDiasAntelacionFrontera() {
        double tarifaBase = 100000;
        int diasAntelacion = 21;
        int edad = 22;
        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaEsperada = tarifaBase * 0.85; // Descuento del 15%

        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
    }
    @Test
    public void testDescuentoPorcientoConDiasAntelacionFrontera() {
        double tarifaBase = 100000;
        int diasAntelacion = 20;
        int edad = 22;
        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaEsperada = tarifaBase;

        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
    }

    @Test
    public void testDescuentoPorcientoConTarifaBaseFrontera() {
        double tarifaBase = 0;
        int diasAntelacion = 20;
        int edad = 22;
        double tarifaFinal = CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        double tarifaEsperada = tarifaBase;

        Assert.assertEquals(tarifaEsperada, tarifaFinal, 0.01);
    }

/*    @Test
    public void testTarifaBaseNegativa() {
        double tarifaBase = -100000;
        int diasAntelacion = 15;
        int edad = 30;

        try {
            CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        } catch (ExcepcionParametrosInvalidos e) {
            Assert.assertEquals(e.getMessage(), ExcepcionParametrosInvalidos.TARIFA_BASE);
        }
    }

    @Test
    public void testDiasNegativos() {
        double tarifaBase = 100000;
        int diasAntelacion = -15;
        int edad = 30;
        try {
            CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        } catch (ExcepcionParametrosInvalidos e) {
            Assert.assertEquals(e.getMessage(), ExcepcionParametrosInvalidos.DIAS_NEGATIVOS);
        }
    }

    @Test
    public void testDiasNegativos() {
        double tarifaBase = 100000;
        int diasAntelacion = 15;
        int edad = -30;
        try {
            CalculadorDescuentos.calculoTarifa(tarifaBase, diasAntelacion, edad);
        } catch (ExcepcionParametrosInvalidos e) {
            Assert.assertEquals(e.getMessage(), ExcepcionParametrosInvalidos.EDAD_INVALIDA);
        }
    }*/
}
