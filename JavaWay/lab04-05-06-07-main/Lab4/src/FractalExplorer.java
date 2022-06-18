import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class FractalExplorer {
//    Поля:
//    1) Целое число «размер экрана», которое является шириной и высотой
//    отображения в пикселях. (Отображение фрактала будет квадратным.)
//    2) Ссылка JImageDisplay, для обновления отображения в разных
//    методах в процессе вычисления фрактала.
//    3) Объект FractalGenerator. Будет использоваться ссылка на базовый
//    класс для отображения других видов фракталов в будущем.
//    4) Объект Rectangle2D.Double, указывающий диапазона комплексной
//    плоскости, которая выводится на экран.
    private FractalGenerator generator;
    private final int size;
    private final JImageDisplay display;
    private final Rectangle2D.Double range;
    private final ArrayList<FractalGenerator> generators = new ArrayList<>();
    private final AtomicInteger remRows = new AtomicInteger(0);
    JFrame frame = new JFrame("Fractal Explorer");
    JButton btn = new JButton("Click on me!"), save = new JButton("Save Image");
    private int rowsRemaining;

    //        JComboBox — это компонент Java Swing, который представляет собой выпадающий список.
    JComboBox<FractalGenerator> cb = new JComboBox<>();
    public FractalExplorer(int size) {
//        конструктор принимает значение
//        размера отображения в качестве аргумента, затем сохраняет это значение в
//        соответствующем поле, а также инициализирует объекты диапазона и
//        фрактального генератора.
        this.size = size;
        display = new JImageDisplay(size, size);
        generators.add(new Mandelbrot());
        generators.add(new Tricorn());
        generators.add(new BurningShip());
        generator = generators.get(0);
        range = new Rectangle2D.Double();
        generator.getInitialRange(range);


    }

//    drawFractal - вспомогательный метод для вывода на экран фрактала.
//    Он циклически проходит через каждый пиксель в отображении (т.е.
//    значения x и y будут меняться от 0 до размера отображения) и
//    вычисляет количество итераций для соответствующих координат в
//    области отображения фрактала.
    private void drawFractal() {
        enableUI(false);
        rowsRemaining = size;
        remRows.set(size);
        for (int y = 0; y < size; y++) {
            new FractalWorker(y).execute();


            // После отрисовки всех пикселей, обновляется
            // JImageDisplay для компонента с помочью repaint();
            display.repaint();
        }
    }

//    метод show инициализирует графический интерфейс Swing:
//    JFrame, содержащий объект JImageDisplay,
//    кнопку для сброса отображения (btn) и кнопку для сохранения.
    private void show() {

        generators.forEach(cb::addItem);

//        addMouseListener добавляет указанный прослушиватель мыши для получения событий мыши от этого компонента.
        display.addMouseListener(new MouseAdapter() {
//            При получении события о щелчке мышью, класс должен
//            отобразить пиксельные кооринаты щелчка в область фрактала, а затем вызвать
//            метод генератора recenterAndZoomRange() с координатами, по которым
//            щелкнули, и масштабом 0.5. Таким образом, нажимая на какое-либо место на
//            фрактальном отображении, вы увеличиваете его!
            @Override
            public void mouseClicked(MouseEvent e) {
                generator.recenterAndZoomRange(range,
                        FractalGenerator.getCoord(range.x, range.x + range.width, size, e.getX()),
                        FractalGenerator.getCoord(range.y, range.y + range.width, size, e.getY()), .5);
                drawFractal();
            }
        });

//        Создание внутреннего класса для обработки событий
//        java.awt.event.ActionListener от кнопки сброса. Обработчик должен сбросить
//        диапазон к начальному, определенному генератором, а затем перерисовать
//        фрактал.
        btn.addActionListener(data -> display.clearImage());

        cb.addItemListener(e -> {
            generator = ((FractalGenerator) e.getItem());
            generator.getInitialRange(range);
            drawFractal();
        });

        save.addActionListener(e -> {
            JFileChooser ch = new JFileChooser();
            ch.setFileFilter(new FileNameExtensionFilter("PNG Images", "png"));
            ch.setAcceptAllFileFilterUsed(false);
//            showSaveDialog открывает диалоговое окно для сохранения
            if (ch.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) try {
                var file = ch.getSelectedFile();
                ImageIO.write(display.image, "png", new File(file + (file.getName().endsWith(".png") ? "" : ".png")));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(ch, "Ошибка при сохранении файла", "Ошибка", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

//        добавить объект Label в разрабатываемый
//        пользовательский интерфейс перед выпадающим списком, в качестве
//        пояснения к выпадающему списку. Это можно сделать, создав новый объект
//        JPanel и добавив в него объекты JLabel и JComboBox, а затем разместить панель
//        на позиции NORTH на вашем макете окна.
        var header = new JPanel();
        header.add(new JLabel("Fractal: "));
        header.add(cb);

        // Building footer
        var footer = new JPanel();
        footer.add(btn);
        footer.add(save);

//        для содержимого окна;
//        добавили объект отображения изображения в позицию
//        BorderLayout.CENTER и кнопку в позицию BorderLayout.SOUTH.
        frame.add(header, BorderLayout.NORTH);
        frame.add(display, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);

//        Данные операции правильно размещают содержимое окна, делают его
//        видимым (окна первоначально не отображаются при их создании для того,
//        чтобы можно было сконфигурировать их прежде, чем выводить на экран), и
//        затем запрещают изменение размеров окна.
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

//    createUI регистрирует экземпляр обработчика
//    в компоненте фрактального отображения и
//    вызывает drawFractal.
    private void createUI() {
        SwingUtilities.invokeLater(this::show);
        drawFractal();
    }
    private class FractalWorker extends SwingWorker<Object, Object> {

        private int y;

        public FractalWorker(int y) {
            super();
            this.y = y;
        }

        // вычислять каждую строчку
        @Override
        protected Object doInBackground() throws Exception {
            double pointY = FractalGenerator.getCoord(range.y, range.y + range.height, size, y);
            for (int x = 0; x < size; x++) {
                double pointX = FractalGenerator.getCoord(range.x, range.x + range.width, size, x);
                int iter = generator.numIterations(pointX, pointY);

//                Если число итераций равно -1 (т.е. точка не выходит за границы,
//                установливается пиксель в черный цвет (для rgb значение 0), а иначе выбирается
//                значение цвета, основанное на количестве итераций. Для этого
//                используется цветовое пространство HSV: поскольку значение цвета
//                варьируется от 0 до 1, получается плавная последовательность цветов от
//                красного к желтому, зеленому, синему, фиолетовому и затем обратно к
//                красному!
                display.drawPixel(x, y, iter >= 0 ? Color.HSBtoRGB(0.7f + iter / 200f, 1f, 1f) : 0);
//                System.out.println(iter);
            }
            return null;
        }

        //отрисовать каждую строчку
        @Override
        protected void done() {
            super.done();
            display.repaint();
            remRows.decrementAndGet();
            rowsRemaining--;
            if (rowsRemaining == 0) {
                enableUI(true);
            }
        }
    }
    private void enableUI(boolean val) {
        cb.setEnabled(val);
        btn.setEnabled(val);
        save.setEnabled(val);
    }

    public static void main(String[] args) {
        new FractalExplorer(700).createUI();
    }
}
