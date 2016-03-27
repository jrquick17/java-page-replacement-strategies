public class Random {
	java.util.Random gen = new java.util.Random();
	Pages pages;
	ReferenceString str;
	int optCount[];

	public Random(Pages pages) {
		this.pages = pages;
	}

	public int simulate(ReferenceString str) {
		this.str = str;

		for (int i = 0; i < str.size(); i++) 
			if (!pages.hasSpace() && !pages.contains(str.get(i))) {
				pages.remove(pages.get(gen.nextInt(pages.getRSS())));
				pages.add(str.get(i));
			}
			else if (pages.hasSpace() && !pages.contains(str.get(i))) {
				pages.add(str.get(i));
			}

		return pages.pageFaults;
	}

	public void print() {
		pages.print();
	}

	public static void main(String[]args) {
		Random random = new Random(new Pages(3));
		ReferenceString str = new ReferenceString(.9, 10000);
		str.fillRandomly();
		System.out.println(random.simulate(str));
	}
}
