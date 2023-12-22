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

### Planned features
The SuperMario feature to make him stronger and bigger when the red mushroom is collected wasn´t implemented.
Besides that, all the planned features were implemented.

### Design
Aplicámos vários design patterns: State Pattern, Factory Method Pattern, Game Loop Pattern, e também MVC Arquitectural Pattern.

#### General Structure
**Problem in context:**
One of our initial doubts in the development of the project was the general structure of the code. We wanted to make sure we used the design patterns that would better suit our code, since our game is divided in different game states and handles a GUI. 

**The pattern:**
The main patterns used in the project were the State Pattern, a behavioral design pattern that lets an object alter its behavior when its internal state changes, and the MVC Architectural Pattern, the Model-View-Controller, commonly used in GUIs.

**Implementation of MVC pattern:**

In the implementation of the MVC Architectural Pattern, we divided our code in three parts:
 - Models: only represent the data;
 - Viewers: display the model data and send user actions to the controller;
 - Controllers: provide model data to the view and interpret user actions.

![MVCpattern.png](UMLs%2FMVCpattern.png)

Fig. 1: Model, Controller and Viewer pattern design



**Implementation of State pattern:**

The image below shows the implementation of the State Pattern, with a 

![Statepattern.png](UMLs%2FStatepattern.png)
Fig. 2: State pattern design

**Consequences:**

There are some benefits of applying the above patterns:
- More understandable code because of the division of the states by different classes.
- Maintability of code, as it can accommodate modifications without affecting the other components/states.
- Makes the testing process easier, by isolating the different components/states, which facilitates the development of robust and reliable code.



### Code Smells
FAZER ERROR PRONE




### Testes

Fig. 6: Cobertura dos testes implementados.

Link para mutation testing report:


### Auto-Avaliação

Todos os membros participaram de igual forma no desenvolvimento do projeto:
- Duarte Marques: 33.3%
- Maria Vieira: 33.3%
- Marta Cruz: 33.3%
