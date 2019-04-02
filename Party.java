public class Party{
    Crusader party[];
	public Party(int size)
	{
		party = new Crusader[size];
	}
    public Crusader getParty(int x){
        return party[x];
    }
    public void setParty(int x, Crusader y){
        party[x] = y;
    }
}