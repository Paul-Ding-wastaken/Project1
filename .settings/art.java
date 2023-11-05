import java.util.Scanner;

class java{
  public static String X[] = {"\u2588\u2588      \u2588\u2588","  \u2588\u2588  \u2588\u2588  ","    \u2588\u2588    ","  \u2588\u2588  \u2588\u2588  ","\u2588\u2588      \u2588\u2588"};
  public static String O[] = {"   \u2588\u2588\u2588\u2588   "," \u2588\u2588    \u2588\u2588 "," \u2588\u2588    \u2588\u2588 "," \u2588\u2588    \u2588\u2588 ","   \u2588\u2588\u2588\u2588   "};
  public static String blank = "          ";
  public static String rail = " | ";
  public static String bound = "------------------------------------";
  public static boolean win = false;
  public static int p[] = new int[9];
  public static String board[][] = new String[3][3];
  public static int d[] = new int[5];
  public static int x[] = new int[4];
  public static int e = -1;
  public static void tictactoe(){
    Scanner c = new Scanner(System.in);
  System.out.println("Welcome to tic-tac-toe! To start, select a square by typing the row and column number(13 for the bottom left square.). You are X and The computer is O.");
    p[0] = 11;p[1] = 21;p[2] = 31;p[3] = 12;p[4] = 22;p[5] = 32;p[6] = 13;p[7] = 23;p[8] = 33; x[0] = 0;x[1] = 0;x[2] = 0;x[3] = 0;
    while(true){
      
      e += 1;
      d[e] = c.nextInt();
      board[(d[e]-(d[e]%10))/10 -1][d[e]%10 -1] = "X";
      pb();
      System.out.println("\n");
      try{
        Thread.sleep(3000);
      }catch(Exception E){}
      AI();
      if(e == 4){
        break;
      }
      pb();
      System.out.println("\n");
    }
  }
  public static void pb(){
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 5; j++){
        if(board[0][i] == null){
          System.out.print(blank);
        }else if(board[0][i].equals("O")){
          System.out.print(O[j]);
        }else{
          System.out.print(X[j]);
        }
        System.out.print(rail);
        if(board[1][i] == null){
          System.out.print(blank);
        }else if(board[1][i].equals("O")){
          System.out.print(O[j]);
        }else{
          System.out.print(X[j]);
        }
        System.out.print(rail);
        if(board[2][i] == null){
          System.out.print(blank);
        }else if(board[2][i].equals("O")){
          System.out.print(O[j]);
        }else{
          System.out.print(X[j]);
        }
        System.out.print("\n");
      }
      if(i < 2){
      System.out.println(bound);
      }
    }
  }
  public static void AI(){
    if(e == 0){
      if(d[e] == 22){
        board[0][0] = "O";
        x[0] = 11;
      }else{
        board[1][1] = "O";
        x[0] = 22;
      }
    }else if(e == 1){
      if(board[1][1].equals("X") && d[e] != 33){
      board[(9-(((d[e]%10)*3)-(3-((d[e]-d[e]%10)/10))))%3][(((10-(((d[e]%10)*3)-(3-(d[e]-d[e]%10)/10)))-1)-(((10-(((d[e]%10)*3)-(3-(d[e]-d[e]%10)/10)))-1)%3))/3] = "O";
        x[1] = ((9-(((d[e]%10)*3)-(3-((d[e]-d[e]%10)/10))))%3+1)*10 + ((((10-(((d[e]%10)*3)-(3-(d[e]-d[e]%10)/10)))-1)-(((10-(((d[e]%10)*3)-(3-(d[e]-d[e]%10)/10)))-1)%3))/3 +1);
      }else if(board[1][1].equals("X")){
        board[2][0] = "O";
        System.out.println("hi");
        x[1] = 31;
      }else if(board[1][1].equals("O")){
        if((d[0] == 11 || d[0] == 31 || d[0] == 13 || d[0] == 33) && (d[1] == 11 || d[1] == 31 || d[1] == 13 || d[1] == 33)){ 
        if((d[0] + d[1]) == 42){
          board[1][0] = "O";
          x[1] = 21;
        }else if((d[0] + d[1]) == 24){
          x[1] = 12;
          board[0][1] = "O";
        }else if((d[0] + d[1]) == 64){
          x[1] = 32;
          board[2][1] = "O";
        }else{
          x[1] = 23;
          board[1][2] = "O";
        }
        }else if(Math.abs(d[0] - d[1]) == 10 || Math.abs(d[0] - d[1]) == 1){
          if(d[0] - d[1] > 0){
            if(d[0] + d[0] - d[1] == 11 || d[1] - d[0] + d[1] == 11){
              x[1] = 11;
              board[0][0] = "O";
            }else if(d[0] + d[0] - d[1] == 31 || d[1] - d[0] + d[1] == 31){
              x[1] = 31;
              board[2][0] = "O";
            }else if(d[0] + d[0] - d[1] == 13 || d[1] - d[0] + d[1] == 13){
              x[1] = 13;
              board[0][2] = "O";
            }else{
              x[1] = 33;
              board[2][2] = "O";
            }
          }else{
              if(d[1] + d[1] - d[0] == 11 || d[0] - d[1] + d[0] == 11){
                x[1] = 11;
                board[0][0] = "O";
              }else if(d[1] + d[1] - d[0] == 31 || d[0] - d[1] + d[0] == 31){
                x[1] = 31;
                board[2][0] = "O";
              }else if(d[1] + d[1] - d[0] == 13 || d[0] - d[1] + d[0] == 13){
                x[1] = 13;
                board[0][2] = "O";
              }else{
                x[1] = 33;
                board[2][2] = "O";
              }
          }
        }
      }
      if(x[1] == 0){
          for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
              if(board[i][j] == null && x[1] == 0){
                board[i][j] = "O";
                x[1] = (j+1)*10 + i+1;
                break;
              }
            }
          }
       }

    }else if(e == 2){
      if(board[1][1].equals("O")){
      for(int i = 0; i < p.length; i++){
        if(x[0] - x[1] > 0){
          if(x[1] - x[0] + x[1] == p[i]){
            goated(p[i], true);
          }
          if(x[0] + x[0] - x[1] == p[i]){
            goated(p[i], true);
          }
        }else{
          if(x[0] - x[1] + x[0] == p[i]){
            goated(p[i], true);
          }
          if(x[1] + x[1] - x[0] == p[i]){
            goated(p[i], true);
          }
        }
      }
      }else if(board[1][1].equals("X") && x[2] == 0){
        for(int i = 0; i < p.length; i++){
          if((x[1] + x[0]) == p[i]*2){
            System.out.println(x[1]);
            System.out.println(x[0]);
            goated(p[i], true);
          }
        }
      }
      if(board[1][1].equals("X") && x[2] == 0){
        for(int i = 0; i < p.length; i++){
          if(d[0] - d[2] > 0){
            if(d[2] - d[0] + d[2] == p[i]){
              goated(p[i], false);
            }
            if(d[0] + d[0] - d[2] == p[i]){
              goated(p[i], false);
            }
          }else{
            if(d[0] - d[2] + d[0] == p[i]){
              goated(p[i], false);
            }
            if(d[2] + d[2] - d[0] == p[i]){
              goated(p[i], false);
            }
          }
        }
        for(int i = 0; i < p.length; i++){
          if(d[2] - d[1] > 0){
            if(d[1] - d[2] + d[1] == p[i]){
              goated(p[i], false);
            }
            if(d[1] + d[2] - d[1] == p[i]){
              goated(p[i], false);
            }
          }else{
            if(d[2] - d[1] + d[2] == p[i]){
              goated(p[i], false);
            }
            if(d[1] + d[1] - d[2] == p[i]){
              goated(p[i], false);
            }
          }
        }
      }else if(board[1][1].equals("O") && x[2] == 0){
        for(int i = 0; i < p.length; i++){
        if((d[0] + d[2]) == p[i]*2){
          goated(p[i], false);
        }
        if((d[1] + d[2]) == p[i]*2){
          goated(p[i], false);
        }
      }
      }
        if(x[2] == 0){
        for(int i = 0; i < 3; i++){
          for(int j = 0; j < 3; j++){
            if(board[i][j] == null && x[2] == 0){
              board[i][j] = "O";
              x[2] = (j+1)*10 + i+1;
              break;
            }
          }
        }
     }
    }else if(e == 3){
      if(board[1][1].equals("O")){
      for(int i = 0; i < p.length; i++){
        if(x[0] - x[2] > 0){
          if(x[2] - x[0] + x[2] == p[i]){
            goated(p[i], true);
          }
          if(x[0] + x[0] - x[2] == p[i]){
            goated(p[i], true);
          }
        }else{
          if(x[0] - x[2] + x[0] == p[i]){
            goated(p[i], true);
          }
          if(x[2] + x[2] - x[0] == p[i]){
            goated(p[i], true);
          }
        }
      }
      for(int i = 0; i < p.length; i++){
        if(x[2] - x[1] > 0){
          if(x[1] - x[2] + x[1] == p[i]){
            goated(p[i], true);
          }
          if(x[1] + x[2] - x[1] == p[i]){
            goated(p[i], true);
          }
        }else{
          if(x[2] - x[1] + x[2] == p[i]){
            goated(p[i], true);
          }
          if(x[1] + x[1] - x[2] == p[i]){
            goated(p[i], true);
          }
        }
      }
    }else if(board[1][1].equals("X")){
        for(int i = 0; i < p.length; i++){
        if((x[0] + x[2]) == p[i]*2){
          goated(p[i], true);
        }
        if((x[1] + x[2]) == p[i]*2){
          goated(p[i], true);
        }
      }
      }
      if(board[1][1].equals("X") && x[3] == 0){
      for(int i = 0; i < p.length; i++){
        if(d[0] - d[3] > 0){
          if(d[3] - d[0] + d[3] == p[i]){
            goated(p[i], false);
          }
          if(d[0] + d[0] - d[3] == p[i]){
            goated(p[i], false);
          }
        }else{
          if(d[0] - d[3] + d[0] == p[i]){
            goated(p[i], false);
          }
          if(d[3] + d[3] - d[0] == p[i]){
            goated(p[i], false);
          }
        }
      }
      for(int i = 0; i < p.length; i++){
        if(d[3] - d[1] > 0){
          if(d[1] - d[3] + d[1] == p[i]){
            goated(p[i], false);
          }
          if(d[1] + d[3] - d[1] == p[i]){
            goated(p[i], false);
          }
        }else{
          if(d[3] - d[1] + d[3] == p[i]){
            goated(p[i], false);
          }
          if(d[1] + d[1] - d[3] == p[i]){
            goated(p[i], false);
          }
        }
      }
        for(int i = 0; i < p.length; i++){
          if(d[3] - d[2] > 0){
            if(d[2] - d[3] + d[2] == p[i]){
              goated(p[i], false);
            }
            if(d[2] + d[3] - d[2] == p[i]){
              goated(p[i], false);
            }
          }else{
            if(d[3] - d[2] + d[3] == p[i]){
              goated(p[i], false);
            }
            if(d[2] + d[2] - d[3] == p[i]){
              goated(p[i], false);
            }
          }
        }
    }else if(board[1][1].equals("X")){
          for(int i = 0; i < p.length; i++){
          if((d[0] + d[3]) == p[i]*2){
            goated(p[i], false);
          }
          if((d[1] + d[3]) == p[i]*2){
            goated(p[i], false);
          }
            if((d[2] + d[3]) == p[i]*2){
              goated(p[i], false);
            }
        } 
      }
        if(x[3] == 0){
            for(int i = 0; i < 3; i++){
              for(int j = 0; j < 3; j++){
                if(board[i][j] == null && x[3] == 0){
                  board[i][j] = "O";
                  x[3] = (j+1)*10 + i+1;
                  break;
                }
              }
            }
         }
      win = true;
    }
      if(e == 4 && win == true){
      pb();
      System.out.println("Its a draw! Heading back now!");
      return;
    }

  }
  public static void goated(int q, boolean h){
    if(board[(q-q%10)/10-1][q%10 -1] == null){
      board[(q-q%10)/10-1][q%10 -1] = "O";
      if(x[2] == 0){
        x[2] = q;
      }else{
        x[3] = q;
      }
      if(h == true){
        pb();
        System.out.println("You Lost. Heading back now!");
        e = 4;
        return;
      }
    }else{
      return;
    }
  }
  public static void cleanㅤ(){
    System.out.println("\u001b[30m             \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588        \u2588\u2588\u2588\u2588\u2588\u2588                                                     \n\u001b[30m             \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588        \u2588\u2588\u2588\u2588\u2588\u2588                                                    \n\u001b[30m             \u2588\u2588\u2588          \u2588\u2588\u2588        \u2588\u2588\u2588                                                        \n\u001b[30m                         \u2588\u2588\u2588         \u2588\u2588\u2588                                                        \n\u001b[30m                        \u2588\u2588\u2588          \u2588\u2588\u2588                                                        \n\u001b[30m             \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588          \u2588\u2588\u2588                                                        \n\u001b[30m             \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588          \u2588\u2588\u2588                                                        \n\u001b[30m                        \u2588\u2588\u2588          \u2588\u2588\u2588                                                        \n\u001b[30m                         \u2588\u2588\u2588         \u2588\u2588\u2588                                                        \n\u001b[30m             \u2588\u2588\u2588          \u2588\u2588\u2588        \u2588\u2588\u2588                                                        \n\u001b[30m             \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588     \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588                                                     \n\u001b[30m             \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588     \u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588\u2588                                                     \n");

  }
}