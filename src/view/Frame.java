
package view;

import controller.Control;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Pardo
 */
public class Frame {
    private final JFrame ventana;
    private final JPanel principal;
    private final Panel top_left;
    private final Panel top_center;
    private final Panel top_right;
    private final Panel middle_left;
    private final Panel middle_center;
    private final Panel middle_right;
    private final Panel bottom_left;
    private final Panel bottom_center;
    private final Panel bottom_right;
    /**
     * Inicializa todos los componentes.
     */
    public Frame() {
        
        ventana = new JFrame();
        principal = new JPanel(new GridLayout(3, 3));
        top_left = new Panel();
        principal.add(top_left);
        top_center = new Panel();
        principal.add(top_center);
        top_right = new Panel();
        principal.add(top_right);
        middle_left = new Panel();
        principal.add(middle_left);
        middle_center = new Panel();
        principal.add(middle_center);
        middle_right = new Panel();
        principal.add(middle_right);
        bottom_left = new Panel();
        principal.add(bottom_left);
        bottom_center = new Panel();
        principal.add(bottom_center);
        bottom_right = new Panel();
        principal.add(bottom_right);
        
        Control controller = new Control();
        top_left.addMouseListener(controller);
        top_center.addMouseListener(controller);
        top_right.addMouseListener(controller);
        middle_left.addMouseListener(controller);
        middle_center.addMouseListener(controller); 
        middle_right.addMouseListener(controller);
        bottom_left.addMouseListener(controller);
        bottom_center.addMouseListener(controller); 
        bottom_right.addMouseListener(controller);
    }

    /**
     * Organiza y muestra todos los componentes.
     */
    public void init() {
        ventana.setPreferredSize(new Dimension(400, 400));
        ventana.add(principal);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.pack();


   

        top_left.setBorder(new MatteBorder(0, 0, 2, 2, Color.black));
        top_center.setBorder(new MatteBorder(0, 0, 2, 2, Color.black));
        top_right.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
        middle_left.setBorder(new MatteBorder(0, 0, 2, 2, Color.black));
        middle_center.setBorder(new MatteBorder(0, 0, 2, 2, Color.black));
        middle_right.setBorder(new MatteBorder(0, 0, 2, 0, Color.black));
        bottom_left.setBorder(new MatteBorder(0, 0, 0, 2, Color.black));
        bottom_right.setBorder(new MatteBorder(0, 2, 0, 0, Color.black));
        
        
        top_left.setName("1");
        top_center.setName("2");
        top_right.setName("3");
        middle_left.setName("4");
        middle_center.setName("5");
        middle_right.setName("6");
        bottom_left.setName("7");
        bottom_center.setName("8");
        bottom_right.setName("9");

        ventana.setVisible(true);
    }



}
