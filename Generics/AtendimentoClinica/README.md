# 🚀 Sistema de Filas Genéricas em Java 17

> Projeto educacional desenvolvido para estudar **Estruturas de Dados**, **Generics**, **Orientação a Objetos**, **Collections Framework** e boas práticas utilizadas em aplicações Java modernas.

---

# 📖 Sobre o Projeto

Este projeto simula um sistema simples de atendimento em uma clínica.

Pacientes chegam para atendimento e são armazenados em uma fila seguindo o modelo:

```text
FIFO
(First In, First Out)
```

ou seja:

```text
Primeiro a entrar
        ↓
Primeiro a sair
```

Embora o contexto utilizado seja uma clínica, a solução foi projetada para ser **genérica e reutilizável**, permitindo que a mesma estrutura seja utilizada em diversos cenários do mundo real.

---

# 🎯 Objetivos de Aprendizagem

Este projeto foi desenvolvido para praticar:

* Java 17
* Programação Orientada a Objetos
* Encapsulamento
* Herança
* Collections Framework
* Queue
* LinkedList
* Generics
* Reutilização de código
* Separação de responsabilidades
* Design orientado a domínio

---

# 🏗️ Evolução do Projeto

## Versão Inicial

Na primeira versão a fila era fortemente acoplada ao domínio da clínica.

```java
public class FilaAtendimento {

    private Queue<Paciente> fila;

}
```

Essa implementação funciona bem.

Entretanto ela possui uma limitação:

```text
Só pode armazenar Pacientes
```

Caso quiséssemos reutilizar a mesma lógica para:

* Pedidos
* Clientes
* Impressões
* Chamados
* Mensagens

seria necessário criar novas classes.

```text
FilaPedido
FilaCliente
FilaMensagem
FilaChamado
```

O código começaria a ser duplicado.

---

# 💡 O Problema

Imagine que temos a seguinte lógica:

```text
Adicionar elemento
Remover elemento
Exibir elementos
Verificar fila vazia
```

Essas regras são exatamente iguais para qualquer tipo de objeto.

Então surge a pergunta:

> Por que criar várias implementações diferentes se a lógica é a mesma?

---

# ✨ A Solução: Generics

A resposta é utilizar Generics.

Ao invés de criar:

```java
FilaPaciente
FilaPedido
FilaCliente
```

criamos uma única estrutura:

```java
Fila<T>
```

onde:

```text
T = Tipo
(Type)
```

A classe passa a trabalhar com qualquer tipo de objeto.

---

# 🧠 Entendendo o Generic

Quando declaramos:

```java
public class Fila<T>
```

estamos dizendo:

> Esta classe pode trabalhar com qualquer tipo definido pelo usuário.

Exemplos:

```java
Fila<String>
```

```java
Fila<Integer>
```

```java
Fila<Paciente>
```

```java
Fila<Pedido>
```

A implementação é sempre a mesma.

---

# 📦 Estrutura do Projeto

```text
fila-clinica-generics
│
└── src
    │
    └── main
        │
        └── java
            │
            └── br.com.clinica
                │
                ├── Main.java
                ├── Paciente.java
                ├── Fila.java
                └── FilaAtendimento.java
```

---

# 🎨 Arquitetura

```text
                    Usuário
                       │
                       ▼
              ┌────────────────┐
              │     Main       │
              └───────┬────────┘
                      │
                      ▼
           ┌─────────────────────┐
           │ FilaAtendimento     │
           │ extends Fila        │
           └──────────┬──────────┘
                      │
                      ▼
              ┌────────────────┐
              │    Fila<T>     │
              └───────┬────────┘
                      │
                      ▼
              Queue<T>
                      │
                      ▼
              LinkedList<T>
```

---

# 🔍 Classes do Projeto

## Paciente

Representa um paciente da clínica.

```java
public class Paciente
```

Responsabilidade:

```text
Representar dados do paciente.
```

Exemplo:

```text
Paciente
└── nome
```

---

## Fila<T>

Classe genérica responsável por armazenar qualquer tipo de objeto.

```java
public class Fila<T>
```

Responsabilidades:

```text
Adicionar elementos
Remover elementos
Exibir elementos
Verificar estado da fila
```

A classe não sabe o que está armazenando.

Ela apenas gerencia elementos do tipo T.

---

## FilaAtendimento

Especialização da fila genérica.

```java
public class FilaAtendimento
        extends Fila<Paciente>
```

Ao fazer isso informamos:

```text
Nesta aplicação
T = Paciente
```

---

## Main

Ponto de entrada da aplicação.

Responsável por:

```text
Exibir menu
Receber entradas
Controlar fluxo
```

---

# 🔄 Como o Generic Funciona

A declaração:

```java
Fila<Paciente>
```

faz o compilador interpretar:

```java
T = Paciente
```

Logo:

```java
public void adicionar(T elemento)
```

torna-se:

```java
public void adicionar(Paciente elemento)
```

automaticamente.

---

# 📚 Estrutura de Dados Utilizada

A implementação interna utiliza:

```java
Queue<T>
```

através de:

```java
LinkedList<T>
```

---

# 🔥 Por Que Utilizar Queue?

Porque o problema exige FIFO.

```text
Ana chegou primeiro

Bruno chegou depois

Carlos chegou depois
```

Fila:

```text
[Ana] [Bruno] [Carlos]
```

Atendimento:

```text
Ana
Bruno
Carlos
```

---

# 🚀 Vantagens da Nova Arquitetura

## 1. Reutilização

Antes:

```java
FilaPaciente
FilaPedido
FilaCliente
```

Agora:

```java
Fila<T>
```

Uma única implementação.

---

## 2. Menos Código

Evita duplicação.

Antes:

```text
Mesma lógica repetida várias vezes
```

Agora:

```text
Uma única fonte de verdade
```

---

## 3. Manutenção Simplificada

Se surgir um bug:

Antes:

```text
Corrigir em várias classes
```

Agora:

```text
Corrigir apenas em Fila<T>
```

---

## 4. Segurança de Tipos

O compilador garante:

```java
Fila<Paciente>
```

não aceita:

```java
new String()
```

Exemplo:

```java
Fila<Paciente> fila = new Fila<>();

fila.adicionar(new Paciente("Ana"));
```

Funciona.

Mas:

```java
fila.adicionar("Texto");
```

Não compila.

---

## 5. Mais Próximo do Mercado

Frameworks modernos utilizam Generics intensivamente.

Exemplos:

```java
List<Usuario>

Set<Cliente>

Map<String, Produto>

ResponseEntity<Usuario>

JpaRepository<Usuario, Long>
```

Ao aprender Generics você começa a entender a base de APIs profissionais.

---

# ☕ Recursos Modernos do Java Utilizados

## Java 17 (LTS)

Versão amplamente utilizada no mercado.

---

## Diamond Operator

```java
new LinkedList<>()
```

O compilador infere o tipo automaticamente.

---

## Text Blocks

```java
"""
Menu
1 - Adicionar
2 - Remover
"""
```

Mais legível que múltiplos "\n".

---

## Switch Expressions

```java
case 1 -> {}
```

Mais moderno e seguro.

---

# 📈 Comparação Entre as Versões

| Característica        | Versão Inicial | Versão Genérica |
| --------------------- | -------------- | --------------- |
| Reutilização          | ❌ Baixa        | ✅ Alta          |
| Acoplamento           | ❌ Forte        | ✅ Fraco         |
| Escalabilidade        | ❌ Limitada     | ✅ Elevada       |
| Manutenção            | ❌ Mais difícil | ✅ Mais simples  |
| Reaproveitamento      | ❌ Pequeno      | ✅ Grande        |
| Uso de Generics       | ❌ Consome      | ✅ Cria          |
| Nível de Conhecimento | Básico         | Intermediário   |

---

# 🎓 Conceitos Aprendidos

Ao concluir este projeto você terá estudado:

✅ Classes

✅ Objetos

✅ Encapsulamento

✅ Herança

✅ Collections

✅ Queue

✅ LinkedList

✅ Generics

✅ Type Safety

✅ Reutilização de Código

✅ Interface vs Implementação

✅ Java 17

---

# 🔮 Próximos Passos

Após dominar esta versão, os próximos desafios naturais são:

### Nível 2

Bounded Generics

```java
class Fila<T extends Identificavel>
```

---

### Nível 3

Comparable

```java
implements Comparable<T>
```

---

### Nível 4

PriorityQueue

```java
PriorityQueue<Paciente>
```

---

### Nível 5

Streams

```java
fila.stream()
```

---

### Nível 6

Transformar em API REST

```text
Java 17
Spring Boot
JPA
SQL Server
Docker
Swagger
```

---

# 🏁 Conclusão

Este projeto vai além de uma simples fila de pacientes.

Ele demonstra a evolução de uma solução específica para uma solução reutilizável e extensível, utilizando Generics para reduzir acoplamento, aumentar reutilização e aproximar o código das práticas encontradas em aplicações Java modernas.

O principal aprendizado não é apenas utilizar uma fila, mas compreender como abstrair comportamentos comuns e transformá-los em componentes reutilizáveis através do uso de Generics.
