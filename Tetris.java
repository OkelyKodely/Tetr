public class Tetris {
 
    public String str = "";

    public javax.swing.JFrame frame = new javax.swing.JFrame();
 
    public javax.swing.JPanel panelZero = new javax.swing.JPanel();
     
    public javax.swing.JPanel panel = new javax.swing.JPanel();

    public javax.swing.JPanel panelS = new javax.swing.JPanel();

    public java.util.ArrayList<ThePiece> thepieces = new java.util.ArrayList<ThePiece>();
    
    public java.util.ArrayList<Block> blocks = new java.util.ArrayList<Block>();

    public int score = 0;

    public boolean levelBegin = true;

    public int levelScoreUp = 0;
    
    public int level = 1;
    
    public ThePiece thepiece = null;
    
    public Square square = null;
    
    public Pyramid pyr = null;
    
    public Line line = null;
    
    public Larm larm = null;
    
    public Rarm rarm = null;
    
    public LShoulder lshoulder = null;
    
    public RShoulder rshoulder = null;
    
    public int gameDelay = 1190;
    
    public String scoreStr = "Score: ";
    
    public javax.swing.JLabel myScore = new javax.swing.JLabel(); 
    
    public String levelStr = "Level = ";

    public javax.swing.JLabel myLevel = new javax.swing.JLabel(); 

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
                this.gameDelay = 1190;
                
                this.levelBegin = true;
                
                this.score = 0;
                this.myScore.setText(this.scoreStr + this.score);
                
                this.level = 1;
                this.myLevel.setText("Level = " + "(" + this.level + "/20)");

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
                this.levelScoreUp++;
                if(this.levelScoreUp % 5 == 0 && this.levelBegin == true && this.levelScoreUp != 0) {
                    this.gameDelay -= 120;
                    this.levelBegin = false;
                    this.level++;
                    java.lang.Thread t = new java.lang.Thread(new java.lang.Runnable() {
                        @Override
                        public void run() {
                            myLevel.setText("Level = " + "(" + level + "/20)");
                        }
                    });
                    t.start();
                    if(this.levelScoreUp == 5) {
                        this.levelScoreUp = 0;
                    }
                    if(this.gameDelay < 600) {
                        this.gameDelay = 600;
                    }
                } else if(this.levelScoreUp % 5 == 0 && this.levelBegin == false) {
                    this.gameDelay -= 120;
                    this.level++;
                    java.lang.Thread t = new java.lang.Thread(new java.lang.Runnable() {
                        @Override
                        public void run() {
                            myLevel.setText("Level = " + "(" + level + "/20)");
                        }
                    });
                    t.start();
                    if(this.levelScoreUp == 12) {
                        this.levelScoreUp = 0;
                    }
                    if(this.gameDelay < 600) {
                        this.gameDelay = 600;
                    }
                }
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
        frame.setTitle("WERlks askja sweklrjiojmmaf lksdafiweklj sda.,msf da/klsjafkjwakej f/.asjdf j234o5rjkl32j@#$23$J 234 jj234jk23$@#$%$%$ J$@J%J 234 dflkjsd sdfaj lksafioewjlkwklqjer sadfmasFs afsa fkljwe jlkfawj elwael");
        
        frame.setSize(new java.awt.Dimension(240, 400));

        panel.setSize(new java.awt.Dimension(240, 400));
        
        panel.setLocation(400, 0);       
        
        panelZero.setLayout(null);
        panelZero.setSize(new java.awt.Dimension(240, 400));
        panelZero.setLocation(0, 0);

        panelZero.setBackground(new java.awt.Color(10, 10, 10));        
 
        panel.setBackground(new java.awt.Color(0, 128, 128));

        panelS.setSize(new java.awt.Dimension(800, 400));
        
        panelS.setLocation(400, 400);       
 
        frame.add(panelZero);

        panelZero.add(panel);
        
        panelZero.add(panelS);
        
        myScore.setText(this.scoreStr + this.score);
        
        panelZero.add(myScore);
        
        myLevel.setText(this.levelStr + "(" + this.level + "/20)");

        this.myScore.setForeground(new java.awt.Color(30, 144, 255));
        this.myScore.setFont(new java.awt.Font("Tahoma",java.awt.Font.BOLD,36));
      
        myScore.setLocation(100, 100);
        myScore.setSize(new java.awt.Dimension(300, 30));

        this.myLevel.setForeground(new java.awt.Color(30, 144, 255));
        this.myLevel.setFont(new java.awt.Font("Tahoma",java.awt.Font.BOLD,36));
      
        myLevel.setLocation(100, 130);
        myLevel.setSize(new java.awt.Dimension(300, 30));
        
        panelZero.add(myLevel);
        
        javax.swing.JLabel thisIsTetrisStr = new javax.swing.JLabel();
        thisIsTetrisStr.setText(("This Is Tetris!!!"));
        thisIsTetrisStr.setFont(new java.awt.Font("arial", java.awt.Font.BOLD, 36));
        thisIsTetrisStr.setForeground(java.awt.Color.pink);
        thisIsTetrisStr.setLocation(700, 150);
        thisIsTetrisStr.setSize(new java.awt.Dimension(400, 200));
        
        panelZero.add(thisIsTetrisStr);

        java.lang.Thread t = new java.lang.Thread(new java.lang.Runnable() {
            public void run()
            {
                while(true)
                {
                    try {
                        java.lang.Thread.sleep(200);
                    } catch(Exception e) {}
                    //panelZero.paintImmediately(0, 0, panelZero.getWidth(), panelZero.getHeight());
                    thisIsTetrisStr.setText((str + "this is Sparta ~"));
                    str += " ";
                    if(str.length() > 20) {
                        str = "";
                    }
                }
            }
        });
        t.start();
        
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
       
        frame.setExtendedState(frame.getExtendedState() 
                                    |
                               javax.swing.JFrame.MAXIMIZED_BOTH);
        
        frame.setVisible(true);
        
        java.lang.Thread tt = new java.lang.Thread(new java.lang.Runnable() {
            public void run()
            {
                while(true)
                {
                    java.awt.Image img = null;

                    try {

                        String image = "starwars.gif";
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
                        img = i.getImage();

                    } catch(Exception e) {
                    }

                    java.awt.Graphics g = panelS.getGraphics();

                    g.drawImage(img, 0, 0, panelS.getWidth(), panelS.getHeight(), panelS);
                }
            }
        });
        tt.start();
        
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