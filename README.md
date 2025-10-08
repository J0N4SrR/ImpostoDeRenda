# 📊 Análise e Teste de Algoritmo de Cálculo de Imposto de Renda

Este projeto apresenta a aplicação de técnicas de teste funcional e estrutural sobre um algoritmo para cálculo do Imposto de Renda (IR), desenvolvido como parte de um exercício acadêmico. O trabalho abrange desde a especificação dos casos de teste, passando pela análise estrutural do código com Grafo de Fluxo de Controle (GFC), até a implementação e validação final com testes de unidade.

## ✨ Tecnologias Utilizadas
* **Java 17** ☕
* **Maven** 📦
* **JUnit 5** ✅

---

## 🧪 1. Etapa 1: Teste Funcional (Caixa-Preta)

A primeira fase do projeto focou no planejamento dos testes utilizando técnicas de caixa-preta. Foram aplicados os critérios de **Partição de Classes de Equivalência** e **Análise de Valor Limite** para definir um conjunto robusto de casos de teste. O objetivo foi garantir uma cobertura abrangente dos cenários, incluindo entradas válidas e inválidas, bem como os valores de fronteira de cada faixa de imposto.

### Classes de Equivalência Identificadas
* ✅ **Válidas:** Cinco partições, uma para cada faixa de alíquota do IR.
* ❌ **Inválidas:** Duas partições principais, para salários negativos e entradas nulas.

### Análise de Valor Limite
Foram definidos casos de teste para os limites inferiores e superiores de cada faixa de imposto, onde a probabilidade de encontrar erros de lógica é maior.

---

## 📈 2. Etapa 2: Teste Estrutural (Caixa-Branca)

Após a implementação do algoritmo em Java, foi realizada uma análise de teste estrutural. O código foi abstraído em blocos indivisíveis (nós) para modelar um **Grafo de Fluxo de Controle (GFC)**, que representa visualmente todos os caminhos de execução possíveis.

### Análise do GFC

* **Complexidade Ciclomática:** A análise do grafo revelou uma complexidade ciclomática de **4**, indicando a necessidade de um conjunto base de 4 caminhos independentes para uma cobertura lógica fundamental.
* **Caminhos Independentes:** Foi definido um conjunto de 4 caminhos para garantir a cobertura de todas as decisões lógicas:
    1.  **Caminho de erro inicial** (`20 -> 21 -> 37`), para entradas inválidas.
    2.  **Caminho base de sucesso** (`20 -> 24 -> 25 -> 27 -> 37`), para o cálculo na primeira faixa.
    3.  **Caminho de teste do laço** (`... -> 25 -> 24 -> ...`), forçando múltiplas iterações.
    4.  **Caminho de erro de saída do laço** (`... -> 24 -> 35 -> 37`), para o caso de a tabela estar mal configurada.

---

## ✅ 3. Etapa 3: Implementação dos Testes de Unidade

Com base nas análises funcional e estrutural, os testes de unidade foram implementados em Java com **JUnit 5**. A abordagem principal foi o uso de **Testes Parametrizados (`@ParameterizedTest`)**, que se mostrou vantajosa por permitir a cobertura de todos os valores limite de forma concisa e organizada, evitando a repetição de código. A principal desvantagem reconhecida é uma menor clareza no relatório de falhas, que pode exigir uma análise mais detalhada para identificar o cenário exato do problema.

### 🚀 Como Executar os Testes

1.  Clone o repositório.
2.  Certifique-se de ter o JDK 17 e o Maven instalados.
3.  Navegue até a pasta raiz do projeto e execute o comando:
    ```bash
    mvn test
    ```

---

## 🔗 Repositório do Projeto

O código-fonte completo, incluindo a implementação do algoritmo e dos testes de unidade, está disponível no GitHub:
[https://github.com/J0N4SrR/ImpostoDeRenda](https://github.com/J0N4SrR/ImpostoDeRenda)
