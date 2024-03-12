package entidades;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> accounts = new ArrayList<>();


    public void addConta(Conta account) {
        accounts.add(account);
    }
    
    public Conta encontraContaPorNumero(int number) throws ContaNaoEncontrada {
        return accounts.stream()
                .filter(a -> a.getNumero() == number)
                .findFirst()
                .orElseThrow(() -> new ContaNaoEncontrada("Conta não encontrada."));
    }
    
    public void removerConta(Conta account) {
        accounts.remove(account);
    }
    
    public void depositarNaConta(int number, double amount) throws ContaNaoEncontrada {
        Conta account = encontraContaPorNumero(number);
        account.deposito(amount);
    }
    
    public void retirarDaConta(int number, double amount) throws ContaNaoEncontrada, FundosInsuficientes {
        Conta account = encontraContaPorNumero(number);
        account.withdraw(amount);
    }
    
    public List<Conta> getConta() {
        return accounts;
    }
}
