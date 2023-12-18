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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(StudentBO s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(StudentBO s) {
		// TODO Auto-generated method stub

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
