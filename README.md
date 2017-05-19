## Game Structure and User Interface

The basic structure of the game consists of player ('#') moving around a
2-D map trying to collect pods ('*').

  * The game provides movement buttons for the player ('N', 'S', 'E', 'W') that
  move the player one square in the desired direction when selected.

  * The player is bound by the dimensions of the game board and does not wrap to
  the opposing boundary.

  * Pods are in perpetual motion, moving in diagonal directions ('NE', 'NW',
  'SE', 'SW').

  * Pods are also bound by the dimensions of the game board; they bounce off
  boundaries and move in the appropriate direction.

  * When the player and a pod occupy the same position, the pod is considered
  caught and will disappear.

  * To encourage efficient gameplay, pods will regenerate every tenth move of
  the player at a random location on the game board, and in a random direction,
  until all pods are caught.

## Instructional Objectives

The specific educational aims of this project include, but should not be
limited to, the following:

  * Provide introduction to generalized container classes--ie. ArrayLists-- and
  corresponding methods in Java

  * Reinforce proper object-oriented design and development of Java classes
