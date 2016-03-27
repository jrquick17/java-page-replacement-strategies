import java.util.Arrays;
import java.util.Stack;

public class MostUsed {
	Pages pages;
	ReferenceString str;
	int count[];

	public MostUsed(Pages pages) {
		this.pages = pages;
	}

	public int simulate(ReferenceString str) {
		this.str = str;

		for (int i = 0; i < str.size(); i++)
			if (!pages.hasSpace() && !pages.contains(str.get(i))) {
				pages.remove(count(str, i));
				pages.add(str.get(i));
			}
			else if (pages.hasSpace() && !pages.contains(str.get(i))) {
				pages.add(str.get(i));
			}

		return pages.pageFaults;
	}

	public int count(ReferenceString str, int start) {
		count = new int[pages.getRSS()];
		int lru = -1;

		for (int page = 0; page < count.length; page++) 
			for (int pos = start; pos > -1; pos--)
				if (str.get(pos) == pages.get(page)) {
					count[page]++;
				}

		for (int i = 0, min = Integer.MAX_VALUE; i < count.length; i++)
			if (min > count[i]) {
				min = count[i];
				lru = i;
			}

		return pages.get(lru);
	}

	public void print() {
		pages.print();
	}

	public static void main(String[]args) {
		MostUsed cbe = new MostUsed(new Pages(3));
		ReferenceString str = new ReferenceString(.9, 10000);
		str.fillRandomly();
		System.out.println(cbe.simulate(str));
	}
}
