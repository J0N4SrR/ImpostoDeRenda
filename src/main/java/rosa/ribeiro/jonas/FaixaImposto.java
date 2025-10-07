package rosa.ribeiro.jonas;

import java.math.BigDecimal;

public record FaixaImposto(BigDecimal limiteSuperior,
                           BigDecimal aliquota,
                           BigDecimal parcelaADeduzir) {
}
