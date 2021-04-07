package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
   private ArrayList<Instrument> listShop;
   
   public Shop() {
	listShop=new ArrayList<Instrument>();
}

public void add(Instrument i) {
	   listShop.add(i);
   }
   
   public Instrument get(int serial) {
	   Instrument ins;
	   for (int i=0;i<listShop.size();i++) {
		   ins=listShop.get(i);
		   if(ins.getSerial()==serial)
			   return ins;
	   }
	   return null;
   }
   
   public List<Integer> allSerials() {
	   List<Integer> l = new ArrayList<>();
	   Instrument ins;
	   for (int i=0;i<listShop.size();i++) {
		   ins=listShop.get(i);
		   l.add(ins.getSerial());
	   }
	   return l;
   }
   
   public List<Integer> guitarsOfType(Type t){
	   List<Integer> l = new ArrayList<>();
	   Instrument ins;
	   for (int i=0;i<listShop.size();i++) {
		   ins=listShop.get(i);
		   if(ins instanceof Guitar) {
			   if(((Guitar) ins).getType().equals(t))
				   l.add(ins.getSerial());
		   }
	   }
	   return l;
   }
   
   public void sell(int serial) throws MusicShopException{
	   Instrument ins,insToRemove=null;
	   int guitarNum=0;
	   for (int i=0;i<listShop.size();i++) {
		   ins=listShop.get(i);
		   if(ins instanceof Guitar) 
			  guitarNum++;
		   if(ins.getSerial()==serial)
			   insToRemove=ins;
	   }
	   if(insToRemove instanceof Guitar && guitarNum==1)
		   throw new MusicShopException("this is the last guitar at the shop");
	   if(insToRemove==null)
		   throw new MusicShopException("this item does not founded");
	   listShop.remove(insToRemove);
   }
   
   public int sellAll(int[] serials) {
	   int cantSell=0;
	   for(int i=0;i<serials.length;i++) {
		   try {
			   sell(serials[i]);
		   } catch (MusicShopException e) {
			   cantSell++;
		   }
	   }
	   return cantSell;
   }
   
   
}
