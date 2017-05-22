
package testtdd;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class ContaTest {

    @Test
    public void testCriarConta() {
        System.out.println("criarConta");
        String nome = "deyvison";
        int idade = 22;
        int numConta = 1234;
        Conta instance = new Conta();
        instance.criarConta(nome, idade, numConta);
        assertEquals(1234,instance.getNumConta(),0.0001);
    }

    /**
     * Test of deposito method, of class Conta.
     */
    @Test
    public void testDeposito() {
        System.out.println("deposito");
        double deposito = 500;
        Conta instance = new Conta();
        instance.deposito(deposito);
        assertEquals(500,instance.getSaldo(),0.001);
    }

    /**
     * Test of saque method, of class Conta.
     */
    @Test
    public void testSaque() {
        System.out.println("saque");
        double saque = 400;
        Conta instance = new Conta();
        instance.deposito(1000);
        instance.saque( saque);
        assertEquals(600,instance.consultarSaldo(),0.001);
    }

    /**
     * Test of encerrarConta method, of class Conta.
     */
    @Test
    public void testEncerrarConta() {
        System.out.println("encerrarConta");
        Conta instance = new Conta();
        instance.encerrarConta();
        assertEquals(Double.NaN,instance.consultarSaldo(),0.0001);
    }

    /**
     * Test of consultarSaldo method, of class Conta.
     */
    @Test
    public void testConsultarSaldo() {
        System.out.println("consultarSaldo");
        Conta instance = new Conta();
        instance.deposito(500);
        double expResult = 500;
        double result = instance.consultarSaldo();
        assertEquals(expResult, result, 0.0001);
       
    }

    /**
     * Test of transferencia method, of class Conta.
     */
    @Test
    public void testTransferencia() {
        System.out.println("transferencia");
        Conta conta = new Conta();
        double valor = 500;
        Conta instance = new Conta();
        instance.deposito(1200);
        instance.transferencia(conta, valor);
        assertEquals(700,instance.consultarSaldo(),0.001);
        assertEquals(500,conta.consultarSaldo(),0.001);
    }

}
