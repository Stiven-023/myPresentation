import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class Presentation extends JFrame {
    //
    JPanel panelTexto, panelImagen,panelBoton;

    JLabel miTexto,miFoto;

    //Elementos del panelBoton
    JButton bCreoQue,bHobbies,bYo;
    Container containerPp;

    JTextArea expectativas;


    public Presentation()  {


        //Constructor
        super("My Presentation");
        //estoy asociando un contenedor al jframe
        containerPp = this.getContentPane();
        this.setSize(600,400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Instanciando o creando un objeto de la clase Jpanell
        panelTexto = new JPanel();
        panelBoton = new JPanel();
        panelImagen = new JPanel();
        panelImagen.setFocusable(true);
        panelImagen.requestFocusInWindow();

        //inicialice los botones
        bHobbies = new JButton("Hobbies");
        bYo = new JButton("Quien soy yo");
        bCreoQue = new JButton("Describir quien soy yo");

        panelBoton.add(bYo);
        panelBoton.add(bHobbies);
        panelBoton.add(bCreoQue);

        //inicialice el label
        miTexto = new JLabel("Hola me llamo Stiven, para conocerme oprime los botones");
        panelTexto.setBackground(Color.black);
        panelTexto.add(miTexto);
        miTexto.setForeground(Color.white);
        miTexto.setFont(new Font("Calibri", Font.BOLD+Font.ITALIC,15));


        miFoto = new JLabel();
        panelImagen.setBorder(BorderFactory.createTitledBorder(null, "About me", TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION, new Font(Font.MONOSPACED, Font.PLAIN,20), Color.BLACK));

        panelImagen.add(miFoto);

        //instanciando

        expectativas = new JTextArea();
        //expectativas.setEnabled(false);
        panelImagen.add(expectativas);
        panelImagen.setBackground(Color.lightGray);

        //lo que va hacer es añadir las instrucciones que le di abajo a los botones "Añadir escucha"
        ManejoEventos eventos = new ManejoEventos();

        bCreoQue.addActionListener(eventos);
        bHobbies.addActionListener(eventos);
        bYo.addActionListener(eventos);
        //panelImagen.addMouseListener(eventos);
        //panelImagen.addMouseListener(eventos);
        panelImagen.addKeyListener(eventos);
        bYo.addMouseListener(eventos);
        bHobbies.addMouseListener(eventos);
        bCreoQue.addKeyListener(eventos);
        bHobbies.addKeyListener(eventos);
        bYo.addKeyListener(eventos);


        bCreoQue.setFocusable(true);
        bCreoQue.requestFocusInWindow();

        containerPp.add(panelImagen, BorderLayout.CENTER);
        containerPp.add(panelTexto, BorderLayout.NORTH);
        containerPp.add(panelBoton, BorderLayout.SOUTH);

        repaint();
        revalidate();
    }

    //Manejo de eventos
    class ManejoEventos implements ActionListener, MouseListener, KeyListener {


        @Override
        public void actionPerformed(ActionEvent ae) {
           // JOptionPane.showMessageDialog(null,"pressed button");
            if (ae.getSource() == bCreoQue){
                //System.out.println("Presione el boton yo");;
                miFoto.setText(null);
                miFoto.setIcon(null);
                expectativas.setText("Mis expectativas en el curso son:\n1. Tener un buen proceso de aprendizaje en cada tema propuesto por el profe"
                +"\n2. Aprender a solucionar problemas utilizando programacion oreintada a objetos."
                +"\n3. Aprender a generar interfaces graficas amigables con el usuario."
                );
            }
            else if(ae.getSource() == bHobbies){
                miFoto.setIcon(null);
                miFoto.setText(null);
                miFoto.setIcon(new ImageIcon("src/resources/images/dinho.png"));
                expectativas.setText("Mi hobbie favorito es jugar futbol. ");

            }

            else if(ae.getSource() == bYo){
                //Da un valor nulo al texto que se debe quitar
                expectativas.setText(null);
                miFoto.setIcon(null);
                miFoto.setIcon(new ImageIcon("src/resources/images/stive.png"));
            }


        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            if (mouseEvent.getClickCount()==1) {
                expectativas.setText(null);
                miFoto.setIcon(null);
                miFoto.setIcon(new ImageIcon("src/resources/images/stive.png"));


            };
            if (mouseEvent.getClickCount()==2) {
                miFoto.setIcon(null);
                miFoto.setText(null);
                miFoto.setIcon(new ImageIcon("src/resources/images/dinho.png"));
                expectativas.setText("Mi hobbie favorito es jugar futbol. ");


            }

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("KeyEvent:" + e.getSource());
            System.out.println("KeyEvent:" + e.getKeyChar());
            if (e.VK_M==e.getKeyCode()) {
                miFoto.setText(null);
                miFoto.setIcon(null);
                expectativas.setText("Mis expectativas en el curso son:\n1. Tener un buen proceso de aprendizaje en cada tema propuesto por el profe"
                        + "\n2. Aprender a solucionar problemas utilizando programacion oreintada a objetos."
                        + "\n3. Aprender a generar interfaces graficas amigables con el usuario."
                );
            }

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {

        }
    }
}
