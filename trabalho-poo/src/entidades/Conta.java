
package entidades;

public class Conta {
    private int number;
    private double balanco;
    private String clienteNome;

    public Conta(int number, String clientName) {
        this.number = number;
        this.clienteNome = clientName;
        this.balanco = 0.0;
    }

    public int getNumero() {
        return number;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clientName) {
        this.clienteNome = clientName;
    }

    public double getBalanco() {
        return balanco;
    }

    public void deposito(double amount) {
        if (amount > 0) {
            balanco += amount;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Erro: O valor do depósito deve ser positivo.");
        }
    }

    public void withdraw(double amount) throws FundosInsuficientes {
        if (amount <= 0) {
            System.out.println("Erro: O valor do saque deve ser positivo.");
        } else if (amount + 5.0 > balanco) { 
            throw new FundosInsuficientes("Saldo insuficiente para realizar o saque.");
        } else {
            balanco -= amount + 5.0; 
            System.out.println("Saque realizado com sucesso!");
        }
    }

    @Override
    public String toString() {
        return "Account{ " +
                "number= " + number +
                ", balance= " + balanco +
                ", clientName= '" + clienteNome + '\'' +
                '}';
    }
}

