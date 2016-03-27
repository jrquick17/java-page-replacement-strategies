import java.util.LinkedList;

public class Pages {
	LinkedList<Integer> pages;
	int pageFaults = 0;
	int RSS;
	
	public Pages (int RSS) {
		pages = new LinkedList<Integer>();
		this.RSS = RSS;
	}
	
	public void clear() {
		pages = new LinkedList<Integer>();
		pageFaults = 0;
	}
	
	public void setRSS(int RSS) {
		this.RSS = RSS;
	}
	
	public void add(int page) {
		pages.add(page);
		pageFaults++;
	}
	
	public int remove(int page) {
		return pages.remove(pages.indexOf(page));
	}
	
	public void push(int page) {
		pages.push(page);
		pageFaults++;
	}
	
	public int pop() {
		return pages.pop();
	}
	
	public void addLast(int page) {
		pages.addLast(page);
	}
	
	public int get(int i) {
		return pages.get(i);
	}
	
	public boolean hasSpace() {
		if (pages.size() < RSS)
			return true;
			
		return false;
	}
	
	public boolean contains(int page) {
		if (pages.contains(page))
			return true;
		
		return false;
	}
	
	public int getRSS() {
		return RSS;
	}
	
	public void print() {
		for (int i = 0; i < pages.size(); i++)
			System.out.println(i + ": " + pages.get(i));
		
		System.out.println();
	}
}
