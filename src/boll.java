

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class boll implements Runnable{

    int x, y, xDirection, yDirection;

    int p1Score, p2Score;
    /* places out the players **/
    player p1 = new player(5, 250, 1);
    player p2 = new player(485, 250, 2);

    Rectangle boll;
    /* various attributes for the boll **/
    public boll(int x, int y){
        p1Score = p2Score = 0;
        this.x = x;
        this.y = y;
        Random r = new Random();
        int rDir = r.nextInt(1);
        if(rDir == 0)
            rDir--;
        setXDirection(rDir);
        int yrDir = r.nextInt(1);
        if(yrDir == 0);
            yrDir--;
        setYDirection(yrDir);
        boll = new Rectangle(this.x, this.y, 15, 15);
    }

    public void setXDirection(int xdir){

        xDirection = xdir;
    }
    public void setYDirection(int ydir){

        yDirection = ydir;
    }
    /* paints the ball white **/
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(boll.x, boll.y, boll.width, boll.height);
    }
    /* reacts to collisions between the ball and player **/
    public void collision(){
        if(boll.intersects(p1.player))
            setXDirection(+3);
        if(boll.intersects(p2.player))
            setXDirection(-3);
    }
    /* movement of the ball **/
    public void move() {
        collision();
        boll.x += xDirection;
        boll.y += yDirection;
        if (boll.x <= 0) {
            setXDirection(+6);
            setYDirection(-2);
            p2Score++;
        }
        if (boll.x >= 485) {
            setXDirection(-3);
            setYDirection(+5);
            p1Score++;
        }
        if (boll.y <= 15)
            setYDirection(+4);
        if (boll.y >= 485)
            setYDirection(-3);

    }
    public void run(){
        try{
            while(true){
                move();
                Thread.sleep(7);
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
