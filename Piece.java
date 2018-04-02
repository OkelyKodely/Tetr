public class Piece {
 
    public Block block1, block2, block3, block4;
    
    public void drawImage(javax.swing.JFrame frame, javax.swing.JPanel panel)
    {        
        java.awt.Image img = null;

        try {

            String image = "block.png";
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
            img = i.getImage();

        } catch(Exception e) {
        }

        java.awt.Graphics g = panel.getGraphics();
        
        g.drawImage(img, block1.x, block1.y, 20, 20, frame);
        
        g.drawImage(img, block2.x, block2.y, 20, 20, frame);

        g.drawImage(img, block3.x, block3.y, 20, 20, frame);

        g.drawImage(img, block4.x, block4.y, 20, 20, frame);        
    }
}