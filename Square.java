public class Square {
    public void draw(int canvas_width,int canvas_height,int side_length,String character,int col_index,int rotation,String Background){
        //draw canvas_width rows
        for(int i=0;i<canvas_height;i++){
            //draw canvas_height columns
            for(int j=0;j<canvas_width;j++) {
                if (j > col_index-2 && j < col_index + side_length-1 && i<=side_length-1){
                    System.out.print(character);
                } else {
                    System.out.print(Background);
                }
            }
            System.out.println();
        }
    }
}
