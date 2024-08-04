# Conceitos de Programação no Projeto

## 1. Herança

Herança é o mecanismo pelo qual uma classe pode herdar características e comportamentos de outra. No seu projeto, a herança não está explicitamente visível, mas se você precisar adicionar novas funcionalidades ou tipos de objetos que compartilham características comuns com `Time`, `Partida`, ou `Classificacao`, você poderia criar uma hierarquia de classes. Por exemplo, se você tivesse diferentes tipos de partidas (como amistosos e campeonatos), você poderia criar uma classe base `Partida` e subclasses específicas que herdam dela.

## 2. Polimorfismo

Polimorfismo permite que um objeto seja tratado como uma instância de sua superclasse. No seu código, o polimorfismo poderia ser utilizado se você tivesse uma interface ou classe base para diferentes tipos de relatórios. Por exemplo, você poderia ter uma interface `Relatorio` e implementar diferentes tipos de relatórios (`RelatorioCompleto`, `RelatorioResumido`, etc.) que oferecem uma implementação específica dos métodos definidos na interface. Isso permite que você trate todos os relatórios de maneira uniforme.

## 3. Encapsulamento

Encapsulamento é o conceito de ocultar os detalhes internos de uma classe e expor apenas o necessário para o mundo exterior. No seu projeto:

- **Classe `Time`**: Os atributos `nome`, `cidade`, e `estado` são privados, e você fornece métodos públicos para acessá-los e modificá-los (`getNome()`, `setNome()`, etc.). Isso garante que os dados internos só possam ser alterados através de métodos controlados.

- **Classe `TimeManager`**: Os atributos `times`, `classificacoes`, e `partidas` são privados, e você fornece métodos públicos para manipulá-los (`adicionarTime()`, `removerTime()`, `exibirClassificacao()`, etc.). Isso permite controlar o acesso e a modificação dos dados.

## 4. Agregação

Agregação é uma relação "tem um" onde o ciclo de vida dos objetos agregados é independente do ciclo de vida do objeto que os agrega. No seu projeto:

- **Classe `TimeManager`**: A `TimeManager` possui uma lista de `Time` e
