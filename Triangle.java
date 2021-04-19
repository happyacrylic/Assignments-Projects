public class Triangle {
    public void draw(int canvas_width,int canvas_height,int side_length,String character,int col_index, int rotation,String Background){
        int character_length=side_length;
        int retract=0;

        //rotate by the remainder
        if(rotation%4==0){
            //draw 6 lines
            for(int i=0;i<canvas_height;i++){
                //draw each line
                for(int j=0;j<canvas_width;j++) {
                    if (j > col_index-2 && j < col_index + character_length-1){
                        System.out.print(character);
                    } else {
                        System.out.print(Background);
                    }
                }
                character_length-=1;
                System.out.println();
            }
        }else if(rotation%4==1){
            //draw 6 lines
            for(int i=0;i<canvas_height;i++){
                //draw each line
                for(int j=0;j<canvas_width;j++) {
                    if (j > col_index-2+retract && j < col_index + side_length-1){
                        System.out.print(character);
                    } else {
                        System.out.print(Background);
                    }
                }
                retract+=1;
                character_length-=1;
                System.out.println();
            }
        }else if(rotation%4==2){
            //draw 6 lines
            for(int i=0;i<canvas_height;i++){
                //draw each line
                for(int j=0;j<canvas_width;j++) {
                    if (j > col_index+character_length-3 && j < col_index+side_length-1&&i<side_length){
                        System.out.print(character);
                    } else {
                        System.out.print(Background);
                    }
                }
                character_length-=1;
                System.out.println();
            }
        }else if(rotation%4==3){
            //draw 6 lines
            character_length=0;
            for(int i=0;i<canvas_height;i++){
                //draw each line
                for(int j=0;j<canvas_width;j++) {
                    if (j > col_index-2 && j < col_index-1+character_length+1&&i<side_length){
                        System.out.print(character);
                    } else {
                        System.out.print(Background);
                    }
                }
                character_length+=1;
                System.out.println();
            }
        }

    }
}
