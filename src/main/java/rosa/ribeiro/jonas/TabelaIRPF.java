package rosa.ribeiro.jonas;

import java.math.BigDecimal;
import java.util.List;

public final class TabelaIRPF {
    private TabelaIRPF() {}

    public static List<FaixaImposto> getTabelaVigente() {
        return List.of(
                // Faixa 1: Isento
                new FaixaImposto(new BigDecimal("2259.20"), new BigDecimal("0.0"),    new BigDecimal("0.0")),

                // Faixa 2: 7,5%
                new FaixaImposto(new BigDecimal("2826.65"), new BigDecimal("0.075"),  new BigDecimal("169.44")),

                // Faixa 3: 15%
                new FaixaImposto(new BigDecimal("3751.05"), new BigDecimal("0.15"),   new BigDecimal("381.44")),

                // Faixa 4: 22,5%
                new FaixaImposto(new BigDecimal("4664.68"), new BigDecimal("0.225"),  new BigDecimal("662.77")),

                // Faixa 5: 27,5%
                new FaixaImposto(BigDecimal.valueOf(Double.MAX_VALUE), new BigDecimal("0.275"),  new BigDecimal("896.00"))
        );
    }

}
