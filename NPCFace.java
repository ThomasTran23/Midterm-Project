import javax.swing.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
// import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.awt.Toolkit;
import java.io.File;
// import java.io.FilenameFilter;
import javax.imageio.ImageIO;
// import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
// import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import javax.swing.Timer;
// import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.Border;
// import javax.swing.text.JTextComponent;
// import javax.swing.JTextField;

import java.awt.image.BufferedImage;

public class NPCFace extends JFrame implements ActionListener{

private final int WIDTH = 1500; //400;
private final int HEIGHT = 900; //400;
private ImagePanel imagePanel;
private JTextPane textArea;
private String base;
private int loopslot = 0;
private String[] files;
private Image[] allPics;
private ArrayList<Image> pics;
private Timer timer;
private JFrame frame;
// private Image[] ePics;
// private ImageFlip flip = new ImageFlip();

private static final String imageBase = "./NPC_images/";

public static void main(String args[]) {
      new NPCFace();
  }

public NPCFace(){
  try {
    javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
            createGUI();
        }
    });
  } catch (Exception e) {
      System.err.println("createGUI didn't successfully complete");
  }
  init();
}

public void init() {
      String curDir = System.getProperty("user.dir");
      
      base = curDir + "/" + imageBase;
      pics = new ArrayList<Image>();
      timer = new Timer(400, this);
      //timer.setInitialDelay(1000);

      getAllImages();
      setBackground("");
      // setImage("angel");      
      // setMessage("Hello, and Welcome!");
      // popMessage("Beware the wares!", "Welcome");

  }



public void createGUI() {
      setMaximumSize(new Dimension(WIDTH, HEIGHT));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(new Dimension(WIDTH, HEIGHT));
      Container contentPane = this.getContentPane();
      contentPane.setLayout(new GridBagLayout());
      // Color bColor = Color.green.darker();
      // contentPane.setBackground(bColor);
  
     
      
      imagePanel = new ImagePanel();
      int width = 415;
      int height = 480;
      imagePanel.setPreferredSize(new Dimension(width, height));
      imagePanel.setMinimumSize(new Dimension(width, height));
      imagePanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
      GridBagConstraints c = new GridBagConstraints();
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridx = 1;
      c.gridy = 1;
      contentPane.add(imagePanel,c);
      
      // textArea = new JTextPane();
      // textArea.setEditable(false);
      // JScrollPane scroll = new JScrollPane(textArea);
      // scroll.setPreferredSize(new Dimension(width, height/2));
      // scroll.setSize(new Dimension(width, height/2));
      // textArea.setPreferredSize(new Dimension(width, height/2));
      // textArea.setSize(new Dimension(width, height/2));


      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridwidth = 2;
      c.gridx = 0;
      c.gridy = 2;
      c.ipady = 20;
      // contentPane.add(scroll, c);

      frame = new JFrame();

      frame.setLocation(0, HEIGHT/2);
      frame.setVisible(true);

      // imagePanel.add(flip);
  
      setLocationRelativeTo(null);
      setVisible(true);
      // toFront();
      setAlwaysOnTop(true);
      setAlwaysOnTop(false);
  }

  public void setBackground(String type) {
    Image backImage = createImage(base+type+"background.jpg", "");
    Border bkgrnd = new CentredBackgroundBorder(backImage);
    ((JComponent) getContentPane()).setBorder(bkgrnd);
}

protected Image createImage(String path, String description) {
         return new ImageIcon(path, description).getImage();
  }

public void setImage(String mood) {
      timer.stop();
      pics.clear();
      getImages(mood);
      timer.start(); 
  }

public void actionPerformed(ActionEvent e) {
    loopslot++;

    if (loopslot >= pics.size()) {
        loopslot = 0;
    }

    imagePanel.repaint();

    if (loopslot == pics.size()) {
        timer.restart();
    }
}


public void getAllImages() {
      File dir = new File(base);   
      files  = dir.list();
      allPics = new Image[files.length];
      for (int i = 0; i < files.length; i++) {
          //System.err.println(files[i]);
          allPics[i]=createImage(base + files[i],"");
          
      }
      //System.err.println(pics.size());
  }


public void getImagesAnim(final String mood) {
  
      for (int i = 0; i < files.length; i++) {
          if (files[i].startsWith(/*"NPC_" +*/ mood)) {
              pics.add(allPics[i]);
          }
      }
      //System.err.println(pics.size());
  }

  public void getImages(final String mood) {

      for (int i = 0; i < files.length; i++) {
        if (files[i].equals(/*"NPC_" +*/ mood + ".jpg")) {
            pics.add(allPics[i]);
        }
      }
    
    //System.err.println(pics.size());
}


public void setMessage(String message) {
      String current = textArea.getText();
      textArea.setText(current + "\n" + message);
      textArea.select(current.length(), (current.length() + message.length() + 1));
  }

  // public void resetImagePanels(){
  //   for (ImagePanel temp:tempPanels){
  //     this.getContentPane().remove(temp);
  //     tempPanels.remove(temp);
  //   }
  // }

  public class ImagePanel extends JPanel {
    public ImagePanel( ) {
        super();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (pics.size() > 0) {
            g.drawImage(pics.get(loopslot), 0, 0, this.getWidth(), this.getHeight(), null);
        }
    }

  }

public class CentredBackgroundBorder implements Border {
      private final Image image;
   
      public CentredBackgroundBorder(Image image) {
          this.image = image;
      }
   
      public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
          g. drawImage(image, 0, 0, NPCFace.this.getWidth(), NPCFace.this.getHeight(),null);
      }
   
      public Insets getBorderInsets(Component c) {
          return new Insets(0,0,0,0);
      }
   
      public boolean isBorderOpaque() {
          return true;
      }
  }

public void popMessage(String message,String title){
  JOptionPane.showMessageDialog(frame, 
    message, 
    title, 
    JOptionPane.PLAIN_MESSAGE);
}

public int popConfirm(String message,String title, String[] options,String image){
  Icon icon;
  if (image!= null){
    icon =  new ImageIcon(base + image +".jpg","");
  }else{
    icon = null;
  }
  
  int n = JOptionPane.showOptionDialog(frame,
    message,
    title,
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    icon,
    options,
    options[1]);
  return n;
}
public String popOption(String message, String title, String[] options,String defaultString, String image){
  Icon icon;
  if (image!= null){
    icon =  new ImageIcon(base + image +".jpg","");
  }else{
    icon = null;
  }

  String s = (String)JOptionPane.showInputDialog(
  frame,
  message,
  title,
  JOptionPane.PLAIN_MESSAGE,
  icon,
  options,
  defaultString);
  return s;
}

public String popText(String message,String title, String defaultText, String errorMessage){
String s = (String)JOptionPane.showInputDialog(
  frame,
  message, title
  ,JOptionPane.PLAIN_MESSAGE,
  null,
  null,
  defaultText);

  if (s.equals("")|| s == null){
    popMessage(errorMessage, "ERROR");
    popText(message, title, defaultText, errorMessage);
  }
  return s;
}

public void movePanel(boolean center){
  if (center){
    imagePanel.setLocation(512,153);
  }else{
    imagePanel.setLocation(1024,153);
  }
}

public static final int FLIP_VERTICAL = 1;
public static final int FLIP_HORIZONTAL = -1;

public void flip(String input, File output, int direction){
  try{
    BufferedImage image = (BufferedImage) createImage(input, "");
    int width = image.getWidth();
    int height = image.getHeight();
    BufferedImage flipped = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

    for (int y = 0;y<height; y++){
      for (int x = 0; x<width; x++){
        switch(direction){
          case FLIP_HORIZONTAL:
            flipped.setRGB((width-1)-x,y,image.getRGB(x,y));
            break;
          case FLIP_VERTICAL:
            flipped.setRGB(x, (height-1)-y,image.getRGB(x,y));
            break;
        }
      }
    }

    ImageIO.write(flipped, "jpg", output);

    // ImageIcon icon = new ImageIcon(output.getPath(),"");

    // Image outImage = icon.getImage();

    // return outImage;

  }catch(IOException ex){
    ex.printStackTrace();
  }
}

public void setImageEnemy(String mood) {
  timer.stop();
  pics.clear();
  File temp = new File("e" + mood);
  flip(mood, temp, FLIP_HORIZONTAL);
  try{
    pics.add(ImageIO.read(temp));
  }catch(IOException e){
    e.printStackTrace();
  }
  timer.start(); 
}

  // public class ImageFlip extends JPanel {

  //   public void paint(Graphics g) {
  //     Image myImage = pics.get(0);
  //     BufferedImage bufferedImage = new BufferedImage(myImage.getWidth(null), myImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
  //     Graphics2D g2d = (Graphics2D) g;

  //     Graphics gb = bufferedImage.getGraphics();
  //     gb.drawImage(myImage, 0, 0, null);
  //     gb.dispose();

  //     AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
  //     tx.translate(-myImage.getWidth(null), 0);
  //     AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
  //     bufferedImage = op.filter(bufferedImage, null);

  //     g2d.drawImage(myImage, 10, 10, null);
  //     g2d.drawImage(bufferedImage, null, 300, 10);
  //   }
    

  // }

}
