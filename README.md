# Java Chess Game

## Description

This project is a Java-based chess game that simulates basic chess piece movements and interactions on a chessboard. It includes classes representing different chess pieces, a chessboard to manage these pieces, and functionality to determine possible moves and threats among pieces.

## Features

- **Chess Pieces**: Implementations for the Rook and Knight pieces with their respective movement logic.
- **Position Class**: Manages the position of pieces on the board.
- **ChessBoard Class**: Handles the board state, adding pieces, and checking interactions.

## Key Classes and Methods

### ChessPiece Interface
Defines the methods for chess pieces.
- `Position[] moves(Position p)`: Returns all possible positions a piece can move to from the given position.
- `Position getPosition()`: Returns the current position of the piece.

### Rook and Knight Classes
Implement the `ChessPiece` interface, representing the specific movements of the rook and knight pieces respectively.
- `toString()`: Returns the type of piece and its position.

### ChessBoard Class
Manages the collection of pieces on the board.
- `addPiece(ChessPiece p)`: Adds a piece to the board.
- `toString()`: Returns a string representation of all pieces on the board.
- `boolean threats(int p1, int p2)`: Checks if the piece at index `p1` threatens the piece at index `p2`.
- `String whoThreatsWho()`: Lists all threats between pieces on the board.

## How to Run
To run the game, compile and execute the main method in the `ChessBoard` class. Example usage:
```java
public static void main(String[] args) {
    ChessBoard board = new ChessBoard();
    board.addPiece(new Knight(new Position(5, 2)));
    board.addPiece(new Rook(new Position(3, 3)));
    board.addPiece(new Knight(new Position(3, 6)));
    System.out.println(board);
    System.out.println(board.threats(0, 1));    
    System.out.println(board.whoThreatsWho());
}
```

## Example Output
```
Knight at (5, 2)
Rook at (3, 3)
Knight at (3, 6)
true
Knight at (5, 2) threats Rook at (3, 3)
Rook at (3, 3) threats Knight at (3, 6)
```
