package section6_design.part0_refactoring;

public class ConsoleView implements View {
    private Rectangle rectangle;

    @Override
    public void redraw() {
        System.out.println(rectangle);
    }

    @Override
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
