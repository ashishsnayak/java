import java.util.*;


public class Main
{
  static ArrayList < Character > chars = new ArrayList < Character > ();
  static ArrayList < String > hide = new ArrayList < String > ();
  static ArrayList < Integer > n = new ArrayList < Integer > ();

  static int counter = 0;
  static int wordGuess = 0;


  public static void main (String[]args)
  {

    char[][] hanging = { {' ', '-', '-', '-', '-', '-', ' '},
    {' ', '|', ' ', ' ', ' ', '|', ' '},
    {' ', '|', ' ', ' ', ' ', ' ', ' '},
    {' ', '|', ' ', ' ', ' ', ' ', ' '},
    {' ', '|', ' ', ' ', ' ', ' ', ' '},
    {' ', '|', ' ', ' ', ' ', ' ', ' '},
    {' ', '|', ' ', ' ', ' ', ' ', ' '},
    {'-', '-', '-', '-', '-', ' ', ' '}

    };


    Scanner scan = new Scanner (System.in);
    System.out.println ("Enter A Secret Word: ");
    String q = scan.next ();
    String word = q.toLowerCase ();

    System.out.println ();


    for (char w:word.toCharArray ())
    {
	    chars.add (w);
    }
    // System.out.println(chars);


    for (int i = 0; i < word.length (); i++)
    {
	    hide.add (" _");
    }

    printHangingThing (hanging);
    getBlanks (hide);
    System.out.println ();


    String c = "";


    while (true)
    {
	    if (addPenalty (hanging) == true)
	    {
	        System.out.println ("Game Over.");
	        System.out.println ("The word was \"" + word + "\".");
	        break;
	    }


	    Scanner sc = new Scanner (System.in);
	    System.out.println ("Enter a letter: ");
	    c = sc.next ();


	    while (check (word, c) == false)
	    {
	        counter++;
	        addPenalty (hanging);

	        if (addPenalty (hanging) == true)
	        {
		        break;
	        }


	    // System.out.println(addPenalty(hanging));
	    printHangingThing (hanging);
	    getBlanks (hide);
	    System.out.println ();
	    System.out.println ("No. Please guess another letter: ");
	    c = sc.next ();
	  }

	//check (word, c);

	if (wordGuess == word.length ())
	  {
	    printHangingThing (hanging);
	    System.out.println ("You got the whole word! Yay!");
	    getBlanks (hide);
	    break;
	  }


	printHangingThing (hanging);
	getBlanks (hide);
	System.out.println ();

      }
  }

  public static void getBlanks (List hide)
  {

    for (int i = 0; i < hide.size (); i++)
      {
	System.out.print (hide.get (i));
      }

  }

  public static boolean check (String word, String c)
  {

    boolean foundchar = false;
    while (chars.contains (c.charAt (0)))
      {

        foundchar = true;
	int num = chars.indexOf (c.charAt (0));

	System.out.println ();

	hide.set (num, " " + c.charAt (0));
	System.out.println ();

	chars.set (num, '-');


	wordGuess++;
      }

	// System.out.println(n);

	//  getBlanks(hide);
	System.out.println ();
	// System.out.println(chars);

	if (foundchar && (word.length () > wordGuess))
	  {
	    System.out.println ("Nice! Guess another!");
	    // make randomizer that changes the message.
	  }


	return foundchar;

  }

  public static boolean addPenalty (char[][]hanging)
  {
    switch (counter)
      {
      case 1:
	hanging[2][5] = 'O';
	System.out.println ();
	return false;

      case 2:
	hanging[3][5] = '|';
	System.out.println ();
	return false;

      case 3:
	hanging[3][4] = '/';
	System.out.println ();
	return false;

      case 4:
	hanging[3][6] = '\\';
	System.out.println ();
	return false;

      case 5:
	hanging[4][5] = '|';
	System.out.println ();
	return false;

      case 6:
	hanging[5][4] = '/';
	System.out.println ();
	return false;

      case 7:
	hanging[5][6] = '\\';
	System.out.println ();
	return true;
      default:
	return false;
      }

  }


  public static void printHangingThing (char[][]hanging)
  {
  for (char[]row:hanging)
      {
      for (char c:row)
	  {
	    System.out.print (c);
	  }
	System.out.println ();
      }
  }




}
