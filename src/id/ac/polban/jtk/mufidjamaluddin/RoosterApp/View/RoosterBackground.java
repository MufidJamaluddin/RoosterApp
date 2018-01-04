/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.mufidjamaluddin.RoosterApp.View;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author mufidjamaluddin
 */
public class RoosterBackground extends JPanel {

    private final Random random;
    private Graphics2D g2d;
    private GradientPaint gp;
    private Color color1, color2;
    private static Float float1, float2, float3;
    
    public RoosterBackground()
    {
        this.random = new Random();
    }
    
    /**
     * @return the g2d
     */
    public Graphics2D getG2d() 
    {
        return g2d;
    }
    
    /**
     * Mengubah Warna
     */
    public void changeColor()
    {
        //if(float1 == null && float2 == null && float3 == null)
       // {
            float1 = random.nextFloat();
            float2 = random.nextFloat();
            float3 = random.nextFloat();
       // }
        color1 = new Color(float1, float2, float3);
        color2 = color1.brighter();
    }
    
    /**
     * Menggambar Backgrund warna gradient
     */
    public void drawBackground()
    {
        gp = new GradientPaint(0, 0, color1, 0, getHeight(), color2);
        getG2d().setPaint(gp);
        getG2d().fillRect(0, 0, getWidth(), getHeight());
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        this.g2d = (Graphics2D) g;
        getG2d().setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        getG2d().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        /**
         * Background
         */
        this.changeColor();
        this.drawBackground();
    }

}
