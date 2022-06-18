import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JImageDisplay extends JComponent {
//    Класс BufferedImage управляет
//    изображением, содержимое которого можно записать.
    final BufferedImage image;
    private final Dimension dim;
    public JImageDisplay(int w, int h) {
//        Конструктор JImageDisplay принимает целочисленные
//        значения ширины и высоты, и инициализирует объект BufferedImage новым
//        изображением с этой шириной и высотой, и типом изображения
//        TYPE_INT_RGB.
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//        Dimention создает новый объект с заданными шириной и высотой.
        dim = new Dimension(w, h);
//        С помощью метода setPreferredSize, после добавления компонента,
//        Dimension отобразит всё изображение на экране.
        setPreferredSize(dim);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
    }

//    метод clearImage устанавливает все пиксели изображения в черный цвет (значение RGB 0).
    public void clearImage() {
        image.setRGB(0, 0, dim.width, dim.height, new int[dim.width * dim.height], 0, 0);
        repaint();
    }

//    метод drawPixel устанавливает пиксель в определенный цвет.
    public void drawPixel(int x, int y, int rgbColor) {
        image.setRGB(x, y, rgbColor);
    }
//    Оба метода будут необходимы для использования в методе setRGB () класса BufferedImage.



    @Override
    public void setPreferredSize(Dimension preferredSize) {
        super.setPreferredSize(dim);
    }
}