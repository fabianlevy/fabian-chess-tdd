package org.digitalstack.chess;

public class ChessBoard {

    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if (!this.isLegalBoardPosition(xCoordinate,yCoordinate)) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }

        Pawn currentPawnAtPosition = pieces[xCoordinate][yCoordinate];

        if (currentPawnAtPosition != null && currentPawnAtPosition.getPieceColor() == pieceColor) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }

        pawn.setXCoordinate(xCoordinate);
        pawn.setYCoordinate(yCoordinate);
        this.pieces[xCoordinate][yCoordinate] = pawn;
        pawn.setChessBoard(this);
    }


    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if (xCoordinate < 0 || xCoordinate >= BOARD_WIDTH) {
            return false;
        }

        if (yCoordinate < 0 || yCoordinate >= BOARD_HEIGHT) {
            return false;
        }

        return true;
    }
}
