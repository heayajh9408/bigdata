package strategy3.modularization;

/*
 * 2020.12.11~ Lim JaeHyun
 */
import strategy3.component.GetSalary;
import strategy3.component.JobLec;

public class Lecturer extends Person {
	private String subject;

	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}

	@Override
	public void print() {
		super.print();
		System.out.println("\t[����]" + subject);
	}

	@Override
	public String toString() {
		return super.toString() + "\t[����]" + subject;
	}
}
