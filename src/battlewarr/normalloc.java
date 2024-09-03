package battlewarr;

public abstract class  normalloc extends location{

	normalloc(player player,String name) {
		super(player);
		this.name=name;
	}
	public boolean getlocation() {
		return true;
	}

}
