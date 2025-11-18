package br.com.trabalho;

// Imports do JUnit 5 (que o Maven baixou)
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContaTest {

    // Teste 1: Deve depositar valor positivo
    @Test
    void testDepositarValorPositivo() {
        // Arrange (Organizar)
        Conta conta = new Conta(100.0);
        // Act (Agir)
        conta.depositar(50.0);
        // Assert (Afirmar)
        assertEquals(150.0, conta.getSaldo());
    }

    // Teste 2: Deve sacar valor válido (dentro do saldo)
    @Test
    void testSacarValorValido() {
        // Arrange
        Conta conta = new Conta(100.0);
        // Act
        boolean sucesso = conta.sacar(50.0);
        // Assert
        assertTrue(sucesso); 
        assertEquals(50.0, conta.getSaldo());
    }

    // Teste 3: Não deve sacar valor maior que o saldo
    @Test
    void testSacarValorMaiorQueSaldo() {
        // Arrange
        Conta conta = new Conta(100.0);
        // Act
        boolean sucesso = conta.sacar(150.0);
        // Assert
        assertFalse(sucesso); 
        assertEquals(100.0, conta.getSaldo()); // Saldo NÃO deve mudar
    }

    // Teste 4: Não deve sacar valor negativo
    @Test
    void testSacarValorNegativo() {
        // Arrange
        Conta conta = new Conta(100.0);
        // Act
        boolean sucesso = conta.sacar(-50.0);
        // Assert
        assertFalse(sucesso);
        assertEquals(100.0, conta.getSaldo()); 
    }

    // Teste 5: Não deve depositar valor negativo
    @Test
    void testDepositarValorNegativo() {
        // Arrange
        Conta conta = new Conta(100.0);
        // Act
        conta.depositar(-50.0);
        // Assert
        assertEquals(100.0, conta.getSaldo());
    }

    // Teste 6: Deve sacar valor exato do saldo (Teste de Fronteira)
    @Test
    void testSacarValorExatoSaldo() {
        // Arrange
        Conta conta = new Conta(100.0);
        // Act
        boolean sucesso = conta.sacar(100.0);
        // Assert
        assertTrue(sucesso);
        assertEquals(0.0, conta.getSaldo());
    }

    // Teste 7: Construtor deve iniciar saldo corretamente
    @Test
    void testConstrutorComSaldoPositivo() {
        // Arrange & Act
        Conta conta = new Conta(500.0);
        // Assert
        assertEquals(500.0, conta.getSaldo());
    }

    // Teste 8: Construtor não deve iniciar com saldo negativo
    @Test
    void testConstrutorComSaldoNegativo() {
        // Arrange & Act
        Conta conta = new Conta(-200.0);
        // Assert
        assertEquals(0.0, conta.getSaldo());
    }
}