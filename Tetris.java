public class Tetris {
 
    public String str = "";
    
    public int pic1 = 28, pic2 = 29, pic3 = 30;

    public javax.swing.JFrame frame = new javax.swing.JFrame();
 
    public javax.swing.JPanel panelZero = new javax.swing.JPanel();
     
    public javax.swing.JPanel panel = new javax.swing.JPanel();

    public javax.swing.JPanel panelS = new javax.swing.JPanel();

    public java.util.ArrayList thepieces = new java.util.ArrayList();
    
    public java.util.ArrayList pies = new java.util.ArrayList();

    public java.util.ArrayList bombsHorizontally = new java.util.ArrayList();

    public java.util.ArrayList bombsVertically = new java.util.ArrayList();

    public java.util.ArrayList bombsRandomnlly = new java.util.ArrayList();

    public java.util.ArrayList<Block> blocks = new java.util.ArrayList<Block>();

    public int score = 0;

    public boolean levelBegin = true;

    public int levelScoreUp = 0;
    
    public int level = 10;
    
    public ThePiece thepiece = null;
    
    public PieceOfMush[] pie = null;
    
    public Bomb[] bombHorizontally = null;

    public Bomb[] bombVertically = null;

    public Bomb[] bombRandomnlly = null;

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
    
    private void GetNewPiece()
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
    }
    
    private void GetNewBombHorizontal()
    {
        java.util.Random r = new java.util.Random();

        bombHorizontally = new Bomb[1];

        for(int q=0; q<bombHorizontally.length; q++) {
            int x = r.nextInt(12) * 20;

            int y = 0;

            bombHorizontally[q] = new Bomb();
            bombHorizontally[q].block.x = x;
            bombHorizontally[q].block.y = y;

            bombHorizontally[q].kind = "h";
        }
    }
    
    private void GetNewBombVertical()
    {
        java.util.Random r = new java.util.Random();

        bombVertically = new Bomb[1];

        for(int q=0; q<bombVertically.length; q++) {
            int x = r.nextInt(12) * 20;

            int y = 0;

            bombVertically[q] = new Bomb();
            bombVertically[q].block.x = x;
            bombVertically[q].block.y = y;

            bombVertically[q].kind = "v";
        }
    }

    private void GetNewBombRandom()
    {
        java.util.Random r3 = new java.util.Random();

        bombRandomnlly = new Bomb[1];

        for(int q=0; q<bombRandomnlly.length; q++) {
            int x = r3.nextInt(12) * 20;

            int y = 0;

            bombRandomnlly[q] = new Bomb();
            bombRandomnlly[q].block.x = x;
            bombRandomnlly[q].block.y = y;

            bombRandomnlly[q].kind = "r";
        }
    }
    
    private void GoDownBombHorizontal(int t)
    {
        if(bombHorizontally[t].block.y < 220)
            bombHorizontally[t].block.y += 60;
        else
            bombHorizontally[t].block.y += 20;
    }

    private void GoDownBombVertical(int t)
    {
        if(bombVertically[t].block.y < 220)
            bombVertically[t].block.y += 60;
        else
            bombVertically[t].block.y += 20;
    }

    private void GoDownBombRandom(int t)
    {
        if(bombRandomnlly[t].block.y < 220)
            bombRandomnlly[t].block.y += 60;
        else
            bombRandomnlly[t].block.y += 20;
    }

    public void RunAndPlay()
    {
        java.util.Random r1 = new java.util.Random();
        
        GetNewPiece();

        GetNewBombHorizontal();
        
        GetNewBombVertical();
        
        GetNewBombRandom();

        pie = new PieceOfMush[2];

        for(int q=0; q<2; q++) {
            int x = r1.nextInt(12) * 20;

            int y = 0;

            pie[q] = new PieceOfMush();
            pie[q].block.x = x;
            pie[q].block.y = y;

            pie[q].kind = "now";
        }
        
        while(true)
        {
            Draw();
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

                GetNewPiece();

            } else {
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
                    
                    clear();
                    
                    java.util.Random r4 = new java.util.Random();

                    int xx = r4.nextInt(12) * 20;

                    int yy = 0;

                    GetNewBombHorizontal();
                }
                else {

                    GoDownBombHorizontal(t);
                }
            }

            for(int t = 0; t < bombVertically.length; t++) {
                bombVertically[t].block.kind = "vert";
                if(bombIsStacked(bombVertically[t])
                    ||
                    bombVertically[t].block.y > 560) {

                    bombsVertically.add(bombVertically[t]);
                    
                    blocks.add(bombVertically[t].block);

                    explodeVertically();
                    
                    clear();
                    
                    GetNewBombVertical();
                }
                else {

                    GoDownBombVertical(t);
                }
            }

            for(int t = 0; t < bombRandomnlly.length; t++) {
                bombRandomnlly[t].block.kind = "bomb";
                if(bombIsStacked(bombRandomnlly[t])
                    ||
                    bombRandomnlly[t].block.y > 560) {

                    bombsVertically.add(bombRandomnlly[t]);

                    blocks.add(bombRandomnlly[t].block);

                    explodeRandomnly();
                    
                    clear();
                    
                    GetNewBombRandom();
                }
                else {

                    GoDownBombRandom(t);
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
                bombsVertically.clear();
                bombsRandomnlly.clear();
                pies.clear();
                thepieces.clear();
                blocks.clear();
                
                GetNewPiece();
            }
        }
    }

    public void Draw()
    {
        try {
            Thread.sleep(gameDelay);

        } catch(Exception e) {}
        try {
            String image = "background.gif";
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
            java.awt.Image img = i.getImage();
            java.awt.Graphics g = panel.getGraphics();
            g.drawImage(img, 0, 0, panel.getWidth(), panel.getHeight(), null);
        } catch(Exception ex) {System.out.println(ex.getMessage());}
        for(int i = 0; i < thepieces.size(); i++) {

            ((ThePiece)thepieces.get(i)).drawImage();
        }    
        for(int i = 0; i < bombsHorizontally.size(); i++) {

            ((Bomb)bombsHorizontally.get(i)).drawImage(frame, panel);
        }    
        for(int s = 0; s < bombHorizontally.length; s++) {

            bombHorizontally[s].drawImage(frame, panel);
        }
        for(int i = 0; i < bombsVertically.size(); i++) {

            ((Bomb)bombsVertically.get(i)).drawImage(frame, panel);
        }    
        for(int s = 0; s < bombVertically.length; s++) {

            bombVertically[s].drawImage(frame, panel);
        }
        for(int i = 0; i < bombsRandomnlly.size(); i++) {

            ((Bomb)bombsRandomnlly.get(i)).drawImage(frame, panel);
        }    
        for(int s = 0; s < bombRandomnlly.length; s++) {

            bombRandomnlly[s].drawImage(frame, panel);
        }
        for(int i = 0; i < pies.size(); i++) {

            ((PieceOfMush)pies.get(i)).drawImage(frame, panel);
        }    
        for(int s = 0; s < pie.length; s++) {

            pie[s].drawImage(frame, panel);
        }
    }

    public void explodeRandomnly()
    {
        java.util.Random r = new java.util.Random();
        for(int i = 0; i < 2; i++) {
            int x = r.nextInt(blocks.size());
            blocks.get(x).y = 10000;
            blocks.get(x).y = 10000;
        }
        try {
            String image = "background.gif";
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
            java.awt.Image img = i.getImage();
            java.awt.Graphics g = panel.getGraphics();
            g.drawImage(img, 0, 0, panel.getWidth(), panel.getHeight(), null);
        } catch(Exception ex) {System.out.println(ex.getMessage());}
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
        try {
            String image = "background.gif";
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
            java.awt.Image img = i.getImage();
            java.awt.Graphics g = panel.getGraphics();
            g.drawImage(img, 0, 0, panel.getWidth(), panel.getHeight(), null);
        } catch(Exception ex) {System.out.println(ex.getMessage());}
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
                if(blocks.get(i).kind.equals("vert") && x == theline) {
                    clearThisLine++;
                    blocks.get(i).kind = "vert";
                }
                if(blocks.get(i).kind.equals("vert") && clearThisLine > 1 && x == theline) {
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
        try {
            String image = "background.gif";
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
            java.awt.Image img = i.getImage();
            java.awt.Graphics g = panel.getGraphics();
            g.drawImage(img, 0, 0, panel.getWidth(), panel.getHeight(), null);
        } catch(Exception ex) {System.out.println(ex.getMessage());}
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
                    if(this.level != 11) {
                        if(pic1 < 60) {
                            pic1 += 3;
                        }
                        if(pic2 < 60) {
                            pic2 += 3;
                        }
                        if(pic3 < 60) {
                            pic3 += 3;
                        }
                        if(this.level == 20) {
                            pic1 = 1;
                            pic2 = 2;
                            pic3 = 3;
                        }
                    } else if(this.level == 11) {
                        pic1 = 1;
                        pic2 = 2;
                        pic3 = 3;
                    }
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
                    if(this.level != 11) {
                        if(pic1 < 60) {
                            pic1 += 3;
                        }
                        if(pic2 < 60) {
                            pic2 += 3;
                        }
                        if(pic3 < 60) {
                            pic3 += 3;
                        }
                        if(this.level == 20) {
                            pic1 = 1;
                            pic2 = 2;
                            pic3 = 3;
                        }
                    } else if(this.level == 11) {
                        pic1 = 1;
                        pic2 = 2;
                        pic3 = 3;
                    }
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
                    
        try {
            String image = "background.gif";
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
            java.awt.Image img = i.getImage();
            java.awt.Graphics g = panel.getGraphics();
            g.drawImage(img, 0, 0, panel.getWidth(), panel.getHeight(), null);
        } catch(Exception ex) {System.out.println(ex.getMessage());}
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
        try {
            String image = "icon.png";
            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(getClass().getClassLoader().getResource(image));
            frame.setIconImage(icon.getImage());
        } catch(Exception e) {System.out.println(e.getMessage());}

        frame.setResizable(false);
        
        frame.setTitle("By Daniel Cho, released on 4/4/2018");
        
        java.awt.Dimension dim = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        
        frame.setSize(new java.awt.Dimension(400, 640));

        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        
        panel.setSize(new java.awt.Dimension(260, 640));
        
        panel.setLocation(140, 0);       
        
        panelZero.setLayout(null);
        panelZero.setSize(new java.awt.Dimension(140, 640));
        panelZero.setLocation(0, 0);

        panelZero.setBackground(new java.awt.Color(210, 210, 210));        
        
        javax.swing.JPanel panelS = new javax.swing.JPanel();
        panelS.setSize(new java.awt.Dimension(130, 140));
        panelS.setLocation(10, 100);
        
        panelZero.add(panelS);
 
        javax.swing.JPanel panelM = new javax.swing.JPanel();
        panelM.setSize(new java.awt.Dimension(130, 140));
        panelM.setLocation(10, 260);

        panelZero.add(panelM);

        javax.swing.JPanel panelF = new javax.swing.JPanel();
        panelF.setSize(new java.awt.Dimension(130, 140));
        panelF.setLocation(10, 410);

        panelZero.add(panelF);

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
        
        java.lang.Thread t = new java.lang.Thread(new java.lang.Runnable() {
            public void run() {
                while(true) {
                    java.awt.Image img = null;
                    try {

                        String image = pic1 + ".gif";
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
                        img = i.getImage();

                        java.awt.Graphics g = panelS.getGraphics();
                        g.drawImage(img, 0, 0, 130, 140, panelS);

                    } catch(Exception e) {}

                    try {

                        String image = pic2 + ".gif";
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
                        img = i.getImage();

                        java.awt.Graphics g = panelM.getGraphics();
                        g.drawImage(img, 0, 0, 130, 140, panelM);

                    } catch(Exception e) {}

                    try {

                        String image = pic3 + ".gif";
                        javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
                        img = i.getImage();

                        java.awt.Graphics g = panelF.getGraphics();
                        g.drawImage(img, 0, 0, 130, 140, panelF);

                    } catch(Exception e) {}
                }
            }
        });
        t.start();
        
        this.frame.addKeyListener(new java.awt.event.KeyAdapter() {

            public void keyTyped(java.awt.event.KeyEvent e) {

            }

            public void keyPressed(java.awt.event.KeyEvent e) {

                try {
                    String image = "background.gif";
                    javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
                    java.awt.Image img = i.getImage();
                    java.awt.Graphics g = panel.getGraphics();
                    g.drawImage(img, 0, 0, panel.getWidth(), panel.getHeight(), null);
                } catch(Exception ex) {System.out.println(ex.getMessage());}

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

                        DrawPieces();
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

                        DrawPieces();
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
                        
                        GetNewPiece();
                    
                    } else {
                        thepiece.moveDown();
                    }

                    DrawPieces();
                }

                else if(e.getKeyCode() == java.awt.event.KeyEvent.VK_UP)
                {
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

                    DrawPieces();
                }
            }

            public void keyReleased(java.awt.event.KeyEvent e) {
            }
        });
    }

    private void DrawPieces()
    {
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

        for(int i = 0; i < bombsRandomnlly.size(); i++)
        {
            ((Bomb)bombsRandomnlly.get(i)).drawImage(frame, panel);
        }    

        for(int s = 0; s < bombRandomnlly.length; s++) {

            bombRandomnlly[s].drawImage(frame, panel);
        }

        for(int i = 0; i < pies.size(); i++)
        {
            ((PieceOfMush)pies.get(i)).drawImage(frame, panel);
        }    

        for(int s = 0; s < pie.length; s++) {

            pie[s].drawImage(frame, panel);
        }
    }

    public static void main(String[] args) {

        Tetris tetris = new Tetris();
    }
}