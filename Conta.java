public class Conta {

    private double saldo;

    // Construtor da conta
    public Conta(double saldoInicial) {
        // Regra de negocio - Uma conta não pode começar negativa
        if (saldoInicial > 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0;
        }
    }

    // Metodo para pegar o saldo
    public double getSaldo() {
        return this.saldo;
    }

    
    // Tenta realizar um deposito.
    // Regra de negocio - Só deposita valores positivos.
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
        // Se o valor for negativo ou zero, o saldo não muda.
    }

     // Tenta realizar um saque.
     // Retorna 'true' se o saque foi bem-sucedido e 'false' se não foi.
    public boolean sacar(double valor) {
        // Regra de negocio 1: O valor do saque deve ser positivo.
        // Regra de negocio 2: O valor do saque não pode ser maior que o saldo.
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true; // Saque realizado com sucesso
        }
        
        return false; // Saque não permitido
    }
}