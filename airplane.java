import java.util.Scanner;
class airplane_ticket
{

    public static void printline()
    {
        for( int g = 1; g <= 120; g++)
        {System.out.print('_');

        }
        System.out.println();
    }

    public static void printlinest()
    {
        for( int g = 1; g <= 120; g++)
        {System.out.print('*');

        }
        System.out.println();
    }

    public static void login ()
    {

        Scanner in = new Scanner(System.in);
        System.out.println("    LOGIN   ");

        String list[] = {"rajeev", "sanjeev", "manish"};
        String pass[] = { "123raj", "sanj73", "Man25"};

        System.out.println("Username with corresponding passwords :");
        for ( int h = 0; h < list.length; h++)
        {
            System.out.println(list[h]);
            System.out.println(pass[h]);
            System.out.println();
        }

        System.out.println(" Enter Username ");
        String username = in.nextLine();

        boolean b = false;
        for(int g = 0; g < list.length; g++)
        {if(username.equals(list[g]))
                b = true;
        }

        if ( b == false)
        { System.out.println("wrong username");
            System.exit(0);
        }

        System.out.println(" Enter password (Password is case sensitive)");
        String password = in.nextLine();

        b = false;
        for(int g = 0; g < list.length; g++)
        {if(username.equals(list[g]) && password.equals(pass[g]))
                b = true;
        }

        if ( b == false)
        { System.out.println("wrong password");
            System.exit(0);
        }
        printline();
    }

    public static void main()
    {   login();
        /** variables*/

        char choice;
        Scanner in = new Scanner(System.in); 
        int n = 23, seat = 1;int i = -1;
        String bookref[] = new String[8],bookref2, pa_name1[] = new String[8], pa_name2[] = new String[8] , nation[] = new String[8],  pass_nu[] = new String[8], name;  
        int age[] = new int[8], seat_nu[] = new int[8];
        boolean ticketstatus[] = new boolean[8]; char choice2; 
        String flight = " Flight 6E 154"; String depart_junc = "BOM (Chhatrapati Shivaji  Airport"; String date = "Date : 12/12/2017";
        String time_depart = " Departure time :(02:00)";  String arrive_junc = " DEL( Indra Gandhi International Airport";
        String time_arrive = " Arrival time :(04:05)";
        int nu_vacseats = 8 ,nu; 

        /**variables*/
        do
        {
            int ctr = 0;
            printline();
            System.out.println();
            System.out.println("CHOOSE AN OPTION : a/b/c/d/e/f/g (Choose option a before implementing any other option)"); // displaying menu
            System.out.println(" a) Book a Ticket"); 
            System.out.println(" b) Cancel a ticket");
            System.out.println(" c) Search passenger name and display details");
            System.out.println(" d) Sort records of passenger in ascending order");
            System.out.println(" e) Print air ticket.");
            System.out.println(" f) Display the seat availability status");
            System.out.println(" g) Exit ");
            choice = Character.toLowerCase(in.next().charAt(0));
            printline();

            switch (choice)
            {
                case 'a' :

                if( nu_vacseats == 0) // to check availabilty of seats
                {System.out.println("Flight is full");
                    continue;
                }

                ++i; // to be used for array storing passenger details
                System.out.println( " Departure Junction : " + depart_junc);
                System.out.println( " Arrival junction : " + arrive_junc);
                System.out.println(date);

                printline(); 

                System.out.println("Flight : " + flight);
                System.out.println("departure time:" + time_depart);
                System.out.println("arrival time: " + time_arrive);

                System.out.println(" Class : Economy"); 
                System.out.println("Enter number of seats");
                nu = in.nextInt();
                bookref = new String[nu];

                System.out.println("Please enter passenger details ");
                printline();

                for( int j = 1; j <= nu; j++) // accepting passenger details
                { System.out.println(" Enter passenger" + (j) +"'s first name");
                    pa_name1[i] = in.next();
                    System.out.println(" Enter passenger" + (j) +"'s surname");
                    pa_name2[i] = in.next();
                    System.out.println("Enter passenger" + (j) +"'s age");
                    age[i] = in.nextInt();
                    System.out.println("Enter passenger" + (j) +"'s nationality");
                    nation[i] = in.next();
                    System.out.println("Enter passenger" + (j) +"'s Passport number");
                    pass_nu[i] = in.next();
                    printline();
                    ticketstatus[i] = true;

                    ++i;
                }
                nu_vacseats = nu_vacseats - nu;
                printline();

                i = i - nu;
                for(int j = 0; j < nu; j++) // displaying passenger booking reference and seat number
                {
                    System.out.println( (j+1) + ". " + pa_name1[j] + " " + pa_name2[j]);

                    bookref[i] = "B" + (n++);
                    seat_nu[i] = seat++ ;
                    System.out.println("Your booking reference is " + bookref[i]);
                    System.out.println("Your seat number is " + ++seat_nu[i]);
                    System.out.println();
                    ++i;

                } 

                break;
                case 'b':
                // for cancelling a ticket
                printline();
                System.out.println("Enter your booking reference");
                bookref2 = in.next();
                for( int h = 0; h < i;h++)
                {   if ( bookref2.equals(bookref[h]))
                    {
                        System.out.println("Passenger name");
                        System.out.println(pa_name1[h] + " " + pa_name2[h]);
                        System.out.println("confirm cancellation, enter y/n");
                        choice2 = in.next().charAt(0);

                        choice2 = Character.toLowerCase(choice2);
                        if( choice2 == 'y')
                        {
                            ticketstatus[h] = false;
                            System.out.println("your ticket has been cancelled");

                        }
                    }
                }

                break;
                case 'c' :

                do // to search for passenger details and display
                {
                    printline();
                    System.out.println("Enter passenger's first name");
                    name = in.next();
                    printline();
                    for(int h = 0; h <= i; h++)
                    { 
                        if( name.equals(pa_name1[h]))
                        { 
                            ctr++;

                            System.out.println("Passenger found");
                            System.out.println("Passenger Name: " + pa_name1[h] + " " + pa_name2[h]);
                            System.out.println("Passenger Age: " + age[h]);
                            System.out.println("Passenger Nationality: " + nation[h]);
                            System.out.println("Passenger Passport number: " + pass_nu[h]);
                            System.out.println();
                            System.out.println(flight);
                            System.out.println(time_depart);
                            System.out.println(time_arrive);

                            System.out.println("Passenger Seat number: " + seat_nu[h]);
                            System.out.println("Passenger Booking reference: " + bookref[h]);
                            if(ticketstatus[h] == false)
                                System.out.println("Passenger ticket status: ticket has been cancelled" );

                        }

                    } 

                    if( ctr == 0)
                    {  System.out.println("Passenger not found");
                        System.out.println("Enter passenger name again");

                    }

                }while( ctr == 0);

                break;
                case 'd':

                //for sorting in alphabetical order
                String temp; int z= i-1;

                for (int x = 0; x < i; x++)
                {
                    for (int y = 0; y < z; y++)
                    {

                        if( pa_name1[y].compareTo( pa_name1[y+1]) > 0)
                        { 
                            temp = pa_name1[y];
                            pa_name1[y] = pa_name1[y+1];
                            pa_name1[y+1] = temp;
                        }

                    }
                    z--;
                }
                for(int d = 0; d < i; d++)
                {  System.out.println((d+1) + ". " + pa_name1[d]);
                    System.out.println("Booking reference: " + bookref[d]);
                    System.out.println("Seat reference: " + seat_nu[d]);

                }

                break;
                case 'e':
                // printing air ticket
                System.out.println(" FLIGHT NAME \t\t" + "DEPARTURE TERMINAL \t \t" + "ARRIVAL TERMINAL \t\t" + "Non-stop flight \t ");
                printlinest();
                System.out.println(   flight+" \t \t"   +    " Mumbai(BOM)\t" +"                  Delhi(DEL)\t\t       " + "Duration : 2hrs 5mins" );
                System.out.println(   "  12/12/2017"+  "  \t    "  + time_depart + " \t     " +  time_arrive + "\t\t  Cabin: Economy");
                System.out.println();
                System.out.println(" PASSENGER NAME \t\t" + "AGE \t \t" + "SEAT NUMBER \t\t" + "BOOKING REFERENCE \t ");
                printlinest();
                for(int y = 0; y < i; y++)
                {

                    System.out.println("  " + pa_name1[y]+" "+ pa_name2[y] +" \t\t\t " + age[y]+" \t\t " + seat_nu[y] +" \t\t\t " + bookref[y]);
                }

                break;
                case'f':
                // seat availability
                System.out.println("Number of Vacant seats : " + nu_vacseats);
                System.out.println("Find your seat availability status, Enter your booking reference");
                String bookingref = in.next();
                for(int s = 0; s < i; s++)
                {
                    if( bookingref.equals(bookref[s]))
                    {
                        if(ticketstatus[s] == false)
                            System.out.println("Your ticket has been cancelled");
                        else
                        {  System.out.println("1. " + pa_name1[s] + " " + pa_name2[s] );
                            System.out.println("Your seat number is: " + seat_nu[s]);
                        }
                    }
                }

            }
        }while( choice != 'g');
    }
}

/** VARIABLE DISCRIPTION :
Int : g,h,j,x,y,d,s : for for loops , n : for booking reference, seat : for seat number, i : for array index, nu_vacseats : number of vacant seats, nu = to accept number of seats
ctr : to check in search option if name exists, z = to store length of array - 1;
Arrays : age[] : to store passenger age, seat_num = to store seat number

Char: choice : to accept menu choice, choice2 : to accept y/n in cancellation option

Boolean : b : used in login to check if accurate details are entered. 
Array : ticketstatus[] : to store availability of passenger's ticket

String : username : to accept username, password : to accept password, name : to accept passengers first name, flight : to store flight name,
time_depart : to store departure time, time_arrive : to store arrival time, depart_junc = to store depart junctino, arrive_junc = to store arrival junction.
date : to store date of departure, bookref2 : to accept booking reference to use in search option, temp : used in sorting to store values temporarily
Arrays : bookref[] : to store booking reference, pa_name1[] : to store passengers first name, pa_name2[] : to store passengers second name
nation[] : to store nationality, pass_nu[] : to store passenger numbers
 */


