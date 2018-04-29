import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        MDPmodel Root = NodeInit(); // This will call NodeInit and receive the root of the tree
    }

    public static MDPmodel NodeInit()
    {
        ArrayList<MDPmodel> Nodes = new ArrayList<>(); //This is for keeping track of the created nodes
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/Node.txt"));
            reader.readLine();
            reader.readLine();
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                if(words[0].equals("Node")) // If the line starts with Node we assume is a node and created the object
                {
                    MDPmodel node = new MDPmodel(words[1], words[2]);
                    Nodes.add(node);// Add the Node to the array list
                }
                else if(words[0].equals("Transition"))
                {
                    //Creates a new Transition Object
                    Transition Trans = new Transition(words[1], Integer.parseInt(words[2]), Double.parseDouble(words[3]));
                    //Uses the created transition object and indexes of the nodes to make the transition
                    Nodes.get(Integer.parseInt(words[4])-1).AddNode(Nodes.get(Integer.parseInt(words[5])-1), Trans);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return Nodes.get(0); //return the first node in the list

    }
}
