import java.util.Arrays;
import java.util.Random;

public class ReferenceString {
	Random gen = new Random();
	int string[], size, programs = 100;
	double percent;

	public ReferenceString(double percent, int size) {
		this.size = size;
		this.percent = percent;
		string = new int[this.size];	
	}
	
	public void fillRange() {
		for (int i = 0, count = 0; i < size; i++, count = 0) {
			if (gen.nextInt(programs) < programs*percent && i > 3)
				do //PREVENTS CONSECUTIVE DUPLICATES
					if (++count < 5)
						string[i] = string[gen.nextInt((int) (programs*-(percent-1)))];
					else {
						string[i] = string[i] = gen.nextInt(programs);
						break;
					}
				while (string[i] == string[i-1]);
			else 
				string[i] = gen.nextInt(programs);
		}
	}

	public void fillLoop() {
		for (int i = 0, count = 0; i < size; i++, count = 0) {
			if (gen.nextInt(programs) < programs*percent && i > 3)
				do //PREVENTS CONSECUTIVE DUPLICATES
					if (++count < 5)
						string[i] = string[i-gen.nextInt(3)-1];
					else {
						string[i] = string[i-gen.nextInt(3)-1];
						break;
					}
				while (string[i] == string[i-1]);
			else 
				string[i] = gen.nextInt(programs);
		}
	}
	
	public void fillRandomly() {
		for (int i = 0, count = 0; i < size; i++, count = 0) {
				do //PREVENTS CONSECUTIVE DUPLICATES
					if (++count > 5)
						string[i] = gen.nextInt(programs);
					else {
						string[i] = gen.nextInt(programs);
						break;
					}
				while (string[i] == string[i-1]);
		}
	}

	public void sort() {
		Arrays.sort(string);
	}

	public void print() {
		for (int i = 0; i < size; i++)
			System.out.println(string[i] + " ");
	}

	public int size() {
		return size;
	}

	public int get(int i) {
		return string[i];
	}

	public static void main(String[] args) {
		ReferenceString str = new ReferenceString(.9, 10000);

		str.fillRandomly();
		str.print();
	}
}
