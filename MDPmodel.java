import java.util.ArrayList;

public class MDPmodel
{
    public ArrayList<MDPmodel> Node = new ArrayList<>();
    public static   ArrayList<Transition> NextNode = new ArrayList<>();
    private String Time;
    private String Name;

    public MDPmodel(String Name, String Time)
    {
        this.Time = Time;
        this.Name = Name;
    }

    public void AddNode(MDPmodel node, Transition NewNode)
    {
        NextNode.add(NewNode);
        Node.add(node);
    }

    public String NodeName()
    {
        return Name;
    }

    public String NodeTime()
    {
        return Time;
    }



}





