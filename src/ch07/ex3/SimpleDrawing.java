package ch07.ex3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SimpleDrawing extends JFrame {

    private final ArrayList<Point> points = new ArrayList<>();

    public SimpleDrawing() {
        setTitle("간단한 그림판");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DrawingPanel panel = new DrawingPanel();
        add(panel);

        // 패널이 아닌 프레임에 마우스 리스너를 추가합니다.
        // 클릭 좌표는 프레임 기준이므로 패널에 정확히 그려집니다.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // getPoint()는 이벤트 소스(프레임) 기준 좌표를 반환합니다.
                points.add(e.getPoint());
                // 프레임의 paintComponent를 간접적으로 호출하여 패널을 다시 그립니다.
                repaint();
            }
        });
    }

    // 그림을 그리는 내부 클래스 Panel
    class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            // 점이 2개 이상일 때만 선을 그립니다.
            if (points.size() > 1) {
                for (int i = 0; i < points.size() - 1; i++) {
                    Point p1 = points.get(i);
                    Point p2 = points.get(i + 1);
                    // 프레임의 컨텐츠 영역에 그려지므로 좌표계가 맞습니다.
                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Event Dispatch Thread에서 GUI를 생성하고 실행합니다.
        SwingUtilities.invokeLater(() -> {
            SimpleDrawing drawing = new SimpleDrawing();
            drawing.setVisible(true);
        });
    }
}
