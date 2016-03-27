import java.text.DecimalFormat;

public class Simulator {
	public static void main(String[]args) throws InterruptedException {
		DecimalFormat form = new DecimalFormat("00000.00");
		Timer timer = new Timer();
		Pages pages = new Pages(0);
		ReferenceString str = new ReferenceString(.9, 10000);

		Random random = new Random(pages);
		FIFO fifo = new FIFO(pages);
		LRU lru = new LRU(pages);
		Optimal optimal = new Optimal(pages);
		MostUsed cbe = new MostUsed(pages);
		LRUa lrua = new LRUa(pages);

		for (int RSS = 1; RSS < 101; RSS++) {
			double randomAvg = 0, fifoAvg = 0, lruAvg = 0, optimalAvg = 0, cbeAvg = 0, LRUaAvg = 0; 
			long randomTime = 0, fifoTime = 0, lruTime = 0, optimalTime = 0, cbeTime = 0, LRUaTime = 0;
			
			pages.setRSS(RSS);
			for (int count = 0; count < 100; count++){
				str.fillLoop();
				
				timer.start();
				randomAvg += random.simulate(str)*.01;
				timer.stop();
				randomTime += timer.getNano()*.01;
				timer.reset();
				pages.clear();
				
				timer.start();
				fifoAvg += fifo.simulate(str)*.01;
				timer.stop();
				fifoTime += timer.getNano()*.01;
				timer.reset();
				pages.clear();
				
				timer.start();
				lruAvg += lru.simulate(str)*.01;
				timer.stop();
				lruTime += timer.getNano()*.01;
				timer.reset();
				pages.clear();
				
				timer.start();
				optimalAvg += optimal.simulate(str)*.01;
				timer.stop();
				optimalTime += timer.getNano()*.01;
				timer.reset();
				pages.clear();
				
				timer.start();
				cbeAvg += cbe.simulate(str)*.01;
				timer.stop();
				cbeTime += timer.getNano()*.01;
				timer.reset();
				pages.clear();
				
				timer.start();
				LRUaAvg += lrua.simulate(str)*.01;
				timer.stop();
				LRUaTime += timer.getNano()*.01;
				timer.reset();
				pages.clear();
			}
			System.out.print(RSS + "\t" + form.format(randomAvg) + "\t" + form.format(fifoAvg)
					+ "\t" + form.format(lruAvg) + "\t" + form.format(optimalAvg) + "\t" 
					+ form.format(cbeAvg) + "\t" + form.format(LRUaAvg) + "\t");
			
			System.out.println(RSS + "\t" + form.format(randomTime) + "\t" + form.format(fifoTime)
					+ "\t" + form.format(lruTime) + "\t" + form.format(optimalTime) + "\t" 
					+ form.format(cbeTime) + "\t" + form.format(LRUaTime));
		}
	}
}
