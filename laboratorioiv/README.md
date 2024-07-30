# Laboratório IV
### 21/07/2024

## Sobre

### Contexto
_Você foi contratado por uma imobiliária para desenvolver um backend de uma aplicação que irá
gerenciar suas operações diárias. O sistema deve seguir uma arquitetura em camadas, composta
por uma camada de modelo, uma camada de acesso a dados utilizando o padrão repository, e
uma camada de serviço para facilitar a implementação de alguns casos de uso._

### Desenvolvimento

O projeto foi dividido em camadas `Model`, `Repository` e `Service`, partindo do modelo EER proposto até o mapeamento objeto-relacional. Neste projeto `Maven`, utilizamos:

- `Jakarta JPA`
- `Hibernate`
- `Lombok`
- `MySQL`

## Modelo
![Modelo](./assets/Model.png)

## Funcionalidades

- **`Cadastro de Imóveis`** (inserir, atualizar e listar todos os imóveis
cadastrados).

- **`Cadastro de Profissionais`** (inserir,atualizar e listar todos os imóveis
cadastrados).
- **`Cadastro de Locação`** (inserir, atualizar e listar todas as locações de um
determinado cliente), associando um imóvel a um cliente (inquilino).

- **`Cadastro de ServicoImovel`** (inserir, atualizar e listar todas
serviços executados para uma determinada locação).
- **`Cadastro de Aluguéis`** (inserir, atualizar e listar todos os aluguéis de um
determinado inquilino).
- **`Registrar Pagamento de Aluguel`** permite a associação de pagamentos
  de aluguel a uma locação.

# Desenvolvido por

* [José Júnior](https://github.com/jjuniorbrasil)
* [Pedro Julius](https://github.com/Pedro-SousaM)
* [Rudney Gabriel](https://github.com/rudneyggf)
