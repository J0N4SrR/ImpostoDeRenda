package rosa.ribeiro.jonas;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<FaixaImposto> tabelaVigente = TabelaIRPF.getTabelaVigente();
        CalculadorIRPF calculadora = new CalculadorIRPF(tabelaVigente);

        System.out.println("--- Calculadora de Imposto de Renda (IRPF) ---");

        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {

            System.out.print("\nDigite o valor do salário (ex: 3751.05) e pressione Enter: ");

            String entradaDoUsuario = scanner.nextLine();

            try {
                BigDecimal salario = new BigDecimal(entradaDoUsuario);

                BigDecimal impostoDevido = calculadora.calcular(salario);

                System.out.printf(">>> Para um salário de R$ %.2f, o imposto devido é: R$ %.2f%n", salario, impostoDevido);

            } catch (NumberFormatException e) {
                System.out.println("\n[ERRO] Entrada inválida. Por favor, digite apenas números e use '.' como separador decimal.");
            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERRO] " + e.getMessage());
            }

        }

        System.out.println("\n--- Programa finalizado ---");
    

    }
}