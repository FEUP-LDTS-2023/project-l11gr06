## LDTS_11_6 - Super Mario Bros

No âmbito do projeto, desenvolvemos um jogo baseado no Super Mario Bros.
Este consiste num jogo 2D em que o jogador percorre o mapa e ganha o jogo quando chega à bandeira.
No mapa existem vários obstáculos e "Mystery Blocks" em que o jogador pode recolher moedas ou cogumelos,
que dão pontos.

Este projeto foi desenvolvido por
Duarte Marques (up202204973@up.pt),
Maria Vieira (up202204802@up.pt)
e Marta Cruz (up202205028@up.pt)
para a cadeira LDTS 23/24.

### Funcionalidades implementadas

- **Menus interligados** - O utilizador navega entre vários menus (ex. MenuState, GameState, GameOverState,...);

- **Botões** - Botões interativos e funcionais nos menus do jogo;

- **Controlo do teclado** - Os inputs do teclado são recebidos e interpretados de acordo com o estado de jogo atual;

- **Controlo do jogador** - O jogador move-se de acordo com os controlos do teclado;

- **Deteção de colisões** - As colisões entre diferentes objetos são detetadas e verificadas o que permite matar ou ser morto por monstros,
  revelar Mystery Blocks e apanhar moedas e cogumelos (ex. Monstro-Monstro, Jogador-Monstro, Jogador, Obstáculo, ...).

### Funcionalidades planeadas
Implementámos a maioria das funcionalidades que tínhamos planeadas. Não desenvolvemos a funcionalidade do Mario ficar maior e mais forte após apanhar o cogumelo, tal como no jogo original. 

### Design
Aplicámos vários design patterns: State Pattern, Factory Method Pattern, Game Loop Pattern, e também MVC Arquitectural Pattern.

#### OS COMANDOS FUNCIONAM DE FORMAS DIFERENTES DEPENDENDO DO ESTADO DO JOGO
**Problema em contexto**
Para a implementação de um menu inicial, as intruções do jogo, 
**O padrão**
**Implementação**
**Consequências**






### Code Smells




### Testes

Fig. 6: Cobertura dos testes implementados.

Link para mutation testing report:


### Auto-Avaliação

Todos os membros participaram de igual forma no desenvolvimento do projeto:
- Duarte Marques: 33.3%
- Maria Vieira: 33.3%
- Marta Cruz: 33.3%
