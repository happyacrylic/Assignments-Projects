import java.util.Scanner;

public class DrawingCanvas {

    //import other classes
    Triangle Tri=new Triangle();
    Square Squ=new Square();


    //choose what to draw
    public void whatToDraw(String option,int canvas_width,int canvas_height,int side_length,String character,int col_index, int rotation,String Background){
        if(option.equals("1")){
            Tri.draw(canvas_width,canvas_height,side_length,character,col_index,rotation,Background);
        }else if(option.equals("2")){
            Squ.draw(canvas_width,canvas_height,side_length,character,col_index,rotation,Background);
        }else if(option.equals("3")){
            this.updateSetting(option,canvas_width,canvas_height,side_length,character,col_index, rotation,Background);
        }else if(option.equals("4")){
            System.out.println("Goodbye!\n");
            System.exit(0);
        }
    }

    //Setting alignment
    public void Setting(String alignment,String option,int canvas_width,int canvas_height,int side_length,String character,int col_index, int rotation,String Background){
        if(alignment.equals("left")){
            col_index = 1;
            this.whatToDraw(option,canvas_width,canvas_height,side_length,character,col_index,rotation,Background);
        }else if(alignment.equals("middle")){
            col_index = (canvas_width - side_length) / 2 + 1;
            this.whatToDraw(option,canvas_width,canvas_height,side_length,character,col_index,rotation,Background);
        }else if(alignment.equals("right")){
            col_index = canvas_width - side_length + 1;
            this.whatToDraw(option,canvas_width,canvas_height,side_length,character,col_index,rotation,Background);
        }
    }

    //Setting canvas type and background
    public void updateSetting(String option,int canvas_width,int canvas_height,int side_length,String character,int col_index, int rotation,String Background){
        System.out.print("Canvas width: ");
        Scanner keyboard = new Scanner(System.in);
        canvas_width = keyboard.nextInt();
        System.out.print("Canvas height: ");
        canvas_height = keyboard.nextInt();
        System.out.print("Background character: ");
        Background = keyboard.next();
        System.out.print("Drawing canvas has been updated!\n");
        System.out.println();
        System.out.println("Current drawing canvas settings:\n- Width: " + canvas_width + "\n- Height: " + canvas_height + "\n- Background character: "+Background+"\n");
        System.out.println("Please select an option. Type 4 to exit.\n1. Draw triangles\n2. Draw squares\n3. Update drawing canvas settings\n4. Exit");
        option = keyboard.next();
    }
}