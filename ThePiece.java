public abstract class ThePiece {

    public abstract Piece getPiece();
    
    public abstract void moveLeft();

    public abstract void moveRight();

    public abstract void moveDown();

    public abstract void computeNextRotation();
    
    public abstract void drawImage();    
}