public class Transition
{
    public int Reward;
    public String Name;
    public double Probability;

    public Transition(String Name, int Reward,  double Probability)
    {
        this.Reward = Reward;
        this.Name = Name;
        if(Probability > 1.0)
            this.Probability = 1.0;
        this.Probability = Probability;
    }

}
