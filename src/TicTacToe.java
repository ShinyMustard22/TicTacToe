import java.awt.BasicStroke;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;


public class TicTacToe extends JFrame implements MouseListener {

    private final JPanel panel;
    private int height;
    private int margin;
    private final boolean[][] tiles;
    private boolean isCross;

    public TicTacToe() {
        super("Tic-Tac-Toe");
        setBounds(0, 0, 600, 600);

        tiles = new boolean[3][3];
        isCross = true;

        panel = new JPanel();
        panel.addMouseListener(this);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        height = getHeight() - getInsets().top;
        margin = height / 48;

        g2.drawLine(margin, height / 3 + getInsets().top, getWidth() - margin, height / 3 + getInsets().top);
        g2.drawLine(margin, height / 3 * 2 + getInsets().top, getWidth() - margin, height / 3 * 2 + getInsets().top);
        g2.drawLine(getWidth() / 3, margin + getInsets().top , getWidth() / 3, getHeight() - margin);
        g2.drawLine(getWidth() / 3 * 2, margin + getInsets().top, getWidth() / 3 * 2, getHeight() - margin);

        g2.setStroke(new BasicStroke(margin * 2));
        g2.drawRect(0, getInsets().top, getWidth(), height);
    }

    private void displayImage(ImageIcon icon, int row, int col) {
        // Will draw the image onto the JFrame
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() < margin || e.getX() > getWidth() - margin || 
            e.getY() < margin || e.getY() > height - margin) {
            return;
        }

        int row = (int) ((double) (e.getX() - margin) / (getWidth() - 2 * margin) * 3);
        int col = (int) ((double) (e.getY() - margin) / (height - 2 * margin) * 3);

        if (tiles[row][col]) {
            // Play *beep* sound...
            return;
        }

        ImageIcon icon;

        if (isCross) {
            icon = new ImageIcon(/*Should access cross image*/);
            isCross = false;
        }

        else {
            icon = new ImageIcon(/*Should access circle image*/);
            isCross = true;
        }

        tiles[row][col] = true;
        displayImage(icon, row, col);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
