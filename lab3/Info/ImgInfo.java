package lab3.Info;



public class ImgInfo extends Info {
    private int width;
    private int height;
    public ImgInfo(String name, long size, String lastUpdate, String created, int width, int height) {
        super(name, size, lastUpdate, created);
        this.width = width;
        this.height = height;
    }


    @Override
    public void display(){
        super.display();
        System.out.println("Image Width: " + width);
        System.out.println("Image Height: " + height);
    }
}
