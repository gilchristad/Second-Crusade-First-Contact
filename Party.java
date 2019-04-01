public class Party{
    Unit party[];
	public Party(int size)
	{
		party = new Unit[size];
	}
    public Unit getParty(int x){
        return party[x];
    }
    public void setParty(int x, Unit y){
        party[x] = y;
    }
}