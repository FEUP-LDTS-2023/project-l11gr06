## LDTS_11_6 - Super Mario Bros

## Game Description
In the context of the project,we developed a game based on Super Mario Bros.
This is a 2D game where the player goes along the map and when he reaches the flag the player wins.
Throughout the map there are a lot of obstacles such as monsters, blocks and some pits.
Furthermore, there are Mystery Blocks which the player can reveal to collect coins and mushrooms in order to win points.

This project was developed by
Duarte Marques (up202204973@up.pt),
Maria Vieira (up202204802@up.pt)
and Marta Cruz (up202205028@up.pt)
for LDTS 23/24.

## Implemented features

- **Linked Menus** - The user has the capability of browsing through the different menus (ex. MenuState, GameState, GameOverState,...);

- **Buttons** - Interactive and functional buttons in the game menus;

- **Keyboard controls** - The keyboard inputs are received and interpreted according to the current game state;

- **Player control** - The player moves according to the keyboard controls;

- **Collision detection** - Collisions between different objects are detected and checked, allowing the player to kill or be killed by monsters, reveal Mystery Blocks, and collect coins and mushrooms(ex. Monster-Monster, Player-Monster, PLayer, Obstacle, ...);

- **Lives** - The player has 3 chances before losing the game.


## Planned features
The SuperMario feature to make him stronger and bigger when the red mushroom is collected and the development of several levels weren´t implemented.
Besides that, all the planned features were implemented successfully.

## Design

### General Structure
#### Problem in Context:
One of our initial doubts in the development of the project was the general structure of the code. We wanted to make sure we used the design patterns that would better suit our code, since our game is divided in different game states and handles a GUI. 

#### The Pattern:
The main patterns used in the project were the State Pattern, a behavioral design pattern that lets an object alter its behavior when its internal state changes, and the MVC Architectural Pattern, the Model-View-Controller, commonly used in GUIs.

#### Implementation of MVC Pattern:

In the implementation of the MVC Architectural Pattern, we divided our code in three parts:
 - Models: only represent the data;
 - Viewers: display the model data and send user actions to the controller;
 - Controllers: provide model data to the view and interpret user actions.

![MVCpattern.png](UMLs%2FMVCpattern.png)
<p align="" justify="">
  <b><i>Figure 1: Model, Controller and Viewer pattern design.</i></b>
</p>
<br>
<br />


#### Implementation of State Pattern:

The image below shows the implementation of the State Pattern, with a 

![Statepattern.png](UMLs%2FStatepattern.png)
<p align="" justify="">
  <b><i>Figure 2: State pattern design.</i></b>
</p>
<br>
<br />


#### Consequences:

There are some benefits of applying the above patterns:
- More understandable code because of the division of the states by different classes.
- Maintability of code, as it can accommodate modifications without affecting the other components/states.
- Makes the testing process easier, by isolating the different components/states, which facilitates the development of robust and reliable code.


### Map Builder

#### Problem in Context:
A map is an aglomeration of elements such as grounds, stairs, blocks, coins, etc. Because of our initial ideia of creating several maps for the several levels, we needed builder classes for each map.

#### The Pattern:
The Factory Method, a creational design pattern, was the appropriate pattern for this situation, since it provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

#### Implementation:
A factory is responsible for constructing the whole but the workers 
are the ones that actually execute the job. 
Analogously, our MapBuilder is a factory and its subclasses represent the workers. 
As for the implementation, the MapBuilder is an 
abstract class which knows how to construct a map, 
however only its subclasses supply the necessary components 
of the map.


![FactoryMethodpattern.png](UMLs%2FFactoryMethodpattern.png)
<p align="" justify="">
  <b><i>Figure 3: Factory Method pattern design.</i></b>
</p>
<br>
<br />

#### Consequences:
Benefits of applying the above pattern:
- You avoid tight coupling between the creator and the concrete products.
- Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.
- You can construct objects step-by-step, defer construction steps or run steps recursively.


## Known-code smells
We have fixed all the errors reported by error-prone. 
However, we identified some code smells:

#### Large Class:
Some classes (like Map, for example) contain many methods. 
We find it justifiable as the classes require these fields. 
Because the Map class is one of the main classes of our program 
it needs to have a considerable amount of methods
to check several interactions between elements in the game.

#### Object-Oriented Abusers (Switch Statements):
The 'step' method, applied in several classes has a complex switch statement, for example in the PlayerController class.
However, this is hard to avoid because of the amount of interactions and elements that need to be considered
in every move of the player.


## Testing

### Screenshot of coverage report
![CodeCoverage.png](images%2FCodeCoverage.png)
<p align="" justify="">
  <b><i>Figure 4: Code coverage screenshot.</i></b>
</p>
<br>
<br />


### Link to mutation testing report: 
[Mutation tests](docs/reports/pitest/202312212037/index.html)


## Self-evaluation

The work was divided in a mutual way and we all contributed with our best.
- Duarte Marques: 33.3%
- Maria Vieira: 33.3%
- Marta Cruz: 33.3%
