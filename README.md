# Java-Castle

This README provides an overview and explanation of the Java code for a text-based castle exploration game. The game uses ASCII art to represent rooms in a castle and allows the player to navigate through them. It also includes a pathfinding feature using Dijkstra's algorithm to find the shortest path between rooms.

The castle Java program is a text-based game that simulates exploring a castle with interconnected rooms. The game uses ASCII art to represent each room and allows players to move between rooms and find the shortest path to specific destinations within the castle.

Features
The program includes the following features:

Game Map Visualization: The game displays a graphical representation of the castle's layout using ASCII art, making it easier for players to visualize their surroundings.

File Input: The program reads information about the castle's rooms and their connections from text files (vertex.txt and edge.txt).

Room Navigation: Players can move between rooms by entering directional commands (North, South, East, West) to explore the castle.

Pathfinding: Players can find the shortest path between their current location and specific destination rooms within the castle using Dijkstra's algorithm.

Game Map
The game displays rooms using ASCII art, and the layout of rooms is read from external text files (vertex.txt and edge.txt). Each room has connections to other rooms in the North, South, East, and West directions, and players can move in these directions if there are valid connections.

File Input
The program reads two text files to construct the castle:

vertex.txt: Contains a list of room names, one per line. Each room is represented as an instance of the Room class.

edge.txt: Contains information about room connections. Each line in this file represents a connection between two rooms, specifying the source room, direction (North, South, East, or West), and the target room.

Game Logic
The core logic of the game involves allowing the player to explore rooms and navigate between them using directional commands (N, S, E, W). Players are provided with a visual representation of their current room and the available connections in ASCII art.

Pathfinding
The program implements Dijkstra's algorithm to find the shortest path between the player's current room and a specified destination room. When the player chooses to find a path (F), they can input the name of the destination room. If a path exists, it will be displayed to the player.

How to Play
Run the program.

The game will display a visual representation of the castle layout using ASCII art.

Use the following commands to navigate through the castle:

N or n: Move North
S or s: Move South
E or e: Move East
W or w: Move West
F or f: Find the shortest path to a specific room
Explore the castle, find hidden rooms, and enjoy the game!

When you want to quit the game, press q.

Acknowledgments
This game program was developed using Java and leverages ASCII art to create a visually engaging castle exploration experience. It also showcases the use of Dijkstra's algorithm for pathfinding within the game world. The code can be extended and modified to create more complex and interactive text-based games.
