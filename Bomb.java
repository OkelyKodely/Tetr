public class Bomb {
 
    public Block block;
    
    public String kind = "";
    
    public Bomb() {
        
        block = new Block();
    }
    
    public void drawImage(javax.swing.JFrame frame, javax.swing.JPanel panel)
    {        
        java.awt.Image img = null;

        try {

            String image = "bomb.png";
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
            img = i.getImage();

        } catch(Exception e) {
        }

        java.awt.Graphics g = panel.getGraphics();
        
        g.drawImage(img, block.x, block.y, 20, 20, frame);
   }
}