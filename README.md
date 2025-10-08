# Análise e Teste de Algoritmo de Cálculo de Imposto de Renda

Este projeto apresenta a aplicação de técnicas de teste funcional e estrutural sobre um algoritmo para cálculo do Imposto de Renda (IR), desenvolvido como parte do "Grupo 2 de Exercícios". O trabalho abrange desde a especificação dos casos de teste até a implementação e validação do código com testes de unidade.

## Tecnologias Utilizadas
* **Java 17**: Linguagem de programação para a implementação do algoritmo.
* **Maven**: Ferramenta para gerenciamento de dependências e build do projeto.
* **JUnit 5**: Framework para a implementação dos testes de unidade.

---

## 1. Teste Funcional: Projeto de Casos de Teste

[cite_start]A primeira etapa do projeto consistiu no planejamento dos testes utilizando técnicas de caixa-preta[cite: 2]. [cite_start]Foram aplicados os critérios de **Partição de Classes de Equivalência** [cite: 2, 3] [cite_start]e **Análise de Valor Limite** [cite: 5] [cite_start]para garantir uma cobertura abrangente dos cenários, incluindo tanto entradas válidas quanto inválidas[cite: 4, 6].

### Tabela de Partição de Classes de Equivalência
| ID | Classe de Equivalência | Descrição |
| :--- | :--- | :--- |
| CEV-01 | Salário na 1ª faixa (isento) | Salários de R$ 0,00 até R$ 2.259,20 |
| CEV-02 | Salário na 2ª faixa (7,5%) | Salários de R$ 2.259,21 até R$ 2.826,65 |
| CEV-03 | Salário na 3ª faixa (15%) | Salários de R$ 2.826,66 até R$ 3.751,05 |
| CEV-04 | Salário na 4ª faixa (22,5%) | Salários de R$ 3.751,06 até R$ 4.664,68 |
| CEV-05 | Salário na 5ª faixa (27,5%) | Salários acima de R$ 4.664,68 |
| CEI-01 | Salário com valor negativo | O sistema não deve processar valores negativos. |
| CEI-02 | Entrada com valor nulo | O sistema deve rejeitar entradas nulas. |

### Tabela de Análise de Valor Limite
| ID | Valor de Entrada (R$) | Descrição |
| :--- | :--- | :--- |
| AVL-01 | 0,00 | Limite inferior da faixa 1 |
| AVL-02 | 2.259,20 | Limite superior da faixa 1 |
| AVL-03 | 2.259,21 | Limite inferior da faixa 2 |
| AVL-04 | 2.826,65 | Limite superior da faixa 2 |
| AVL-05 | 2.826,66 | Limite inferior da faixa 3 |
| AVL-06 | 3.751,05 | Limite superior da faixa 3 |
| AVL-07 | 3.751,06 | Limite inferior da faixa 4 |
| AVL-08 | 4.664,68 | Limite superior da faixa 4 |
| AVL-09 | 4.664,69 | Limite inferior da faixa 5 |

---

## 2. Teste Estrutural: Análise de Fluxo de Controle

[cite_start]Após a implementação do algoritmo em Java, foi realizada uma análise de teste estrutural (caixa-branca)[cite: 7]. [cite_start]O código foi abstraído em blocos indivisíveis (nós) para modelar um **Grafo de Fluxo de Controle (GFC)**[cite: 7, 8], que representa visualmente todos os caminhos de execução possíveis.

### Análise do GFC

* [cite_start]**Complexidade Ciclomática:** A análise do grafo revelou uma complexidade ciclomática de **4**[cite: 33, 34], indicando a necessidade de 4 caminhos independentes para uma cobertura lógica fundamental.
* **Caminhos Independentes:** Foi definido um conjunto de 4 caminhos para garantir a cobertura de todas as decisões lógicas:
    1.  [cite_start]**Caminho de erro inicial** (`20 -> 21 -> 37`), para entradas inválidas[cite: 18, 36].
    2.  [cite_start]**Caminho base de sucesso** (`20 -> 24 -> 25 -> 27 -> 37`), para o cálculo na primeira faixa[cite: 19, 36].
    3.  [cite_start]**Caminho de teste do laço** (`... -> 25 -> 24 -> ...`), forçando múltiplas iterações[cite: 19, 37].
    4.  [cite_start]**Caminho de erro de saída do laço** (`... -> 24 -> 35 -> 37`), para o caso de a tabela estar mal configurada[cite: 20, 38].

---

## 3. Implementação dos Testes de Unidade

[cite_start]Com base na análise funcional e estrutural, os testes de unidade foram implementados em Java com **JUnit 5**[cite: 40, 41].

A abordagem principal foi o uso de **Testes Parametrizados (`@ParameterizedTest`)**. [cite_start]Essa escolha se mostrou vantajosa por permitir a cobertura de todos os valores limite e caminhos de sucesso de forma concisa e organizada[cite: 45, 46]. [cite_start]A principal desvantagem reconhecida é uma menor clareza no relatório de falhas, que pode exigir uma análise mais detalhada para identificar o cenário exato do problema[cite: 47].

### Como Executar os Testes

1.  Clone o repositório.
2.  Certifique-se de ter o JDK 17 e o Maven instalados.
3.  Navegue até a pasta raiz do projeto e execute o comando:
    ```bash
    mvn test
    ```

---

## Repositório do Projeto

O código-fonte completo, incluindo a implementação do algoritmo e dos testes de unidade, está disponível no GitHub:
[cite_start][https://github.com/J0N4SrR/ImpostoDeRenda](https://github.com/J0N4SrR/ImpostoDeRenda) [cite: 48]
