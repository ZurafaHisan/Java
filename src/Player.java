import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Player implements ActionListener {

    JFrame frame;

    JButton playButton;
    JButton stopButton;
    JButton resetButton;

    JPanel panel;
    JLabel label;
    Font myFont = new Font("Times New Roman", Font.ITALIC, 30);

    Clip clip;

    Player() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        ImageIcon image = new ImageIcon("logo2.png");
       // Image scaleImage = image.getImage().getScaledInstance(400, 200, Image.SCALE_DEFAULT);


        File file = new File("Black Swan.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioStream);


        frame = new JFrame("Media Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLayout(null);

        playButton = new JButton("Play");
        playButton.addActionListener(this);
        playButton.setFont(myFont);
        playButton.setFocusable(false);

        stopButton = new JButton("Stop");
        stopButton.addActionListener(this);
        stopButton.setFont(myFont);
        stopButton.setFocusable(false);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        resetButton.setFont(myFont);
        resetButton.setFocusable(false);

        panel = new JPanel();
        panel.setBounds(42, 250, 400, 200);
        panel.setBackground(Color.BLACK);
        panel.setLayout(new GridLayout());

        panel.add(playButton);
        panel.add(stopButton);
        panel.add(resetButton);

        label = new JLabel();
        label.setBounds(90, 10, 400, 230);
        label.setIcon(image);
        label.setBackground(Color.BLUE);



        frame.add(panel);
        frame.add(label);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        new Player();



    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == playButton){
            clip.start();
        }
        if(e.getSource() == stopButton){
            clip.stop();
        }
        if(e.getSource() == resetButton){
            clip.setMicrosecondPosition(0);
        }

    }
}