import java.util.Arrays;
import java.util.Stack;

public class Optimal {
	Pages pages;
	ReferenceString str;
	int optCount[];

	public Optimal(Pages pages) {
		this.pages = pages;
	}

	public int simulate(ReferenceString str) {
		this.str = str;

		for (int i = 0; i < str.size(); i++)
			if (!pages.hasSpace() && !pages.contains(str.get(i))) {
				pages.remove(findLRU(str, i));
				pages.add(str.get(i));
			}
			else if (pages.hasSpace() && !pages.contains(str.get(i))) {
				pages.add(str.get(i));
			}


		return pages.pageFaults;
	}

	public int findLRU(ReferenceString str, int start) {
		optCount = new int[pages.getRSS()];
		int opt = -1;

		for (int page = 0; page < optCount.length; page++) {
			for (int pos = start; pos < str.size(); pos++)
				if (str.get(pos) == pages.get(page)) {
					optCount[page] = pos;
					break;
				}

			if (optCount[page] == 0) 
				optCount[page] = Integer.MAX_VALUE;
		}

		for (int i = 0, max = Integer.MIN_VALUE; i < optCount.length; i++)
			if (max < optCount[i]) {
				max = optCount[i];
				opt = i;
			}

		return pages.get(opt);
	}

	public void print() {
		pages.print();
	}

	public static void main(String[]args) {
		Optimal optimal = new Optimal(new Pages(3));
		ReferenceString str = new ReferenceString(.9, 10000);
		str.fillRandomly();
		System.out.println(optimal.simulate(str));
	}
}
