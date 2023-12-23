## LDTS_11_6 - Super Mario Bros

## Game Description
In the context of the project, we developed a game based on Super Mario Bros.
This is a 2D game where the player goes along the map and wins when reaches the flag.
Throughout the map there are several obstacles such as monsters, blocks and some pits.
Furthermore, there are Mystery Blocks which the player can reveal to collect coins and mushrooms in order to win points.

This project was developed by
Duarte Marques (up202204973@up.pt), 
Maria Vieira (up202204802@up.pt)
and Marta Cruz (up202205028@up.pt)
for LDTS 23/24.

## Commands
* ```<``` : Move backward;
* ```>``` : Move forward;
* ```^```: Jump vertically;
* ```X``` : Front Jump;
* ```Z``` : Back jump;
* ```q``` : Return to the main menu in the middle of the game. 


## Implemented features

- **Linked Menus** - The user has the capability of browsing through the different menus (ex. MenuState, GameState, GameOverState,...);

- **Buttons** - Interactive and functional buttons in the game menus;

- **Keyboard controls** - The keyboard inputs are received and interpreted according to the current game state;

- **Player control** - The player moves according to the keyboard controls;

- **Collision detection** - Collisions between different objects are detected and checked, allowing the player to kill or be killed by monsters, reveal Mystery Blocks, and collect coins and mushrooms (ex. Monster-Monster, Player-Monster, Player-Obstacle, ...);

- **Lives** - The player has 3 chances before losing the game.


## Images
The following images show an overview of the game, as well as its different functionalities:

### Game Demo

![GamePlay (1).gif](docs%2FGIFs%2FGamePlay%20%281%29.gif)

GIF 1: Game Demo.

![Monsters.gif](docs%2FGIFs%2FMonsters.gif)

GIF 2: Monsters.

![MysteryBlock.gif](docs%2FGIFs%2FMysteryBlock.gif)

GIF 3: Mystery Blocks.


### Menus
![InitialMenu.png](docs%2Fimages%2FInitialMenu.png)
Figure 1: Model of the Main Menu.

![HelpMenu.png](docs%2Fimages%2FHelpMenu.png)
Figure 2: Model of the Help Menu.

![AboutMenu.png](docs%2Fimages%2FAboutMenu.png)
Figure 3: Model of the About Menu.

![Game.png](docs%2Fimages%2FGame.png)
Figure 4: Model of the Game initially.

![GameOver.png](docs%2Fimages%2FGameOver.png)
Figure 5: Model of the GameOver Menu.

![Victory.png](docs%2Fimages%2FVictory.png)
Figure 6: Model of the Victory Menu.

