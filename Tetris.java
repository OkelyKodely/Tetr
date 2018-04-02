public class Tetris {
 
    public javax.swing.JFrame frame = new javax.swing.JFrame();
    
    public javax.swing.JPanel panel = new javax.swing.JPanel();

    public java.util.ArrayList<ThePiece> thepieces = new java.util.ArrayList<ThePiece>();
    
    public java.util.ArrayList<Block> blocks = new java.util.ArrayList<Block>();

    public int score = 0;
    
    public ThePiece thepiece = null;
    
    public Square square = null;
    
    public Pyramid pyr = null;
    
    public Line line = null;
    
    public Larm larm = null;
    
    public Rarm rarm = null;
    
    public LShoulder lshoulder = null;
    
    public RShoulder rshoulder = null;
    
    public int gameDelay = 1590;
    
    public String scoreStr = "Score: ";
    
    public javax.swing.JLabel myScore = new javax.swing.JLabel(); 
    
    public Tetris()
    {
        BuildTetrisGuiAndEngineOfTheGame();        
        RunAndPlay();
    }
    
    public void RunAndPlay()
    {
        java.util.Random r = new java.util.Random();
        
        int v = r.nextInt(7);
        
        if(v == 0) {
        
            square = new Square(120, 40);

            square.frame = this.frame;

            square.panel = this.panel;

            thepiece = square;

        } else if(v == 1) {
            
            pyr = new Pyramid(120, 40);

            pyr.frame = this.frame;

            pyr.panel = this.panel;

            thepiece = pyr;

        } else if(v == 2) {
            
            line = new Line(120, 40);

            line.frame = this.frame;

            line.panel = this.panel;            

            thepiece = line;
            
        } else if(v == 3) {
            
            larm = new Larm(120, 40);

            larm.frame = this.frame;

            larm.panel = this.panel;            

            thepiece = larm;

        } else if(v == 4) {
            
            rarm = new Rarm(120, 40);

            rarm.frame = this.frame;

            rarm.panel = this.panel;

            thepiece = rarm;

        } else if(v == 5) {
            
            lshoulder = new LShoulder(120, 40);

            lshoulder.frame = this.frame;

            lshoulder.panel = this.panel;

            thepiece = lshoulder;

        } else if(v == 6) {
            
            rshoulder = new RShoulder(120, 40);

            rshoulder.frame = this.frame;

            rshoulder.panel = this.panel;

            thepiece = rshoulder;
        }

        thepieces.add(thepiece);
        
        while(true) {
            
            try {
                Thread.sleep(gameDelay);
            
            } catch(Exception e) {}
            
            panel.paintImmediately(0, 0, 240, 480);

            for(int i = 0; i < thepieces.size(); i++)
            {
                if(thepieces == null || thepieces.get(i) == null) {
                    System.exit(-1);
                }

                thepieces.get(i).drawImage();
            }     
            
            if(stacked(thepiece.getPiece())
                ||
                thepiece.getPiece().block1.y > 360
                || 
                thepiece.getPiece().block2.y > 360 
                || 
                thepiece.getPiece().block3.y > 360 
                || 
                thepiece.getPiece().block4.y > 360) {
 
                thepieces.add(thepiece);
                
                blocks.add(thepiece.getPiece().block1);

                blocks.add(thepiece.getPiece().block2);

                blocks.add(thepiece.getPiece().block3);

                blocks.add(thepiece.getPiece().block4);
 
                clear();

                if(blocks.size() == 0)
                    System.exit(-1);
               
                java.util.Random r2 = new java.util.Random();

                int v2 = r2.nextInt(7);

                if(v2 == 0) {

                    square = new Square(120, 40);

                    square.frame = this.frame;

                    square.panel = this.panel;

                    thepiece = square;

                } else if(v2 == 1) {

                    pyr = new Pyramid(120, 40);

                    pyr.frame = this.frame;

                    pyr.panel = this.panel;

                    thepiece = pyr;

                } else if(v2 == 2) {

                    line = new Line(120, 40);

                    line.frame = this.frame;

                    line.panel = this.panel;            

                    thepiece = line;

                } else if(v2 == 3) {

                    larm = new Larm(120, 40);

                    larm.frame = this.frame;

                    larm.panel = this.panel;            

                    thepiece = larm;

                } else if(v2 == 4) {

                    rarm = new Rarm(120, 40);

                    rarm.frame = this.frame;

                    rarm.panel = this.panel;

                    thepiece = rarm;

                } else if(v2 == 5) {

                    lshoulder = new LShoulder(120, 40);

                    lshoulder.frame = this.frame;

                    lshoulder.panel = this.panel;

                    thepiece = lshoulder;

                } else if(v2 == 6) {

                    rshoulder = new RShoulder(120, 40);

                    rshoulder.frame = this.frame;

                    rshoulder.panel = this.panel;

                    thepiece = rshoulder;
                }

                thepieces.add(thepiece);
            }

            else {

                thepiece.moveDown();
            }
            
            if(topReached(thepiece.getPiece()))
            {
                this.score = 0;
                this.myScore.setText(this.scoreStr + this.score);
                
                thepieces.clear();
                
                blocks.clear();
                
                java.util.Random r2 = new java.util.Random();

                int v2 = r2.nextInt(7);

                if(v2 == 0) {

                    square = new Square(120, 40);

                    square.frame = this.frame;

                    square.panel = this.panel;

                    thepiece = square;

                } else if(v2 == 1) {

                    pyr = new Pyramid(120, 40);

                    pyr.frame = this.frame;

                    pyr.panel = this.panel;

                    thepiece = pyr;

                } else if(v2 == 2) {

                    line = new Line(120, 40);

                    line.frame = this.frame;

                    line.panel = this.panel;            

                    thepiece = line;

                } else if(v2 == 3) {

                    larm = new Larm(120, 40);

                    larm.frame = this.frame;

                    larm.panel = this.panel;            

                    thepiece = larm;

                } else if(v2 == 4) {

                    rarm = new Rarm(120, 40);

                    rarm.frame = this.frame;

                    rarm.panel = this.panel;

                    thepiece = rarm;

                } else if(v2 == 5) {

                    lshoulder = new LShoulder(120, 40);

                    lshoulder.frame = this.frame;

                    lshoulder.panel = this.panel;

                    thepiece = lshoulder;

                } else if(v2 == 6) {

                    rshoulder = new RShoulder(120, 40);

                    rshoulder.frame = this.frame;

                    rshoulder.panel = this.panel;

                    thepiece = rshoulder;
                }

                thepieces.add(thepiece);
            }
        }
    }
    
    private void clear()
    {
        java.util.ArrayList<Integer> clearBlocks = new java.util.ArrayList<Integer>();
        for(int line=0; line<=19; line++) {
            int clearThisLine = 0;
            for(int i=0; i<blocks.size(); i++) {
                int x = blocks.get(i).x;
                int y = blocks.get(i).y;
                int theline = line * 20;
                if(y == theline) {
                    clearThisLine++;
                }
            }
            if(clearThisLine > 11) {
                clearBlocks.add(line);
                this.score++;
                this.myScore.setText(this.scoreStr + this.score);
            }
        }
        for(int i=0; i<clearBlocks.size(); i++) {
            for(int j=0; j<blocks.size(); j++) {
                if(blocks.get(j).y /20== clearBlocks.get(i)) {
                    blocks.get(j).y = 1000;
                } else if(blocks.get(j).y /20< clearBlocks.get(i)) {
                    blocks.get(j).y = blocks.get(j).y + 20;
                }
            }
        }
        panel.paintImmediately(0, 0, 240, 480);
    }
    
    private boolean isLeft(Piece piece)
    {
        for(int i = 0; i < thepieces.size(); i++) {
            if((piece != thepieces.get(i).getPiece() && piece.block1.x +20== thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x +20 == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x +20 == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x +20 == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x +20 == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x +20 == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x +20 == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x +20 == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x +20 == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x +20 == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x +20 == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x +20 == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x +20 == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x +20== thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x +20== thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x +20== thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y == thepieces.get(i).getPiece().block4.y)
                    ) {
                
                    return true;
                }
            }
    
        return false;        
    }

    private boolean isRight(Piece piece)
    {
        for(int i = 0; i < thepieces.size(); i++) {
            if((piece != thepieces.get(i).getPiece() && piece.block1.x -20== thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x -20 == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x -20 == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x -20 == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x -20 == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x -20 == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x -20 == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x -20 == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x -20 == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x -20 == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x -20 == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x -20 == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x -20 == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x -20== thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x -20== thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x -20== thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y == thepieces.get(i).getPiece().block4.y)
                    ) {
                
                    return true;
                }
            }
    
        return false;        
    }

    private boolean topReached(Piece piece)
    {
        for(int i = 0; i < thepieces.size(); i++) {
            if(piece != thepieces.get(i).getPiece() && piece.block1.y == 40
                ||
                piece != thepieces.get(i).getPiece() && piece.block1.y == 40
                ||
                piece != thepieces.get(i).getPiece() && piece.block1.y == 40
                ||
                piece != thepieces.get(i).getPiece() && piece.block1.y == 40) {
                
                if((piece != thepieces.get(i).getPiece() && piece.block1.x == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y == thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y == thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y == thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y +20== thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y +20== thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y +20== thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y +20== thepieces.get(i).getPiece().block4.y)
                    ) {
                
                    return true;
                }
            }
        }
    
        return false;        
    }
    
    public boolean stacked(Piece piece)
    {
        for(int i = 0; i < thepieces.size(); i++) {
            if((piece != thepieces.get(i).getPiece() && piece.block1.x == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y +20== thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y +20== thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y +20== thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block1.x == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block1.y +20== thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y +20== thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y +20== thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y +20== thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block2.x == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block2.y +20== thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y +20== thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y +20== thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y +20== thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block3.x == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block3.y +20== thepieces.get(i).getPiece().block4.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x == thepieces.get(i).getPiece().block1.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y +20== thepieces.get(i).getPiece().block1.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x == thepieces.get(i).getPiece().block2.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y +20== thepieces.get(i).getPiece().block2.y)
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x == thepieces.get(i).getPiece().block3.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y +20== thepieces.get(i).getPiece().block3.y)                    
                    ||
                    (piece != thepieces.get(i).getPiece() && piece.block4.x == thepieces.get(i).getPiece().block4.x
                    &&
                    piece != thepieces.get(i).getPiece() && piece.block4.y +20== thepieces.get(i).getPiece().block4.y)
                    ) {
                
                    return true;
                }
            }
    
        return false;
    }
    
    public void BuildTetrisGuiAndEngineOfTheGame()
    {
        frame.setSize(new java.awt.Dimension(240, 400));

        panel.setSize(new java.awt.Dimension(240, 400));
        
        panel.setLocation(400, 0);
        
        javax.swing.JPanel panelZero = new javax.swing.JPanel();
        
        panelZero.setLayout(null);
        panelZero.setSize(new java.awt.Dimension(240, 400));
        panelZero.setLocation(0, 0);

        panelZero.setBackground(new java.awt.Color(10, 10, 10));        
        panel.setBackground(java.awt.Color.black);

        frame.add(panelZero);

        panelZero.add(panel);
        
        myScore.setText(this.scoreStr + this.score);
        
        panelZero.add(myScore);
        
        this.myScore.setForeground(java.awt.Color.white);
        this.myScore.setFont(new java.awt.Font("Tahoma",java.awt.Font.BOLD,36));
      
        myScore.setLocation(100, 100);
        myScore.setSize(new java.awt.Dimension(300, 30));

        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
       
        frame.setExtendedState(frame.getExtendedState() 
                                    |
                               javax.swing.JFrame.MAXIMIZED_BOTH);
        
        frame.setVisible(true);
        
        this.frame.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyTyped(java.awt.event.KeyEvent e) {

            }

            public void keyPressed(java.awt.event.KeyEvent e) {

                if(e.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT)
                {
                    if(isRight(thepiece.getPiece())) {

                        return;
                    }

                    if(thepiece.getPiece().block1.x > 0 &&
                            thepiece.getPiece().block2.x > 0 &&
                            thepiece.getPiece().block3.x > 0 &&
                            thepiece.getPiece().block4.x > 0)
                        thepiece.moveLeft();

                    panel.paintImmediately(0, 0, 240, 480);

                    for(int i = 0; i < thepieces.size(); i++)
                    {
                        if(thepieces == null || thepieces.get(i) == null) {
                            System.exit(-1);
                        }
                        thepieces.get(i).drawImage();
                    }     
                }

                else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT)
                {
                    if(isLeft(thepiece.getPiece())) {

                        return;
                    }
                    
                    if(thepiece.getPiece().block1.x < 220 &&
                            thepiece.getPiece().block2.x < 220 &&
                            thepiece.getPiece().block3.x < 220 &&
                            thepiece.getPiece().block4.x < 220)
                        thepiece.moveRight();

                    panel.paintImmediately(0, 0, 240, 480);

                    for(int i = 0; i < thepieces.size(); i++)
                    {
                        if(thepieces == null || thepieces.get(i) == null) {
                            System.exit(-1);
                        }
                        thepieces.get(i).drawImage();
                    }     
                }
                
                else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN)
                {
                    if(stacked(thepiece.getPiece())
                            ||
                            thepiece.getPiece().block1.y > 360
                            || 
                            thepiece.getPiece().block2.y > 360 
                            || 
                            thepiece.getPiece().block3.y > 360 
                            || 
                            thepiece.getPiece().block4.y > 360) {

                        thepieces.add(thepiece);

                        blocks.add(thepiece.getPiece().block1);

                        blocks.add(thepiece.getPiece().block2);

                        blocks.add(thepiece.getPiece().block3);

                        blocks.add(thepiece.getPiece().block4);

                        clear();
                        
                        java.util.Random r2 = new java.util.Random();

                        int v2 = r2.nextInt(5);

                        if(v2 == 0) {

                            square = new Square(120, 40);

                            square.frame = frame;

                            square.panel = panel;

                            thepiece = square;

                        } else if(v2 == 1) {

                            pyr = new Pyramid(120, 40);

                            pyr.frame = frame;

                            pyr.panel = panel;

                            thepiece = pyr;

                        } else if(v2 == 2) {

                            line = new Line(120, 40);

                            line.frame = frame;

                            line.panel = panel;            

                            thepiece = line;

                        } else if(v2 == 3) {

                            larm = new Larm(120, 40);

                            larm.frame = frame;

                            larm.panel = panel;            

                            thepiece = larm;

                        } else if(v2 == 4) {

                            rarm = new Rarm(120, 40);

                            rarm.frame = frame;

                            rarm.panel = panel;

                            thepiece = rarm;
                        }

                        thepieces.add(thepiece);
                    }

                    else {
                        
                        thepiece.moveDown();
                    }

                    panel.paintImmediately(0, 0, 240, 480);

                    for(int i = 0; i < thepieces.size(); i++)
                    {
                        if(thepieces == null || thepieces.get(i) == null) {

                            System.exit(-1);
                        }

                        else {
                            thepieces.get(i).drawImage();
                        }
                    }
                }

                else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_UP)
                {
                    panel.paintImmediately(0, 0, 240, 480);

                    thepiece.computeNextRotation();

                    if(thepiece.getPiece().block1.x > 480 &&
                            thepiece.getPiece().block2.x > 480 &&
                            thepiece.getPiece().block3.x > 480 &&
                            thepiece.getPiece().block4.x > 480) {
                        thepiece.getPiece().block1.x -= 80;
                        thepiece.getPiece().block2.x -= 80;
                        thepiece.getPiece().block3.x -= 80;
                        thepiece.getPiece().block4.x -= 80;
                    }
                    
                    for(int i = 0; i < thepieces.size(); i++)
                    {

                        if(thepieces == null || thepieces.get(i) == null) {
                            System.exit(-1);
                        }
                        
                        thepieces.get(i).drawImage();
                    }     
                }
            }

            public void keyReleased(java.awt.event.KeyEvent e) {
            }
        });
    }
    
    public static void main(String[] args) {

        Tetris tetris = new Tetris();
    }
}