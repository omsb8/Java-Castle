import java.io.*;
import java.util.*;
import javax.swing.*;


public class castle
{
	
	static String CLS = "\033[2J\033[1;1H";
	static String Red = "\033[31;1m";
	static String Green = "\033[32;1m";
	static String Yellow = "\033[33;1m";
	static String Blue = "\033[34;1m";
	static String Purple = "\033[35;1m";
	static String Cyan = "\033[36;1m";
	static String White = "\033[37;1m";
	static String Normal = "\033[0m"; // default gray color & reset background to black
	
	
	static ArrayList<Room> Vertex = new ArrayList<Room>();
	static ArrayList<Room> Path = new ArrayList<Room>();

	public static void main(String[] args) throws IOException
	{
		
		//-----------Showing Map
		var frame = new JFrame();
		var icon = new ImageIcon("my_castle.jpg");
		var label = new JLabel(icon);
		frame.add(label);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		

		Scanner in = new Scanner(System.in);

		// read in vertices
		File file = new File("vertex.txt");
		Scanner infile = new Scanner(file);
		String Input = "";
		while (infile.hasNextLine())
		{
			Input = infile.nextLine();
			Vertex.add(new Room(Input));
		}
		System.out.println(Vertex.size() + " vertices read from file"); //--------------------------- For Testing

		// read in edges
		file = new File("edge.txt");
		infile = new Scanner(file);
		String From, Direction, To;
		int Count=0;
		while (infile.hasNext())
		{
			Count++;
			From = infile.next();
			Direction = infile.next();
			To = infile.next();
			// Uncomment this line to help debug runtime error reading edge.txt
			// System.out.println("From: " + From + " Direction: " + Direction + " To: " + To);
			
			// locate From Vertex in ArrayList
			int IndexFrom = 0;
			while (!Vertex.get(IndexFrom).RoomName.equals(From))
			{  IndexFrom++;  }
			// locate To Vertex in ArrayList
			int IndexTo = 0;
			while (!Vertex.get(IndexTo).RoomName.equals(To))
			{  IndexTo++;  }
			// create edge
			if (Direction.equals("North"))
			{
				Vertex.get(IndexFrom).North = Vertex.get(IndexTo);
				Vertex.get(IndexTo).South = Vertex.get(IndexFrom);
			}
			if (Direction.equals("South"))
			{
				Vertex.get(IndexFrom).South = Vertex.get(IndexTo);
				Vertex.get(IndexTo).North = Vertex.get(IndexFrom);
			}
			if (Direction.equals("East"))
			{
				Vertex.get(IndexFrom).East = Vertex.get(IndexTo);
				Vertex.get(IndexTo).West = Vertex.get(IndexFrom);
			}
			if (Direction.equals("West"))
			{
				Vertex.get(IndexFrom).West = Vertex.get(IndexTo);
				Vertex.get(IndexTo).East = Vertex.get(IndexFrom);
			}
		}
		System.out.println(Count + " edges read from file"); //-------------------- For Testing
		System.out.println("______");
		System.out.println("|          /\\       |>>    |\\    /|");
		System.out.println("|_____    /__\\      |>>>   | \\  / |");
		System.out.println("|        /    \\     |>\\    |  \\/  |");
		System.out.println("|       /      \\    |  \\   |      |");
		System.out.println("|      /        \\   |   \\  |      |");

		System.out.println("Press <Enter> to Continue");
		in.nextLine();
		Room Entrance = Vertex.get (0);
		Room Temp = Entrance;
		char Choice = ' '; 
		while (Choice !='q')
		{
			System.out.println ( "You are in the : " +Green+ Temp.RoomName +Normal);

			if (Temp.RoomName.equals("Your_Farm")) {
				// ASCII art for Your Farm
				System.out.println("     /\\");
				System.out.println("    /  \\ ");
				System.out.println("   /    \\");
				System.out.println("  /      \\");
				System.out.println(" /        \\");
				System.out.println("/__________\\");
				System.out.println("|          |");
				System.out.println("|          |");
				System.out.println("|          |");
				System.out.println("|          |");
				System.out.println(" ----------");
			}

			if (Temp.RoomName.equals("Ocean"))
			{
				System.out.println(Blue + "~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~"+Normal);
			}
			if (Temp.RoomName.equals("Bus_Stop"))
			{
				System.out.println("      ___________");
				System.out.println("     |           |");
				System.out.println("=====|           |======");
				System.out.println("     |           |");
				System.out.println("      -----------");
			}

			if (Temp.RoomName.equals("River")) {
				// ASCII art for the River
				System.out.println(Blue + "~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~"+Normal);
			}

			if (Temp.North != null)
				System.out.println ("  ___|  |___");
			else
			{
				System.out.println("  __________");
				System.out.println(" |          |");
			}
			if (Temp.West != null && Temp. East != null) // door east and west
			{
				System.out.println ("_|          |_");
				System.out.println ("_            _");
			}
			
			if (Temp.West == null && Temp.East != null) // door west
			{
				System.out.println(" |          |_");
				System.out.println(" |           _");
			}

			if (Temp.West != null && Temp.East == null)
			{
				System.out.println("_|          |");
				System.out.println("_           |");
			}
			System.out.println(" |          |");
			
			
			if (Temp.South != null)
			{
				System.out.println (" |___    ___|");
				System.out.println ("     |  |  ");
			}
			else
				System.out.println ("  ----------");
				
			System.out.print ("You can move to the following direction/s "+Red+"ONLY"+Normal+": ");
			if (Temp.North != null)
				System.out.print ("North ");
			if (Temp. South != null)
				System.out.print ("South ");
			if (Temp.East != null)
				System.out.print ("East ");
			if (Temp.West != null)
				System.out.print ("West ");
			System.out.println () ;
			// room ASCII art would go here
			System.out.println ("Options "+Red+"N"+Normal+"=north, "+Red+"S"+Normal+"=south, "+Red+"E"+Normal+"=east, "+Red+"W"+Normal+"=west, "+Red+"F"+Normal+"=find path,  "+Red+"q"+Normal+"=quit");
			Choice = in.next().charAt(0);
			if ((Choice == 'e' || Choice == 'E') && Temp.East != null)
				Temp = Temp.East;
			if ((Choice == 'w' || Choice == 'W') && Temp.West != null)
				Temp = Temp.West;
			if ((Choice == 's' || Choice == 'S') && Temp.South != null)
				Temp = Temp.South;
			if ((Choice == 'n' || Choice == 'N') && Temp.North != null)
				Temp = Temp.North;
			if (Choice == 'f' || Choice == 'F')
			{
				
				Scanner in1 = new Scanner(System.in);
		        System.out.println("Please type one of the following rooms to find the shortest path to it: ");
		        System.out.println("1- Your_Farm.");
		        System.out.println("2- Marnie_Ranch.");
		        System.out.println("3- Wizard_Tower.");
		        System.out.println("4- River.");
		        System.out.println("5- Bus_Stop.");
		        System.out.println("6- Village.");
		        System.out.println("7- Carpenter.");
		        System.out.println("8- Mines.");
		        System.out.println("9- Mountains.");
		        System.out.println("10- Community_Center.");
		        System.out.println("11- Museum.");
		        System.out.println("12- Beach.");
		        System.out.println("13- Ocean.");
				
				
		        String Destination = in1.nextLine();
				int count = 0;
				
				
				
				while (count < Vertex.size() && !Vertex.get (count) . RoomName. equals (Destination))
				{
					count++;
				}
				
				if (count == Vertex.size())
				{
					System.out.print("The destiantion you entered is not available. Thank you! ");
					System.out.println();
					System.out.println();

				}
				
				else
				{
					Dijkstra (Temp, Vertex.get (count) ) ;
					
					// if Destination found print Path 
					for (int i=0; i<Path.size () ; i++)
					{
						System.out.print(Blue+Path.get(i).RoomName+Yellow+ " > "+Normal);
					}	
					System.out.println();
				}

				

			}
			

		}

	}// end main
	
	static void Dijkstra(Room Start, Room Finish)
	{
		// set distance to all rooms (except for Start) to 1000 and visited = false
		for (int i=0; i<Vertex.size(); i++)
		{
			if (Vertex.get(i) == Start)
				Vertex.get(i).Distance = 0;
			else
				Vertex.get(i).Distance = 1000;  // set distance to "infinity"
			Vertex.get(i).Visited = false;
		}
		// Do Dijkstra - find Distance to each room
		Room Temp = Start;
		while (!Finish.Visited)
		{
			Temp.Visited = true;
			if (Temp.North!=null && !Temp.North.Visited && Temp.North.Distance > Temp.Distance+1)
				Temp.North.Distance = 1 + Temp.Distance;
			if (Temp.South!=null && !Temp.South.Visited && Temp.South.Distance > Temp.Distance+1)
				Temp.South.Distance = 1 + Temp.Distance;
			if (Temp.East!=null && !Temp.East.Visited && Temp.East.Distance > Temp.Distance+1)
				Temp.East.Distance = 1 + Temp.Distance;
			if (Temp.West!=null && !Temp.West.Visited && Temp.West.Distance > Temp.Distance+1)
				Temp.West.Distance = 1 + Temp.Distance;

			int Smallest = 1000;
			int SmallestIndex = 0;
			for (int i=0; i<Vertex.size(); i++)
			{
				if (!Vertex.get(i).Visited && Vertex.get(i).Distance < Smallest)
				{
					Smallest = Vertex.get(i).Distance;
					SmallestIndex = i;
				}
			}
			Temp = Vertex.get(SmallestIndex);
		}

		// populate Path ArrayList with Rooms of shortest path
		Temp = Finish;
		Path.clear();
		Path.add(0,Finish);
		while (Temp != Start)
		{
			int N = 1000, S = 1000, E = 1000, W = 1000;
			if (Temp.North != null)  N = Temp.North.Distance;
			if (Temp.South != null)  S = Temp.South.Distance;
			if (Temp.East != null)  E = Temp.East.Distance;
			if (Temp.West != null)  W = Temp.West.Distance;
			if (N < S && N < E && N < W)
				Temp = Temp.North;
			else if (S < E && S < W)
				Temp = Temp.South;
			else if (E < W)
				Temp = Temp.East;
			else
				Temp = Temp.West;
			Path.add(0,Temp);
		}
	}// end Dijkstra
	
	
}

	
	
	
	
	
class Room
{
	String RoomName;
	Room North, South, East, West;
	boolean Visited;   // used for Dijkstra
	int Distance;      // used for Dijkstra

	Room (String theRoomName)
	{
		RoomName = theRoomName;
		
	}
}


    
    

