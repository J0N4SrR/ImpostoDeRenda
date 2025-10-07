package rosa.ribeiro.jonas;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertThrows;


class CalculadorIRPFTest {
    private CalculadorIRPF calculadora;


    @BeforeEach
    void setUp() {
        List<FaixaImposto> tabela = TabelaIRPF.getTabelaVigente();
        calculadora = new CalculadorIRPF(tabela);
    }

    @Test
    @DisplayName("Deve dar erro quando o salário for negativo")
    void testeSalarioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadora.calcular(new BigDecimal("-100.00"));
        });
    }

    @ParameterizedTest
    @DisplayName("Teste de Valores Limite com BigDecimal")
    @CsvSource({
            "2259.20,   0.00",
            "2259.21,   0.00",
            "2826.65,   42.56",
            "2826.66,   42.56",
            "3751.05,   181.22",
            "3751.06,   181.22",
            "4664.68,   386.78",
            "4664.69,   386.79"
    })
    void testaCalculoParaValoresLimite(String salarioStr, String impostoEsperadoStr) {

        BigDecimal salario = new BigDecimal(salarioStr);
        BigDecimal impostoEsperado = new BigDecimal(impostoEsperadoStr);

        BigDecimal impostoCalculado = calculadora.calcular(salario);

        Assertions.assertEquals(impostoEsperado, impostoCalculado);
    }

}