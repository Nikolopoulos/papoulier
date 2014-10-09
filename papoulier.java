package papoulier;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Basil Nikolopoulos <nikolopoulosbasil@gmail.com>
 */
public class Papoulier {

    /**
     * @param args the command line arguments
     */
    static final ArrayList<String> images = new ArrayList<String>();

    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.google.gr/search?q=κάρολος+παπούλιας&biw=986&bih=583&source=lnms&tbm=isch&sa=X&ei=5l82VL_FHunjywPG-IHYDA&ved=0CAgQ_AUoAQ");
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
            InputStream is = conn.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line = null;

            while ((line = reader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                String[] parts = line.split("<img ");
                for (String s : parts) {
                    if (s.startsWith("height")) {
                        String[] innerParts = s.split("src=\"");
                        for (String innerS : innerParts) {
                            System.out.println(innerS);
                            if (innerS.startsWith("https://encrypted")) {
                                String[] lastParts = innerS.split("\"");
                                images.add(lastParts[0]);
                            }
                        }

                    }

                }

            }
            for (String s : images) {
                System.out.println(s);
            }
            reader.close();

        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        Random rng = new Random();
        boolean yolo = true;
        while (yolo) {
            JFrame f = initiFrame();
            animation(f);
            try {
                long sr = rng.nextInt(1000*60*20) + 1000*60*10;
                System.out.println(sr);
                Thread.sleep(sr);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void animation(JFrame f) {

        Random rng = new Random();
        int position = 2;//rng.nextInt(8);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        switch (position) {
            case 0: {
                f.setLocation(-f.getWidth(), 0);
                long ms = 0;
                ms = System.currentTimeMillis();
                while (f.getLocation().x < 0) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    f.setLocation(f.getLocation().x + 1, 0);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                while (System.currentTimeMillis() - ms < 5000) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ms = System.currentTimeMillis();
                while (f.getLocation().x > -f.getWidth()) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    f.setLocation(f.getLocation().x - 1, 0);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                break;
            }
            case 1: {
                f.setLocation(0, -f.getHeight());
                long ms = 0;
                ms = System.currentTimeMillis();
                while (f.getLocation().y < 0) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    //System.out.println((int) ((f.getHeight() / 10) * (df / 20)));

                    f.setLocation(0, f.getLocation().y + 1);
                    try {
                        Thread.sleep(30);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                while (System.currentTimeMillis() - ms < 5000) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ms = System.currentTimeMillis();
                while (f.getLocation().y > -f.getHeight()) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    f.setLocation(0, f.getLocation().y - 1);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                break;

            }
            case 2: {
                f.setLocation(width, 0);

                long ms = 0;
                ms = System.currentTimeMillis();
                while (f.getLocation().x > width - f.getWidth()) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    //System.out.println((int) ((f.getHeight() / 10) * (df / 20)));

                    f.setLocation(f.getLocation().x - 1, 0);
                    try {
                        Thread.sleep(30);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                while (System.currentTimeMillis() - ms < 5000) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ms = System.currentTimeMillis();
                while (f.getLocation().x < width) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    f.setLocation(f.getLocation().x + 1, 0);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                break;
            }
            case 3: {
                f.setLocation(width - f.getWidth(), -f.getHeight());

                long ms = 0;
                ms = System.currentTimeMillis();
                while (f.getLocation().y < 0) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    //System.out.println((int) ((f.getHeight() / 10) * (df / 20)));

                    f.setLocation(f.getLocation().x, f.getLocation().y + 1);
                    try {
                        Thread.sleep(30);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                while (System.currentTimeMillis() - ms < 5000) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ms = System.currentTimeMillis();
                while (f.getLocation().y > -f.getWidth()) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    f.setLocation(f.getLocation().x, f.getLocation().y - 1);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                break;
            }
            case 4: {
                f.setLocation(-f.getWidth(), height - f.getHeight());

                long ms = 0;
                ms = System.currentTimeMillis();
                while (f.getLocation().x < 0) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    //System.out.println((int) ((f.getHeight() / 10) * (df / 20)));

                    f.setLocation(f.getLocation().x + 1, f.getLocation().y);
                    try {
                        Thread.sleep(30);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                while (System.currentTimeMillis() - ms < 5000) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ms = System.currentTimeMillis();
                while (f.getLocation().x > -f.getWidth()) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    f.setLocation(f.getLocation().x - 1, f.getLocation().y);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                break;
            }
            case 5: {
                f.setLocation(0, height);

                long ms = 0;
                ms = System.currentTimeMillis();
                while (f.getLocation().y > height - f.getHeight()) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    //System.out.println((int) ((f.getHeight() / 10) * (df / 20)));

                    f.setLocation(f.getLocation().x, f.getLocation().y - 1);
                    try {
                        Thread.sleep(30);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                while (System.currentTimeMillis() - ms < 5000) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ms = System.currentTimeMillis();
                while (f.getLocation().y < height) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    f.setLocation(f.getLocation().x, f.getLocation().y + 1);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                break;
            }
            case 6: {
                f.setLocation(width, height - f.getHeight());

                long ms = 0;
                ms = System.currentTimeMillis();
                while (f.getLocation().x > width - f.getWidth()) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    //System.out.println((int) ((f.getHeight() / 10) * (df / 20)));

                    f.setLocation(f.getLocation().x - 1, f.getLocation().y);
                    try {
                        Thread.sleep(30);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                while (System.currentTimeMillis() - ms < 5000) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ms = System.currentTimeMillis();
                while (f.getLocation().x < width) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    f.setLocation(f.getLocation().x + 1, f.getLocation().y);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                break;
            }
            case 7: {
                f.setLocation(width - f.getWidth(), height);

                long ms = 0;
                ms = System.currentTimeMillis();
                while (f.getLocation().y > height - f.getHeight()) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    //System.out.println((int) ((f.getHeight() / 10) * (df / 20)));

                    f.setLocation(f.getLocation().x, f.getLocation().y - 1);
                    try {
                        Thread.sleep(30);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                while (System.currentTimeMillis() - ms < 5000) {
                    try {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                ms = System.currentTimeMillis();
                while (f.getLocation().y < height) {
                    long newms = System.currentTimeMillis();
                    long df = newms - ms;
                    ms = newms;
                    f.setLocation(f.getLocation().x, f.getLocation().y + 1);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //System.out.println(f.getLocation());
                }

                break;
            }

        }

        //popup.setLocation(new Point(width-icon.getIconWidth(), height-icon.getIconHeight()));
        //System.out.println(width + "   " + height);
    }

    public static JFrame initiFrame() {

        JFrame popup = new JFrame();
        popup.setAlwaysOnTop(true);
        popup.setUndecorated(true);
        Random rng = new Random();
        rng.nextInt(images.size());
        URL url = null;
        try {
            url = new URL(images.get(rng.nextInt(images.size())));
        }
        catch (MalformedURLException ex) {
            Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Image image = ImageIO.read(url);

            ImageIcon icon = new ImageIcon(image);
            JLabel ic = new JLabel(icon);

            popup.add(ic);
            popup.setVisible(true);
            popup.setSize(icon.getIconWidth(), icon.getIconHeight());

        }
        catch (IOException ex) {
            Logger.getLogger(Papoulier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return popup;

    }
}
