package equiv;

import java.util.ArrayList;
import java.util.List;

public class Equiv<E> {

	private List<List<E>> lis;

  public Equiv() {
	  lis=new ArrayList<>();
		for (List<E> s:lis)
			s=new ArrayList<E>();
	}
public void add(E e1, E e2) {
	 List<E> l=new ArrayList<>();
	  l.add(e1);
	  l.add(e2);
	  lis.add(l);
	  order(e1, e2);
	  System.out.println(lis);
  }
private void order(E e1, E e2) {
    boolean flag1=false,flag2=false;
    int in=0,in1=0;
	for(int i=0;i<lis.size()-1;i++) {
		for(int j=0;j<lis.get(i).size();j++) {
			if(lis.get(i).get(j).equals(e1)) {
				flag1=true;
				in=i;
			}
			if(lis.get(i).get(j).equals(e2)) {
				flag2=true;
				in1=i;
			}
		}
	}

	if(flag1&&!flag2) {
		lis.get(in).add(e2);
		lis.remove(lis.size()-1);

	}
	if(!flag1&&flag2) {
		lis.get(in1).add(e1);
		lis.remove(lis.size()-1);
	}
	
}
  public boolean are(E e1, E e2) {
	  boolean flag=false;
	  if(e1.equals(e2))return true;
	 
	  for(List<E> listIn:lis) {
			if (listIn.contains(e1)&&listIn.contains(e2))flag=true;
		}
	  return flag;
  }
/*public static void main(String[] args) {
	Equiv<String> equiv = new Equiv<>();
	equiv.add("ball", "balloon");
	equiv.add("child", "person");
	equiv.add("girl", "child");
	equiv.add("ball", "sphere");
	equiv.add("sphere", "circle");
	equiv.add("dog", "cat");
	equiv.add("girl", "circle");

	System.out.println(equiv.lis);
	System.out.println(equiv.are("balloon", "circle"));
	System.out.println(equiv.are("child", "girl"));
	System.out.println(equiv.are("sun", "sun"));	
	System.out.println(equiv.are("girl", "ball"));
	System.out.println(equiv.are("table", "dog"));	
}*/
}
