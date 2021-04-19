import java.util.Scanner;

public class ConsoleDrawing {
    /* authorship statement
     * name Yueyuan Zhang
     * student number 1214448
     * username YUEYUANZ */
    public static void main(String[] args) {
        //Basic settings
        int canvas_width = 10;
        int canvas_height = 6;
        int col_index = 1;
        int rotation = 40;
        int side_length=0;
        String option="1";
        String alignment="left";
        String character="A";
        String Background="-";
        String another="N";

        //import other classes
        DrawingCanvas drawCanv = new DrawingCanvas();

        //welcome screen
        System.out.println("----WELCOME TO MY CONSOLE DRAWING APP----\n" +
                "Current drawing canvas settings:\n" +
                "- Width: " + canvas_width + "\n" +
                "- Height: " + canvas_height + "\n" +
                "- Background character: "+Background+"\n");
        //choose what to draw
        System.out.println("Please select an option. Type 4 to exit.\n" +
                "1. Draw triangles\n" +
                "2. Draw squares\n" +
                "3. Update drawing canvas settings\n" +
                "4. Exit");
        Scanner keyboard = new Scanner(System.in);
        option = keyboard.next();

        while(!option.equals("4")){
            //option=1. Draw triangles
            if(option.equals("1")) {
                System.out.println("Side length:");
                side_length = keyboard.nextInt();
                if (side_length > canvas_height || side_length > canvas_width) {
                    System.out.println("Error! The side length is too long (Current canvas size is " + canvas_width + "x" + canvas_height + "). Please try again.\nSide length:");
                    side_length = keyboard.nextInt();
                }
                System.out.println("Printing character:");
                character = keyboard.next();
                System.out.println("Alignment (left, middle, right):");
                alignment = keyboard.next();
                //draw canvas;
                drawCanv.Setting(alignment, option, canvas_width, canvas_height, side_length, character, col_index, rotation, Background);
                System.out.println("Type R/L to rotate clockwise/anti-clockwise. Use other keys to continue.");
                outer:
                for (int i = 0; i < 50; i++) {
                    String change = keyboard.next();
                    switch (change) {
                        //rotate function
                        case "R":
                        case "r":
                            rotation += 1;
                            drawCanv.Setting(alignment, option, canvas_width, canvas_height, side_length, character, col_index, rotation, Background);
                            System.out.println("Type R/L to rotate clockwise/anti-clockwise. Use other keys to continue.");
                            break;
                        case "L":
                        case "l":
                            rotation -= 1;
                            drawCanv.Setting(alignment, option, canvas_width, canvas_height, side_length, character, col_index, rotation, Background);
                            System.out.println("Type R/L to rotate clockwise/anti-clockwise. Use other keys to continue.");
                            break;
                        default:
                            System.out.println("Draw another triangle (Y/N)?");
                            another = keyboard.next();
                            if (!another.equals("Y") && !another.equals("N")) {
                                System.out.println("Unsupported option. Please try again!");
                            }
                            if (another.equals("N")) {
                                System.out.println("Please select an option. Type 4 to exit.\n" +
                                        "1. Draw triangles\n" +
                                        "2. Draw squares\n" +
                                        "3. Update drawing canvas settings\n" +
                                        "4. Exit");
                                option = keyboard.next();
                                if (option.equals("4")) {
                                    System.out.println("Goodbye!");
                                    System.exit(0);
                                }
                                break outer;
                            }
                            if (another.equals("Y")) {
                                option = "1";
                                break outer;
                            }
                    }
                }
            }//option=2. Draw squares
            else if(option.equals("2")) {
                //input drawing arguments
                System.out.println("Side length:");
                side_length = keyboard.nextInt();
                if (side_length > canvas_height || side_length > canvas_width) {
                    System.out.println("Error! The side length is too long (Current canvas size is " + canvas_width + "x" + canvas_height + "). Please try again.\nSide length:");
                    side_length = keyboard.nextInt();
                }
                System.out.println("Printing character:");
                character = keyboard.next();
                System.out.println("Alignment (left, middle, right):");
                String judge= keyboard.next();
                if(judge.equals("left") ||judge.equals("middle")||judge.equals("right")){
                    alignment=judge;
                }
                //draw canvas;
                drawCanv.Setting(alignment, option, canvas_width, canvas_height, side_length, character, col_index, rotation, Background);
                System.out.println("Type I/O to zoom in/out. Use other keys to continue.");
                outer:
                for (int i = 0; i < 50; i++){
                    String change = keyboard.next();
                    switch (change) {
                        //zoom function
                        case "I":
                            side_length += 1;
                            if (side_length > canvas_height) {
                                side_length = canvas_height;
                            }
                            drawCanv.Setting(alignment, option, canvas_width, canvas_height, side_length, character, col_index, rotation, Background);
                            System.out.println("Type I/O to zoom in/out. Use other keys to continue.");
                            break;
                        case "O":
                            side_length -= 1;
                            if (side_length == 0) {
                                side_length = 1;
                            }
                            drawCanv.Setting(alignment, option, canvas_width, canvas_height, side_length, character, col_index, rotation, Background);
                            System.out.println("Type I/O to zoom in/out. Use other keys to continue.");
                            break;
                        default:
                            System.out.println("Draw another square (Y/N)?");
                            another = keyboard.next();
                            if (!another.equals("Y") && !another.equals("N")) {
                                System.out.println("Unsupported option. Please try again!");
                            }
                            if (another.equals("N")) {
                                System.out.println("Please select an option. Type 4 to exit.\n" +
                                        "1. Draw triangles\n" +
                                        "2. Draw squares\n" +
                                        "3. Update drawing canvas settings\n" +
                                        "4. Exit");
                                option = keyboard.next();
                                if (option.equals("4")) {
                                    System.out.println("Goodbye!");
                                    System.exit(0);
                                }
                                break outer;
                            }
                            if (another.equals("Y")) {
                                option = "2";
                                break outer;
                            }
                    }
                }

            }//option=3. Update drawing canvas settings
            else if(option.equals("3")){
                System.out.print("Canvas width: ");
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
            }//option=4. Exit
            else if(option.equals("4")){
                System.out.println("Goodbye!");
                System.exit(0);
            }//function selection error
            else{
                System.out.println(
                        "Unsupported option. Please try again!\n" +
                                "Please select an option. Type 4 to exit.\n" +
                                "1. Draw triangles\n" +
                                "2. Draw squares\n" +
                                "3. Update drawing canvas settings\n" +
                                "4. Exit"
                );
                option = keyboard.next();
            }
        }
    }
}

