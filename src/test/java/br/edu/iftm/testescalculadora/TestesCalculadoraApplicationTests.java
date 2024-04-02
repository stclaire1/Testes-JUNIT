package br.edu.iftm.testescalculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestesCalculadoraApplicationTests {
	private static Calculadora calculadora;

	@BeforeAll
	static void iniciaTeste(){
        System.out.println("Começou caso de teste");
    }

	@BeforeEach
    void setValor() {
        calculadora = new Calculadora(3);
    }

	//Teste para o construtor sem parâmetro de entrada
	@Test
	void testConstrutorSemParametro() throws Exception{
		calculadora = new Calculadora();
        assertEquals(0, calculadora.getMemoria());
    }

	//Teste para o construtor com parâmetro de entrada, valor 3
	@Test
    void testConstrutorComParametro() throws Exception{
        assertEquals(3, calculadora.getMemoria());
    }

	//Teste para o método somar: somar um número negativo
	@Test
    void testSomarNumeroNegativo() throws Exception{
        calculadora.somar(-2);
        assertEquals(1, calculadora.getMemoria());
    }

	//Teste para o método subtrair: subtrair um número positivo
	@Test
    void testSubtrairNumeroPositivo() throws Exception{
        calculadora.subtrair(2);
        assertEquals(1, calculadora.getMemoria());
    }

	//Teste para o método multiplicar: multiplicar um número positivo
	@Test
    void testMultiplicarNumeroPositivo() throws Exception{
        calculadora.multiplicar(3);
        assertEquals(9, calculadora.getMemoria());
    }

	//Teste para o método dividir: dividir por 0, deverá lançar uma exceção
	@Test
    void testDividirZero() {
        assertThrows(Exception.class, () -> calculadora.dividir(0));
    }

	//Teste para o método dividir: dividir um número positivo
	@Test
    void testDividirNumeroPositivo() throws Exception {
        calculadora.dividir(3);
        assertEquals(1, calculadora.getMemoria());
    }

	//Teste para o método exponenciar: elevar o valor da memória a 1
	@Test
    void testExponenciarPorUm() throws Exception {
        calculadora.exponenciar(1);
        assertEquals(3, calculadora.getMemoria());
    }

	//Teste para o método exponenciar: elevar o valor da memória a 10
	@Test
    void testExponenciarPorDez() throws Exception {
        calculadora.exponenciar(10);
        assertEquals(59049, calculadora.getMemoria());
    }

	//Teste para o método exponenciar, se a entrada for maior que 10, deverá lançar uma exceção
	@Test
    void testExponencialMaiorQueDez() {
        assertThrows(Exception.class, () -> calculadora.exponenciar(12));
    }

	//Teste para o método zerarMemoria (valor da memória deve ser 0)
	@Test
    void testZerarMemoria() throws Exception{
        calculadora.zerarMemoria();
        assertEquals(0, calculadora.getMemoria());
    }

	@AfterEach
    void TerminaTeste(){
        System.out.println("Caso de teste finalizado.");        
    }
}
