package in.ineuron.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.StudentBO;


@Repository
public class StudentDaoImpl implements IStudentDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	@Override
	public int insert(StudentBO bo) {
		
		Integer rowAffected = (Integer) hibernateTemplate.save(bo);
		
		return rowAffected;
	}

	@Override
	public void delete(int id) {
		StudentBO studentBO = hibernateTemplate.get(StudentBO.class, id);
		if(studentBO != null) {
			hibernateTemplate.delete(studentBO);
			System.out.println("Record Deleted Successfully:: " + id);
		}
		else {
			System.out.println("Record Not Available for the id:: " + id);
		}
	}

	@Override
	public void delete(StudentBO bo) {
		
		StudentBO studentBO = hibernateTemplate.get(StudentBO.class, bo.getSid());
		
		if(studentBO != null) {
			hibernateTemplate.delete(studentBO);
			System.out.println("Record Successfully Deleted for the ID:: " + bo.getSid());
		}
		else {
			System.out.println("Record not available for the id:: " + bo.getSid());
		}
		
	}

	@Override
	public void update(StudentBO bo) {
		
		StudentBO studentBO = hibernateTemplate.get(StudentBO.class, bo.getSid());
		
		if(studentBO != null) {
			hibernateTemplate.merge(bo);
			System.out.println("Record Successfully Updated for the id:: " + bo.getSid());
		}
		else {
			System.out.println("Record Updation failed for the id:: " + bo.getSid());
		}
	
	}

	@Override
	public StudentBO getStudent(int id) {
		StudentBO studentBO = hibernateTemplate.get(StudentBO.class, id);
		return studentBO;
	}

	@Override
	public List<StudentBO> getAllStudents() {
		List<StudentBO> listBO = hibernateTemplate.loadAll(StudentBO.class);
		return listBO;
	}

	@Override
	public String toString() {
		return "StudentDaoImpl [template=" + hibernateTemplate + "]";
	}

}
