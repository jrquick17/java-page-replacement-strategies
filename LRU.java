import java.util.Arrays;
import java.util.Stack;

public class LRU {
	Pages pages;
	ReferenceString str;
	int lruCount[];

	public LRU(Pages pages) {
		this.pages = pages;
	}

	public int simulate(ReferenceString str) {
		this.str = str;

		for (int i = 0; i < str.size(); i++) {
			if (!pages.hasSpace() && !pages.contains(str.get(i))) {
				pages.remove(findLRU(str, i));
				pages.add(str.get(i));
			}
			else if (pages.hasSpace() && !pages.contains(str.get(i))) {
				pages.add(str.get(i));
			}
		}
		
		return pages.pageFaults;
	}

	public int findLRU(ReferenceString str, int start) {
		lruCount = new int[pages.getRSS()];
		int lru = -1;

		for (int page = 0; page < lruCount.length; page++) {
			for (int pos = start; pos > -1; pos--)
				if (str.get(pos) == pages.get(page)) {
					lruCount[page] = pos;
					break;
				}
		}

		for (int i = 0, min = Integer.MAX_VALUE; i < lruCount.length; i++)
			if (min > lruCount[i]) {
				min = lruCount[i];
				lru = i;
			}

		return pages.get(lru);
	}

	public void print() {
		pages.print();
	}

	public static void main(String[]args) {
		LRU lru = new LRU(new Pages(3));
		ReferenceString str = new ReferenceString(.9, 10000);
		str.fillRandomly();
		System.out.println(lru.simulate(str));
	}
}
