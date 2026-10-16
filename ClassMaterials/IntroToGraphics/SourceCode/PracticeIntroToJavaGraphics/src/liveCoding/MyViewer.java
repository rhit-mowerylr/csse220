package liveCoding;

import javax.swing.*;


public class MyViewer {
    private JFrame myFrame;
    private MyComponent myComponent;

    public MyViewer(){
        this.myFrame = new JFrame();
        this.myComponent = new MyComponent();
    }

    public static void main(String[] args) {
        MyViewer app= new MyViewer();
        app.runApp();
    }

    private void runApp(){
        int width =800;
        int height =600;
        int x=50;
        int y=100;
        this.myFrame.setSize(width, height);
        this.myFrame.setLocation(x,y);
        this.myFrame.setTitle("How is it going?");
        this.myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.myFrame.add(this.myComponent);
        this.myFrame.setVisible(true);
    }
}
