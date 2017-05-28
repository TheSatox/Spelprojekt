

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class player implements Runnable {

    int x, y, yDirection, id;

    Rectangle player;
    /* draws the players **/
    public player(int x, int y, int id){
        this.x = x;
        this.y = y;
        this.id = id;
        player = new Rectangle(x, y, 10, 50);
    }
    /* looks for key actions to move players **/
    public void keyPressed(KeyEvent e){
        switch (id){
            default:
                System.out.println("Var god ange giltig ID i spelarkonstruktorn");
                break;
            case 1:
                if(e.getKeyCode() == e.VK_W){
                    setYDirection(1);
                }
                if (e.getKeyCode() == e.VK_S) {
                    setYDirection(-1);
                }
                break;
            case 2:
                if (e.getKeyCode() == e.VK_UP) {
                    setYDirection(-1);
                }
                if (e.getKeyCode() == e.VK_DOWN){
                    setYDirection(1);
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e){
        switch (id){
            default:
                System.out.println("Var god ange giltig ID i spelarkonstruktorn");
                break;
            case 1:
                if(e.getKeyCode() == e.VK_W){
                    setYDirection(-1);
                }
                if (e.getKeyCode() == e.VK_S) {
                    setYDirection(1);
                }
                break;
            case 2:
                if (e.getKeyCode() == e.VK_UP) {
                    setYDirection(1);
                }
                if (e.getKeyCode() == e.VK_DOWN){
                    setYDirection(-1);
                }
                break;
        }
    }

    public void setYDirection(int ydir) {

        yDirection = ydir;
    }
    /* stops player if they move to the edge **/
    public void move(){
        player.y += yDirection;
        if(player.y <= 25)
            player.y = 25;
        if (player.y >= 450)
            player.y = 450;
    }
    /* fills out players with colors **/
    public void draw(Graphics g){
        switch(id){
            default:
                System.out.println("Var god ange giltig ID i spelarkonstruktorn");
                break;
            case 1:
                g.setColor(Color.BLUE);
                g.fillRect(player.x, player.y, player.width, player.height);
                break;
            case 2:
                g.setColor(Color.RED);
                g.fillRect(player.x, player.y, player.width, player.height);
                break;

        }
    }
    /* sets speed for the player **/
    public void run(){
        try{
            while(true){
                move();
                Thread.sleep(3);
            }
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
