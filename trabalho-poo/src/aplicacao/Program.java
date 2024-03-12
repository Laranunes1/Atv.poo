package aplicacao;

import java.util.Scanner;

import entidades.Banco;
import entidades.Conta;
import entidades.ContaNaoEncontrada;
import entidades.FundosInsuficientes;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco();

        
        banco.addConta(new Conta(1, "Alice"));
        banco.addConta(new Conta(2, "Bob"));
        banco.addConta(new Conta(3, "Charlie"));

        
        try {
            banco.depositarNaConta(1, 1000);
            banco.retirarDaConta(1, 300);
        } catch (ContaNaoEncontrada | FundosInsuficientes e) {
            System.out.println(e.getMessage());
        }

        
        System.out.println("Dados das contas após operações:");
        banco.getConta().forEach(System.out::println);

        
        try {
            System.out.println("Digite o número da conta para depósito:");
            int accountNumber = sc.nextInt();

            System.out.println("Digite o valor do depósito:");
            double depositValue = sc.nextDouble();
            banco.depositarNaConta(accountNumber, depositValue);

            System.out.println("Digite o número da conta para saque:");
            accountNumber = sc.nextInt();
            System.out.println("Digite o valor do saque:");
            double withdrawValue = sc.nextDouble();
            banco.retirarDaConta(accountNumber, withdrawValue);
        } catch (ContaNaoEncontrada | FundosInsuficientes e) {
            System.out.println(e.getMessage());
        }

        
        System.out.println("Dados das contas após as operações:");
        banco.getConta().forEach(System.out::println);

        sc.close();
    }
}
