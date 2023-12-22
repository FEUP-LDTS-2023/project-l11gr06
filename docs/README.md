## LDTS_11_6 - Super Mario Bros

In the context of the project,we developed a game based on Super Mario Bros.
This is a 2D game where the player goes along the map and when he reaches the flag the player wins.
Throughout the map there are a lot of obstacles such as monsters, blocks and some pits.
Furthermore, there are Mystery Blocks which the player can reveal to collect coins and mushrooms in order to win points.

This project was developed by
Duarte Marques (up202204973@up.pt),
Maria Vieira (up202204802@up.pt)
and Marta Cruz (up202205028@up.pt)
for LDTS 23/24.

### Implemented features

- **Linked Menus ** - The user has the capability of browsing through the different menus (ex. MenuState, GameState, GameOverState,...);

- **Buttons** - Interactive and functional buttons in the game menus;

- **Keyboard controls** - The keyboard inputs are received and interpreted according to the current game state;

- **PLayer control** - The player moves according to the keyboard controls;

- **Collision detection** - Collisions between different objects are detected and checked, allowing the player to kill or be killed by monsters, reveal Mystery Blocks, and collect coins and mushrooms(ex. Monster-Monster, Player-Monster, PLayer, Obstacle, ...);

- **Lives** - The player has 3 chances before losing the game.


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
