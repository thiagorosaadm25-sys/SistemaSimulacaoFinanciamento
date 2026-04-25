# Sistema de Simulação de Financiamentos Imobiliários
Este projeto é uma aplicação Java robusta desenvolvida para a  disciplina de Programação Orientada a Objetos.
O objetivo é simular múltiplos financiamentos, gerenciando coleções de objetos na memória e aplicando regras
de negócio realistas do mercado financeiro brasileiro.

### Evolução e Funcionalidades
O sistema deixou de ser uma simulação única para se tornar um gerenciador de portfólio de financiamentos:

- **Gestão de Coleções (`ArrayList`):** Implementação de listas dinâmicas para armazenar e iterar sobre múltiplos
objetos de financiamento.

- **Fluxo de Inserção Inteligente:** Estrutura de repetição que garante o cadastro mínimo de 4 financiamentos
(conforme requisito acadêmico), permitindo que o usuário adicione novos itens opcionalmente.

- **Juros Padrão SBPE:** Regra de negócio que sugere a taxa média de mercado (11.5% a.a.).
Caso o usuário não informe uma taxa, o sistema assume automaticamente o valor padrão.

- **Tratamento de Exceções (Resiliência):** Implementação de blocos `try-catch` para capturar erros de entrada
(como o uso indevido de vírgulas em vez de pontos). O sistema oferece até **3 tentativas** antes de encerrar por segurança.

- **Formatação Monetária BRL:** Saída de dados totalmente formatada para o padrão brasileiro (R$ 1.234.567,89)
utilizando `Locale.of("pt", "BR")`.

- **Herança:** A classe `Financing` tornou-se uma superclasse abstrata, servindo de base para `House`, `Apartment` e `Land`.

- **Especialização de Regras:**
    - **Casas:** Adição de taxa de seguro obrigatória (R$ 80,00/parcela).
    - **Apartamentos:** Implementação de juros compostos utilizando `Math.pow` para maior precisão financeira.
    - **Terrenos:** Acréscimo de 2% sobre o valor da parcela devido ao risco de inadimplência.

- **Polimorfismo:** O sistema agora processa uma lista única de financiamentos, chamando dinamicamente o método de cálculo correto para cada tipo de objeto em tempo de execução.

- **Relatórios Analíticos:** Inclusão de balanço geral que separa o Valor do Imóvel, o Custo dos Juros e o Total Financiado.

### Tecnologias e Conceitos Aplicados
- **Linguagem:** Java (JDK 19+).
- **Paradigma:** Orientação a Objetos (Associação de classes, Encapsulamento e Interação entre objetos).
- **Tratamento de Dados:** `java.util.Scanner` com tratamento de `InputMismatchException`.
- **Internacionalização:** Uso de `java.text.NumberFormat` para localização de moeda.

### Estrutura de Pacotes
O projeto segue o padrão de separação de responsabilidades:

- `main`: Contém a lógica de execução e orquestração do fluxo.
- `modelo`: _Classe Financing_ com os atributos privados e métodos de cálculo.
- `util`: _Classe UserInterface_ responsável pela interação limpa e segura com o usuário.

### Como Testar
1. Certifique-se de ter o JDK instalado.
2. Compile o projeto e execute a classe `main.Main`.
3. O sistema solicitará os dados de pelo menos 4 financiamentos.
4. Ao final, será exibido um relatório detalhado com o valor individual de cada item e o **balanço consolidado**
(soma total) de todos os imóveis e financiamentos.