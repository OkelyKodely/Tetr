public class PieceOfMush {
 
    public Block block1;
    
    public String kind = "";
    
    public PieceOfMush() {
        
        block1 = new Block();
    }
    
    public void drawImage(javax.swing.JFrame frame, javax.swing.JPanel panel)
    {        
        java.awt.Image img = null;

        try {

            String image = "mushroom.jpg";
            javax.swing.ImageIcon i = new javax.swing.ImageIcon(this.getClass().getResource(image));
            img = i.getImage();

        } catch(Exception e) {
        }

        java.awt.Graphics g = panel.getGraphics();
        
        g.drawImage(img, block1.x, block1.y, 20, 20, frame);
   }
}