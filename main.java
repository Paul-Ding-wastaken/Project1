import java.util.Scanner;
import java.util.Arrays;

class main extends java{
  public static Scanner c = new Scanner(System.in);
  public static String m(){
    String i = darkweb();
    return i;
  }
  public static String darkweb(){
    clean ();
    System.out.println("\u001b[40m\u001b[32;1m\u001b[1mWelcome back operator. 👨‍💻\nWhat would you like to do today? Here are the commands at your arsenal. \n>Wipe\nThis will revoke everyone's accounts and prevent anyone from logging in.\n\n>account_creation\nCreates a new account.\n\n>account_deletion\nDeletes someone's account.\n\n>account_change\nChanges a person's password in case they forgot. Or changes their username if they request it.\n\n>unlimited\nAllows you to create an account greater than the limit of 50.\n\nban\nBans a person from using their account.\n\n>???\n?");
    String a = c.nextLine();
    if(a.equals("wipe")){
      wipe();
      return "wipe";
    }else if(a.equals("logout")){
      return"logout";
    }else if(a.equals("account_creation")){
      return "account_creation";
    }else if(a.equals("account_deletion")){
      return "account_deletion";
    }else if(a.equals("account_change")){
      return "account_change";
    }else if(a.equals("ban")){
      return "ban";
    }else if(a.equals("tictactoe")){
      tictactoe();
      try{Thread.sleep(2000);}catch(Exception E){}
      darkweb();
    }
    
    return "timeout";
  }
  public static void clean (){
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
  public static void loading(){
    try{
      clean ();
      for(int i = 0; i < 2; i++){
      System.out.println("\u001b[40m\u001b[32;1m\u001b[1mPreparing your tools.");
      Thread.sleep(1000);
      clean ();
      System.out.println("\u001b[40m\u001b[32;1m\u001b[1mPreparing your tools..");
      Thread.sleep(1000);
      clean ();
      System.out.println("\u001b[40m\u001b[32;1m\u001b[1mPreparing your tools...");
      Thread.sleep(1000);
      clean ();
      }
      System.out.println("Preparing your tools..?");
      cleanㅤ();
      Thread.sleep(1000);
      clean ();
    }catch(Exception E){
      clean ();
    }
  }
  public static void wipe(){
    clean ();
System.out.println("Wiping accounts.");
    try{
    Thread.sleep(1000);
    clean ();
    System.out.println("Wiping accounts..");
    Thread.sleep(1000);
    clean ();
    System.out.println("Wiping accounts...");
    Thread.sleep(1000);
    clean ();
    System.out.println("Wiped!");
    Thread.sleep(1000);
    clean ();
    }catch(Exception E){}
  }
    
}