

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;



public class pong extends JFrame {


    Image dbImage;
    Graphics dbg;
    /* Creates a new boll and a field **/
    static boll b = new boll(250, 250);

    int
    GWIDTH = 500,
    GHEIGHT = 500;

    Dimension fieldSize = new Dimension (GWIDTH, GHEIGHT);
    /* sets up parameters for the game **/
    public pong(){
        this.setTitle("Unfair Pong");
        this.setSize(fieldSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        this.addKeyListener(new AL());
    }
    /* creates the game and runs it**/
    public static void main(String args[]) {
        pong p = new pong();
        Thread boll = new Thread(b);
        boll.start();
        Thread p1 = new Thread(b.p1);
        Thread p2 = new Thread(b.p2);
        p1.start();
        p2.start();
    }
    public void paint(Graphics g){
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        draw(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }
    public void draw(Graphics g){
        b.draw(g);
        b.p1.draw(g);
        b.p2.draw(g);

        g.setColor(Color.WHITE);
        g.drawString(""+b.p1Score, 30, 50);
        g.drawString(""+b.p2Score, 470, 50);

        repaint();

    }
    /* looks for key actions **/
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            b.p1.keyPressed(e);
            b.p2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e){
            b.p1.keyReleased(e);
            b.p2.keyReleased(e);
        }
    }

}