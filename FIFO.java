
public class FIFO{
	Pages pages;
	ReferenceString str;

	public FIFO(Pages pages) {
		this.pages = pages;
	}

	public int simulate(ReferenceString str) {
		this.str = str;

		for (int i = 0; i < str.size(); i++)
			if (!pages.hasSpace() && !pages.contains(str.get(i))) {
				pages.pop();
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
		ReferenceString str = new ReferenceString(.9, 10000);
		str.fillRandomly();
		FIFO fifo = new FIFO(new Pages(3));
		System.out.println(fifo.simulate(str));
	}
}
