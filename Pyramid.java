public class Pyramid extends ThePiece {
 
    public Piece piece = new Piece();
    
    public javax.swing.JFrame frame;
    
    public javax.swing.JPanel panel;
    
    public String direction = "up";

    public void computeNextRotation()
    {
        if(direction.equals("up")) {
            
            direction = "right";
        } else if(direction.equals("right")) {
            
            direction = "down";
        } else if(direction.equals("down")) {
            
            direction = "left";
        } else if(direction.equals("left")) {
            
            direction = "up";
        }
        
        rotate();
    }
    
    public void rotate()
    {
        if(direction.equals("right")) {
            piece.block1.x = piece.block1.x + 40;
            piece.block1.y = piece.block1.y + 40;

            piece.block2.x = piece.block2.x + 40;
            piece.block2.y = piece.block2.y - 40;

            piece.block3.x = piece.block3.x;
            piece.block3.y = piece.block3.y;

            piece.block4.x = piece.block4.x - 40;
            piece.block4.y = piece.block4.y + 40;        

        } else if(direction.equals("down")) {
            piece.block1.x = piece.block1.x - 40;
            piece.block1.y = piece.block1.y + 40;

            piece.block2.x = piece.block2.x + 40;
            piece.block2.y = piece.block2.y + 40;

            piece.block3.x = piece.block3.x;
            piece.block3.y = piece.block3.y;

            piece.block4.x = piece.block4.x - 40;
            piece.block4.y = piece.block4.y - 40;        

        } else if(direction.equals("left")) {
            piece.block1.x = piece.block1.x - 40;
            piece.block1.y = piece.block1.y - 40;

            piece.block2.x = piece.block2.x - 40;
            piece.block2.y = piece.block2.y + 40;

            piece.block3.x = piece.block3.x;
            piece.block3.y = piece.block3.y;

            piece.block4.x = piece.block4.x + 40;
            piece.block4.y = piece.block4.y - 40;        

        } else if(direction.equals("up")) {
            piece.block1.x = piece.block1.x + 40;
            piece.block1.y = piece.block1.y - 40;

            piece.block2.x = piece.block2.x - 40;
            piece.block2.y = piece.block2.y - 40;

            piece.block3.x = piece.block3.x;
            piece.block3.y = piece.block3.y;

            piece.block4.x = piece.block4.x + 40;
            piece.block4.y = piece.block4.y + 40;        
        }
    }
    
    public Piece getPiece()
    {
        return this.piece;
    }
    
    public Pyramid(int x, int y)
    {
        piece.block1 = new Block();
        
        piece.block2 = new Block();

        piece.block3 = new Block();
        
        piece.block4 = new Block();

        piece.block1.x = x + 40;
        piece.block1.y = y;
        
        piece.block2.x = x;
        piece.block2.y = y + 40;

        piece.block3.x = x + 40;
        piece.block3.y = y + 40;

        piece.block4.x = x + 80;
        piece.block4.y = y + 40;        
    }
    
    public void drawImage()
    {
        if(piece != null && this.frame != null && this.panel != null)
            piece.drawImage(this.frame,
                            this.panel);
    }
        
    public void moveLeft()
    {
        piece.block1.x -= 40;
        piece.block2.x -= 40;
        piece.block3.x -= 40;
        piece.block4.x -= 40;
    }

    public void moveRight()
    {
        piece.block1.x += 40;
        piece.block2.x += 40;
        piece.block3.x += 40;
        piece.block4.x += 40;
    }

    public void moveDown()
    {
        piece.block1.y += 40;
        piece.block2.y += 40;
        piece.block3.y += 40;
        piece.block4.y += 40;
    }
}