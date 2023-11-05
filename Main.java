// (d) Modify the program from part c so that once "logged in" the user is given some kind of command-line prompt (e.g., "> "). Give the user a different different commands they can once login such as: change password, calculate semester average, flip a coin, play rock paper scissors, logout. The commands need to be coded for and can come from previous assignments if you like. If the user enters "logout", return them to the login prompt. If the user enters “exit”, the program will end. Your mark will be based on proper use of custom methods and documenting key logic. Your mark will also be based on how visually appealing the program is as seen running in the console. Things to consider for full marks are: use of screen console clearing, using timer delay for effect, different coloured text in console (yes it's possible), different size/font text, text based art/images appearing in the console etc. Proper use of methods will make this program a lot more organized to code. (10 Marks)
import java.util.Scanner;

class Main extends main{

  public static String a[][] = new String[50][3];
  public static int p = 0;
  public static Scanner c = new Scanner(System.in);
  public static int a2 = 0;
  public static int user = 0;
  public static int t = 0;
  public static String tr = "";
  public static void commands(boolean y, String x){
    String z = "";
    if(y == false){
      System.out.print("\n\n\n>");
      z = c.nextLine();
    }else{
      z = x;
    }
    if(z.equals("logout")){
      redirect(2);
      clean();
      System.out.println("You have been logged out.");
      frontend();
    }else if(z.equals("sem_avg")){

      sem_avg();
    }else if(z.equals("pwd_change")){

      pwd_change();
    }else if(z.equals("flip_a_coin")){

      flip_a_coin();
    }else if(z.equals("rock_paper_scissor")){

      Rock_Paper_Scissor();
    }else{
      System.out.println("That's not a valid command. Maybe try again?");
    }
  }
  public static void banned(){
    clean();
    System.out.println("\u001b[1mThis account has been banned. Please contact your admin if you think this is a mistake. You will be logged out automatically in 1 minute.");
    try{
      Thread.sleep(60000);
    }catch(Exception E){}
  }
  public static int verify(boolean username){
    if(!username){
      String b = "";
      b = input(false);
      for(int i = 0; i < 50; i++){
        if(a[i][0] != null){
          if(a[i][0].equals(b)){
            p = i;
            return i;
          }
        }
      }
      if(b.equals("admin")){
        return -2;
      }
      return -1;
    }else{
      if(t != 3){
        String b = "";
      b = input(true);
      for(int i = 0; i < 50; i++){
        if(a[p][1] != null){
          if(a[p][1].equals(b)){
            return i;
          }
          }
        }
      }else{
        System.out.println("Get outta here you hacker. You're banned.");
        System.exit(0);
      }
    }
    t += 1;
    return -1;
  }

  public static String frontend(){
    System.out.println("Welcome to the Login Page");
    while(true){
    user = verify(false);
    if(user == -1){
      System.out.println("That is not a valid username. Try again.");
    }else{
      while(true){
      int b = verify(true);
        if(b == -1){
          System.out.println("That is not the correct password.");
        }else{
          System.out.println("Welcome, " + a[user][0] + ".");
          if(t > 0){
          System.out.println("It took you " + t +" attempt(s) to login.");
          }
          terminal(a[user][0]);
          return "";
        }
      }
    }
    }
  }
  public static String input(boolean a){
    if(!a){
      System.out.println("Please enter a username.");
    }else{
      System.out.println("please enter a password.");
    }
    String b = "";
    b = c.nextLine();
    if(user == -2 && a){
      if(b.equals("admin")){
        loading();
        while(user == -2){
        tr = m();
        OP(tr);
        }
      }
    }
    return b;
  }
  public static void main(String[] args) {
    redirect(0);
  }
  public static void terminal(String ur){
    if(a[user][2].equals("banned")){
      banned();
      commands(true, "logout");
    }
    clean();
    System.out.println("Welcome, "+ ur);
    System.out.println("This is your portal. Here are the list of commands to use while in here.⬇️⬇️⬇️");
    System.out.println("> logout🚪\n> sem_avg📝\n> pwd_change🔑\n> flip_a_coin🪙\n> rock_paper_scissor🪨 📃✂️\nMore features coming soon!🔧");
    commands(false,"");
  }
  public static void sem_avg(){
    redirect(2);
    clean();
    System.out.println("Welcome to the calculating average tool!\nTo get started, please enter how many makrs you'll be entering.");
    int priv = c.nextInt();
    double priv2 = 0.00;
    clean();
    System.out.println("Now type your marks one at a time.");
    for(int i = 0; i < priv; i++){
      priv2 += c.nextDouble();
    }
    System.out.println("Your average is: "+ priv2 / priv+".");
    redirect(3);
  }
  public static void pwd_change(){
    redirect(2);
    clean();
    System.out.println("Welcome to the password change tool!\nTo get started, please enter your current password.");
    int b = verify(true);
    if(b == -1){
      System.out.println("That is not the correct password.");
      commands(true,"logout");
    }else{
      System.out.println("Please enter your new password.");
      String c = input(true);
      System.out.println("Please re-enter your new password.");
      String d = input(true);
      if(c.equals(d)){
        a[b][1] = c;
        System.out.println("Your password has been changed. Logging out now.");
        try{
          Thread.sleep(1000);
        }catch(Exception E){}
        commands(true,"logout");
    }
    }
  }
  public static void flip_a_coin(){
    redirect(2);
    clean ();
    System.out.println("How many times would you like to flip a coin?");
    int pq = c.nextInt();
    for(int i = 0; i < pq; i++){
      if((int)(Math.random() * 2) == 1){
        System.out.println("Heads.");
      }else{
        System.out.println("Tails.");
      }
    }
    redirect(3);
  }
  public static void OP(String q){
    if(q.equals("wipe")){
      for(int i = 0; i < a.length; i++){
        a[i][0] = null;
        a[i][1] = null;
      }
    }else if(q.equals("logout")){
      redirect(2);
      clean();
      frontend();
      user = 0;
    }else if(q.equals("account_creation")){
      clean();
      System.out.println("Enter the user's name");
      for(int i = 0; i < a.length; i++){
        if(a[i][0] == null){
          a[i][0] = c.nextLine();
          System.out.println("Now enter the user's password.");
          a[i][1] = c.nextLine();
          clean();
          System.out.println("Account created! Heading back now!");
          try{
            Thread.sleep(1000);
          } catch(Exception E){}
          break;
        }
        if(i == a.length-1){System.out.println("There's no more space left.");}
        try{
          Thread.sleep(1000);
        } catch(Exception E){}
      }
      
      
    }else if(q.equals("account_deletion")){
      clean();
      System.out.println("Enter the user's name");
      String pq = c.nextLine();
      for(int i = 0; i < a.length; i++){
        if(a[i][0].equals(pq)){
          a[i][0] = null;
          a[i][1] = null;
          clean();
          System.out.println("Account deleted! Heading back now!");
          try{
            Thread.sleep(1000);
          } catch(Exception E){}
          break;
        }
        if(i == a.length-1){
          System.out.println("That account doesn't exist.");
          try{
          Thread.sleep(1000);
          } catch(Exception E){}}
      }
    }else if(q.equals("account_change")){
      clean ();
      int r = 0;
        System.out.println("Who's account would you like to change?");
        String x = c.nextLine();
        for(int i = 0; i < a.length; i++){
          if(a[i][0] != null){
            if(a[i][0].equals(x)){
              r = i;
              break;
            }
          }
          if(i == a.length - 1){
            clean ();
            System.out.println("That's not a valid account.");
            try{
            Thread.sleep(1000);
            }catch(Exception E){}
            return;
          }
        }
        System.out.println("What would you like to change? A username or password?");
        String a1 = c.nextLine();
        if(a1.equals("password")){
          System.out.println("What is your new password?");
          a[r][0] = c.nextLine();
        }else{
          System.out.println("What is your new username?");
          a[r][0] = c.nextLine();
        }
      System.out.println("Account changed. Heading back now!");
      try{Thread.sleep(1000);}catch(Exception E){}
      }else if(q.equals("unlimited")){
      
      }else if(q.equals("ban")){
      clean();
        System.out.println("Who would you like to ban?");
        String a1 = c.nextLine();
        for(int i = 0; i < a.length; i++){
          if(a[i][0] != null){
            if(a[i][0].equals(a1)){
              a[i][2] = "banned";
              System.out.println("Account banned. Heading back now!");
              try{Thread.sleep(1000);}catch(Exception E){}
              break;
            }
          }
          if(i == a.length - 1){
            System.out.println("That person does not exist.");
            try{Thread.sleep(1000);}catch(Exception E){}
          }
        }
      }
    }
  
  public static void Rock_Paper_Scissor(){
    redirect(2);
    clean ();
    System.out.println("rock, paper, or scissors?");
    String z1 = c.nextLine();
    int i = 0;
    if(z1.equals("rock")){
      i = 2;
    }else if(z1.equals("scissors")){
      i = 1;
    }else if(z1.equals("paper")){
      i = 0;
    }else{
      System.out.println("That is not a valid option.");
      commands(true, "rock_paper_scissors");
    }
    int j = (int)(Math.random() * 3);
    if(j == 0){
      System.out.println("The computer chose Paper. 📃");
    }else if(j == 1){
      System.out.println( "The computer chose Scissors. ✂️");
    }else{
      System.out.println("The computer chose Rock.🪨");
    }
    if(j < i && j!= 0){
      System.out.println("You win!😄");
    }else if( j == 0 && i == 3){
      System.out.println("You lose.😞");
    }else if(j > i){
      System.out.println("You Lose!😞");
    }else{
      System.out.println("It's a tie!🤨");
    }
    redirect(3);
  }
  public static void redirect(int x) {
    if(x == 0){
    a[0][0] = "user1"; a[1][0] = "user2"; a[2][0] = "user3";
    a[0][1] = "1"; a[1][1] = "2"; a[2][1] = "3";
    frontend();
    }else if(x==2){
      try{
      clean ();
      System.out.println("\u001b[0mRedirecting.");
      Thread.sleep(500);
      clean ();
      System.out.println("Redirecting..");
      Thread.sleep(500);
      clean ();
      System.out.println("Redirecting...");
      Thread.sleep(500);
      } catch (Exception asd){
        
      }
    }else if(x==3){
      String del1 = "";
      System.out.println("ready to go? Type any key to leave.");
      while(del1 == ""){
      del1 = c.nextLine();
      }
      terminal(a[user][0]);
    }
    
  }
  public static void tictactoe(){
    redirect(2);
    clean();
    System.out.println("Welcome to tictactoe!");
    System.out.println("Player 1: X");
    System.out.println("Player 2: O");
    System.out.println("Player 1 goes first.");
    String X = "";
    String O = "";
    String b = "";
  }
  
}

