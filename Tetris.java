public class Tetris {
 
    public String str = "";

    public javax.swing.JFrame frame = new javax.swing.JFrame();
 
    public javax.swing.JPanel panelZero = new javax.swing.JPanel();
     
    public javax.swing.JPanel panel = new javax.swing.JPanel();

    public javax.swing.JPanel panelS = new javax.swing.JPanel();

    public java.util.ArrayList thepieces = new java.util.ArrayList();
    
    public java.util.ArrayList pies = new java.util.ArrayList();

    public java.util.ArrayList bombsHorizontally = new java.util.ArrayList();

    public java.util.ArrayList bombsVertically = new java.util.ArrayList();

    public java.util.ArrayList<Block> blocks = new java.util.ArrayList<Block>();

    public int score = 0;

    public boolean levelBegin = true;

    public int levelScoreUp = 0;
    
    public int level = 1;
    
    public ThePiece thepiece = null;
    
    public PieceOfMush[] pie = null;
    
    public Bomb[] bombHorizontally = null;

    public Bomb[] bombVertically = null;

    public Square square = null;
    
    public Pyramid pyr = null;
    
    public Line line = null;
    
    public Larm larm = null;
    
    public Rarm rarm = null;
    
    public LShoulder lshoulder = null;
    
    public RShoulder rshoulder = null;
    
    public int gameDelay = 1290;
    
    public String scoreStr = "Score: ";
    
    public javax.swing.JLabel myScore = new javax.swing.JLabel(); 
    
    public String levelStr = "Level ";

    public javax.swing.JLabel myLevel = new javax.swing.JLabel(); 

    public Tetris()
    {
        BuildTetrisGuiAndEngineOfTheGame();        
        RunAndPlay();
    }
    
    public void RunAndPlay()
    {
        java.util.Random r1 = new java.util.Random();
        
        java.util.Random r3 = new java.util.Random();

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
        
        bombHorizontally = new Bomb[1];

        for(int q=0; q<bombHorizontally.length; q++) {
            int x = r3.nextInt(12) * 20;

            int y = 0;

            bombHorizontally[q] = new Bomb();
            bombHorizontally[q].block.x = x;
            bombHorizontally[q].block.y = y;

            bombHorizontally[q].kind = "h";
        }

        bombVertically = new Bomb[1];

        for(int q=0; q<bombVertically.length; q++) {
            int x = r3.nextInt(12) * 20;

            int y = 0;

            bombVertically[q] = new Bomb();
            bombVertically[q].block.x = x;
            bombVertically[q].block.y = y;

            bombVertically[q].kind = "v";
        }

        pie = new PieceOfMush[2];

        for(int q=0; q<2; q++) {
            int x = r1.nextInt(12) * 20;

            int y = 0;

            pie[q] = new PieceOfMush();
            pie[q].block.x = x;
            pie[q].block.y = y;

            pie[q].kind = "now";
        }
        
        thepieces.add(thepiece);
        
        while(true) {
            
            try {
                Thread.sleep(gameDelay);
            
            } catch(Exception e) {}
            
            panel.paintImmediately(0, 0, 240, 680);

            for(int i = 0; i < thepieces.size(); i++)
            {
                ((ThePiece)thepieces.get(i)).drawImage();
            }    
            
            for(int i = 0; i < bombsHorizontally.size(); i++)
            {
                ((Bomb)bombsHorizontally.get(i)).drawImage(frame, panel);
            }    

            for(int s = 0; s < bombHorizontally.length; s++) {
            
                bombHorizontally[s].drawImage(frame, panel);
            }

            for(int i = 0; i < bombsVertically.size(); i++)
            {
                ((Bomb)bombsVertically.get(i)).drawImage(frame, panel);
            }    

            for(int s = 0; s < bombVertically.length; s++) {
            
                bombVertically[s].drawImage(frame, panel);
            }
            
            for(int i = 0; i < pies.size(); i++)
            {
                ((PieceOfMush)pies.get(i)).drawImage(frame, panel);
            }    

            for(int s = 0; s < pie.length; s++) {
            
                pie[s].drawImage(frame, panel);
            }
            
            if(stacked(thepiece.getPiece())
                ||
                thepiece.getPiece().block[0].y > 560
                || 
                thepiece.getPiece().block[1].y > 560 
                || 
                thepiece.getPiece().block[2].y > 560 
                || 
                thepiece.getPiece().block[3].y > 560) {
 
                thepieces.add(thepiece);
                
                blocks.add(thepiece.getPiece().block[0]);

                blocks.add(thepiece.getPiece().block[1]);

                blocks.add(thepiece.getPiece().block[2]);

                blocks.add(thepiece.getPiece().block[3]);
 
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
            
            for(int t = 0; t < pie.length; t++) {
                if(weedIsStacked(pie[t])
                    ||
                    pie[t].block.y > 560) {

                    pies.add(pie[t]);

                    blocks.add(pie[t].block);

                    clear();
                    
                    java.util.Random r4 = new java.util.Random();

                    int xx = r4.nextInt(12) * 20;

                    int yy = 0;

                    pie[t] = new PieceOfMush();

                    pie[t].block.x = xx;
                    pie[t].block.y = yy;

                    pie[t].kind = "now";
                }
                else {

                    if(pie[t].block.y < 200)
                        pie[t].block.y += 40;
                    else
                        pie[t].block.y += 20;
                }
            }
            
            for(int t = 0; t < bombHorizontally.length; t++) {
                bombHorizontally[t].block.kind = "bomb";
                if(bombIsStacked(bombHorizontally[t])
                    ||
                    bombHorizontally[t].block.y > 560) {

                    bombsHorizontally.add(bombHorizontally[t]);

                    blocks.add(bombHorizontally[t].block);

                    explodeHorizontally();
                    
                    java.util.Random r4 = new java.util.Random();

                    int xx = r4.nextInt(12) * 20;

                    int yy = 0;

                    bombHorizontally[t] = new Bomb();

                    bombHorizontally[t].block.x = xx;
                    bombHorizontally[t].block.y = yy;

                    bombHorizontally[t].kind = "h";
                }
                else {

                    if(bombHorizontally[t].block.y < 220)
                        bombHorizontally[t].block.y += 60;
                    else
                        bombHorizontally[t].block.y += 20;
                }
            }

            for(int t = 0; t < bombVertically.length; t++) {
                bombVertically[t].block.kind = "bomb";
                if(bombIsStacked(bombVertically[t])
                    ||
                    bombVertically[t].block.y > 560) {

                    bombsVertically.add(bombVertically[t]);

                    blocks.add(bombVertically[t].block);

                    explodeVertically();
                    
                    java.util.Random r4 = new java.util.Random();

                    int xx = r4.nextInt(12) * 20;

                    int yy = 0;

                    bombVertically[t] = new Bomb();

                    bombVertically[t].block.x = xx;
                    bombVertically[t].block.y = yy;

                    bombVertically[t].kind = "v";
                }
                else {

                    if(bombVertically[t].block.y < 220)
                        bombVertically[t].block.y += 60;
                    else
                        bombVertically[t].block.y += 20;
                }
            }

            if(topReached(thepiece.getPiece()))
            {
                this.gameDelay = 1290;
                
                this.levelBegin = true;
                
                this.score = 0;
                this.myScore.setText(this.scoreStr + this.score);
                
                this.level = 1;
                this.myLevel.setText("Level " + this.level + " Of 20");

                bombsHorizontally.clear();
                
                pies.clear();
                
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
    
    private void explodeHorizontally()
    {
        java.util.ArrayList<Integer> clearBlocks = new java.util.ArrayList<Integer>();
        for(int line=0; line<=29; line++) {
            int clearThisLine = 0;
            for(int i=0; i<blocks.size(); i++) {
                int x = blocks.get(i).x;
                int y = blocks.get(i).y;
                int theline = line * 20;
                if(blocks.get(i).kind.equals("bomb") && y + 20 == theline) {
                    clearThisLine++;
                    blocks.get(i).kind = "explode";
                } else if(blocks.get(i).kind.equals("bomb") && y == theline) {
                    clearThisLine++;
                    blocks.get(i).kind = "explode";
                }
                System.out.println(blocks.get(i).kind);
                System.out.println("" + clearThisLine);
                if(blocks.get(i).kind.equals("explode") && clearThisLine > 2 && y + 20 == theline) {
                    clearBlocks.add(line);
                } else if(clearThisLine > 11) {
                    clearBlocks.add(line);
                }
            }
        }
        for(int i=0; i<clearBlocks.size(); i++) {
            for(int j=0; j<blocks.size(); j++) {
                if(blocks.get(j).y / 20== clearBlocks.get(i)) {
                    blocks.get(j).y = 10000;
                } else if(blocks.get(j).y / 20< clearBlocks.get(i)) {
                    blocks.get(j).y = blocks.get(j).y + 20;
                }
            }
        }
        panel.paintImmediately(0, 0, 240, 680);
    }
    
    private void explodeVertically()
    {
        java.util.ArrayList<Integer> clearBlocks = new java.util.ArrayList<Integer>();
        for(int line=0; line<=11; line++) {
            int clearThisLine = 0;
            for(int i=0; i<blocks.size(); i++) {
                int x = blocks.get(i).x;
                int y = blocks.get(i).y;
                int theline = line * 20;
                if(blocks.get(i).kind.equals("bomb") && x == theline) {
                    clearThisLine++;
                    blocks.get(i).kind = "explode";
                }
                if(blocks.get(i).kind.equals("explode") && clearThisLine > 0 && x == theline) {
                    clearBlocks.add(line);
                }
            }
        }
        for(int i=0; i<clearBlocks.size(); i++) {
            for(int j=0; j<blocks.size(); j++) {
                if(blocks.get(j).x / 20== clearBlocks.get(i)) {
                    blocks.get(j).x = 1000;
                    blocks.get(j).y = 1000;
                }
            }
        }
        panel.paintImmediately(0, 0, 240, 680);
    }

    private void clear()
    {
        java.util.ArrayList<Integer> clearBlocks = new java.util.ArrayList<Integer>();
        for(int line=0; line<=29; line++) {
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
                if(this.levelScoreUp % 1 == 0 && this.levelBegin == true && this.levelScoreUp != 0) {
                    this.gameDelay -= 120;
                    this.levelBegin = false;
                    this.level++;
                    java.lang.Thread t = new java.lang.Thread(new java.lang.Runnable() {
                        @Override
                        public void run() {
                            if(level <= 20)
                                myLevel.setText("Level " + "" + level + " Of 20");
                        }
                    });
                    t.start();
                    if(this.levelScoreUp == 1) {
                        this.levelScoreUp = 0;
                    }
                    if(this.gameDelay < 600) {
                        this.gameDelay = 600;
                    }
                } else if(this.levelScoreUp % 1 == 0 && this.levelBegin == false) {
                    this.gameDelay -= 120;
                    this.level++;
                    java.lang.Thread t = new java.lang.Thread(new java.lang.Runnable() {
                        @Override
                        public void run() {
                            if(level <= 20)
                                myLevel.setText("Level " + "" + level + " Of 20");
                        }
                    });
                    t.start();
                    if(this.levelScoreUp == 1) {
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
                if(blocks.get(j).y / 20== clearBlocks.get(i)) {
                    blocks.get(j).y = 1000;
                } else if(blocks.get(j).y / 20< clearBlocks.get(i)) {
                    blocks.get(j).y = blocks.get(j).y + 20;
                }
            }
        }
        panel.paintImmediately(0, 0, 240, 680);
    }

    private boolean isLeft(Piece piece)
    {
        for(int h = 0; h < blocks.size(); h++) {
            
            if((piece.block[0].x + 20 == blocks.get(h).x &&
                    piece.block[0].y == blocks.get(h).y)
                ||
                (piece.block[1].x + 20 == blocks.get(h).x &&
                    piece.block[1].y == blocks.get(h).y)
                ||
                (piece.block[2].x + 20 == blocks.get(h).x &&
                    piece.block[2].y == blocks.get(h).y)
                ||
                (piece.block[3].x + 20 == blocks.get(h).x &&
                    piece.block[3].y == blocks.get(h).y)) {
                
                return true;
            }
        }
        
        for(int i = 0; i < thepieces.size(); i++) {
            if(piece != ((ThePiece)thepieces.get(i)).getPiece()) {
                int j = 0;
                do {
                    int k = 0;
                    while(k < ((ThePiece)thepieces.get(i)).getPiece().block.length) {
                        if(piece.block[j].x +20== ((ThePiece)thepieces.get(i)).getPiece().block[k].x
                            &&
                            piece.block[j].y == ((ThePiece)thepieces.get(i)).getPiece().block[k].y) {

                            return true;
                        }
                        k++;
                    }
                    j++;
                } while(j < piece.block.length);
            }
        }
    
        return false;        
    }

    private boolean isRight(Piece piece)
    {
        for(int h = 0; h < blocks.size(); h++) {
            
            if((piece.block[0].x - 20 == blocks.get(h).x &&
                    piece.block[0].y == blocks.get(h).y)
                ||
                (piece.block[1].x - 20 == blocks.get(h).x &&
                    piece.block[1].y == blocks.get(h).y)
                ||
                (piece.block[2].x - 20 == blocks.get(h).x &&
                    piece.block[2].y == blocks.get(h).y)
                ||
                (piece.block[3].x - 20 == blocks.get(h).x &&
                    piece.block[3].y == blocks.get(h).y)) {
                
                return true;
            }
        }
        
        for(int i = 0; i < thepieces.size(); i++) {
            if(piece != ((ThePiece)thepieces.get(i)).getPiece()) {
                int j = 0;
                do {
                    int k = 0;
                    while(k < ((ThePiece)thepieces.get(i)).getPiece().block.length) {
                        if(piece.block[j].x -20== ((ThePiece)thepieces.get(i)).getPiece().block[k].x                            &&
                            piece.block[j].y == ((ThePiece)thepieces.get(i)).getPiece().block[k].y) {

                            return true;
                        }
                        k++;
                    }
                    j++;
                } while(j < piece.block.length);
            }
        }
    
        return false;        
    }

    private boolean topReached(Piece piece)
    {
        for(int i = 0; i < thepieces.size(); i++) {
            if(piece != ((ThePiece)thepieces.get(i)).getPiece()) {
                int j = 0;
                do {
                    int k = 0;
                    while(k < ((ThePiece)thepieces.get(i)).getPiece().block.length) {
                        if(piece.block[0].y == 40) {
                            if((piece.block[j].x == ((ThePiece)thepieces.get(i)).getPiece().block[k].x) &&
                                    (piece.block[j].y == ((ThePiece)thepieces.get(i)).getPiece().block[k].y)) {

                                return true;
                            }
                        }
                        k++;
                    }
                    j++;
                } while(j < piece.block.length);
            }
        }
    
        return false;        
    }

    public boolean bombIsStacked(Bomb bomb)
    {
        for(int i = 0; i < blocks.size(); i++) {
            
            if(blocks.get(i).x == bomb.block.x &&
               blocks.get(i).y - 20 == bomb.block.y) {

                return true;
            }
        }
        
        return false;
    }

    public boolean weedIsStacked(PieceOfMush pie)
    {
        for(int i = 0; i < blocks.size(); i++) {
            
            if(blocks.get(i).x == pie.block.x &&
               blocks.get(i).y - 20 == pie.block.y) {

                return true;
            }
        }
        
        return false;
    }
    
    public boolean stacked(Piece piece)
    {
        for(int h = 0; h < pies.size(); h++) {
            int g = 0;
            do {
                if(piece.block[g].x == ((PieceOfMush)pies.get(h)).block.x
                    &&
                    piece.block[g].y + 20 == ((PieceOfMush)pies.get(h)).block.y) {

                    return true;
                }
                g++;
            } while(g < piece.block.length);
        }
        
        for(int h = 0; h < bombsHorizontally.size(); h++) {
            int g = 0;
            do {
                if(piece.block[g].x == ((Bomb)bombsHorizontally.get(h)).block.x
                    &&
                    piece.block[g].y + 20 == ((Bomb)bombsHorizontally.get(h)).block.y) {

                    return true;
                }
                g++;
            } while(g < piece.block.length);
        }

        for(int i = 0; i < thepieces.size(); i++) {
            if((piece != ((ThePiece)thepieces.get(i)).getPiece())) {
                int f = 0;
                do {
                    int e = 0;
                    while(e < ((ThePiece)thepieces.get(i)).getPiece().block.length) {
                        if(piece.block[f].x == ((ThePiece)thepieces.get(i)).getPiece().block[e].x
                            &&
                            piece.block[f].y + 20== ((ThePiece)thepieces.get(i)).getPiece().block[e].y) {

                            return true;
                        }
                        e++;
                    }
                    f++;
                } while(f < piece.block.length);
            }
        }
        
        return false;
    }
    
    public void BuildTetrisGuiAndEngineOfTheGame()
    {
        frame.setTitle("Weedtris");
        
        frame.setResizable(false);
        
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        
        frame.setSize(new java.awt.Dimension(400, 640));

        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        
        panel.setSize(new java.awt.Dimension(260, 640));
        
        panel.setLocation(140, 0);       
        
        panelZero.setLayout(null);
        panelZero.setSize(new java.awt.Dimension(140, 640));
        panelZero.setLocation(0, 0);

        panelZero.setBackground(new java.awt.Color(210, 210, 210));        
 
        panel.setBackground(new java.awt.Color(0, 0, 0));

        frame.add(panelZero);

        panelZero.add(panel);
        
        myScore.setText(this.scoreStr + this.score);
        
        panelZero.add(myScore);
        
        myLevel.setText(this.levelStr + this.level + " Of 20");

        this.myScore.setForeground(new java.awt.Color(255, 0, 0));
        this.myScore.setFont(new java.awt.Font("Tahoma",java.awt.Font.PLAIN,16));
      
        myScore.setLocation(0, 0);
        myScore.setSize(new java.awt.Dimension(200, 30));

        this.myLevel.setForeground(new java.awt.Color(255, 0, 0));
        this.myLevel.setFont(new java.awt.Font("Tahoma",java.awt.Font.ITALIC,16));
      
        myLevel.setLocation(0, 50);
        myLevel.setSize(new java.awt.Dimension(200, 30));
        
        panelZero.add(myLevel);
        
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
       
        frame.show();
        
        this.frame.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyTyped(java.awt.event.KeyEvent e) {

            }

            public void keyPressed(java.awt.event.KeyEvent e) {

                if(e.getKeyCode() == java.awt.event.KeyEvent.VK_LEFT)
                {
                    if(isRight(thepiece.getPiece())) {

                        return;
                    }

                    if(thepiece.getPiece().block[0].x > 0 &&
                            thepiece.getPiece().block[1].x > 0 &&
                            thepiece.getPiece().block[2].x > 0 &&
                            thepiece.getPiece().block[3].x > 0)
                        thepiece.moveLeft();

                    panel.paintImmediately(0, 0, 240, 680);

                    for(int i = 0; i < thepieces.size(); i++)
                    {
                        if(thepieces == null || thepieces.get(i) == null) {
                            System.exit(-1);
                        }
                        ((ThePiece)thepieces.get(i)).drawImage();
                    }     

                    for(int i = 0; i < bombsHorizontally.size(); i++)
                    {
                        ((Bomb)bombsHorizontally.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < bombHorizontally.length; s++) {

                        bombHorizontally[s].drawImage(frame, panel);
                    }

                    for(int i = 0; i < bombsVertically.size(); i++)
                    {
                        ((Bomb)bombsVertically.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < bombVertically.length; s++) {

                        bombVertically[s].drawImage(frame, panel);
                    }

                    for(int i = 0; i < pies.size(); i++)
                    {
                        ((PieceOfMush)pies.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < pie.length; s++) {

                        pie[s].drawImage(frame, panel);
                    }
                }

                else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_RIGHT)
                {
                    if(isLeft(thepiece.getPiece())) {

                        return;
                    }
                    
                    if(thepiece.getPiece().block[0].x < 220 &&
                            thepiece.getPiece().block[1].x < 220 &&
                            thepiece.getPiece().block[2].x < 220 &&
                            thepiece.getPiece().block[3].x < 220)
                        thepiece.moveRight();

                    panel.paintImmediately(0, 0, 240, 680);

                    for(int i = 0; i < thepieces.size(); i++)
                    {
                        if(thepieces == null || thepieces.get(i) == null) {
                            System.exit(-1);
                        }
                        ((ThePiece)thepieces.get(i)).drawImage();
                    }     

                    for(int i = 0; i < bombsHorizontally.size(); i++)
                    {
                        ((Bomb)bombsHorizontally.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < bombHorizontally.length; s++) {

                        bombHorizontally[s].drawImage(frame, panel);
                    }

                    for(int i = 0; i < bombsVertically.size(); i++)
                    {
                        ((Bomb)bombsVertically.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < bombVertically.length; s++) {

                        bombVertically[s].drawImage(frame, panel);
                    }

                    for(int i = 0; i < pies.size(); i++)
                    {
                        ((PieceOfMush)pies.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < pie.length; s++) {

                        pie[s].drawImage(frame, panel);
                    }
                }
                
                else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_DOWN)
                {
                    if(stacked(thepiece.getPiece())
                            ||
                            thepiece.getPiece().block[0].y > 560
                            || 
                            thepiece.getPiece().block[1].y > 560 
                            || 
                            thepiece.getPiece().block[2].y > 560 
                            || 
                            thepiece.getPiece().block[3].y > 560) {

                        thepieces.add(thepiece);

                        blocks.add(thepiece.getPiece().block[0]);

                        blocks.add(thepiece.getPiece().block[1]);

                        blocks.add(thepiece.getPiece().block[2]);

                        blocks.add(thepiece.getPiece().block[3]);

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

                    panel.paintImmediately(0, 0, 240, 680);

                    for(int i = 0; i < thepieces.size(); i++)
                    {
                        if(thepieces == null || thepieces.get(i) == null) {

                            System.exit(-1);
                        }

                        else {
                            ((ThePiece)thepieces.get(i)).drawImage();
                        }
                    }

                    for(int i = 0; i < bombsHorizontally.size(); i++)
                    {
                        ((Bomb)bombsHorizontally.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < bombHorizontally.length; s++) {

                        bombHorizontally[s].drawImage(frame, panel);
                    }

                    for(int i = 0; i < bombsVertically.size(); i++)
                    {
                        ((Bomb)bombsVertically.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < bombVertically.length; s++) {

                        bombVertically[s].drawImage(frame, panel);
                    }
 
                    for(int i = 0; i < pies.size(); i++)
                    {
                        ((PieceOfMush)pies.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < pie.length; s++) {

                        pie[s].drawImage(frame, panel);
                    }
                }

                else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_UP)
                {
                    panel.paintImmediately(0, 0, 240, 680);

                    thepiece.computeNextRotation();

                    if(thepiece.getPiece().block[0].x > 480 &&
                            thepiece.getPiece().block[1].x > 480 &&
                            thepiece.getPiece().block[2].x > 480 &&
                            thepiece.getPiece().block[3].x > 680) {
                        thepiece.getPiece().block[0].x -= 80;
                        thepiece.getPiece().block[1].x -= 80;
                        thepiece.getPiece().block[2].x -= 80;
                        thepiece.getPiece().block[3].x -= 80;
                    }
                    
                    for(int i = 0; i < thepieces.size(); i++)
                    {

                        if(thepieces == null || thepieces.get(i) == null) {
                            System.exit(-1);
                        }
                        
                        ((ThePiece)thepieces.get(i)).drawImage();
                    }     

                    for(int i = 0; i < bombsHorizontally.size(); i++)
                    {
                        ((Bomb)bombsHorizontally.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < bombHorizontally.length; s++) {

                        bombHorizontally[s].drawImage(frame, panel);
                    }

                    for(int i = 0; i < bombsVertically.size(); i++)
                    {
                        ((Bomb)bombsVertically.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < bombVertically.length; s++) {

                        bombVertically[s].drawImage(frame, panel);
                    }

                    for(int i = 0; i < pies.size(); i++)
                    {
                        ((PieceOfMush)pies.get(i)).drawImage(frame, panel);
                    }    

                    for(int s = 0; s < pie.length; s++) {

                        pie[s].drawImage(frame, panel);
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