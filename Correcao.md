# Comentários
> Commit: f4a7c34 | 2025-02-20 19:07:11 -0300

- Muita responsabilidade em Tabuleiro, que poderia ser da classe Peça.
- Peça não deve implementar a interface DrawListener e nem colocar um método toString como abstrato, pois um método com essa assinatura já existe na classe Object
- **Nota:** 10


## Requisitos atendidos

- [x] Arquivo `.gitignore` adequado ao projeto
- [x] Projeto Java com gradle e com as dependências de bibliotecas externas necessárias
- [x] Fez uso correto de constantes e do encapsulamento de dados
- [x] Respeitou a responsabilidade única e divisão de responsabilidades
- [x] Fez uso de classes abstratas ou interface onde for necessário
- [x] Fez uso de herança e polimorfismo
- [x] Comportamento correto da classe que possui o método `main`
- [x] Comportamento correto das demais classes modeladas
- [x] Arquivo `Readme.md` na raiz do repositório, contém o diagrama de classes UML (perspectiva de implementação). É necessário representar corretamente as associações entre classes e os modificadores de acesso dos atributos e métodos (métodos triviais DEVEM ser omitidos)
- [x] Arquivo `Readme.md` na raiz do repositório, contém captura de tela do jogo em execução
- [x] Arquivo `Readme.md` na raiz do repositório, indica quais funcionalidades foram implementadas e quais não foram.
- [x] É possível executar o projeto com o comando: `./gradlew run`. Projetos que não executarem serão avaliados com nota zero.
