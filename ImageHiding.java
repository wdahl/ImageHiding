import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import java.io.*;

import javax.imageio.ImageIO;

import javax.swing.*;

public class ImageHiding extends JFrame implements ActionListener
{
 BufferedImage hostImage;
 BufferedImage secretImage;

 JPanel controlPanel;
 JPanel imagePanel;

 JTextField encodeBitsText;
 JButton encodeBitsPlus;
 JButton encodeBitsMinus;

 JTextField nBitsText;
 JButton nBitsPlus;
 JButton nBitsMinus;

 ImageCanvas hostCanvas;
 ImageCanvas secretCanvas;

 Steganography s;

 JCheckBoxMenuItem box1 = new JCheckBoxMenuItem("MSB encoded in MSB.");
 JCheckBoxMenuItem box2 = new JCheckBoxMenuItem("MSB encoded in LSB.");
 JCheckBoxMenuItem box3 = new JCheckBoxMenuItem("LSB encoded in MSB.");
 JCheckBoxMenuItem box4 = new JCheckBoxMenuItem("LSB encoded in LSB.");

 public BufferedImage getHostImage()
 {
  BufferedImage img = null;

  try
  {
   img = ImageIO.read(new File("host_image.jpg"));
  }
  catch (IOException ioe) { ioe.printStackTrace(); }

  return img;
 }

 public BufferedImage getSecretImage()
 {
  BufferedImage img = null;

  try
  {
   img = ImageIO.read(new File("secret_image.jpg"));
  }
  catch (IOException ioe) { ioe.printStackTrace(); }

  return img;
 }

 public int getBits()
 {
  return Integer.parseInt(encodeBitsText.getText());
 }

 public void actionPerformed(ActionEvent event)
 {
  Object source = event.getSource();

  //executes if MSB to MSB is the chosen encoding method
  if(box1.getState()){
    if (source == encodeBitsPlus)
    {
      int bits = this.getBits() + 1;

      if (bits > 8) { bits = 8; }

      encodeBitsText.setText(Integer.toString(bits));

      s = new Steganography(this.getHostImage());
      s.encodeMSB(this.getSecretImage(), bits);

      hostCanvas.setImage(s.getImage());
      hostCanvas.repaint();

      s = new Steganography(this.getSecretImage());
      s.getMaskedImageMSB(bits);

      secretCanvas.setImage(s.getImage());
      secretCanvas.repaint();
    }

    else if (source == encodeBitsMinus)
    {
      int bits = this.getBits() - 1;

      if (bits < 0) { bits = 0; }

      encodeBitsText.setText(Integer.toString(bits));

      s = new Steganography(this.getHostImage());
      s.encodeMSB(this.getSecretImage(), bits);

      hostCanvas.setImage(s.getImage());
      hostCanvas.repaint();

      s = new Steganography(this.getSecretImage());
      s.getMaskedImageMSB(bits);

      secretCanvas.setImage(s.getImage());
      secretCanvas.repaint();
    }
  }

  //exectues if MSB to LSB is the chosen encoding method
  else if(box2.getState()){
    if (source == encodeBitsPlus)
    {
      int bits = this.getBits() + 1;

      if (bits > 8) { bits = 8; }

      encodeBitsText.setText(Integer.toString(bits));

      s = new Steganography(this.getHostImage());
      s.encodeLSB(this.getSecretImage(), bits);

      hostCanvas.setImage(s.getImage());
      hostCanvas.repaint();

      s = new Steganography(this.getSecretImage());
      s.getMaskedImageMSB(bits);

      secretCanvas.setImage(s.getImage());
      secretCanvas.repaint();
    }

    
    else if (source == encodeBitsMinus)
    {
      int bits = this.getBits() - 1;

      if (bits < 0) { bits = 0; }

      encodeBitsText.setText(Integer.toString(bits));

      s = new Steganography(this.getHostImage());
      s.encodeLSB(this.getSecretImage(), bits);

      hostCanvas.setImage(s.getImage());
      hostCanvas.repaint();

      s = new Steganography(this.getSecretImage());
      s.getMaskedImageMSB(bits);

      secretCanvas.setImage(s.getImage());
      secretCanvas.repaint();
    }
  }

  //exectues if LSB to MSB is the chosen encoding method
  else if(box3.getState()){
    if (source == encodeBitsPlus)
    {
      int bits = this.getBits() + 1;

      if (bits > 8) { bits = 8; }

      encodeBitsText.setText(Integer.toString(bits));

      s = new Steganography(this.getHostImage());
      s.encodeMSB(this.getSecretImage(), bits);

      hostCanvas.setImage(s.getImage());
      hostCanvas.repaint();

      s = new Steganography(this.getSecretImage());
      s.getMaskedImageLSB(bits);

      secretCanvas.setImage(s.getImage());
      secretCanvas.repaint();
    }

    else if (source == encodeBitsMinus)
    {
      int bits = this.getBits() - 1;

      if (bits < 0) { bits = 0; }

      encodeBitsText.setText(Integer.toString(bits));

      s = new Steganography(this.getHostImage());
      s.encodeMSB(this.getSecretImage(), bits);

      hostCanvas.setImage(s.getImage());
      hostCanvas.repaint();

      s = new Steganography(this.getSecretImage());
      s.getMaskedImageLSB(bits);

      secretCanvas.setImage(s.getImage());
      secretCanvas.repaint();
    }
  }

  //executes if LSB to LSB is the chosen encoding method
  else if(box4.getState()){
    if (source == encodeBitsPlus)
    {
      int bits = this.getBits() + 1;

      if (bits > 8) { bits = 8; }

      encodeBitsText.setText(Integer.toString(bits));

      s = new Steganography(this.getHostImage());
      s.encodeLSB(this.getSecretImage(), bits);

      hostCanvas.setImage(s.getImage());
      hostCanvas.repaint();

      s = new Steganography(this.getSecretImage());
      s.getMaskedImageLSB(bits);

      secretCanvas.setImage(s.getImage());
      secretCanvas.repaint();
    }

    else if (source == encodeBitsMinus)
    {
      int bits = this.getBits() - 1;

      if (bits < 0) { bits = 0; }

      encodeBitsText.setText(Integer.toString(bits));

      s = new Steganography(this.getHostImage());
      s.encodeLSB(this.getSecretImage(), bits);

      hostCanvas.setImage(s.getImage());
      hostCanvas.repaint();

      s = new Steganography(this.getSecretImage());
      s.getMaskedImageLSB(bits);

      secretCanvas.setImage(s.getImage());
      secretCanvas.repaint();
    }
  }
 }

 public ImageHiding()
 {
  GridBagLayout layout = new GridBagLayout();
  GridBagConstraints gbc = new GridBagConstraints();
  this.setTitle("Image Hiding Demo");

  Container container = this.getContentPane();

  this.setLayout(layout);

  JMenuBar bar = new JMenuBar();
  JMenu menu = new JMenu("Type of encoding");
  menu.add(box1);
  menu.add(box2);
  menu.add(box3);
  menu.add(box4);
  bar.add(menu);
  this.add(bar);

  this.add(new JLabel("Bits to encode into host image:"));

  encodeBitsText = new JTextField("0", 5);
  encodeBitsText.setEditable(false);

  gbc.weightx = -1.0;
  layout.setConstraints(encodeBitsText, gbc);
  this.add(encodeBitsText);

  encodeBitsPlus = new JButton("+");
  encodeBitsPlus.addActionListener(this);

  encodeBitsMinus = new JButton("-");
  encodeBitsMinus.addActionListener(this);

  gbc.weightx = 1.0;
  layout.setConstraints(encodeBitsPlus, gbc);
  this.add(encodeBitsPlus);

  gbc.gridwidth = GridBagConstraints.REMAINDER;
  layout.setConstraints(encodeBitsMinus, gbc);
  this.add(encodeBitsMinus);

  GridBagLayout imageGridbag = new GridBagLayout();
  GridBagConstraints imageGBC = new GridBagConstraints();

  imagePanel = new JPanel();
  imagePanel.setLayout(imageGridbag);

  JLabel hostImageLabel = new JLabel("Host image:");
  JLabel secretImageLabel = new JLabel("Secret image:");

  imagePanel.add(hostImageLabel);

  imageGBC.gridwidth = GridBagConstraints.REMAINDER;
  imageGridbag.setConstraints(secretImageLabel, imageGBC);
  imagePanel.add(secretImageLabel);

  hostCanvas = new ImageCanvas(this.getHostImage());  
  secretCanvas = new ImageCanvas(this.getSecretImage());

  imagePanel.add(hostCanvas);
  imagePanel.add(secretCanvas);

  gbc.gridwidth = GridBagConstraints.REMAINDER;
  layout.setConstraints(imagePanel, gbc);
  this.add(imagePanel);

  //if MSB to MSB is the chosen encoding method
  if(box1.getState()){
    MSBToMSB();
  }

  //if MSB to lSB is the chosen encoding method
  else if(box2.getState()){
    MSBToLSB();
  }

  //If LSB to mSB is the chosen encoding method
  else if(box3.getState()){
    LSBToMSB();
  }

  //if LSB to LSB is the chosen encdoing method
  else if(box4.getState()){
    LSBToLSB();
  }
  }

  //Encodes MSB of secert image into the MSB of the host image
  public void MSBToMSB(){

  Steganography host = new Steganography(this.getHostImage());
  host.encodeMSB(this.getSecretImage(), this.getBits());
  hostCanvas.setImage(host.getImage());

  Steganography secret = new Steganography(this.getSecretImage());
  secret.getMaskedImageMSB(this.getBits());
  secretCanvas.setImage(secret.getImage());

  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.pack();

  this.setVisible(true);
  }

  //Encodes the MSB of the secret images into the LSB of the host image
  public void MSBToLSB(){

  Steganography host = new Steganography(this.getHostImage());
  host.encodeLSB(this.getSecretImage(), this.getBits());
  hostCanvas.setImage(host.getImage());

  Steganography secret = new Steganography(this.getSecretImage());
  secret.getMaskedImageMSB(this.getBits());
  secretCanvas.setImage(secret.getImage());

  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.pack();

  this.setVisible(true);
  }

  //Encodes the LSB of the secret image into the MSB of the host image
  public void LSBToMSB(){

  Steganography host = new Steganography(this.getHostImage());
  host.encodeMSB(this.getSecretImage(), this.getBits());
  hostCanvas.setImage(host.getImage());

  Steganography secret = new Steganography(this.getSecretImage());
  secret.getMaskedImageLSB(this.getBits());
  secretCanvas.setImage(secret.getImage());

  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.pack();

  this.setVisible(true);
  }

  //Encodes the LSB of the secret image into the LSB of the Host image
  public void LSBToLSB(){

  Steganography host = new Steganography(this.getHostImage());
  host.encodeLSB(this.getSecretImage(), this.getBits());
  hostCanvas.setImage(host.getImage());

  Steganography secret = new Steganography(this.getSecretImage());
  secret.getMaskedImageLSB(this.getBits());
  secretCanvas.setImage(secret.getImage());

  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.pack();

  this.setVisible(true);
  }

 public static void main(String[] args)
 {
  ImageHiding frame = new ImageHiding();
  frame.setVisible(true);
 }

 public class ImageCanvas extends JPanel
 { 
  Image img;

  public void paintComponent(Graphics g)
  {
   g.drawImage(img, 0, 0, this);
  }

  public void setImage(Image img)
  {
   this.img = img;
  }

  public ImageCanvas(Image img)
  {
   this.img = img;

   this.setPreferredSize(new Dimension(img.getWidth(this), img.getHeight(this)));
  }
 }
}

class Steganography
{
 BufferedImage image;

 //Gets the MSB's of the secret image
 public void getMaskedImageMSB(int bits)
 {
  int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

  int maskBits = (int)(Math.pow(2, bits)) - 1 << (8 - bits);
  int mask = (maskBits << 24) | (maskBits << 16) | (maskBits << 8) | maskBits;

  for (int i = 0; i < imageRGB.length; i++)
  {
   imageRGB[i] = imageRGB[i] & mask;
  }

  image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
 }

 //gets the LSB of the host image
 public void encodeLSB(BufferedImage encodeImage, int encodeBits)
 {
  int[] encodeRGB = encodeImage.getRGB(0, 0, encodeImage.getWidth(null), encodeImage.getHeight(null), null, 0, encodeImage.getWidth(null));
  int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

  int encodeByteMask = (int)(Math.pow(2, encodeBits)) - 1 << (8 - encodeBits);
  int encodeMask = (encodeByteMask << 24) | (encodeByteMask << 16) | (encodeByteMask << 8) | encodeByteMask;

  int decodeByteMask = ~(encodeByteMask >>> (8 - encodeBits)) & 0xFF;
  int hostMask = (decodeByteMask << 24) | (decodeByteMask << 16) | (decodeByteMask << 8) | decodeByteMask;

  for (int i = 0; i < imageRGB.length; i++)
  {
   int encodeData = (encodeRGB[i] & encodeMask) >>> (8 - encodeBits);
   imageRGB[i] = (imageRGB[i] & hostMask) | (encodeData & ~hostMask);
  }

  image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
 }

 //gets the LSB of the secret image
 public void getMaskedImageLSB(int bits)
 {
  int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

  int maskBits = (int)(Math.pow(2, bits)) - 1 << (8 - bits);
  int mask = (maskBits << 24) | (maskBits << 16) | (maskBits << 8) | maskBits;
  mask = mask >>> 7;

  for (int i = 0; i < imageRGB.length; i++)
  {
   imageRGB[i] = imageRGB[i] & mask;
  }

  image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
 }

 //gets the MSB of the host image
 public void encodeMSB(BufferedImage encodeImage, int encodeBits)
 {
  int[] encodeRGB = encodeImage.getRGB(0, 0, encodeImage.getWidth(null), encodeImage.getHeight(null), null, 0, encodeImage.getWidth(null));
  int[] imageRGB = image.getRGB(0, 0, image.getWidth(null), image.getHeight(null), null, 0, image.getWidth(null));

  int encodeByteMask = (int)(Math.pow(2, encodeBits)) - 1 << (8 - encodeBits);
  int encodeMask = (encodeByteMask << 24) | (encodeByteMask << 16) | (encodeByteMask << 8) | encodeByteMask;
  encodeMask = encodeMask >>> 7;//unsighned right shift by 7 to get LSB

  int decodeByteMask = ~(encodeByteMask >>> (8 - encodeBits)) & 0xFF;
  int hostMask = (decodeByteMask << 24) | (decodeByteMask << 16) | (decodeByteMask << 8) | decodeByteMask;
  hostMask = hostMask >>> 7; 

  for (int i = 0; i < imageRGB.length; i++)
  {
   int encodeData = (encodeRGB[i] & encodeMask) >>> (8 - encodeBits);
   imageRGB[i] = (imageRGB[i] & hostMask) | (encodeData & ~hostMask);
  }

  image.setRGB(0, 0, image.getWidth(null), image.getHeight(null), imageRGB, 0, image.getWidth(null));
 }

 public Image getImage()
 {
  return image;
 }

 public Steganography(BufferedImage image)
 {
  this.image = image;
 }
}
