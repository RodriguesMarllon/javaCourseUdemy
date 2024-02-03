package entities;

import java.util.Objects;

public class StudentEntry {

	private int idStudent;

	public StudentEntry(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStudent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentEntry other = (StudentEntry) obj;
		return idStudent == other.idStudent;
	}
}
