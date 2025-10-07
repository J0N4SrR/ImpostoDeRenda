package rosa.ribeiro.jonas;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class CalculadorIRPF {
    private final List<FaixaImposto> faixas;

    public CalculadorIRPF(List<FaixaImposto> faixas) {
        Objects.requireNonNull(faixas, "A lista de faixas não pode ser nula.");
        if (faixas.isEmpty()) {
            throw new IllegalArgumentException("A lista de faixas não pode estar vazia.");
        }
        this.faixas = faixas;
    }

    public BigDecimal calcular(BigDecimal baseDeCalculo) {
        if (baseDeCalculo == null || baseDeCalculo.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A base de cálculo não pode ser nula ou negativa.");
        }

        for (FaixaImposto faixa : faixas) {
            if (baseDeCalculo.compareTo(faixa.limiteSuperior()) <= 0) {

                BigDecimal impostoBruto = baseDeCalculo.multiply(faixa.aliquota());
                BigDecimal impostoLiquido = impostoBruto.subtract(faixa.parcelaADeduzir());

                return impostoLiquido.max(BigDecimal.ZERO)
                        .setScale(2, RoundingMode.HALF_UP);
            }
        }

        throw new IllegalStateException("Nenhuma faixa de imposto aplicável foi encontrada.");
    }

}
