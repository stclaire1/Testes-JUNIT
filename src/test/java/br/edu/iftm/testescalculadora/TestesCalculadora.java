package br.edu.iftm.testescalculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestesCalculadora {
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
		int resultadoEsperado = 0;
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

	//Teste para o construtor com parâmetro de entrada, valor 3
	@Test
    void testConstrutorComParametro() throws Exception{
        int resultadoEsperado = 3;
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

	//Teste para o método somar: somar um número negativo
	@Test
    void testSomarNumeroNegativo() throws Exception{
        int valorASerSomado = -2;
        int resultadoEsperado = 1;
        calculadora.somar(valorASerSomado);
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

	//Teste para o método subtrair: subtrair um número positivo
	@Test
    void testSubtrairNumeroPositivo() throws Exception{
        int valorASerSubtraido = 2;
        int resultadoEsperado = 1;
        calculadora.subtrair(valorASerSubtraido);
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

	//Teste para o método multiplicar: multiplicar um número positivo
	@Test
    void testMultiplicarNumeroPositivo() throws Exception{
        int valorASerMultiplicado = 3;
        int resultadoEsperado = 9;
        calculadora.multiplicar(valorASerMultiplicado);
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

	//Teste para o método dividir: dividir por 0, deverá lançar uma exceção
	@Test
    void testDividirZero() {
        int valorDivisor = 0;
        assertThrows(Exception.class, () -> calculadora.dividir(valorDivisor));
    }

	//Teste para o método dividir: dividir um número positivo
	@Test
    void testDividirNumeroPositivo() throws Exception {
        int valorASerDividido = 3;
        int resultadoEsperado = 1;
        calculadora.dividir(valorASerDividido);
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
	//Teste para o método exponenciar: elevar o valor da memória a 1
	@Test
    void testExponenciarPorUm() throws Exception {
        int valorExpoente = 1;
        int resultadoEsperado = 3;
        calculadora.exponenciar(valorExpoente);
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

	//Teste para o método exponenciar: elevar o valor da memória a 10
	@Test
    void testExponenciarPorDez() throws Exception {
        int valorExpoente = 10;
        int resultadoEsperado = 59049;
        calculadora.exponenciar(valorExpoente);
        int resultadoObtido = calculadora.getMemoria();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

	//Teste para o método exponenciar, se a entrada for maior que 10, deverá lançar uma exceção
	@Test
    void testExponenciarMaiorQueDez() {
        int valorExpoente = 12;
        assertThrows(Exception.class, () -> calculadora.exponenciar(valorExpoente));
    }

	//Teste para o método zerarMemoria (valor da memória deve ser 0)
	@Test
    void testZerarMemoria() throws Exception{
        int valorEsperado = 0;
        calculadora.zerarMemoria();
        int valorObtido = calculadora.getMemoria();
        assertEquals(valorEsperado, valorObtido);
    }

	@AfterEach
    void TerminaTeste(){
        System.out.println("Caso de teste finalizado.");        
    }
}
