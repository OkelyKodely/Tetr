public class Square extends ThePiece {
 
    public Piece piece = new Piece();
    
    public javax.swing.JFrame frame;
    
    public javax.swing.JPanel panel;
    
    public void computeNextRotation() {}
    
    public Piece getPiece()
    {
        return this.piece;
    }
    
    public Square(int x, int y)
    {
        piece.block1 = new Block();
        
        piece.block2 = new Block();

        piece.block3 = new Block();
        
        piece.block4 = new Block();

        piece.block1.x = x;
        piece.block1.y = y;
        
        piece.block2.x = x +20;
        piece.block2.y = y;

        piece.block3.x = x;
        piece.block3.y = y +20;

        piece.block4.x = x +20;
        piece.block4.y = y +20;        
    }
    
    public void drawImage()
    {
        if(piece != null && this.frame != null && this.panel != null)
            piece.drawImage(this.frame,
                            this.panel);
    }
    
    public void moveLeft()
    {
        piece.block1.x -=20;
        piece.block2.x -=20;
        piece.block3.x -=20;
        piece.block4.x -=20;
    }

    public void moveRight()
    {
        piece.block1.x +=20;
        piece.block2.x +=20;
        piece.block3.x +=20;
        piece.block4.x +=20;
    }

    public void moveDown()
    {
        piece.block1.y +=20;
        piece.block2.y +=20;
        piece.block3.y +=20;
        piece.block4.y +=20;
    }
}